import visidia.simulation.process.algorithm.LC0_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;

public class Election_TP3 extends LC0_Algorithm {
    @Override
    public Object clone() {
        return new Election_TP3();
    }

    @Override
    public String getDescription() {
        return "Spanning tree algorithm using LC0";
    }

    @Override
    protected void beforeStart() {
        setLocalProperty("label", vertex.getLabel());
        String c = String.valueOf(getArity());
        setLocalProperty("compteur", c);
    }


    @Override
    protected void onStarCenter() {
        if (getLocalProperty("label").equals("N") && getLocalProperty("compteur").equals("1")) {
            int add = Integer.parseInt((String)getNeighborProperty("compteur"));
            if (getNeighborProperty("label").equals("N") && add > 1) {
                setLocalProperty("label", "F");
                add--;
                String c = String.valueOf(add);
                setNeighborProperty("compteur", c);
                setDoorState(new MarkedState(true), neighborDoor);
            } else if (getNeighborProperty("label").equals("N") && getNeighborProperty("compteur").equals("1")) {
                setLocalProperty("label", "E");
                setLocalProperty("compteur", "0");
                setNeighborProperty("label", "F");
                setNeighborProperty("compteur", "0");
            }
        }
    }
}
