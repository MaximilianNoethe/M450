package ch.tbz.m450.connect4.ui;

import ch.tbz.m450.connect4.logic.Board;
import ch.tbz.m450.connect4.logic.GameRules;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsoleUITest {

    @Mock
    Board board;

    @Mock
    GameRules gameRules;

    @Test
    public void testPlayOneRound() {
        // Simulate user input: "4\n" (column 4)
        String inputData = "4\n";
        InputStream stdin = new ByteArrayInputStream(inputData.getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(stdin);

        ConsoleUI ui = new ConsoleUI(board, gameRules, scanner);

        // When checkWin is called, return false to continue (or true to stop, checking
        // loop logic)
        // Let's testing a single placement then stop or simulate a win.
        // Assume processTurn returns true if game continues, false if game over.

        // We will test a method called processTurn()
        ui.processTurn('X');

        // Verify that board.dropToken was called with column 4 and player 'X'
        verify(board).dropToken(4, 'X');
    }
}
