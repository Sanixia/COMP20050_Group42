import java.util.ArrayList;
import java.util.Objects;

public class Scoring_Setup extends Board
{
    private static int odd;

    private static Board[][] board;

    public Scoring_Setup(String biome, String animals, int rotation) {
        super(biome, animals, rotation);
    }

    public static void changeToNull(Board[][] board, int row, int col) {
        Scoring_Setup.board[row][col] = null;
    }
    public static Board[][] getBoard() {
        return board;
    }
    public static void setBoard(Board[][] board) {
        Scoring_Setup.board = board;
    }
    public static void setOdd(int odd) {
        Scoring_Setup.odd = odd;
    }

    public static int calculateSpace(int col) {
        if (col % 2 == 0 && odd == 1) return 0;
        return 1;
    }

    public static void main(String[] args) {

        Board[][] b = new Board[MAXSIZE][MAXSIZE];
       /* b[0][1] = new Board("RM", "s", 0);
        b[0][2] = new Board("RM", "e", 0);
        b[0][3] = new Board("RM", "s", 0);
        b[0][4] = new Board("RM", "b", 0);
        b[1][1] = new Board("RM", "s", 0);
        b[1][2] = new Board("R", "s", 0);
        b[1][3] = new Board("R", "e", 0);
        b[2][1] = new Board("R", "b", 0);
        b[2][2] = new Board("R", "e", 0);
        b[2][3] = new Board("R", "s", 0);
        b[2][5] = new Board("R", "b", 0);
        b[3][1] = new Board("R", "b", 0);
        b[3][2] = new Board("R", "f", 0);
        b[3][3] = new Board("R", "b", 0);
        b[3][4] = new Board("R", "b", 0);
        b[3][5] = new Board("R", "s", 0);
        b[4][3] = new Board("R", "b", 0);

        */
        b[0][1] = new Board("RM", "h", 0);
        b[0][2] = new Board("RM", "H", 0);
        b[0][3] = new Board("RM", "H", 0);
        b[0][4] = new Board("RM", "h", 0);
        b[1][1] = new Board("RM", "BS", 0);
        b[1][2] = new Board("RM", "BS", 0);
        b[2][1] = new Board("RM", "e", 0);
        b[2][2] = new Board("RM", "h", 0);
        b[2][3] = new Board("RM", "BS", 0);



        // TODO                b e f h s
        int[] scoring_cards = {3,1,1,3,1};
        Board.print_boards(b, 5, 3, 1);
        scoring_setups(b, 1,  scoring_cards);
    }


    public static void scoring_setups(Board[][]board, int odd, int[] scoring_cards) {       // temporary for testing purposes
        setBoard(board);
        setOdd(odd);
        int fox_num=0, hawk_num=0, bear_num=0, salmon_score=0, elk_num=0;
        int[] bear_shapes = new int[20];
        int b=0;
        for (int i=0; i<MAXSIZE; i++) {
            for (int j=0; j<MAXSIZE; j++) {
                Board t = board[i][j];
                if( t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='f') {
                    System.out.println("fox    ["+i+"]["+j+"] " + fox_scoring_cards(i, j, scoring_cards[2]));
                    fox_num += fox_scoring_cards(i, j, 1);
                }
                else if(t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='h') {
                    //System.out.println("hawk   ["+i+"]["+j+"] " + hawk_scoring_cards(i, j, scoring_cards[3]));
                    if(scoring_cards[3]==3) {
                        hawk_num += hawk_score_calculate(hawk_scoring_cards(i, j, scoring_cards[3]), scoring_cards[3]);
                    }
                    else{
                        hawk_num += hawk_scoring_cards(i, j, 2);
                    }
                    //hawk_num += hawk_scoring_cards(i, j, 3);
                }
                else if(t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='b') {
                    System.out.println("bear   ["+i+"]["+j+"] " + bear_scoring_cards(i, j, scoring_cards[0]));
                    if (scoring_cards[0]==3) {
                        bear_shapes[b] = bear_scoring_cards(i, j, scoring_cards[0]);
                        b++;
                    }
                    else bear_num += bear_scoring_cards(i, j, scoring_cards[0]);
                }
                else if(t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='s') {
                  //  System.out.println("salmon ["+i+"]["+j+"] " + salmon_scoring_cards(i, j, 3));
                    salmon_score += salmon_score_calculate(salmon_scoring_cards(i, j, 2), 2);
                }
                if(t!=null && t.getAnimals().charAt(0)=='e') {
                    //System.out.println("elk    ["+i+"]["+j+"] " + elk_scoring_cards(i, j, 2, -1));
                    elk_num += elk_scoring_cards(i, j, 2, -1);
                    //elk_score += elk_scoring_cards(i, j, 2, -1);
                }
            }
        }
        int fox_score = fox_score_calculate(fox_num, scoring_cards[2]);
        int hawk_score = hawk_score_calculate(hawk_num, 2);
        int bear_score = bear_score_calculate(bear_num, bear_shapes, scoring_cards[0]);
        int elk_score = elk_score_calculate(elk_num, scoring_cards[1]); // insert bear scoring
        int salmon_score2 = salmon_score_calculate(salmon_score, 3);
        System.out.println("\nTotal Fox score:" + fox_score);
        System.out.println("Total Hawk score:" + hawk_num);
        System.out.println("Total Bear score:" + bear_score);
        System.out.println("Total Salmon score:" + salmon_score);
        System.out.println("Total Elk score:" + elk_score);
    }


