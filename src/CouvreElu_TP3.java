import visidia.simulation.process.algorithm.LC0_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;
public class CouvreElu_TP3 extends LC0_Algorithm {
    @Override
    public Object clone() {
        return new CouvreElu_TP3();
    }

    @Override
    public String getDescription() {
        return "Spanning tree algorithm using LC0";
    }

    @Override
    protected void beforeStart() {
        setLocalProperty("label", vertex.getLabel());
    }


    @Override
    protected void onStarCenter() {
        if (getLocalProperty("label").equals("N") && getNeighborProperty("label").equals("A")) {
                setLocalProperty("label", "A");
                setNeighborProperty("label", "I");
                setEdgeProperty("label", "actif");
                setDoorState(new MarkedState(true), neighborDoor);
        } else if (getLocalProperty("label").equals("A") && getNeighborProperty("label").equals("I") && getEdgeProperty("label").equals("actif")) {
            setLocalProperty("label", "F");
            setNeighborProperty("label", "A");
        }
    }
}
