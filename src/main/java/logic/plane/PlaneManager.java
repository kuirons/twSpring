package logic.plane;

import config.PositonConfig;
import config.Q_positonInforBean;
import data.plane.PlaneData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/** @Author: kuirons @Date: 18-1-18 */
public class PlaneManager {
  private Map<String, PlaneData> planeDatas = new HashMap<>();

  public Map<String, PlaneData> getPlaneDatas() {
    return planeDatas;
  }

  public void setPlaneDatas(Map<String, PlaneData> planeDatas) {
    this.planeDatas = planeDatas;
  }

  public int check(List<Q_positonInforBean> list, Predicate<Q_positonInforBean> p) {
    int result = list.size();
    for (int i = 0; i < list.size(); i++) {
      if (!p.test(list.get(i))) {
        result = i;
        break;
      }
    }
    return result;
  }

  public void create(PositonConfig positonConfig) {
    for (String s : positonConfig.getPositonInfor().keySet()) {

      List<Q_positonInforBean> lq = positonConfig.getPositonInfor().get(s);

      int end = getFinalWrongNum(lq);

      PlaneData planeData = new PlaneData();
      planeData.getPlane().setPlaneId(s);

      Map<Integer, String> result = new HashMap<>();

      for (int i = 0; i < end; i++) {
        result.put(i, getinfo(lq.get(i)));
      }
      for (int i = end; i < lq.size(); i++) {
        result.put(i, "Error:");
      }
      planeData.setPositions(result);
      planeDatas.put(s, planeData);
    }
  }

  private String getinfo(Q_positonInforBean q_positonInforBean) {
    int[] sum = getsum(q_positonInforBean);
    return "" + sum[0] + " " + sum[1] + " " + sum[2];
  }

  private int getFinalWrongNum(List<Q_positonInforBean> lq) {
    int end = getWrongNum(lq);

    int equalWrong = lq.size();
    for (int i = 0; i < end; i++) {
      Q_positonInforBean thisBean = lq.get(i);
      if (i + 1 >= end) equalWrong = i + 1;
      else {
        Q_positonInforBean futureBean = lq.get(i + 1);
        int[] thisNum = getsum(thisBean);
        for (int j = 0; j < 3; j++) {
          if (thisNum[j] != Integer.parseInt(futureBean.getPositions().get(j))) {
            equalWrong = i + 1;
            break;
          }
        }
      }
      if (equalWrong != lq.size()) break;
    }
    return getMin(end, equalWrong);
  }

  private int[] getsum(Q_positonInforBean bean) {
    int[] result = new int[3];
    for (int i = 0; i < 3; i++) {
      result[i] =
          Integer.parseInt(bean.getPositions().get(i))
              + Integer.parseInt(bean.getPositions().get(i + 3));
    }
    return result;
  }

  private int getWrongNum(List<Q_positonInforBean> lq) {
    int idWrong = check(lq, q -> !"error".equals(q.getPlaneId()));
    int formatWrong =
        check(lq, q -> q.getPositions().stream().allMatch(n -> n.matches("^-?[1-9]\\d*$|0")));
    int numWrong = check(lq, q -> q.getPositions().size() == 6);

    int end = getMin(idWrong, formatWrong, numWrong);

    return end;
  }

  private int getMin(int num1, int... nums) {
    for (int i : nums) {
      num1 = num1 < i ? num1 : i;
    }
    return num1;
  }

  public String selectInfo(int id) {
    String planeId = "plane1";
    PlaneData p = planeDatas.get(planeId);
    if (id >= p.getPositions().size()) return "Cannot find " + id;
    if (p.getPositions().get(id).equals("Error:")) return "Error:" + id;
    return p.getPlane().getPlaneId() + " " + id + " " + p.getPositions().get(id);
  }
}
