import java.util.ArrayList;
public class Scoring_Setup extends tile2D{
    public static int MAXSIZE = 26;
    public static int totalscore = 0;
    public static int odd;
    public static tile2D[][] board;

    public Scoring_Setup(String biome, String animals, int rotation) {
        super(biome, animals, rotation);
    }

    public static void increaseScore() {
        Scoring_Setup.totalscore++;
    }
    public static void setBoard(tile2D[][] board) {
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
        tile2D[][] b = new tile2D[MAXSIZE][MAXSIZE];
        b[0][1] = new tile2D("R", "h", 0);
        b[0][2] = new tile2D("R", "b", 0);
        b[0][3] = new tile2D("R", "f", 0);
        b[0][4] = new tile2D("R", "f", 0);
        b[1][1] = new tile2D("R", "s", 0);
        b[1][2] = new tile2D("R", "b", 0);
        b[1][3] = new tile2D("R", "h", 0);
        b[2][2] = new tile2D("R", "b", 0);
        b[2][3] = new tile2D("R", "b", 0);
        b[3][2] = new tile2D("R", "s", 0);
        // todo                b e f h s
        int[] scoring_cards = {1,1,1,1,1};
        tile2D.print_boards(b, 6, 4, 1);
        scoring_setup(b, 1, scoring_cards);
    }



    public static void scoring_setup(tile2D[][]board, int odd, int[] scoring_cards) {
        setBoard(board);
        setOdd(odd);
        int fox_score=0, hawk_num=0, bear_num=0;
        for (int i=0; i<MAXSIZE; i++) {
            for (int j=0; j<MAXSIZE; j++) {
                tile2D t = board[i][j];
                if(t!=null && t.getAnimals().charAt(0)=='f') {
                    System.out.println("fox    ["+i+"]["+j+"] " + fox_scoring_cards(i, j, 1));
                    fox_score += fox_scoring_cards(i, j, 1);
                }
                if(t!=null && t.getAnimals().charAt(0)=='h') {
                    System.out.println("hawk   ["+i+"]["+j+"] " + hawk_scoring_cards(i, j, 1));
                    hawk_num += hawk_scoring_cards(i, j, 1);
                }
                if(t!=null && t.getAnimals().charAt(0)=='b') {
                    System.out.println("bear   ["+i+"]["+j+"] " + bear_scoring_cards(i, j, 1));
                    bear_num += bear_scoring_cards(i, j, 1);
                }
                if(t!=null && t.getAnimals().charAt(0)=='s') {
                    //System.out.println("salmon ["+i+"]["+j+"] " + salmon_scoring_cards(i, j, 1));
                    //bear_num += salmon_scoring_cards(i, j, 1);
                }
            }
        }
        int hawk_score = hawk_score_calculate(hawk_num);
        int bear_score = bear_score_calculate(bear_num);                              // insert bear scoring
        System.out.println("\nTotal Fox score:" + fox_score);
        System.out.println("Total Hawk score:" + hawk_score);
        System.out.println("Total Bear score:" + bear_score);
    }

    public static int fox_scoring_cards(int x, int y, int card) {
        return switch (card) {
            case 1 -> Scoring_Calculate.fox_scoring_1(x, y);
            case 2 -> Scoring_Calculate.fox_scoring_2(x, y);
            default -> Scoring_Calculate.fox_scoring_3(x, y);
        };
    }

    public static int elk_scoring_cards(int x, int y, int card) {
        return switch (card) {
            case 1 -> Scoring_Calculate.elk_scoring_1(x, y);
            case 2 -> Scoring_Calculate.elk_scoring_2(x, y);
            default -> Scoring_Calculate.elk_scoring_3(x, y);
        };
    }

    public static int bear_scoring_cards(int x, int y, int card) {
        return switch (card) {
            case 1 -> Scoring_Calculate.bear_scoring_1(x, y);
            case 2 -> Scoring_Calculate.bear_scoring_2(x, y);
            default -> Scoring_Calculate.bear_scoring_3(x, y);
        };
    }

    public static int salmon_scoring_cards(int x, int y, int card) {
        return switch (card) {
            case 1 -> Scoring_Calculate.salmon_scoring_1(x, y);
            case 2 -> Scoring_Calculate.salmon_scoring_2(x, y);
            default -> Scoring_Calculate.salmon_scoring_3(x, y);
        };
    }

    public static int hawk_scoring_cards(int x, int y, int card) {
        return switch (card) {
            case 1 -> Scoring_Calculate.hawk_scoring_1(x, y);
            case 2 -> Scoring_Calculate.hawk_scoring_2(x, y);
            default -> Scoring_Calculate.hawk_scoring_3(x, y);
        };
    }



    public static int hawk_score_calculate(int h) {
        if (h==0) return 0;
        if (h>7) return 26;
        else {
            if (h>5) return 4*(h-2)+2;
            else return 3*(h-1)+2;
        }
    }

    public static int bear_score_calculate(int b) {
        if (b==0) return 0;
        b = b/2;
        if (b>3) return 27;
        else {
            return 7*(b-1)+4;
        }
    }

    public static tile2D get_surrounding_tile(int x, int y, int pos) {     // returns a tile around specified tile
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
        return board[row][col];
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
}