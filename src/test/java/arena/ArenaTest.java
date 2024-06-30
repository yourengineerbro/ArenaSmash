package arena;

import com.yourengineerbro.arenasmash.arena.Arena;
import com.yourengineerbro.arenasmash.dice.Dice;
import com.yourengineerbro.arenasmash.player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArenaTest {

    @Mock
    private Dice mockAttackDice;

    @Mock
    private Dice mockDefendDice;

    @Mock
    private Scanner mockScanner;

    private Arena arena;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        Player mockPlayer1 = new Player("Player1", 200, 5, 36);
        Player mockPlayer2 = new Player("Player2", 90, 4, 35);

        // Initialize Arena with mock objects
        arena = new Arena(mockPlayer1, mockPlayer2, mockAttackDice, mockDefendDice);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void close() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void testFight_Player1Wins() {

        // Setup mock dice rolls
        when(mockAttackDice.roll()).thenReturn(6);  // Mock attack dice roll
        when(mockDefendDice.roll()).thenReturn(3);  // Mock defend dice roll

        // Call the fight method
        arena.fight(mockScanner);

        // Assert the winner based on expected outcome
        assertEquals("Player1 wins the match!", getConsoleOutput().trim());
    }

    @Test
    public void testFight_Player2Wins() {

        // Setup mock dice rolls
        when(mockAttackDice.roll()).thenReturn(6);  // Mock attack dice roll
        when(mockDefendDice.roll()).thenReturn(2);  // Mock defend dice roll

        // Call the fight method
        arena.fight(mockScanner);

        // Assert the winner based on expected outcome
        assertEquals("Player2 wins the match!", getConsoleOutput().trim());
    }

    private String getConsoleOutput() {
        String capturedOutput = outputStream.toString();

        // Split by lines and get the last line
        String[] lines = capturedOutput.split(System.lineSeparator());
        return lines[lines.length - 1];
    }
}
