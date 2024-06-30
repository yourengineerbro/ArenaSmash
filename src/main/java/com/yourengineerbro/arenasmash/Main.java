package com.yourengineerbro.arenasmash;

import com.yourengineerbro.arenasmash.dice.Dice;
import com.yourengineerbro.arenasmash.player.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Player player1 = createPlayer(scanner);
        Player player2 = createPlayer(scanner);

        // Assuming here that players roll the dice simultaneously thus required 2 dice.
        Dice attackDice = new Dice(6);
        Dice defendDice = new Dice(6);

        scanner.close();
    }

    private static Player createPlayer(Scanner scanner) {

        String handle;
        // transaction bottleneck here
        System.out.print("Handle: ");
        while(true) {
            handle = scanner.next();
            // See if we can use StringBuilder Here
            handle = handle.trim();
            if (Player.contains(handle)) {
                System.out.println("Player handle must be unique");
            } else {
                Player.addPlayerHandle(handle);
                break;
            }
        }
        System.out.print("Health: ");
        int health = scanner.nextInt();
        System.out.print("Strength: ");
        int strength = scanner.nextInt();
        System.out.print("Attack: ");
        int attack = scanner.nextInt();
        return new Player(handle, health, strength, attack);
    }
}