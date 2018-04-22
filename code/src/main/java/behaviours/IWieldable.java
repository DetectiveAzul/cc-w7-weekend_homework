package behaviours;

import character.Character;
import collectables.Treasure;

public interface IWieldable {
    public String getName();
    public int getDamage();
    public int rollDamageDie();
    public void unWield(Character character);
}
