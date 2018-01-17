package data.plane;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: kuirons
 * @Date: 18-1-18
 */
public class PlaneData {
    private Plane plane = new Plane();
    private Map<Integer,String> positions = new HashMap<Integer, String>();

    public Map<Integer, String> getPositions() {
        return positions;
    }

    public void setPositions(Map<Integer, String> positions) {
        this.positions = positions;
    }

    public Plane getPlane() {

        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }
}
