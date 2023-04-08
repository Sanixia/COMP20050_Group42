import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Scoring_SetupTest {
        @Test
        void FoxTest() {
                Board[][] b = new  Board[26][26];

                b[0][2] = new Board("F", "f", 0);
                b[0][3] = new Board("F", "f", 0);
                b[2][2] = new Board("F", "f", 0);
                b[2][3] = new Board("F", "f", 0);
                b[3][4] = new Board("F", "f", 0);
                b[3][2] = new Board("F", "f", 0);


                int[] scoring_cards = {0,0,1,0,0};
                Board.print_boards(b, 8, 6, 1);
                int fox_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);
                assertEquals(5, fox_score);

        }



}