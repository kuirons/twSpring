package config;

import com.google.common.base.Preconditions;
import util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** @Author: kuirons @Date: 18-1-18 */
public class PositonConfig {
  private Map<String, List<Q_positonInforBean>> positonInfor;

  private boolean check(String s) {
      if(s == null)
          return false;
      if(!s.split(" ")[0].matches("^[A-Za-z0-9]+$"))
          return false;
    return true;
  }

  public void load(String url) throws IOException {
    File[] files = FileUtil.fileFilter(url);
    for (File f : files) {
      List<String> listPosition = FileUtil.readFile(f);
      for (String s : listPosition) {
        Preconditions.checkArgument(check(s), "load file {} failure.", f.getName());
        List<String> splitString = Arrays.asList(s.split(" "));
        Q_positonInforBean bean = new Q_positonInforBean();
      }
    }
  }
}
