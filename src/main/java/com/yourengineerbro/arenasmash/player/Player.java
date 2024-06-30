package com.yourengineerbro.arenasmash.player;

public class Player {
    // Decision if needed to change byte to int
    private final byte playerID;
    private static byte playerCounter = 0;
    // to check if playerHandles can be specifically declared non-final.
    private String playerHandle;
    private int health;
    private int strength;
    private int attack;

    // Constructor
    public Player(String playerHandle, int health, int strength, int attack) {
        this.playerID = playerCounter++;
        this.playerHandle = playerHandle;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    // Default constructor
    public Player() {
        this.playerID = playerCounter++;
    }

    public byte getPlayerID() {
        return playerID;
    }

    // Getter and Setter for playerHandle
    public String getPlayerHandle() {
        return playerHandle;
    }

    public void setPlayerHandle(String playerHandle) {
        this.playerHandle = playerHandle;
    }

    // Getter and Setter for health
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    // Getter and Setter for strength
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    // Getter and Setter for attack
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public boolean isAlive() {
        return health > 0;
    }

}

