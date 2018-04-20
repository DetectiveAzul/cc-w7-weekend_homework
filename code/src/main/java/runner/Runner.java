package runner;

import character.player_character.Player;
import collectables.CoinChest;
import collectables.CoinType;
import dungeon.*;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Player player = new Player("Cian");
        TreasureRoom treasure = new TreasureRoom("Treasure Room", "A small treasure room");
        EntryRoom entry = new EntryRoom("Dungeon Entrance", "Where the dungeon begins");
        MonsterRoom monster = new MonsterRoom("Boss Lair", "The house of a small green dragon");
        EndRoom end = new EndRoom("The Exit", "If you have the key, you can escape");
        CoinChest chest = new CoinChest(100, CoinType.GOLD);
        CoinChest chest2 = new CoinChest(100, CoinType.COPPER);

        entry.setNorth(monster);
        entry.setSouth(treasure);

        treasure.addTreasure(chest);
        treasure.addTreasure(chest2);
        player.setCurrenRoom(treasure);

        boolean game = true;
        while(game) {

            System.out.println(TextColor.BLUE.getAnsiiCode() + player.getCurrentRoom().getName());
            System.out.println();
            System.out.println(TextColor.CYAN.getAnsiiCode() + player.getCurrentRoom().getDescription());
            System.out.println();
            System.out.println(TextColor.PURPLE.getAnsiiCode() + player.getCurrentRoom().displayTreasures());
            System.out.println(TextColor.PURPLE.getAnsiiCode() + player.displayTreasures());
            System.out.println();
            System.out.println(TextColor.YELLOW.getAnsiiCode() + player.getCurrentRoom().getExitsAvailable());
            System.out.println();
            System.out.println(TextColor.RESET.getAnsiiCode() + "What are you doing?");

            //User Input
            Scanner user_input = new Scanner(System.in);
            String choice = user_input.nextLine();

            //Check for break condition
            if (choice.startsWith("exit")) break;

            //Check player dictionary
            player.checkAction(choice);

        }
        System.out.println("ByeBye!");



    }
}
