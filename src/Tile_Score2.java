import java.util.ArrayList;
public class Tile_Score2 {
    public static int maxsize = 28;
    public static int totalscore = 0;
    public static int odd;
    public static tile2D[][] board;

    public static void increaseScore() {
        Tile_Score2.totalscore++;
    }
    public static void setBoard(tile2D[][] board) {
        Tile_Score2.board = board;
    }
    public static void setOdd(int odd) {
        Tile_Score2.odd = odd;
    }

    public static int calculateSpace(int col) {
        if (col % 2 == 0 && odd == 1) return 0;
        return 1;
    }

    public static void main(String[] args) {
        tile2D[][] b = new tile2D[maxsize][maxsize];
        b[0][1] = new tile2D("R", "h", 0);
        b[0][2] = new tile2D("R", "b", 0);
        b[0][3] = new tile2D("R", "f", 0);
        b[1][1] = new tile2D("R", "b", 0);
        b[1][2] = new tile2D("R", "b", 0);
        b[1][3] = new tile2D("R", "h", 0);
        b[2][2] = new tile2D("R", "h", 0);
        b[2][3] = new tile2D("R", "b", 0);
        b[3][2] = new tile2D("R", "s", 0);

        tile2D.print_boards(b, 6, 4, 1);
        scoring_setup(b, 1);
    }

    public static void scoring_setup(tile2D[][]board, int odd) {
        setBoard(board);
        setOdd(odd);
        int fox_score=0, hawk_num=0, bear_num=0;
        for (int i=0; i<maxsize; i++) {
            for (int j=0; j<maxsize; j++) {
                tile2D t = board[i][j];
                if(t!=null && t.getAnimals().charAt(0)=='f') {
                    System.out.println("fox ["+i+"]["+j+"] " +fox_scoring_1(i, j)) ;
                    fox_score += fox_scoring_1(i, j);
                }
                if(t!=null && t.getAnimals().charAt(0)=='h') {
                    System.out.println("hawk ["+i+"]["+j+"] " +hawk_scoring_1(i, j));
                    hawk_num += hawk_scoring_1(i, j);
                }
                if(t!=null && t.getAnimals().charAt(0)=='b') {
                    System.out.println("bear ["+i+"]["+j+"] " +bear_scoring_1(i, j));
                    bear_num += bear_scoring_1(i, j);
                }
            }
        }
        int hawk_score = hawk_score_calculate(hawk_num);
        int bear_score = bear_num;                              // insert bear scoring
        System.out.println("\nTotal Fox score:" + fox_score);
        System.out.println("\nTotal Hawk score:" + hawk_score);
        System.out.println("\nTotal Bear score:" + bear_score);
    }

    public static int fox_scoring_1(int x, int y) {         // returns the score of fox tile specified
        int scor=0, b=0, e=0, f=0, s=0, h=0;
        ArrayList<String> animals = new ArrayList<String>();

        for (int i=0; i<6; i++) {
            tile2D surrounding_tile = get_surrounding_tile(x, y, i+1);
            if (surrounding_tile!=null){
                animals.add(surrounding_tile.getAnimals());
            }
        }
        if (animals.contains("f")) f=1;
        if (animals.contains("h")) h=1;
        if (animals.contains("s")) s=1;
        if (animals.contains("b")) b=1;
        if (animals.contains("e")) e=1;
        scor = b+e+f+s+h;
        return scor;
    }

    public static int bear_scoring_1(int x, int y) {                   // returns 1 if it's a pair of bears
        ArrayList<Integer> positions = new ArrayList<Integer>();

        for (int i=2; i<5; i++) {               // will only check to the right, bottom right, bottom left to not count any tiles that were before it
            tile2D surrounding_tile = get_surrounding_tile(x, y, i+1);
            if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == 'b'){
                positions.add(i+1);
            }
        }
        if (positions.size()==1) {
            int x2 = get_surrounding_row(x, y, positions.get(0));
            int y2 = get_surrounding_col(x, y, positions.get(0));

            for (int i=0; i<6; i++) {               // will only check to the right, bottom right, bottom left to not count any tiles that were before it
                tile2D surrounding_tile = get_surrounding_tile(x2, y2, i+1);
                if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == 'b'){
                    positions.add(i+1);
                }
            }

            if (positions.size()==2) return 1;
        }

        return 0;
    }

    public static int elk_scoring_1(int x, int y) {
        int score=0;
        return score;
    }

    public static int salmon_scoring_1(int x, int y) {
        int score=0;
        return score;
    }

    public static int hawk_scoring_1(int x, int y) {     // returns 1 if hawk tile specified is valid and 0 otherwise
        int num_hawks=1;
        ArrayList<String> animals = new ArrayList<String>();

        for (int i=0; i<6; i++) {
            tile2D surrounding_tile = get_surrounding_tile(x, y, i+1);
            if (surrounding_tile!=null){
                animals.add(surrounding_tile.getAnimals());
            }
        }
        if (animals.contains("h")) num_hawks=0;
        return num_hawks;
    }

    public static int hawk_score_calculate(int h) {
        if (h>7) return 26;
        else {
            if (h>5) return 4*(h-2)+2;
            else return 3*(h-1)+2;
        }
    }

    public static tile2D get_surrounding_tile(int x, int y, int pos) {     // returns a tile around specified tile
        int plusOne = calculateSpace(x);
        int row = x;
        int col = y;
        if (pos==1 && row-1>=0 && col-1+plusOne>=0) {
            row--;
            col += plusOne - 1;                                     // top left
        } if (pos==2 && row-1>=0 && col+plusOne<=maxsize) {
            row--;
            col += plusOne;                                         // top right
        } if (pos==3 && col+1<=maxsize) {
            col++;                                                  // right
        }if (pos==4 && row+1<=maxsize && col+plusOne<=maxsize) {
            row++;
            col += plusOne;                                         // bottom right
        }if (pos==5 && row+1<=maxsize && col-1+plusOne<=maxsize) {
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



    public static void tile_scoring(int x, int y, int maxsize) {
        String biome = board[x][y].getBiome();
    }
}


