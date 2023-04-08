import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Scoring_SalmonTest {

    @Test
    public void salmon_scoring_A() {
        int[] scoring_cards = {0,0,0,0,1};

        Board[][] b = new  Board[26][26];

        // 6 salmon scored because they are not adjacent to more than 1 salmon for the run
        // 20 score for 6 salmon
        b[0][0] = new Board("P", "s", 0);
        b[1][0] = new Board("P", "s", 0);
        b[1][1] = new Board("P", "s", 0);
        b[1][2] = new Board("P", "s", 0);
        b[0][3] = new Board("P", "s", 0);
        b[0][4] = new Board("P", "s", 0);


        // 0 salmon scored because they are touching more than 2 salmon each
        // 0 score for 0 salmon
        b[3][0] = new Board("P", "s", 0);
        b[3][1] = new Board("P", "s", 0);
        b[4][1] = new Board("P", "s", 0);
        b[4][0] = new Board("P", "s", 0);
        b[5][0] = new Board("P", "s", 0);


        // 4 salmon scored from the run
        // 11 score for 4 salmon
        b[3][3] = new Board("P", "s", 0);
        b[2][4] = new Board("P", "s", 0);
        b[2][5] = new Board("P", "s", 0);
        b[3][4] = new Board("P", "B", 0);
        b[3][5] = new Board("P", "s", 0);
        b[4][4] = new Board("P", "B", 0);
        b[4][5] = new Board("P", "F", 0);


        // 2 salmon scored from the run
        // 4 score for 2 salmon
        b[5][5] = new Board("P", "f", 0);
        b[4][6] = new Board("P", "b", 0);
        b[3][6] = new Board("P", "h", 0);
        b[5][6] = new Board("P", "s", 0);
        b[4][7] = new Board("P", "s", 0);







        Board.print_boards(b, 8, 6, 1);
        int salmon_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);

        // 20 + 0 + 11 + 4 = 35
        assertEquals(35, salmon_score);
    }


    @Test
    public void salmon_scoring_B() {

        Scoring_Salmon.getSalmon_found().clear();
        Scoring_Salmon.setIndex_salmon(1);

        int[] scoring_cards = {0,0,0,0,2};

        Board[][] b = new  Board[26][26];

        // 4 salmon scored because they are not adjacent to more than 1 salmon for the run
        // 12 score for 4 salmon (after 4 doesn't count)
        b[0][0] = new Board("P", "s", 0);
        b[1][0] = new Board("P", "s", 0);
        b[1][1] = new Board("P", "s", 0);
        b[1][2] = new Board("P", "s", 0);
        b[0][3] = new Board("P", "s", 0);
        b[0][4] = new Board("P", "s", 0);


        // 0 salmon scored because they are touching more than 2 salmon each
        // 0 score for 0 salmon
        b[3][0] = new Board("P", "s", 0);
        b[3][1] = new Board("P", "s", 0);
        b[4][1] = new Board("P", "s", 0);
        b[4][0] = new Board("P", "s", 0);
        b[5][0] = new Board("P", "s", 0);


        // 4 salmon scored from the run
        // 12 score for 4 salmon
        b[3][3] = new Board("P", "s", 0);
        b[2][4] = new Board("P", "s", 0);
        b[2][5] = new Board("P", "s", 0);
        b[3][4] = new Board("P", "B", 0);
        b[3][5] = new Board("P", "s", 0);
        b[4][4] = new Board("P", "B", 0);
        b[4][5] = new Board("P", "F", 0);


        // 2 salmon scored from the run
        // 4 score for 2 salmon
        b[5][5] = new Board("P", "f", 0);
        b[4][6] = new Board("P", "b", 0);
        b[3][6] = new Board("P", "h", 0);
        b[5][6] = new Board("P", "s", 0);
        b[4][7] = new Board("P", "s", 0);



        Board.print_boards(b, 8, 6, 1);
        int salmon_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);

        // 12 + 0 + 12 + 4 = 28
        assertEquals(28, salmon_score);
    }


    @Test
    public void salmon_scoring_C() {



        Scoring_Salmon.getSalmon_found().clear();
        Scoring_Salmon.setIndex_salmon(1);

        int[] scoring_cards = {0,0,0,0,3};

        Board[][] b = new  Board[26][26];

        // 4 salmon scored because they are not adjacent to more than 1 salmon for the run
        // 17 score for 5 salmon (after 5 doesn't count)
        b[0][0] = new Board("P", "s", 0);
        b[1][0] = new Board("P", "s", 0);
        b[1][1] = new Board("P", "s", 0);
        b[1][2] = new Board("P", "s", 0);
        b[0][3] = new Board("P", "s", 0);
        b[0][4] = new Board("P", "s", 0);


        // 0 salmon scored because they are touching more than 2 salmon each
        // 0 score for 0 salmon
        b[3][0] = new Board("P", "s", 0);
        b[3][1] = new Board("P", "s", 0);
        b[4][1] = new Board("P", "s", 0);
        b[4][0] = new Board("P", "s", 0);
        b[5][0] = new Board("P", "s", 0);


        // 4 salmon scored from the run
        // 11 score for 4 salmon
        b[3][3] = new Board("P", "s", 0);
        b[2][4] = new Board("P", "s", 0);
        b[2][5] = new Board("P", "s", 0);
        b[3][4] = new Board("P", "B", 0);
        b[3][5] = new Board("P", "s", 0);
        b[4][4] = new Board("P", "B", 0);
        b[4][5] = new Board("P", "F", 0);


        // 2 salmon scored from the run
        // 4 score for 2 salmon
        b[5][5] = new Board("P", "f", 0);
        b[4][6] = new Board("P", "b", 0);
        b[3][6] = new Board("P", "h", 0);
        b[5][6] = new Board("P", "s", 0);
        b[4][7] = new Board("P", "s", 0);



        Board.print_boards(b, 8, 6, 1);
        int salmon_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);

        // 17 + 0 + 11 + 4 = 32
        assertEquals(32, salmon_score);
    }
}