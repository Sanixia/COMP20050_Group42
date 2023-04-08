import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Scoring_FoxTest
{
    @Test
    public void fox_scorecard1() {
        Board[][] b = new  Board[26][26];
        int[] scoring_cards = {0,0,1,0,0};

        b[1][2] = new Board("F", "h", 0);
        b[1][3] = new Board("F", "S", 0);
        b[2][2] = new Board("F", "s", 0);
        b[2][3] = new Board("F", "f", 0);
        b[2][4] = new Board("F", "b", 0);
        b[3][2] = new Board("F", "e", 0);
        b[3][3] = new Board("F", "h", 0);

        Board.print_boards(b, 6, 5, 1);
        int fox_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);
        assertEquals(4, fox_score);

        b[0][1] = new Board("F", "f", 0);
        b[0][3] = new Board("F", "e", 0);
        b[0][4] = new Board("F", "s", 0);
        b[1][3] = new Board("F", "f", 0);
        b[2][1] = new Board("F", "S", 0);
        b[3][0] = new Board("F", "s", 0);
        b[3][1] = new Board("F", "f", 0);

        Board.print_boards(b, 6, 5, 1);
        fox_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);
        assertEquals(12, fox_score);
    }

    @Test
    public void fox_scorecard2() {
        Board[][] b = new  Board[26][26];
        int[] scoring_cards = {0,0,2,0,0};

        b[1][1] = new Board("F", "h", 0);
        b[1][2] = new Board("F", "s", 0);
        b[2][1] = new Board("F", "s", 0);
        b[2][2] = new Board("F", "f", 0);
        b[2][3] = new Board("F", "b", 0);
        b[3][1] = new Board("F", "e", 0);
        b[3][2] = new Board("F", "h", 0);

        Board.print_boards(b, 6, 5, 1);
        int fox_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);
        assertEquals(5, fox_score);

        b[0][1] = new Board("F", "s", 0);
        b[0][2] = new Board("F", "s", 0);
        b[1][0] = new Board("F", "e", 0);
        b[1][1] = new Board("F", "f", 0);
        b[1][2] = new Board("F", "e", 0);
        b[1][3] = new Board("F", "f", 0);
        b[2][3] = new Board("F", "e", 0);
        b[3][1] = new Board("F", "b", 0);
        b[3][2] = new Board("F", "b", 0);

        Board.print_boards(b, 6, 5, 1);
        fox_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);
        assertEquals(12, fox_score);
    }

    @Test
    public void fox_scorecard3() {
        Board[][] b = new  Board[26][26];
        int[] scoring_cards = {0,0,3,0,0};

        b[1][2] = new Board("F", "h", 0);
        b[1][3] = new Board("F", "h", 0);
        b[2][2] = new Board("F", "s", 0);
        b[2][3] = new Board("F", "f", 0);
        b[2][4] = new Board("F", "b", 0);
        b[3][2] = new Board("F", "e", 0);
        b[3][3] = new Board("F", "h", 0);

        Board.print_boards(b, 6, 5, 1);
        int fox_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);
        assertEquals(3, fox_score);

        b[0][1] = new Board("F", "s", 0);
        b[0][2] = new Board("F", "s", 0);
        b[0][3] = new Board("F", "b", 0);
        b[0][4] = new Board("F", "e", 0);
        b[1][0] = new Board("F", "e", 0);
        b[1][1] = new Board("F", "f", 0);
        b[1][2] = new Board("F", "e", 0);
        b[1][3] = new Board("F", "f", 0);
        b[1][4] = new Board("F", "b", 0);
        b[2][1] = new Board("F", "f", 0);
        b[2][3] = new Board("F", "e", 0);
        b[3][2] = null;
        b[3][3] = null;

        Board.print_boards(b, 6, 5, 1);
        fox_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);
        assertEquals(7, fox_score);
    }
}