    public static void scoring_setup(Board[][] board, int odd, int max_col, int max_row, int[] scoring_cards, String name, int nature_tokens) { //TODO replace playertracker with  board, odd, max row, maxcol
        setBoard(board);
        setOdd(odd);

        remove_slot();
        print_boards(board, max_col, max_row, odd);

        int fox_num=0, hawk_num=0, bear_num=0, salmon_score=0, elk_num=0;

        int[] bear_shapes = new int[20];
        int b=0;

        for (int i=0; i< max_row; i++) {
            for (int j=0; j< max_col; j++) {

                Board t = board[i][j];
                if( t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='f') {

                    fox_num += fox_scoring_cards(i, j, scoring_cards[2]);
                }

                if(t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='h') {
                    if(scoring_cards[3]==3) {
                        hawk_num += hawk_score_calculate(hawk_scoring_cards(i, j, scoring_cards[3]), scoring_cards[3]);
                    }
                    else{
                        hawk_num += hawk_scoring_cards(i, j, scoring_cards[3]);
                    }
                }

                if(t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='b') {

                    if (scoring_cards[0]==3) {
                        bear_shapes[b] = bear_scoring_cards(i, j, scoring_cards[0]);
                        b++;
                    }
                    else bear_num += bear_scoring_cards(i, j, scoring_cards[0]);
                }
                if(t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='s') {

                    salmon_score += salmon_score_calculate(salmon_scoring_cards(i, j, scoring_cards[4]), scoring_cards[4]);
                }
                if(t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='e') {

                    elk_num += elk_scoring_cards(i, j, scoring_cards[1], -1);


                }
            }
        }
        int fox_score = fox_score_calculate(fox_num, scoring_cards[2]);

        int bear_score = bear_score_calculate(bear_num, bear_shapes, scoring_cards[0]);                       // insert bear scoring


        System.out.println("\n\nTotal Fox score:" + fox_score);

        int hawk_score = 0;

        if(scoring_cards[3]==3) {
            hawk_score = hawk_score_calculate(hawk_num, scoring_cards[3]);
            System.out.println("Total Hawk score:" + hawk_score);
        }
        else {
            hawk_score = hawk_num;
            System.out.println("Total Hawk score:" + hawk_score);
        }
        System.out.println("Total Bear score:" + bear_score);
        System.out.println("Total Salmon score:" + salmon_score);

        int elk_score = 0;

        if(scoring_cards[1]==1) {
            elk_score = elk_num;
            System.out.println("Total Elk score:" + elk_score);
        }
        else {
            elk_score= elk_score_calculate(elk_num, scoring_cards[1]);
            System.out.println("Total Elk score:" + elk_score + "\n");
        }

        System.out.println("\nTotal score for " + name + " is: " + (fox_score + hawk_score + bear_score + salmon_score + elk_score + nature_tokens + "\n\n\n\n"));

    }

    public static int fox_scoring_cards(int x, int y, int card) {
        return switch (card) {
            case 1 -> Scoring_Fox.fox_scoring_1(x, y);
            case 2 -> Scoring_Fox.fox_scoring_2(x, y);
            default -> Scoring_Fox.fox_scoring_3(x, y);
        };
    }

