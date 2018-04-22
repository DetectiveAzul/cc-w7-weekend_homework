package engine;

import behaviours.IWieldable;
import character.Character;
import character.non_player_character.NonPlayerCharacter;
import character.player_character.Player;
import runner.TextColor;

public class Combat {

    public static void BeginCombat(Player player, NonPlayerCharacter foe) {
        System.out.println(TextColor.RESET.getAnsiiCode() + "----COMBAT BEGINS----");

        //Combat will autorun until it is finished
        boolean combat = true;
        while(combat) {
            //Get the damage that each fighter deals
            int playerDamage = rollDie(player.getPrimaryTool());
            int enemyDamage = rollDie(foe.getPrimaryTool());

            //Apply the damage, check if died and finish the combat if true
                //Enemy side
                //Enemy receiving damage
                System.out.println(TextColor.GREEN.getAnsiiCode() + applyDamage(foe, playerDamage));
                //Check if dead
                if (foe.isDead()) {
                    System.out.println(TextColor.GREEN.getAnsiiCode() + foe.getName() + " dies and drop any object to the ground");
                    break;
                }

                //Display info
                System.out.println(TextColor.RED.getAnsiiCode() + applyDamage(player, enemyDamage));
                //Check if dead
                if (player.isDead()) break;
            }
        System.out.println(TextColor.RESET.getAnsiiCode() + "----COMBAT ENDS----");
    }

    private static int rollDie(IWieldable tool) {
        return tool.rollDamageDie();
    }

    private static String applyDamage(Character character, int damage) {
        character.takeDamage(damage);
        return character.getName() + " receives " + damage + " of damage";
    }

}
