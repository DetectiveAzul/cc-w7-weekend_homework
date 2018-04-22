package behaviours;

import character.Character;

public interface IUsable {
    //Takes a character parameter to be able to use its properties on it (healing or unlocking current room)
    public void use(Character character);
}
