import java.util.Arrays;
import java.util.Scanner;

// tile.java but modified to use 2d array instead of list of lists for board
public class tile2D {
    private static final int MAXSIZE = 26;
    private String biome;
    private String animals;
    private int rotation;
    private int position;
    private static int max_col;         // adjusts 'length' of board
    private static int max_row;         // adjusts 'height' of board
    private static int odd;          // 1 if odd rows are at the front

    private static int checkBoardUpper = 0;
    private static int checkBoardLower = 0;
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

    public void setmax_row() {
        max_row++;
    }

    public void setmax_col() {
        max_col++;
    }


    public static int getCheckBoardUpper() {
        return checkBoardUpper;
    }

    public static void setCheckBoardUpper() {
        checkBoardUpper++;
    }

    public static int getCheckBoardLower() {
        return checkBoardLower;
    }

    public static void setCheckBoardLower() {
        checkBoardLower++;
    }

    public static void changeOdd() {
        if (odd == 1) odd = 0;
        else odd = 1;
    }


    public static void main(String[] args) {
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

        //place_animal_token("e", 2, 3);
        print_board();
        //place_animal_token("b");
        System.out.println(Arrays.deepToString(board2));


        for (int i = 0; i < 20; i++) {
            place();
            print_board();
            place_animal_token("f");
            System.out.println(Arrays.deepToString(board2));
            System.out.println(max_col);
            System.out.println(max_row);
        }
    }

    public static void setup() {
        board_add_tile("F", "F", 0, 1, 2);
        board_add_tile("P", "BES", 0, 2, 2);
        board_add_tile("RM", "BEH", 1, 2, 3);
        //board_add_tile("slot", "", 0, 1, 1);
        //board_add_tile("slot", "", 0, 2, 1);
        //board_add_tile("slot", "", 0, 3, 1);
        //board_add_tile("slot", "", 0, 3, 2);
        //board_add_tile("slot", "", 0, 3, 3);
        //board_add_tile("slot", "", 0, 2, 4);
        //board_add_tile("slot", "", 0, 1, 3);
        //board_add_tile("slot", "", 0, 0, 2);
        //board_add_tile("slot", "", 0, 1, 3);

        odd = 0;
        max_row = 4;
        max_col = 6;
    }

    public static void place() {            // temporary place test feature
        Scanner in = new Scanner(System.in);
        int x, y;
        System.out.print("enter x: ");
        x = in.nextInt();
        System.out.print("\nenter y: ");
        y = in.nextInt();

        while (verify_tile_placement(x, y, getCheckBoardUpper(), getCheckBoardLower())) {
            System.out.println("Please enter a valid tile placement!\n");
            System.out.print("enter x: ");
            x = in.nextInt();
            System.out.print("\nenter y: ");
            y = in.nextInt();
        }
        board_add_tile("RM", "BEH", 1, x, y);
    }


    public static void board_add_tile(String biome, String animals, int rotation, int row, int col) { //TODO verify
        tile2D tile = new tile2D(biome, animals, rotation);
        board2[row][col] = tile;
        int plusOne = 0;
        if (col % 2 == 1 && odd == 1 || col % 2 == 0 && odd == 0) plusOne = 1;

        if (row == 0) {
            indent_row();
            setCheckBoardUpper();
            max_row++;
        } else if (row >= max_row - 1) {
            setCheckBoardLower();
            max_row++;
        }

        if (col == 0) {
            indent_col();
            max_col++;
        } else if (col + plusOne >= max_col - 1) {
            max_col++;
        }
    }

    public static void place_animal_token(String animal) { //TODO verify
        boolean availableTokenPlacement = false;

        for(int i = 0; i < max_row; i++){

            for(int j = 0; j < max_col; j++){
                if(board2[i][j] != null){
                    if(board2[i][j].getAnimals().contains(animal.toUpperCase())){
                        availableTokenPlacement = true;
                        i = max_row;
                        break;
                    }
                }
            }
        }

        if(availableTokenPlacement){
            Scanner in = new Scanner(System.in);
            int x, y;

            System.out.print("enter x: ");
            x = in.nextInt();
            System.out.print("\nenter y: ");
            y = in.nextInt();

            // verify that there is available tiles that can place a token on


            while (verify_animal_token_placement(x, y, animal)) {
                System.out.println("Please enter a valid tile that can place this animal token onto it and hasn't been taken already!\n");
                System.out.print("enter x: ");
                x = in.nextInt();
                System.out.print("\nenter y: ");
                y = in.nextInt();
            }

            board2[x][y].setAnimals(animal);
        }

        else{
            System.out.println("No available tiles to place token");
        }

    }

