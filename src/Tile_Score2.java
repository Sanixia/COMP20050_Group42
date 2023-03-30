import java.util.ArrayList;
public class Tile_Score2 {
    public static int maxsize = 28;
    public static int score = 0;
    public static int odd;
    public static tile2D[][] board;

    public static void increaseScore() {
        Tile_Score2.score++;
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
        //b[0][2] = new tile2D("R", "f", 0);
        //b[0][3] = new tile2D("R", "f", 0);
        //b[1][1] = new tile2D("R", "f", 0);
        //b[1][2] = new tile2D("R", "f", 0);
        //b[1][3] = new tile2D("R", "f", 0);
        b[2][2] = new tile2D("R", "f", 0);
        b[2][3] = new tile2D("R", "f", 0);

        tile2D.print_boards(b, 6, 4, 1);
        scoring_setup(b, 1);
    }

    public static void scoring_setup(tile2D[][]board, int odd) {
        setBoard(board);
        setOdd(odd);
        for (int i=0; i<maxsize; i++) {
            for (int j=0; j<maxsize; j++) {
                tile2D t = board[i][j];
                //if(t.getBiome().length()==1) tile_scoring(i, j, maxsize); // tile scoring
                if(t!=null && t.getAnimals().charAt(0)=='f') System.out.println(fox_scoring_1(i, j));
            }
        }
    }

    public static int fox_scoring_1(int x, int y) {
        int fox_score=0, b=0, e=0, f=0, s=0, h=0;
        ArrayList<String> animals = new ArrayList<String>();

        for (int i=0; i<4; i++) {
            tile2D surrounding_tile = get_surrounding_tile(x, y, i);
            if (surrounding_tile!=null){
                animals.add(surrounding_tile.getAnimals());
            }
        }
        if (animals.contains("f")) f=1;
        if (animals.contains("h")) h=1;
        if (animals.contains("s")) s=1;
        if (animals.contains("b")) b=1;
        if (animals.contains("e")) e=1;
        score = b+e+f+s+h;

        return score;
    }

    public static tile2D get_surrounding_tile(int x, int y, int pos) {     // returns a tile around specified tile
        int plusOne = calculateSpace(x);
        int row = x;
        int col = y;
        if (pos==1 && row-1>=0 && col-1+plusOne>=0) row--; col+=plusOne-1;              // top left
        if (pos==2 && row-1>=0 && col+plusOne<=maxsize) row--; col+=plusOne;            // top right
        if (pos==3 && col+1<=maxsize) col++;                                            // right
        if (pos==4 && row+1<=maxsize && col+plusOne<=maxsize) row++; col+=plusOne;      // bottom right
        if (pos==5 && row+1<=maxsize && col-1+plusOne<=maxsize) row++; col+=plusOne-1;  // bottom left
        if (pos==6 && col-1>=0) col--;                                                  // left

        if (row==x && col==y) return null;
        return board[row][col];
    }



    public static void tile_scoring(int x, int y, int maxsize) {
        String biome = board[x][y].getBiome();
    }
}


