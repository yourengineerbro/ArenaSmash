package com.yourengineerbro.arenasmash.app;

import com.yourengineerbro.arenasmash.arena.Arena;
import com.yourengineerbro.arenasmash.dice.Dice;
import com.yourengineerbro.arenasmash.player.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // To create a constant file
        System.out.println("Welcome to the ArenaSmash!!");
        Scanner scanner = new Scanner(System.in);

        // Input player details
        System.out.println("Enter details for Player 1:");
        Player player1 = createPlayer(scanner);

        System.out.println("Enter details for Player 2:");
        Player player2 = createPlayer(scanner);

        // Assuming here that players roll the dice simultaneously thus required 2 dice.
        Dice attackDice = new Dice(6);
        Dice defendDice = new Dice(6);

        Arena arena = new Arena(player1, player2, attackDice, defendDice);
        System.out.print("Press Enter to start the game");
        scanner.nextLine();
        arena.fight(scanner);
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
        scanner.nextLine();
        return new Player(handle, health, strength, attack);
    }
}