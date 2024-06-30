package com.yourengineerbro.arenasmash.arena;

import com.yourengineerbro.arenasmash.dice.Dice;
import com.yourengineerbro.arenasmash.player.Player;

import java.util.Scanner;

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
            int attackRoll = attackDice.roll();
            int defendRoll = defendDice.roll();

            int damageDealt = attacker.getAttack() * attackRoll;
            int damageDefended = defender.getStrength() * defendRoll;
            int damageInflicted = Math.max(0, damageDealt - damageDefended);

            defender.setHealth(Math.max(0, defender.getHealth() - damageInflicted));


            // Swap roles
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        Player winner = attacker.isAlive() ? attacker : defender;
        System.out.println(winner.getPlayerHandle() + " wins the match!");
    }
}