    public static int elk_scoring_cards(int x, int y, int card, int pos) {

        return switch (card) {
            case 1 -> elk_score_calculate(Scoring_Elk.elk_scoring_1(x, y, pos), card);
            case 2 -> elk_score_calculate(Scoring_Elk.elk_scoring_2(x, y), card);
            default -> elk_score_calculate(Scoring_Elk.elk_scoring_3(x, y), card);
        };
    }

    public static int bear_scoring_cards(int x, int y, int card) {
        return switch (card) {
            case 1 -> Scoring_Bear.bear_scoring_1(x, y);
            case 2 -> Scoring_Bear.bear_scoring_2(x, y);
            default -> Scoring_Bear.bear_scoring_3(x, y);
        };
    }

    public static int hawk_scoring_cards(int x, int y, int card) {
        return switch (card) {
            case 1 -> Scoring_Hawk.hawk_scoring_1(x, y);
            case 2 -> Scoring_Hawk.hawk_scoring_2(x, y);
            default -> Scoring_Hawk.hawk_scoring_3(x, y);
        };
    }

    public static int salmon_scoring_cards(int x, int y, int card) {
        return Scoring_Salmon.salmon_scoring(x, y, card);
    }



    public static int hawk_score_calculate(int h, int card) {
        switch (card) {
            case 1:
                if (h == 0) return 0;
                if (h == 1) return 2;
                if (h == 2) return 5;
                if (h == 3) return 8;
                if (h == 4) return 11;
                if (h == 5) return 14;
                if (h == 6) return 18;
                if (h == 7) return 22;
                return 26;
            case 2:
                if (h == 0) return 0;
                if (h == 1) return 2;
                if (h == 2) return 5;
                if (h == 3) return 9;
                if (h == 4) return 12;
                if (h == 5) return 16;
                if (h == 6) return 20;
                if (h == 7) return 24;
                return 28;
            default:
                return h*3;
        }

    }

    public static int bear_score_calculate(int b, int[] bear_shapes, int card) {
        switch (card) {
            case (1):
                b = b / 2;
                if (b == 0) return 0;
                if (b == 1) return 4;
                if (b == 2) return 11;
                if (b == 3) return 19;
                return 27;
            case(2):
                b = b / 3;
                if (b == 0) return 0;
                return b*10;
            default:
                int one=0, two=0, three=0, three_b=0, bonus=0;
                for (int bear_shape : bear_shapes) {
                    if (bear_shape == 1) one++;
                    if (bear_shape == 2) two++;
                    if (bear_shape == 3) three++;
                    if (bear_shape == 4) three_b++;
                }
                three += three_b/3;
                if (one>0 && two>0 && three>0) bonus=3;
                return one*2 + two*5 + three*8 + bonus;
        }
    }

    public static int fox_score_calculate(int f, int card) {
        if (card == 2) {
            if (f == 0) return 0;
            if (f == 1) return 3;
            if (f == 2) return 5;
            return 7;
        }
        return f;
    }

    public static int elk_score_calculate(int e, int card) {
        switch (card) {
            case 1:
                if(e == 0) return 0;
                if (e == 1) return 2;
                if (e == 2) return 5;
                if (e == 3) return 9;
                return 13;
            case 2:
                if (e == 0) return 0;
                if (e == 1) return 2;
                if (e == 2) return 4;
                if (e == 3) return 7;
                if (e == 4) return 10;
                if (e == 5) return 14;
                if (e == 6) return 18;
                if (e == 7) return 23;
                return 28;
            default:
                return  0;
        }

    }

    public static int salmon_score_calculate(int s, int card) {
        switch(card){
            case 1:
                if (s == 0) return 0;
                if (s == 1) return 2;
                if (s == 2) return 4;
                if (s == 3) return 7;
                if (s == 4) return 11;
                if (s == 5) return 15;
                if (s == 6) return 20;
                return 26;
            case 2:
                if (s == 0) return 0;
                if (s == 1) return 2;
                if (s == 2) return 4;
                if (s == 3) return 8;
                return 12;
            default:
                if (s == 0) return 0;
                if (s == 1) return 2;
                if (s == 2) return 4;
                if (s == 3) return 9;
                if (s == 4) return 11;
                return 17;
        }

    }

