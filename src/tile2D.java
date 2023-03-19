import java.util.ArrayList;

// tile.java but modified to use 2d array instead of list of lists for board
public class tile2D {
    private static final int MAXSIZE = 24;
    private String biome;
    private String animals;
    private int rotation;
    private int position;
    private static int max_row;
    private static int max_col;
    private static int odd;          // 1 if odd rows are at the front

    static tile2D[][] board2 = new tile2D[MAXSIZE][MAXSIZE];

    public tile2D(String biome, String animals, int rotation) {
        this.biome = biome;
        this.animals = animals;
        this.rotation = rotation;
    }

    public String getBiome() {
        return biome;
    }
    public String getAnimals() {
        return animals;
    }
    public int getRotation() {
        return rotation;
    }


    public void setAnimals(String animals) {
        this.animals = animals;
    }
    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
    public void setMax_col() {
        max_col++;
    }
    public void setMax_row() {
        max_row++;
    }
    public static void changeOdd() {
        if (odd==1) odd = 0;
        else odd = 1;
    }




    public static void main(String[] args)
    {
        //tile2D t = new tile2D("F", "BES", 0);           // can test printing out individual tiles
        //System.out.println(Ex2D.print_tile_setup(t));

        /*
        board_add_tile("F", "BES", 0, 0, 0);
        board_add_tile("F", "BES", 0, 0, 3);

        board_add_tile("RM", "BEH", 1, 1, 0);
        board_add_tile("WP", "FS", 0, 1, 2);

        board_add_tile("P", "E", 1, 2, 1);
        board_add_tile("P", "E", 3, 2, 2);

        board_add_tile("P", "E", 1, 3, 1);
        board_add_tile("P", "E", 3, 4, 2);
        print_board();
        place_animal_token("s", 0, 0);
        indent();
        print_board();
         */


        setup();
        print_board();

        indent_col();
        print_board();

        indent_row();
        print_board();
    }

    public static void setup() {
        board_add_tile("F", "BES", 0, 1, 1);
        board_add_tile("F", "BES", 0, 2, 1);
        board_add_tile("RM", "BEH", 1, 2, 2);

        odd = 0;
        max_col = 4;
        max_row = 4;
    }


    public static void board_add_tile(String biome, String animals, int rotation, int row, int col) { //TODO verify
        tile2D tile = new tile2D(biome, animals, rotation);
        board2[row][col] = tile;
    }

    public static void place_animal_token(String animal, int row, int col) { //TODO verify
        board2[row][col].setAnimals(animal);
    }

    public static void print_board() {
        String row;
        for (int i=0; i!=max_col; i++) {                // printing the board + 1 empty row boarder
            if (i%2==0 && odd==1 || i%2==1 && odd==0) {
                row = Ex2D.row_printer(board2[i], max_row, 1);      // maxrow specifies lenght
            } else {
                row = Ex2D.row_printer(board2[i], max_row, 0);
            }
            System.out.println(row);
        }
        System.out.println("\n");
    }

    public static void indent_col() {
        for (int i=0; i<max_col+1; i++) {
            tile2D curr = board2[i][0];
            tile2D next;
            board2[i][0] = null;
            for (int j=0; j<max_row; j++) {
                next = board2[i][j+1];
                board2[i][j+1] = curr;
                curr = next;
            }
        }
    }

    public static void indent_row() {
        for (int i=0; i<max_row+1; i++) {
            tile2D curr = board2[0][i];
            tile2D next;
            board2[0][i] = null;
            for (int j=0; j<max_col; j++) {
                next = board2[j+1][i];
                board2[j+1][i] = curr;
                curr = next;
            }
        }
        changeOdd();
    }
}
