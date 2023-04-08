
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Scoring_ElkTest {

    @Test
    void elk_scoring_A() {
        Board[][] b = new  Board[26][26];
        int[] scoring_cards = {0,1,0,0,0};

        // 1 elk scored
        // 2 score
        b[0][2] = new Board("W", "e", 0);

        // 2 elk scored
        // 5 score
        b[1][1] = new Board("W", "e", 0);
        b[1][2] = new Board("W", "e", 0);

        // 3 elk scored
        // 9 score
        b[2][1] = new Board("W", "e", 0);
        b[2][2] = new Board("W", "e", 0);
        b[2][3] = new Board("W", "e", 0);

        // 4 elk scored
        // 13 score
        b[3][0] = new Board("W", "e", 0);
        b[3][1] = new Board("W", "e", 0);
        b[3][2] = new Board("W", "e", 0);
        b[3][3] = new Board("W", "e", 0);

        // 3 elk scored in diagonal
        // 9 score
        b[0][6] = new Board("W", "e", 0);
        b[1][5] = new Board("W", "e", 0);
        b[2][5] = new Board("W", "e", 0);

        // 2 elk scored in straight line
        // 5 score
        b[1][6] = new Board("W", "f", 0);
        b[2][6] = new Board("W", "e", 0);
        b[2][7] = new Board("W", "e", 0);


        // 2 elk scored in straight diagonal line whilst surrounded by habitat tiles
        // 5 score

        b[4][5] = new Board("W", "e", 0);
        b[4][6] = new Board("W", "E", 0);
        b[5][5] = new Board("W", "e", 0);
        b[5][6] = new Board("W", "f", 0);
        b[5][4] = new Board("W", "F", 0);
        b[4][4] = new Board("W", "s", 0);
        b[3][4] = new Board("W", "b", 0);
        b[3][5] = new Board("W", "H", 0);



        Board.print_boards(b, 8, 6, 1);
        int elk_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);

        // 2 + 5 + 9 + 13 + 9 + 5 + 5 = 48
        assertEquals(48, elk_score);


    }

    @Test
    void elk_scoring_B() {
        Board[][] b = new  Board[26][26];
        int[] scoring_cards = {0,2,0,0,0};

        // 1 elk scored
        // 2 score
        b[0][2] = new Board("W", "e", 0);

        // 2 elk scored
        // 5 score
        b[1][1] = new Board("W", "e", 0);
        b[1][2] = new Board("W", "e", 0);

        // 3 elk scored
        // 9 score
        b[2][1] = new Board("W", "e", 0);
        b[2][2] = new Board("W", "e", 0);
        b[2][3] = new Board("W", "e", 0);

        // 4 elk scored
        // 13 score
        b[3][0] = new Board("W", "e", 0);
        b[3][1] = new Board("W", "e", 0);
        b[3][2] = new Board("W", "e", 0);
        b[3][3] = new Board("W", "e", 0);

        // 3 elk scored in diagonal
        // 9 score
        b[0][6] = new Board("W", "e", 0);
        b[1][5] = new Board("W", "e", 0);
        b[2][5] = new Board("W", "e", 0);

        // 2 elk scored in straight line
        // 5 score
        b[1][6] = new Board("W", "f", 0);
        b[2][6] = new Board("W", "e", 0);
        b[2][7] = new Board("W", "e", 0);


        // 2 elk scored in straight diagonal line whilst surrounded by habitat tiles
        // 5 score

        b[4][5] = new Board("W", "e", 0);
        b[4][6] = new Board("W", "E", 0);
        b[5][5] = new Board("W", "e", 0);
        b[5][6] = new Board("W", "f", 0);
        b[5][4] = new Board("W", "F", 0);
        b[4][4] = new Board("W", "s", 0);
        b[3][4] = new Board("W", "b", 0);
        b[3][5] = new Board("W", "H", 0);



        Board.print_boards(b, 8, 6, 1);
        int elk_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);

        // 2 + 5 + 9 + 13 + 9 + 5 + 5 = 48
        assertEquals(48, elk_score);
    }

    @Test
    void elk_scoring_C() {
        Board[][] b = new  Board[26][26];
        int[] scoring_cards = {0,1,0,1,0};

        b[0][2] = new Board("F", "f", 0);
        b[0][3] = new Board("F", "f", 0);
        b[2][2] = new Board("F", "f", 0);
        b[2][3] = new Board("F", "f", 0);
        b[3][4] = new Board("F", "f", 0);
        b[3][2] = new Board("F", "f", 0);

        Board.print_boards(b, 8, 6, 1);
        int elk_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);
        assertEquals(5, elk_score);

        b[0][1] = new Board("F", "f", 0);
        b[0][3] = new Board("F", "f", 0);
        b[0][4] = new Board("F", "f", 0);
        b[1][3] = new Board("F", "f", 0);
        b[2][1] = new Board("F", "f", 0);
        b[3][0] = new Board("F", "f", 0);
        b[3][1] = new Board("F", "f", 0);

        Board.print_boards(b, 8, 6, 1);
        elk_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);
        assertEquals(12, elk_score);
    }
}