    public static Board get_surrounding_tile(int x, int y, int pos) {     // returns a tile around specified tile
        int plusOne = calculateSpace(x);
        int row = x;
        int col = y;
        if (pos==1 && row-1>=0 && col-1+plusOne>=0) {
            row--;
            col += plusOne - 1;                                     // top left
        } if (pos==2 && row-1>=0 && col+plusOne<=MAXSIZE) {
            row--;
            col += plusOne;                                         // top right
        } if (pos==3 && col+1<=MAXSIZE) {
            col++;                                                  // right
        }if (pos==4 && row+1<=MAXSIZE && col+plusOne<=MAXSIZE) {
            row++;
            col += plusOne;                                         // bottom right
        }if (pos==5 && row+1<=MAXSIZE && col-1+plusOne<=MAXSIZE) {
            row++;
            col += plusOne - 1;                                     // bottom left
        }if (pos==6 && col-1>=0) {
            col--;                                                  // left
        }
        if (row==x && col==y) return null;
        if(row<0 || row>MAXSIZE || col<0 || col>MAXSIZE) return null;
        return board[row][col];
    }

    public static int[] get_surrounding_tile_coordinates(int x, int y, int pos) {     // returns a tile around specified tile
        int plusOne = calculateSpace(x);
        int row = x;
        int col = y;
        if (pos==1 && row-1>=0 && col-1+plusOne>=0) {
            row--;
            col += plusOne - 1;                                     // top left
        } if (pos==2 && row-1>=0 && col+plusOne<=MAXSIZE) {
            row--;
            col += plusOne;                                         // top right
        } if (pos==3 && col+1<=MAXSIZE) {
            col++;                                                  // right
        }if (pos==4 && row+1<=MAXSIZE && col+plusOne<=MAXSIZE) {
            row++;
            col += plusOne;                                         // bottom right
        }if (pos==5 && row+1<=MAXSIZE && col-1+plusOne<=MAXSIZE) {
            row++;
            col += plusOne - 1;                                     // bottom left
        }if (pos==6 && col-1>=0) {
            col--;                                                  // left
        }
        if (row==x && col==y) return new int[] {-1,-1};
        return new int[] {row, col};
    }

    public static int[] get_surrounding_tile_hawk(int x, int y, int pos) {     // returns a tile around specified tile
        int plusOne = calculateSpace(x);
        int row = x;
        int col = y;
        int[] arr = {-1,-1};
        if (pos==1 && row-1>=0 && col-1+plusOne>=0) {
            row -= 2;
            col -= 1;                                     // top left
        } if (pos==2 && row-1>=0 && col+plusOne<=MAXSIZE) {
            row -= 2;
            col += 1;                                         // top right
        } if (pos==3 && col+1<=MAXSIZE) {
            col += 2;                                                  // right
        }if (pos==4 && row+1<=MAXSIZE && col+plusOne<=MAXSIZE) {
            row += 2;
            col += 1;                                         // bottom right
        }if (pos==5 && row+1<=MAXSIZE && col-1+plusOne<=MAXSIZE) {
            row += 2;
            col -= 1;                                     // bottom left
        }if (pos==6 && col-1>=0) {
            col -= 2;                                                  // left
        }

        if (row==x && col==y) return new int[] {-1,-1};
        return new int[] {row, col};
    }

    public static int get_surrounding_row(int x, int y, int pos) {     // returns row of specified surround tile
        int row = x;
        if (pos==1||pos==2) return row-1;
        if (pos==4||pos==5) return row+1;
        return row;
    }

    public static int get_surrounding_col(int x, int y, int pos) {     // returns column of specified surround tile
        int plusOne = calculateSpace(x);
        int col = y;
        if (!(pos==3 || pos==6)) col += plusOne;
        if (pos==1 || pos==5 || pos==6) return col-1;
        else if (pos==3) return col+1;
        return col;
    }

    public static void remove_slot() {
        for (int i = 0; i < MAXSIZE; i++) {
            for (int j = 0; j < MAXSIZE; j++) {
                if (board[i][j]!=null && Objects.equals(board[i][j].getBiome(), "slot")) {
                    board[i][j] = null;
                }
            }
        }
    }

    public static int reverse_position(int x) {
        switch(x){
            case 1: return 4;
            case 2: return 5;
            case 3: return 6;
            case 4: return 1;
            case 5: return 2;
            case 6: return 3;
            default: return 0;
        }
    }

    public static boolean check_beside(int a, int b) {
        return (a == 6 && b == 1) || (a == 1 && b == 6) || (a - b == 1 || b - a == 1);
    }
}