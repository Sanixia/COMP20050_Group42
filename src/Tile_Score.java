/*public class Tile_Score {
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

    public void scoring_setup(tile2D[][] board, int odd) {
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


    public void tile_scoring(int x, int y, String biome) {
        int plusOne = tile2D.calculateSpace(x);
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

 */
