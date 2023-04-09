
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// Group 42
// Roshan, Michal
// Sanixia, glucoseIntolerant
class Scoring_BearTest
{
    @Test
    public void bear_scorecard_A() {
        Board[][] b1 = new  Board[26][26];
        Board[][] b2 = new  Board[26][26];
        int[] scoring_cards = {1, 0, 0, 0, 0};  // b e f h s

        b1[0][1] = new Board("F", "b", 0);
        b1[0][3] = new Board("F", "b", 0);
        b1[0][4] = new Board("F", "b", 0);
        b1[1][1] = new Board("F", "b", 0);
        b1[1][2] = new Board("F", "E", 0);
        b1[1][3] = new Board("F", "H", 0);
        b1[2][3] = new Board("F", "b", 0);
        b1[2][4] = new Board("F", "b", 0);

        Board.print_boards(b1, 6, 4, 1);
        int bear_score1 = Scoring_Setup.scoring_setups(b1, 1,  scoring_cards);
        assertEquals(19, bear_score1);   // 3 pairs

        b2 = b1;
        b2[2][0] = new Board("F", "b", 0);
        b2[2][1] = new Board("F", "S", 0);
        b2[3][0] = new Board("F", "b", 0);
        b2[4][0] = new Board("F", "b", 0);
        b2[4][1] = new Board("F", "E", 0);
        b2[4][2] = new Board("F", "b", 0);
        b2[4][3] = new Board("F", "F", 0);
        b2[4][4] = new Board("F", "b", 0);

        Board.print_boards(b2, 6, 5, 1);
        int bear_score2 = Scoring_Setup.scoring_setups(b2, 1,  scoring_cards);
        assertEquals(bear_score1, bear_score2);     // demonstrating only pairs are valid
    }

    @Test
    public void bear_scorecard_B() {
        Board[][] b1 = new  Board[26][26];
        Board[][] b2 = new  Board[26][26];
        int[] scoring_cards = {2, 0, 0, 0, 0};  // b e f h s

        b2[0][1] = new Board("F", "b", 0);
        b2[0][3] = new Board("F", "b", 0);
        b2[0][4] = new Board("F", "b", 0);
        b2[1][0] = new Board("F", "b", 0);
        b2[1][1] = new Board("F", "b", 0);
        b2[1][2] = new Board("F", "E", 0);
        b2[1][4] = new Board("F", "b", 0);
        b2[2][1] = new Board("F", "F", 0);
        b2[3][1] = new Board("F", "b", 0);
        b2[3][2] = new Board("F", "b", 0);
        b2[3][3] = new Board("F", "b", 0);

        Board.print_boards(b2, 6, 5, 1);
        int bear_score = Scoring_Setup.scoring_setups(b2, 1,  scoring_cards);
        assertEquals(30, bear_score);   // demonstrating any shape for group of 3 works

        b1[0][0] = new Board("F", "b", 0);
        b1[0][1] = new Board("F", "b", 0);
        b1[0][2] = new Board("F", "b", 0);
        b1[0][4] = new Board("F", "b", 0);
        b1[1][0] = new Board("F", "b", 0);
        b1[1][4] = new Board("F", "b", 0);
        b1[2][1] = new Board("F", "S", 0);
        b1[2][2] = new Board("F", "b", 0);
        b1[2][3] = new Board("F", "b", 0);
        b1[2][4] = new Board("F", "E", 0);
        b1[3][0] = new Board("F", "b", 0);
        b1[3][2] = new Board("F", "b", 0);

        Board.print_boards(b1, 6, 5, 1);
        bear_score = Scoring_Setup.scoring_setups(b1, 1,  scoring_cards);
        assertEquals(10, bear_score);   // only group of 3 scored
    }

    @Test
    public void bear_scorecard_C() {
        Board[][] b1 = new  Board[26][26];
        Board[][] b2 = new  Board[26][26];
        int[] scoring_cards = {3, 0, 0, 0, 0};  // b e f h s

        b1[0][0] = new Board("F", "b", 0);
        b1[0][1] = new Board("F", "b", 0);
        b1[0][3] = new Board("F", "H", 0);
        b1[0][4] = new Board("F", "b", 0);
        b1[1][0] = new Board("F", "b", 0);
        b1[1][2] = new Board("F", "b", 0);
        b1[1][4] = new Board("F", "b", 0);
        b1[2][1] = new Board("F", "H", 0);
        b1[2][2] = new Board("F", "b", 0);
        b1[3][1] = new Board("F", "b", 0);

        Board.print_boards(b1, 6, 4, 1);
        int bear_score = Scoring_Setup.scoring_setups(b1, 1,  scoring_cards);
        assertEquals(21, bear_score);   // two groups of 3 + group of 2

        b2[0][0] = new Board("F", "b", 0);
        b2[0][1] = new Board("F", "b", 0);
        b2[0][2] = new Board("F", "S", 0);
        b2[0][4] = new Board("F", "b", 0);
        b2[0][5] = new Board("F", "b", 0);
        b2[1][0] = new Board("F", "b", 0);
        b2[1][2] = new Board("F", "b", 0);
        b2[1][3] = new Board("F", "E", 0);

        Board.print_boards(b2, 7, 3, 1);
        bear_score = Scoring_Setup.scoring_setups(b2, 1,  scoring_cards);
        assertEquals(18, bear_score);       // complete set ie + bonus
    }
}