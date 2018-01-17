package config;

/**
 * @Author: kuirons
 * @Date: 18-1-18
 */
public class Q_positonInforBean {
    private String planeId;
    private int[] positon;

    public int[] getPositon() {
        return positon;
    }

    public void setPositon(int[] positon) {
        this.positon = positon;
    }

    public String getPlaneId() {

        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }
}
