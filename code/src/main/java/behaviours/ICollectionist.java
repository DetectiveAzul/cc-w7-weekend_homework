package behaviours;

import collectables.Treasure;

import java.util.ArrayList;

public interface ICollectionist {
    ArrayList<Treasure> getTreasures();
    void setTreasures(ArrayList<Treasure> treasures);
    void addTreasure(Treasure treasure);
    void removeTreasure(Treasure treasure);
    String displayTreasures();
}
