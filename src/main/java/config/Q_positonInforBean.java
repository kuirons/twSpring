package config;

import com.google.common.base.Preconditions;

/**
 * @Author: kuirons
 * @Date: 18-1-18
 */
public class Q_positonInforBean {
    private String planeId;
    private int[] positions;

    public int[] getPositions() {
        return positions;
    }

    public void setPositons(int[] positions) {
        this.positions = positions;
    }

    public String getPlaneId() {

        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    public void init(String planeID,int[] position){
        planeId = planeID;
        positions = position;

    }
}
