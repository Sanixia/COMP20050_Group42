import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Scoring_HawkTest {

    @Test
    public void hawk_scoring_1() {
        int[] scoring_cards = {0,0,0,1,0};

        Board[][] b = new Board[26][26];

        // Should equal 1 because hawk is on its own
        b[0][2] = new Board("F", "h", 0);

        // Should equal 1 because hawk is on its own
        b[1][3] = new Board("F", "H", 0);
        b[1][4] = new Board("F", "B", 0);
        b[2][4] = new Board("F", "h", 0);
        b[2][3] = new Board("F", "E", 0);
        b[2][5] = new Board("F", "F", 0);
        b[3][4] = new Board("F", "H", 0);
        b[3][3] = new Board("F", "S", 0);

        // Should equal 0 since 2 hawks are touching
        b[0][0] = new Board("F", "h", 0);
        b[1][0] = new Board("F", "h", 0);

        // Should equal 1 because hawk is on its own
        b[0][6] = new Board("F", "h", 0);
        b[0][7] = new Board("F", "b", 0);
        b[1][6] = new Board("F", "B", 0);


        Board.print_boards(b, 8, 6, 1);
        int hawk_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);

        // 3 hawks for 8 total score
        assertEquals(8, hawk_score);
    }

    @Test
    public void hawk_scoring_2() {
        int[] scoring_cards = {0,0,0,2,0};

        Board[][] b = new Board[26][26];

        // Should equal 1 because hawk as line of sight to only 2, 4
        b[0][3] = new Board("F", "h", 0);

        // Should equal 1 because hawk as line of sight to only 0, 3
        b[1][3] = new Board("F", "H", 0);
        b[1][4] = new Board("F", "b", 0);
        b[1][5] = new Board("F", "H", 0);
        b[2][4] = new Board("F", "h", 0);
        b[2][3] = new Board("F", "E", 0);


        // Should equal 1 because hawk has line of sight to 0,5 and blocked by fox for the hawk at 2,4
        b[2][5] = new Board("F", "f", 0);
        b[2][6] = new Board("F", "h", 0);
        b[3][4] = new Board("F", "H", 0);
        b[3][3] = new Board("F", "S", 0);

        // Should equal 0 since 2 hawks are touching
        b[2][1] = new Board("F", "h", 0);
        b[2][2] = new Board("F", "h", 0);

        // Should equal 1 because hawk is in line of sight to 2, 6 and null tile at 0, 4 blocks line of sight with hawk at 0, 3
        b[0][5] = new Board("F", "h", 0);



        Board.print_boards(b, 8, 6, 1);
        int hawk_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);

        // 4 hawks for 12 total score
        assertEquals(12, hawk_score);

    }

    @Test
    public void hawk_scoring_3() {

        int[] scoring_cards = {0,0,0,3,0};

        Board[][] b = new Board[26][26];

        // Should equal 1 because hawk as line of sight to only 2, 4
        b[0][3] = new Board("F", "h", 0);

        // Should equal 1 because hawk as line of sight to only 0, 3
        b[1][3] = new Board("F", "H", 0);
        b[1][4] = new Board("F", "b", 0);
        b[1][5] = new Board("F", "H", 0);
        b[2][4] = new Board("F", "h", 0);
        b[2][3] = new Board("F", "E", 0);


        // Should equal 1 because hawk has line of sight to 0,5 and blocked by fox for the hawk at 2,4
        b[2][5] = new Board("F", "f", 0);
        b[2][6] = new Board("F", "h", 0);
        b[3][4] = new Board("F", "H", 0);
        b[3][3] = new Board("F", "S", 0);

        // Should equal 1 because it has a line of sight to 2, 4
        b[2][1] = new Board("F", "h", 0);
        b[2][2] = new Board("F", "h", 0);

        // Should equal 1 because hawk is in line of sight to 2, 6 and null tile at 0, 4 blocks line of sight with hawk at 0, 3
        b[0][5] = new Board("F", "h", 0);

        // Should equal 1 because it has a line of sight to 2, 4
        b[4][3] = new Board("F", "H", 0);
        b[5][2] = new Board("F", "h", 0);

        // 4, 5 should equal 1 because it has a line of sight to 2, 4 while 5,5 does not
        b[4][5] = new Board("F", "h", 0);
        b[5][5] = new Board("F", "h", 0);

        // Should equal 0 because it has no line of sights
        b[5][0] = new Board("F", "h", 0);


        Board.print_boards(b, 8, 6, 1);
        int hawk_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);

        // 4 hawks for 12 total score
        assertEquals(15, hawk_score);
    }
}