
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// Group 42
// Roshan, Michal
// Sanixia, glucoseIntolerant
public class Scoring_ElkTest {

    @Test
    void elk_scoring_A() {
        Board[][] b = new  Board[26][26];
        int[] scoring_cards = {0,1,0,0,0};

        // 1 elk scored
        // 2 score
        b[0][2] = new Board("W", "e", 6);

        // 2 elk scored
        // 5 score
        b[1][1] = new Board("W", "e", 6);
        b[1][2] = new Board("W", "e", 6);

        // 3 elk scored
        // 9 score
        b[2][1] = new Board("W", "e", 6);
        b[2][2] = new Board("W", "e", 6);
        b[2][3] = new Board("W", "e", 6);

        // 4 elk scored
        // 13 score
        b[3][0] = new Board("W", "e", 6);
        b[3][1] = new Board("W", "e", 6);
        b[3][2] = new Board("W", "e", 6);
        b[3][3] = new Board("W", "e", 6);

        // 3 elk scored in diagonal
        // 9 score
        b[0][6] = new Board("W", "e", 6);
        b[1][5] = new Board("W", "e", 6);
        b[2][5] = new Board("W", "e", 6);

        // 2 elk scored in straight line
        // 5 score
        b[1][6] = new Board("W", "f", 6);
        b[2][6] = new Board("W", "e", 6);
        b[2][7] = new Board("W", "e", 6);


        // 2 elk scored in straight diagonal line whilst surrounded by habitat tiles
        // 5 score

        b[4][5] = new Board("W", "e", 6);
        b[4][6] = new Board("W", "E", 6);
        b[5][5] = new Board("W", "e", 6);
        b[5][6] = new Board("W", "f", 6);
        b[5][4] = new Board("W", "F", 6);
        b[4][4] = new Board("W", "s", 6);
        b[3][4] = new Board("W", "b", 6);
        b[3][5] = new Board("W", "H", 6);



        Board.print_boards(b, 8, 6, 1);
        int elk_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);

        // 2 + 5 + 9 + 13 + 9 + 5 + 5 = 48
        assertEquals(48, elk_score);


    }

    @Test
    void elk_scoring_B() {
        Board[][] b = new Board[26][26];
        int[] scoring_cards = {0, 2, 0, 0, 0};

        // 8 elk
        // 28 score
        b[0][0] = new Board("W", "e", 6);
        b[0][1] = new Board("W", "e", 6);
        b[1][1] = new Board("W", "e", 6);
        b[1][2] = new Board("W", "e", 6);
        b[1][3] = new Board("W", "e", 6);
        b[0][4] = new Board("W", "e", 6);
        b[1][5] = new Board("W", "e", 6);
        b[2][3] = new Board("W", "e", 6);
        b[3][2] = new Board("W", "e", 6);


        // 5 elk scored
        // 14 score
        b[0][6] = new Board("W", "e", 6);
        b[1][5] = new Board("W", "e", 6);
        b[2][5] = new Board("W", "e", 6);
        b[1][6] = new Board("W", "f", 6);
        b[2][6] = new Board("W", "e", 6);
        b[2][7] = new Board("W", "e", 6);


        // 2 elk scored in straight diagonal line whilst surrounded by habitat tiles
        // 4 score
        b[4][5] = new Board("W", "e", 6);
        b[4][6] = new Board("W", "E", 6);
        b[5][5] = new Board("W", "e", 6);
        b[5][6] = new Board("W", "f", 6);
        b[5][4] = new Board("W", "F", 6);
        b[4][4] = new Board("W", "s", 6);
        b[3][4] = new Board("W", "b", 6);
        b[3][5] = new Board("W", "H", 6);

        // 1 elk
        // 2 score
        b[4][7] = new Board("W", "e", 6);


        Board.print_boards(b, 8, 6, 1);
        int elk_score = Scoring_Setup.scoring_setups(b, 1, scoring_cards);

        // 28 + 14 + 4 + 2 = 48
        assertEquals(48, elk_score);
    }

    @Test
    void elk_scoring_C() {
        Board[][] b = new  Board[26][26];
        Board[][] b1 = new  Board[26][26];
        Board[][] b2 = new  Board[26][26];
        int[] scoring_cards = {0,3,0,0,0};

        b[0][0] = new Board("W", "e", 6);
        b[0][1] = new Board("W", "e", 6);
        b[0][3] = new Board("W", "e", 6);
        b[0][5] = new Board("W", "e", 6);
        b[0][6] = new Board("W", "e", 6);
        b[1][0] = new Board("W", "e", 6);
        b[1][1] = new Board("W", "e", 6);
        b[1][3] = new Board("W", "S", 6);
        b[1][4] = new Board("W", "e", 6);
        b[1][5] = new Board("W", "e", 6);
        b[2][1] = new Board("W", "B", 6);
        b[2][2] = new Board("W", "H", 6);
        b[2][3] = new Board("W", "e", 6);
        b[3][0] = new Board("W", "e", 6);
        b[3][2] = new Board("W", "e", 6);
        b[3][3] = new Board("W", "e", 6);
        b[3][4] = new Board("W", "F", 6);
        b[3][5] = new Board("W", "e", 6);
        b[3][6] = new Board("W", "e", 6);
        b[4][1] = new Board("W", "e", 6);
        b[4][3] = new Board("W", "e", 6);
        b[4][6] = new Board("W", "e", 6);

        Board.print_boards(b, 8, 5, 1);
        int elk_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);
        assertEquals(55, elk_score);    // demonstrating different shapes rotated and still valid

        b1[0][0] = new Board("W", "e", 6);
        b1[0][3] = new Board("W", "e", 6);
        b1[0][8] = new Board("W", "e", 6);
        b1[1][0] = new Board("W", "e", 6);
        b1[1][1] = new Board("W", "e", 6);
        b1[1][3] = new Board("W", "e", 6);
        b1[1][4] = new Board("W", "e", 6);
        b1[1][5] = new Board("W", "e", 6);
        b1[1][7] = new Board("W", "e", 6);
        b1[2][0] = new Board("W", "e", 6);
        b1[2][7] = new Board("W", "e", 6);
        b1[3][2] = new Board("W", "e", 6);
        b1[3][3] = new Board("W", "e", 6);
        b1[3][6] = new Board("W", "e", 6);
        b1[4][2] = new Board("W", "e", 6);


        b2[0][0] = new Board("W", "e", 6);
        b2[0][1] = new Board("W", "e", 6);
        b2[0][4] = new Board("W", "e", 6);
        b2[0][5] = new Board("W", "e", 6);
        b2[1][0] = new Board("W", "e", 6);
        b2[1][1] = new Board("W", "e", 6);
        b2[1][3] = new Board("W", "e", 6);
        b2[1][4] = new Board("W", "e", 6);
        b2[1][7] = new Board("W", "e", 6);
        b2[2][7] = new Board("W", "e", 6);
        b2[2][8] = new Board("W", "e", 6);
        b2[3][2] = new Board("W", "e", 6);
        b2[3][3] = new Board("W", "e", 6);
        b2[3][7] = new Board("W", "e", 6);
        b2[4][3] = new Board("W", "e", 6);

        Board.print_boards(b1, 9, 5, 1);
        int elk_score1 = Scoring_Setup.scoring_setups(b1, 1,  scoring_cards);

        Board.print_boards(b2, 9, 5, 1);
        int elk_score2 = Scoring_Setup.scoring_setups(b2, 1,  scoring_cards);
        assertNotEquals(elk_score2, elk_score1);    // b1 should not equal b2 as it doesnt have valid shapes
    }
}
