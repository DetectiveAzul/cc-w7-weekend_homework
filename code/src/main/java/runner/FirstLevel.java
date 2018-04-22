package runner;

import character.player_character.Player;
import collectables.Key;
import collectables.tools.consumables.Potion;
import collectables.tools.weapons.Weapon;
import dungeon.EndRoom;
import dungeon.EntryRoom;
import dungeon.MonsterRoom;
import dungeon.TreasureRoom;
import engine.Game;

import java.util.Scanner;

public class FirstLevel {
    private EndRoom end;
    private EntryRoom entry;
    private Player player;
    private MonsterRoom hallway;
    private TreasureRoom cell01;
    private TreasureRoom cell02;
    private Key key;
    private Weapon dagger;
    private Potion potion;


    public FirstLevel() {
        System.out.println("What's your name, player?");

        //User Input
        Scanner user_input = new Scanner(System.in);
        String name = user_input.next();
        entry = new EntryRoom(
                "Dark Cell", "This is a very dark cell inside the inner dungeons" +
                " of Lady Myylthik. You were thrown here... some weeks ago after your city was conquered" +
                " by her minions. Walls are humid, the smell in here is awful, and two days have passed" +
                " since you received your last meal. For some reason, your door is open. When did it happen?");

        end = new EndRoom("Stairs", "This stairs lead your way onto the ground levels. There is" +
                " a locked door. The key is usually carried by the guards. If you could just use a Key to open it...");

        hallway = new MonsterRoom( "Hallway between Cells", "From this point you can see all other" +
                " cells. They are now empty. Where are the rest of the prisoners? You can smell fresh blood from one" +
                " of the two other open cells.");

        cell01 = new TreasureRoom( "Cell", "A moody, humid and dirty cell, like yours. The body of a" +
                " dead guard is in the floor. You can guess that's the reason of your recently gained freedom. " +
                " It is possible the prisoner sleeping here caught the guard and kill it.");

        key = new Key("Copper", end);
        cell01.addTreasure(key);
        dagger = new Weapon("Small Dagger", 1, 6);
        cell01.addTreasure(dagger);


        cell02 = new TreasureRoom( "Cell", "A moody, humid and dirty cell, like yours. In the last" +
                " few days you saw a Dwarf, dying like you. But nobody is here now.");

        potion = new Potion("Small Gloomy Red", false, 5);

        cell02.addTreasure(potion);

        player = new Player(name, 15, 5, entry);

        entry.setNorth(hallway);
        hallway.setEast(cell01);
        hallway.setWest(cell02);
        hallway.setNorth(end);

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
