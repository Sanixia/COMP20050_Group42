import java.util.ArrayList;

// tile.java but modified to use 2d array instead of list of lists for board
public class tile2D {
    private static final int MAXSIZE = 24;
    private String biome;
    private String animals;
    private int rotation;
    private int position;
    private static int max_row=4;
    private static int start_row=0;
    private static int end_row=2;
    public static int odd = 1;

    static tile2D[][] board2 = new tile2D[MAXSIZE*2][MAXSIZE];

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
    public void setPosition(int position) {
        this.position = position;
    }


    public static void main(String[] args)
    {
        board_add_tile("F", "BES", 0, 0, 0);
        board_add_tile("F", "BES", 0, 0, 3);

        board_add_tile("RM", "BEH", 1, 1, 0);
        board_add_tile("WP", "FS", 0, 1, 2);

        board_add_tile("P", "E", 1, 2, 1);
        board_add_tile("P", "E", 3, 2, 2);

        //place_animal_token("s", 0, 0);
        print_board();

        indent();
        print_board();
    }

    public static void board_add_tile(String biome, String animals, int rotation, int row, int col) { //TODO
        tile2D tile = new tile2D(biome, animals, rotation);
        board2[row][col] = tile;
    }

    public static void place_animal_token(String animal, int row, int col) {
        board2[row][col].setAnimals(animal);
    }

    public static void print_board() {
        for (int i=start_row; i<end_row+1; i++) {
            Ex2D.row_printer(board2[i], max_row);
        }
    }

    /*
    public static void indent() {
        int index;
        for (int i=start_row; i<end_row; i++) {
            for (int j=0; j<max_row; j++) {
                index = board2[i][j].getPosition()+2;
                board2[i][j].setPosition(index);
            }
        }
    }
     */

    public static void indent() {
        for (int i=start_row; i<end_row; i++) {
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
}
