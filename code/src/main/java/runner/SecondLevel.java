package runner;

import character.non_player_character.NonPlayerCharacter;
import character.player_character.Player;
import collectables.CoinChest;
import collectables.CoinType;
import collectables.Key;
import collectables.tools.consumables.Potion;
import collectables.tools.weapons.Weapon;
import dungeon.EndRoom;
import dungeon.EntryRoom;
import dungeon.MonsterRoom;
import dungeon.TreasureRoom;
import engine.Game;

import java.util.Scanner;

public class SecondLevel {
    private EndRoom end;
    private EntryRoom entry;
    private Player player;
    private MonsterRoom hallway;
    private MonsterRoom boss;
    private Key key;
    private Weapon chair;
    private Potion potion01;
    private Potion potion02;
    private Weapon sword;
    private CoinChest chest01;
    private NonPlayerCharacter chief;


    public SecondLevel(Player player) {
        //User Input
        entry = new EntryRoom(
                "End of the Stairs", "You reach the top of the stairs, getting to the ground " +
                "level of the dungeon where you thought you would die. The exit is very close, but it might be" +
                " possible that a fight or two will happen before you can see the sun again. If you have a weapon" +
                " this is the perfect moment to 'use' it to put it in your hand. If you weren't lucky enough, be" +
                "fast and find any suitable weapon");

        end = new EndRoom("Main Door", "You did it, this is the door to your freedom. To the other" +
                " side the kingdom of Ashandar awaits you. You are afraid of how everything will be after the war, " +
                "but at least your alive. The door is locked, but somebody should have the key");

        hallway = new MonsterRoom( "Hallway to your freedom", "A long hallway leading to the guard" +
                " room. After that room, you know for sure that the exit is waiting for you. There are some objects in this" +
                " room that could be useful for you before your fight. 'use' a Potion could it be useful");

        boss = new MonsterRoom( "Guard Room", "There is it. You're hiding between some boxes, you know" +
                "you can go through this room without being seen. The other door in front of you is fully open, maybe" +
                "you can skip this fight. But if you want to, you just need to 'attack' him");

        chief = new NonPlayerCharacter("Guard Chief McKenzy", 10, 4, boss);
        key = new Key("Silver", end);
        sword = new Weapon("Long Sword", 10, 10);
        chest01 = new CoinChest(50, CoinType.ELECTRUM);

        chief.addTreasure(key);
        chief.addTreasure(chest01);
        chief.addTreasure(sword);
        chief.setPrimaryTool(sword);
        boss.addFoe(chief);

        chair = new Weapon("Wooden Chair", 0, 3);
        potion01 = new Potion("Purple", true, 2);
        potion02 = new Potion("Water", false, 1);
        hallway.addTreasure(chair);
        hallway.addTreasure(potion01);
        hallway.addTreasure(potion02);

        this.player = player;
        this.player.setCurrenRoom(entry);

        entry.setWest(hallway);
        hallway.setNorth(boss);
        boss.setEast(end);

    }

    public Player levelRunner() {
        boolean win = false;
        while(!win) {
            //Display everything
            System.out.println(TextColor.BLUE.getAnsiiCode() + player.getCurrentRoom().getName());
            System.out.println();
            System.out.println(TextColor.CYAN.getAnsiiCode() + player.getCurrentRoom().getDescription());
            System.out.println();
            System.out.println(TextColor.PURPLE.getAnsiiCode() + player.getCurrentRoom().displayTreasures());
            System.out.println(TextColor.PURPLE.getAnsiiCode() + player.displayHand());
            System.out.println(TextColor.PURPLE.getAnsiiCode() + player.displayTreasures());
            System.out.println();
            System.out.println(TextColor.GREEN.getAnsiiCode() + player.getCurrentRoom().displayFoes());
            System.out.println();
            System.out.println(TextColor.YELLOW.getAnsiiCode() + player.getCurrentRoom().getExitsAvailable());
            player.displayStatus();
            System.out.println(TextColor.RESET.getAnsiiCode() + "What will you do?");

            //User Input
            Scanner user_input = new Scanner(System.in);
            String choice = user_input.nextLine();

            //Check player dictionary
            player.checkAction(choice);

            //Check win or dead condition
            win = Game.checkWin(end);
            if (player.isDead()) break;
        }

        if (player.getHp() <= 0 ) System.out.println("You Died. GAME OVER");
        return player;
    }
}
