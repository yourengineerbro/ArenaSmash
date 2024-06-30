package dice;

import com.yourengineerbro.arenasmash.dice.Dice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {

    private static final int SIDES = 6;
    private Dice dice;

    @BeforeEach
    public void setUp() {
        dice = new Dice(SIDES);
    }

    @Test
    public void testDiceCreation() {
        assertNotNull(dice);
        assertEquals(SIDES, dice.getSides());
    }

    @Test
    public void testRollWithinRange() {
        for (int i = 0; i < 100; i++) {  // Roll the dice multiple times to check the range
            int roll = dice.roll();
            assertTrue(roll >= 1 && roll <= SIDES, "Roll is out of range: " + roll);
        }
    }

    @Test
    public void testRollIsRandom() {
        boolean[] rolls = new boolean[SIDES];
        int uniqueRolls = 0;
        for (int i = 0; i < 100; i++) {
            int roll = dice.roll();
            if (!rolls[roll - 1]) {
                rolls[roll - 1] = true;
                uniqueRolls++;
            }
        }
        assertTrue(uniqueRolls > 1, "Rolls do not appear to be random enough");
    }
}
