package config;

import com.google.common.base.Preconditions;
import util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.*;

/** @Author: kuirons @Date: 18-1-18 */
public class PositonConfig {
  private Map<String, List<Q_positonInforBean>> positonInfor = new HashMap<>();

  public Map<String, List<Q_positonInforBean>> getPositonInfor() {
    return positonInfor;
  }

  public void setPositonInfor(Map<String, List<Q_positonInforBean>> positonInfor) {
    this.positonInfor = positonInfor;
  }

  private boolean check(String s) {
    if (!s.split(" ")[0].matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]+$")) return false;
    return true;
  }

  public void load(String url) throws IOException {
    File[] files = FileUtil.fileFilter(url);
    for (File f : files) {
      List<Q_positonInforBean> loadInfoList = new ArrayList<>();
      List<String> listPosition = FileUtil.readFile(f);
      Preconditions.checkArgument(check(listPosition.get(0)), "load file {} failure.", f.getName());
      String planeId = listPosition.get(0).split(" ")[0];
      boolean firstFlag = true;
      for (String s : listPosition) {
        List<String> splitString = Arrays.asList(s.split(" "));
        Q_positonInforBean bean = new Q_positonInforBean();
        if (!check(s)) bean.init("error", splitString, false);
        if (firstFlag) {
          bean.init(splitString.get(0), splitString, true);
          firstFlag = false;
        } else {
          bean.init(splitString.get(0), splitString, false);
        }

        loadInfoList.add(bean);
      }
      positonInfor.put(planeId, loadInfoList);
    }
  }
}
