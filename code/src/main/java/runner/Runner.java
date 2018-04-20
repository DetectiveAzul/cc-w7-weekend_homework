package runner;

import dungeon.*;

public class Runner {
    public static void main(String[] args) {
        TreasureRoom treasure = new TreasureRoom("Treasure Room", "A small treasure room");
        EntryRoom entry = new EntryRoom("Dungeon Entrance", "Where the dungeon begins");
        MonsterRoom monster = new MonsterRoom("Boss Lair", "The house of a small green dragon");
        EndRoom end = new EndRoom("The Exit", "If you have the key, you can escape");

        entry.setNorth(monster);
        entry.setSouth(treasure);

        Room current_room = entry;

        System.out.println(TextColor.BLUE.getAnsiiCode() + current_room.getName());
        System.out.println(TextColor.CYAN.getAnsiiCode() + current_room.getDescription());
        System.out.println();
        System.out.println(TextColor.PURPLE.getAnsiiCode() + "There are:");
        System.out.println(TextColor.YELLOW.getAnsiiCode() + current_room.getExitsAvailable());
        System.out.println();
        System.out.println(TextColor.RESET.getAnsiiCode() + "What are you doing?");


    }
}
