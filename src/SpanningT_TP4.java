import visidia.simulation.process.algorithm.LC1_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;
public class SpanningT_TP4 extends LC1_Algorithm {
    @Override
    public Object clone() {
        return new SpanningT_TP4();
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
        if (getLocalProperty("label").equals("N")) {
            int door = 0;
            while (door < getArity()) {
                if (getNeighborProperty(door,"label").equals("A")) {
                    setLocalProperty("label", "A");
                    setEdgeProperty("label", "actif");
                    setDoorState(new MarkedState(true), door);
                    door = getArity();
                }
                door++;
            }
        }
    }
}
