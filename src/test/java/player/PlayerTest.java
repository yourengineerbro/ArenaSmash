package player;

import com.yourengineerbro.arenasmash.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {

    @BeforeEach
    public void setUp() {
        // Reset playerCounter and playerHandles before each test
        Player.resetPlayerCounter();
        Player.resetPlayerHandles();
    }

    @Test
    public void testPlayerCreation() {
        Player player = new Player("player1", 100, 10, 20);
        assertNotNull(player);
        assertEquals("player1", player.getPlayerHandle());
        assertEquals(100, player.getHealth());
        assertEquals(10, player.getStrength());
        assertEquals(20, player.getAttack());
        assertTrue(player.isAlive());
    }

    @Test
    public void testDefaultPlayerCreation() {
        Player player = new Player();
        assertNotNull(player);
        assertEquals(player.getPlayerID(), 0);
        assertNull(player.getPlayerHandle());
        assertEquals(0, player.getHealth());
        assertEquals(0, player.getStrength());
        assertEquals(0, player.getAttack());
    }

    @Test
    public void testPlayerCounter() {
        Player player1 = new Player("player1", 100, 10, 20);
        Player player2 = new Player("player2", 100, 10, 20);
        assertEquals(0, player1.getPlayerID());
        assertEquals(1, player2.getPlayerID());
    }

    @Test
    public void testHealthModification() {
        Player player = new Player("player1", 100, 10, 20);
        player.setHealth(80);
        assertEquals(80, player.getHealth());
    }

    @Test
    public void testPlayerDeath() {
        Player player = new Player("player1", 100, 10, 20);
        player.setHealth(0);
        assertFalse(player.isAlive());
    }

    @Test
    public void testPlayerHandleUniqueness() {
        Player.addPlayerHandle("player1");
        assertTrue(Player.contains("player1"));

        // Attempt to add a duplicate handle
        Player.addPlayerHandle("player1");
        // The handle should not be added again
        assertEquals(1, Player.getPlayerHandlesSize());
    }

    @Test
    public void testSetPlayerHandle() {
        Player player = new Player("player1", 100, 10, 20);
        player.setPlayerHandle("player2");
        assertEquals("player2", player.getPlayerHandle());
    }

    @Test
    public void testSetStrength() {
        Player player = new Player("player1", 100, 10, 20);
        player.setStrength(15);
        assertEquals(15, player.getStrength());
    }

    @Test
    public void testSetAttack() {
        Player player = new Player("player1", 100, 10, 20);
        player.setAttack(25);
        assertEquals(25, player.getAttack());
    }
}