    public static void print_board() {
        String row;
        System.out.println(Ex2D.column_numbers(max_col));
        for (int i = 0; i != max_row; i++) {                // printing the board + 1 empty row boarder
            if (i % 2 == 0 && odd == 1 || i % 2 == 1 && odd == 0) {
                row = Ex2D.row_printer(board2[i], max_col, 1, String.valueOf(i));      // maxrow specifies lenght
            } else {
                row = Ex2D.row_printer(board2[i], max_col, 0, String.valueOf(i));
            }
            System.out.println(row);
        }
        System.out.println("\n");
    }


    public static void indent_col() {
        for (int i = 0; i < max_row + 1; i++) {
            tile2D curr = board2[i][0];
            tile2D next;
            board2[i][0] = null;
            for (int j = 0; j < max_col; j++) {
                next = board2[i][j + 1];
                board2[i][j + 1] = curr;
                curr = next;
            }
        }
    }

    public static void indent_row() {
        for (int i = 0; i < max_col + 1; i++) {
            tile2D curr = board2[0][i];
            tile2D next;
            board2[0][i] = null;
            for (int j = 0; j < max_row; j++) {
                next = board2[j + 1][i];
                board2[j + 1][i] = curr;
                curr = next;
            }
        }
        changeOdd();
    }


    public static boolean verify_animal_token_placement(int x, int y, String animalToken){

        // first check if there is a tile present
        if(board2[x][y] != null){

            //check if tile contains the animalToken letter and checks if tile hasn't been taken already by the animalToken
            if(board2[x][y].getAnimals().contains(animalToken.toUpperCase()) && !board2[x][y].getAnimals().equals(animalToken)){
                return false;
            }
        }
        return true;
    }

    public static boolean verify_tile_placement(int x, int y, int checkBoardUpper, int checkBoardLower) {

        if (checkBoardUpper % 2 == 0) { //even top rows
            if (x == 0 && y == 0) {
                return board2[x][y] == null && board2[x][y + 1] == null && board2[x + 1][y] == null; //top left corner
            } else if (x == 0) {
                return board2[x][y] == null && board2[x][y + 1] == null && board2[x][y - 1] == null && //top section
                        board2[x + 1][y - 1] == null && board2[x + 1][y] == null;
            } else if (y == 0) { //left side


                if (x % 2 == 0) {
                    return board2[x][y] == null && board2[x][y + 1] == null && board2[x + 1][y] == null && board2[x - 1][y] == null;                 // odd and even rows EXCEPT DUMB ind0ent rows and columns keep changing]
                    // this so basically useless
                } else {
                    return board2[x][y] == null && board2[x][y + 1] == null && board2[x - 1][y] == null && board2[x - 1][y + 1] == null
                            && board2[x + 1][y] == null && board2[x + 1][y + 1] == null;
                }
            }
        }


        if (checkBoardUpper % 2 != 0) { // odd top rows
            if (x == 0 && y == 0) {
                return board2[x][y] == null && board2[x][y + 1] == null && board2[x + 1][y] == null && board2[x + 1][y + 1] == null; //top left corner
            } else if (x == 0) {
                return board2[x][y] == null && board2[x][y + 1] == null && board2[x][y - 1] == null && //top section
                        board2[x + 1][y] == null && board2[x + 1][y+1] == null;
            } else if (y == 0) { //left side


                if (x % 2 != 0) {
                    return board2[x][y] == null && board2[x][y + 1] == null && board2[x + 1][y] == null && board2[x - 1][y] == null;                 // odd and even rows EXCEPT DUMB ind0ent rows and columns keep changing]

                } else {
                    return board2[x][y] == null && board2[x][y + 1] == null && board2[x - 1][y] == null && board2[x - 1][y + 1] == null
                            && board2[x + 1][y] == null && board2[x + 1][y + 1] == null;
                }
            }
        }

            // checks to see if a tile isn't already placed
            if (board2[x][y] != null) {
                return true;
            }


            // check if bottom row of board is odd number of spaces
            if(checkBoardLower % 2 != 0){
                return board2[x][y] == null && board2[x][y - 1] == null && board2[x][y + 1] == null && board2[x - 1][y] == null && board2[x - 1][y+1] == null
                        && board2[x + 1][y] == null && board2[x + 1][y+1] == null;
            }

            else{
                return board2[x][y] == null && board2[x][y - 1] == null && board2[x][y + 1] == null && board2[x - 1][y - 1] == null && board2[x - 1][y] == null       //everyhting else
                        && board2[x + 1][y - 1] == null && board2[x + 1][y] == null;
            }

    }


}

