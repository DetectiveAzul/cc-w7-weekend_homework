package runner;

import character.player_character.Player;

public class GameRunner {
    public static void main(String[] args) {

        //Creates first level and runs it
        FirstLevel level01 = new FirstLevel();
        Player player = level01.levelRunner();

        //Creates second level (adding the player) and runs it
        SecondLevel level02 = new SecondLevel(player);
        player = level02.levelRunner();

        if (player.getHp() > 0) System.out.println("You did it! You escaped this filthy castle!!");

    }
}
