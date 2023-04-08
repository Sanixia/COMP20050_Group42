import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Scoring_SalmonTest {

    @Test
    public void salmon_scoring_A() {
        int[] scoring_cards = {0,0,0,0,1};

        Board[][] b = new  Board[26][26];

        // Gives 6 because they are not adjacent to more than 1 salmon for the run
        b[0][0] = new Board("P", "s", 0);
        b[1][0] = new Board("P", "s", 0);
        b[1][1] = new Board("P", "s", 0);
        b[1][2] = new Board("P", "s", 0);
        b[0][3] = new Board("P", "s", 0);
        b[0][4] = new Board("P", "s", 0);


        // Gives 0 because they are touching more than 2 salmon each
        b[3][0] = new Board("P", "s", 0);
        b[3][1] = new Board("P", "s", 0);
        b[4][1] = new Board("P", "s", 0);
        b[4][0] = new Board("P", "s", 0);
        b[5][0] = new Board("P", "s", 0);


        // Gives 4 from the run
        b[3][3] = new Board("P", "s", 0);
        b[2][4] = new Board("P", "s", 0);
        b[2][5] = new Board("P", "s", 0);
        b[3][4] = new Board("P", "B", 0);
        b[3][5] = new Board("P", "s", 0);

        b[5][5] = new Board("P", "f", 0);
        b[4][6] = new Board("P", "b", 0);
        b[3][6] = new Board("P", "s", 0);







        Board.print_boards(b, 8, 6, 1);
        int salmon_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);

        // 4 hawks for 12 total score
        assertEquals(31, salmon_score);
    }


    @Test
    public void salmon_scoring_B() {
    }


    @Test
    public void salmon_scoring_C() {
    }
}