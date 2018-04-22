package engine;

import character.player_character.Player;
import dungeon.EndRoom;

public class Game {

    //Is runned at the end of the game loop. If EndRoom is unlocked, the game finishes.
    public static boolean checkWin(EndRoom room) {
        return room.isRoomIsUnlocked();
    }
}
