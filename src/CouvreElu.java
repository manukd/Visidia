import visidia.simulation.process.algorithm.LC1_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;
public class CouvreElu extends LC1_Algorithm {
    @Override
    public Object clone() {
        return new CouvreElu();
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
                if (getNeighborProperty(door,"label").equals("I")) {
                    setLocalProperty("label", "I");
                    setDoorState(new MarkedState(true), door);
                    setEdgeProperty(door, "label", "actif");
                    door = getArity();
                }
                door++;
            }
        } else if (lookNeigh()){
            if (getLocalProperty("label").equals("I")) {
                System.out.println(getLocalProperty("label") + " : ");
                for (int j = 0; j < getActiveDoors().size(); j++) {
                    int num = getActiveDoors().get(j);
                    System.out.println(getEdgeProperty(num, "label"));
                }
                boolean f = true;
                int compteur = 0;
                for (int i = 0; i < getArity(); i++) {
                    if (getNeighborProperty(i,"label").equals("I") && getEdgeProperty(i, "label").equals("actif")) {
                        compteur++;
                    }
                }
                if (compteur == 1) {
                    setLocalProperty("label", "F");
                } else if (compteur == 0){
                    setLocalProperty("label", "E");
                    globalTermination();
                }
            }
        }
    }

    boolean lookNeigh() {
        boolean res = true;
        for (int i = 0; i < getArity(); i++) {
            if ((!getNeighborProperty(i, "label").equals("I")) && (!getNeighborProperty(i, "label").equals("F")) && (!getNeighborProperty(i, "label").equals("E"))) {
                res = false;
            }
        }
        return res;
    }
}
