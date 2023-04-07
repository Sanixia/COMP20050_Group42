import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Scoring_HawkTest {

    @Test
    public void hawk_scoring_1() {
        Board[][] b = new Board[26][26];

        b[0][2] = new Board("F", "h", 0);
        b[0][3] = new Board("F", "h", 0);
        b[2][2] = new Board("F", "h", 0);
        b[2][3] = new Board("F", "h", 0);
        b[3][4] = new Board("F", "h", 0);
        b[3][2] = new Board("F", "h", 0);


        int[] scoring_cards = {0,0,0,1,0};
        Board.print_boards(b, 8, 6, 1);
        int hawk_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);
        assertEquals(1, hawk_score);
    }

    @Test
    public void hawk_scoring_2() {
    }

    @Test
    public void hawk_scoring_3() {
    }
}