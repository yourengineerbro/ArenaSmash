package com.yourengineerbro.arenasmash.arena;

import com.yourengineerbro.arenasmash.dice.Dice;
import com.yourengineerbro.arenasmash.player.Player;

import java.util.Scanner;

import static com.yourengineerbro.arenasmash.util.Constants.Game.ROLL_ATTACK_DICE;
import static com.yourengineerbro.arenasmash.util.Constants.Game.ROLL_DEFEND_DICE;

public class Arena {
    private final Player player1;
    private final Player player2;
    private final Dice attackDice;
    private final Dice defendDice;

    public Arena(Player player1, Player player2, Dice attackDice, Dice defendDice) {
        this.player1 = player1;
        this.player2 = player2;
        this.attackDice = attackDice;
        this.defendDice = defendDice;
    }

    public void fight(Scanner scanner) {
        Player attacker = player1.getHealth() <= player2.getHealth() ? player1 : player2;
        Player defender = attacker == player1 ? player2 : player1;

        while (attacker.isAlive() && defender.isAlive()) {

            System.out.println(attacker.getPlayerHandle() + "'s turn to attack.");
            System.out.print(ROLL_ATTACK_DICE);
            scanner.nextLine();

            int attackRoll = attackDice.roll();
            System.out.println(attacker.getPlayerHandle() + " rolls the attack dice: " + attackRoll);

            System.out.println();

            System.out.println(defender.getPlayerHandle() + "'s turn to defend.");
            System.out.print(ROLL_DEFEND_DICE);
            scanner.nextLine();

            int defendRoll = defendDice.roll();
            System.out.println(defender.getPlayerHandle() + " rolls the defend dice: " + defendRoll);

            System.out.println();

            int damageDealt = attacker.getAttack() * attackRoll;
            int damageDefended = defender.getStrength() * defendRoll;
            int damageInflicted = Math.max(0, damageDealt - damageDefended);

            defender.setHealth(Math.max(0, defender.getHealth() - damageInflicted));

            System.out.println(attacker.getPlayerHandle() + " attacks with damage " + damageDealt + " (rolled " + attackRoll + ")");
            System.out.println(defender.getPlayerHandle() + " defends with " + damageDefended + " (rolled " + defendRoll + ")");
            System.out.println(defender.getPlayerHandle() + " receives " + damageInflicted + " damage, health now " + defender.getHealth());

            System.out.println();

            // Swap roles
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        Player winner = attacker.isAlive() ? attacker : defender;
        System.out.println(winner.getPlayerHandle() + " wins the match!");
    }
}

