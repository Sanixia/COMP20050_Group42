
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Scoring_Test_Board {
        @Test
        void Test_Example_Board_All_A() {
                int[] scoring_cards = {1,1,1,1,1};
                Board[][] b = new  Board[26][26];

                b[0][2] = new Board("F", "FB", 0);
                b[0][3] = new Board("F", "b", 0);
                b[0][5] = new Board("F", "s", 0);

                b[1][1] = new Board("F", "h", 0);
                b[1][2] = new Board("F", "b", 0);
                b[1][3] = new Board("F", "s", 0);
                b[1][4] = new Board("F", "s", 0);
                b[1][5] = new Board("F", "e", 0);
                b[1][6] = new Board("F", "h", 0);

                b[2][1] = new Board("F", "f", 0);
                b[2][2] = new Board("F", "f", 0);
                b[2][3] = new Board("F", "s", 0);
                b[2][4] = new Board("F", "h", 0);
                b[2][5] = new Board("F", "e", 0);
                b[2][6] = new Board("F", "b", 0);

                b[3][1] = new Board("F", "e", 0);
                b[3][2] = new Board("F", "e", 0);
                b[3][3] = new Board("F", "s", 0);
                b[3][4] = new Board("F", "e", 0);
                b[3][5] = new Board("F", "b", 0);
                b[3][6] = new Board("F", "F", 0);

                b[4][3] = new Board("F", "BES", 0);
                b[4][4] = new Board("F", "h", 0);
                b[4][5] = new Board("F", "f", 0);


                // Bear: 2 pairs of bear for 11 points
                // Fox:  Fox at 2,1 with 3 points, 2,2 with 5 points, 4,5 with 3 points for 11 points
                // Salmon: 5 salmon run for 15 points
                // Hawk: 4 valid hawks for 11 points
                // Elk: one run of 3 elk for 9 points and one run of 2 elk for 5 points for 14 points

                // Total: 11 + 11 + 15 + 11 + 14 = 62 points

                Board.print_boards(b, 8, 6, 1);
                int total_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);
                assertEquals(62, total_score);

        }

        @Test
        void Test_Example_Board_All_B() {

                Scoring_Salmon.getSalmon_found().clear();
                Scoring_Salmon.setIndex_salmon(1);

                int[] scoring_cards = {2,2,2,2,2};
                Board[][] b = new  Board[26][26];

                b[0][2] = new Board("F", "FB", 0);
                b[0][3] = new Board("F", "b", 0);
                b[0][5] = new Board("F", "s", 0);

                b[1][1] = new Board("F", "h", 0);
                b[1][2] = new Board("F", "b", 0);
                b[1][3] = new Board("F", "s", 0);
                b[1][4] = new Board("F", "s", 0);
                b[1][5] = new Board("F", "e", 0);
                b[1][6] = new Board("F", "h", 0);

                b[2][1] = new Board("F", "F", 0);
                b[2][2] = new Board("F", "f", 0);
                b[2][3] = new Board("F", "s", 0);
                b[2][4] = new Board("F", "h", 0);
                b[2][5] = new Board("F", "e", 0);
                b[2][6] = new Board("F", "b", 0);

                b[3][0] = new Board("F", "h", 0);
                b[3][1] = new Board("F", "e", 0);
                b[3][2] = new Board("F", "e", 0);
                b[3][3] = new Board("F", "s", 0);
                b[3][4] = new Board("F", "e", 0);
                b[3][5] = new Board("F", "b", 0);
                b[3][6] = new Board("F", "F", 0);

                b[4][3] = new Board("F", "BES", 0);
                b[4][4] = new Board("F", "h", 0);
                b[4][5] = new Board("F", "f", 0);


                // Bear: no bears found with 3 so 0 points
                // Fox:  Fox at 2,2 with 1 pair for 2 points
                // Salmon: 5 salmon run for 12 points
                // Hawk: 2 hawks found with line of sight for 5 points
                // Elk: one run of 3 elk for 7 points and one run of 2 elk for 4 points for 11 points

                // Total: 0 + 2 + 12 + 5 + 11 = 30 points

                Board.print_boards(b, 8, 6, 1);
                int total_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);
                assertEquals(30, total_score);

        }

        @Test
        void Test_Example_Board_All_C() {

                Scoring_Salmon.getSalmon_found().clear();
                Scoring_Salmon.setIndex_salmon(1);

                int[] scoring_cards = {3,3,3,3,3};
                Board[][] b = new  Board[26][26];

                b[0][2] = new Board("F", "FB", 0);
                b[0][3] = new Board("F", "b", 0);
                b[0][5] = new Board("F", "s", 0);

                b[1][1] = new Board("F", "h", 0);
                b[1][2] = new Board("F", "b", 0);
                b[1][3] = new Board("F", "s", 0);
                b[1][4] = new Board("F", "s", 0);
                b[1][5] = new Board("F", "e", 0);
                b[1][6] = new Board("F", "h", 0);

                b[2][1] = new Board("F", "F", 0);
                b[2][2] = new Board("F", "f", 0);
                b[2][3] = new Board("F", "s", 0);
                b[2][4] = new Board("F", "h", 0);
                b[2][5] = new Board("F", "e", 0);
                b[2][6] = new Board("F", "b", 0);

                b[3][0] = new Board("F", "h", 0);
                b[3][1] = new Board("F", "e", 0);
                b[3][2] = new Board("F", "e", 0);
                b[3][3] = new Board("F", "s", 0);
                b[3][4] = new Board("F", "e", 0);
                b[3][5] = new Board("F", "b", 0);
                b[3][6] = new Board("F", "F", 0);

                b[4][3] = new Board("F", "BES", 0);
                b[4][4] = new Board("F", "h", 0);
                b[4][5] = new Board("F", "f", 0);


                // Bear: 2 found of pair 2 so 5 + 5 = 10 points
                // Fox:  Fox at 2,2 with 1 pair for 2 points and Fox at 4,5 with 1 for 1 point for 3 points
                // Salmon: 5 salmon run for 17 points
                // Hawk: 1 pair of hawks for 3 points
                // Elk: one pair of Elk found for 5 points

                // Total: 10 + 3 + 17 + 3 + 5 = 38 points

                Board.print_boards(b, 8, 6, 1);
                int total_score = Scoring_Setup.scoring_setups(b, 1,  scoring_cards);
                assertEquals(38, total_score);

        }



}