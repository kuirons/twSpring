package config;

import java.util.ArrayList;
import java.util.List;

/** @Author: kuirons @Date: 18-1-18 */
public class Q_positonInforBean {
  private String planeId;
  private List<String> positions = new ArrayList<>();

  public List<String> getPositions() {
    return positions;
  }

  public void setPositons(List<String> positions) {
    this.positions = positions;
  }

  public String getPlaneId() {

    return planeId;
  }

  public void setPlaneId(String planeId) {
    this.planeId = planeId;
  }

  public void init(String planeID, List<String> wholeInfo, boolean isFirst) {
    planeId = planeID;
    for (int i = 1; i < wholeInfo.size(); i++) {
      positions.add(wholeInfo.get(i));
    }
    if (isFirst)
      for (int i = 0; i < 3; i++) {
        positions.add("0");
      }
  }
}
