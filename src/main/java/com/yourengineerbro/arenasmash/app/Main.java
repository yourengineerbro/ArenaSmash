package com.yourengineerbro.arenasmash.app;

import com.yourengineerbro.arenasmash.arena.Arena;
import com.yourengineerbro.arenasmash.dice.Dice;
import com.yourengineerbro.arenasmash.player.Player;

import java.util.Scanner;
;import static com.yourengineerbro.arenasmash.util.Constants.*;
import static com.yourengineerbro.arenasmash.util.Constants.Error.UNIQUE_HANDLE;

public class Main {
    public static void main(String[] args) {
        // To create a constant file
        System.out.println(WELCOME_MESSAGE);
        Scanner scanner = new Scanner(System.in);

        // Input player details
        System.out.println(ASK_PLAYER1);
        Player player1 = createPlayer(scanner);

        System.out.println(ASK_PLAYER2);
        Player player2 = createPlayer(scanner);

        // Assuming here that players roll the dice simultaneously thus required 2 dice.
        Dice attackDice = new Dice(6);
        Dice defendDice = new Dice(6);

        Arena arena = new Arena(player1, player2, attackDice, defendDice);
        System.out.print(ASK_TO_START);
        scanner.nextLine();
        System.out.println();
        // TO DO: ability to restart the game
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
            handle = handle.trim().toLowerCase();
            if (Player.contains(handle)) {
                System.out.println(UNIQUE_HANDLE);
                System.out.print("Reenter handle: ");
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