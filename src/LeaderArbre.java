import visidia.simulation.process.algorithm.LC1_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;
public class LeaderArbre extends LC1_Algorithm {
    @Override
    public Object clone() {
        return new LeaderArbre();
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
            boolean f = true;
            int compteur = 0;
            for (int i = 0; i < getArity(); i++) {
                if (getNeighborProperty(i,"label").equals("N")) {
                    compteur++;
                }
            }
            if (compteur == 1) {
                setLocalProperty("label", "F");
            } else if (compteur == 0){
                setLocalProperty("label", "E");
            }
        }
    }
}
