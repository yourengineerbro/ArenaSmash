package com.yourengineerbro.arenasmash.dice;

import java.util.Random;

public class Dice {
    private final int sides;
    private final Random random;

    public Dice(int sides) {
        this.sides = sides;
        this.random = new Random();
    }
    // can change the random logic
    public int roll() {
        return random.nextInt(sides) + 1;
    }
}
