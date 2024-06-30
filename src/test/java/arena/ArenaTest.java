package arena;

import com.yourengineerbro.arenasmash.arena.Arena;
import com.yourengineerbro.arenasmash.dice.Dice;
import com.yourengineerbro.arenasmash.player.Player;
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


    private Player mockPlayer1;


    private Player mockPlayer2;

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
        mockPlayer1 = new Player("Player1", 200, 5, 36);
        mockPlayer2 = new Player("Player2", 90, 4, 35);


        // Initialize Arena with mock objects
        arena = new Arena(mockPlayer1, mockPlayer2, mockAttackDice, mockDefendDice);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testFight_Player1Wins() {
        // Setup mock player behaviors
//        when(mockPlayer1.getHealth()).thenReturn(100);  // Player 1 has higher health
//        when(mockPlayer2.getHealth()).thenReturn(50);   // Player 2 has lower health
//        when(mockPlayer1.getPlayerHandle()).thenReturn("Player1");
//        when(mockPlayer2.getPlayerHandle()).thenReturn("Player2");

        // Setup mock dice rolls
        when(mockAttackDice.roll()).thenReturn(6);  // Mock attack dice roll
        when(mockDefendDice.roll()).thenReturn(3);  // Mock defend dice roll

        // Mock user input via scanner (not needed for this test)
        mockUserInput();

        // Call the fight method
        arena.fight(mockScanner);

        // Assert the winner based on expected outcome
        assertEquals("Player1 wins the match!", getConsoleOutput().trim());
    }

    @Test
    public void testFight_Player2Wins() {
        // Setup mock player behaviors
//        when(mockPlayer1.getHealth()).thenReturn(50);   // Player 1 has lower health
//        when(mockPlayer2.getHealth()).thenReturn(100);  // Player 2 has higher health
//        when(mockPlayer1.getPlayerHandle()).thenReturn("Player1");
//        when(mockPlayer2.getPlayerHandle()).thenReturn("Player2");

        // Setup mock dice rolls
        when(mockAttackDice.roll()).thenReturn(6);  // Mock attack dice roll
        when(mockDefendDice.roll()).thenReturn(2);  // Mock defend dice roll

        // Mock user input via scanner (not needed for this test)
        mockUserInput();

        // Call the fight method
        arena.fight(mockScanner);

        // Assert the winner based on expected outcome
        assertEquals("Player2 wins the match!", getConsoleOutput().trim());
    }

    private void mockUserInput() {
        // Mock user input via scanner
        when(mockScanner.nextLine()).thenReturn("");
    }

    private String getConsoleOutput() {
        String capturedOutput = outputStream.toString();

        // Split by lines and get the last line
        String[] lines = capturedOutput.split(System.lineSeparator());
        return lines[lines.length - 1];
    }
}
