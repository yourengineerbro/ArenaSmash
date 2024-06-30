package com.yourengineerbro.arenasmash.dice;

import java.util.Random;

public class Dice {
    private final int sides;
    private final Random random;

    public Dice(int sides) {
        this.sides = sides;
        this.random = new Random();
    }

    public int getSides() {
        return sides;
    }

    // can change the random logic
    public int roll() {
        return random.nextInt(sides) + 1;
    }
}
