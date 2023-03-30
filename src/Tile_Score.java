public class Tile_Score {
    public static tile2D[][] board;
    public static int score = 0;
    public static int MAXSIZE = 26;
    public static int odd;

    public void setBoard(tile2D[][] board) {
        board = board;
    }
    public static void setOdd(int odd) {
        odd = odd;
    }

    public static void incrementScore() {
        score++;
    }

    public int calculateSpace(int col) {
        if (col % 2 == 0 && odd == 1) return 0;
        return 1;
    }

    public void scoring_setup(tile2D[][]board, int odd) {
        setBoard(board);
        setOdd(odd);
        tile_scoring_setup();
    }

    public void tile_scoring_setup() {
        for (int i=0; i<MAXSIZE; i++) {
            for (int j=0; j<MAXSIZE; j++) {
                String biome = board[i][j].getBiome();
                if(biome.length() == 1) {
                    tile_scoring(i, j, biome);
                }
            }
        }
    }

    public tile2D get_surrounding_tile(int x, int y, int pos) {     // returns a tile around specified tile
        int plusOne = calculateSpace(x);
        int row = x;
        int col = y;
        if (pos==1 && row-1>=0 && col-1+plusOne>=0) row--; col+=plusOne-1;              // top left
        if (pos==2 && row-1>=0 && col+plusOne<=MAXSIZE) row--; col+=plusOne;            // top right
        if (pos==3 && col+1<=MAXSIZE) col++;                                            // right
        if (pos==4 && row+1<=MAXSIZE && col+plusOne<=MAXSIZE) row++; col+=plusOne;      // bottom right
        if (pos==5 && row+1<=MAXSIZE && col-1+plusOne<=MAXSIZE) row++; col+=plusOne-1;  // bottom left
        if (pos==6 && col-1>=0) col--;                                                  // left
        return board[row][col];
    }


    public void tile_scoring(int x, int y, String biome) {
        int plusOne = calculateSpace(x);
        if (y-1>=0 && checkTile(x, y, biome, 1)) incrementScore();              // left
        if (y-1<=MAXSIZE && checkTile(x, y, biome, 4)) incrementScore();        // right
        if (y-1+plusOne>=0 && x-1>=0 && checkTile(x, y, biome, 2)) incrementScore();        // top left
        if (y+plusOne<=MAXSIZE && x-1>=0 && checkTile(x, y, biome, 3)) incrementScore();    // top right
        if (y-1+plusOne>=0 && x+1<=MAXSIZE && checkTile(x, y, biome, 0)) incrementScore();       // bottom left
        if (y+plusOne<=MAXSIZE && x+1<=MAXSIZE && checkTile(x, y, biome, 5)) incrementScore();   // bottom right
    }

    public Boolean checkTile(int x, int y, String keystoneBiome, int pos) {
        int rotation = board[x][y].getRotation();
        if (board[x][y].getBiome().charAt(1) == keystoneBiome.charAt(0)) {
            rotation = (rotation+3)%6;
        }
        if (pos == rotation || pos == (rotation+1)%6 || pos == (rotation+5%6)) {
            return true;
        }
        return false;
    }


}


