import visidia.simulation.process.algorithm.LC0_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;

public class SpanningT extends LC0_Algorithm {
    @Override
    public Object clone() {
        return new SpanningT();
    }

    @Override
    public String getDescription() {
        return "Spanning tree algorithm using LC0";
    }

    @Override
    protected void beforeStart() {
        setLocalProperty("label", vertex.getLabel());
        setLocalProperty("compteur", "1");
    }
    

    @Override
    protected void onStarCenter() {
        if (!getLocalProperty("label").equals("F")) {
            if (getLocalProperty("label").equals("N") && getNeighborProperty("label").equals("A")) {
                setLocalProperty("label", "A");
                setNeighborProperty("label", "I");
                setEdgeProperty("label", "actif");
                setDoorState(new MarkedState(true), neighborDoor);
            }
            boolean context = true;
            for (int i = 0; i < getArity(); i++) {
                if (vertex.getNeighborByDoor(i).getLabel().equals("N")) {
                    context = false;
                }
            }
            if (context) {
                if (getLocalProperty("label").equals("A") && getNeighborProperty("label").equals("I") && getEdgeProperty("label").equals("actif")) {
                    setLocalProperty("label", "F");
                    setNeighborProperty("label", "A");
                    int add = Integer.parseInt((String)getNeighborProperty("compteur")) + Integer.parseInt((String)getLocalProperty("compteur"));
                    String c = String.valueOf(add);
                    setNeighborProperty("compteur", c);
                }
            }
        } else {
            localTermination();
            setLocalProperty("label", getLocalProperty("compteur"));
        }
        System.out.println(getLocalProperty("compteur"));
    }
}
