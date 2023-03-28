import java.util.Arrays;
import java.util.Scanner;

// tile.java but modified to use 2d array instead of list of lists for board
public class tile2D {
    private static final int MAXSIZE = 26;
    private String biome;
    private String animals;
    private int rotation;
    private static int max_col;         // adjusts 'length' of board
    private static int max_row;         // adjusts 'height' of board
    private static int odd;          // 1 if odd rows are at the front

    private static int checkBoardUpper = 0;
    private static int checkBoardLower = 0;

    private static int checkOddOrEven = 0;
    //static tile2D[][] board = new tile2D[MAXSIZE][MAXSIZE];

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


    public static int getCheckOddOrEven() {
        return checkOddOrEven;
    }

    public static void setChangeOddOrEven(){
        if(checkOddOrEven == 0) checkOddOrEven = 1;
        else checkOddOrEven = 0;
    }


    public static void changeOdd() {
        if (odd == 1) odd = 0;
        else odd = 1;
        setChangeOddOrEven();
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


        //setup("River");

        //place_animal_token("e", 2, 3);
        //print_board(board);
        //place_animal_token("b");
        //System.out.println(Arrays.deepToString(board));


        for (int i = 0; i < 20; i++) {
            //place();
            //print_board(board);
            //place_animal_token("f");
            //System.out.println(Arrays.deepToString(board));
            System.out.println(max_col);
            System.out.println(max_row);
        }
    }

    public static void setup(String setup_board, tile2D[][] board) {
        odd = 1;                                            // need this here for my tile placement to work michal lol

        switch(setup_board){
            case "Forest":
                board_add_tile("F", "E", 0, 1, 2, board);
                board_add_tile("RM", "BEH", 3, 2, 2,board);
                board_add_tile("WP", "FS", 6, 2, 3,board);
                break;
            case "Prairie":
                board_add_tile("P", "F", 0, 1, 2,board);
                board_add_tile("WR", "FHS", 5, 2, 2,board);
                board_add_tile("FM", "BE", 0, 2, 3,board);
                break;
            case "Wetland":
                board_add_tile("W", "H", 0, 1, 2,board);
                board_add_tile("FR", "EHS", 2, 2, 2,board);
                board_add_tile("MP", "BF", 3, 2, 3,board);
                break;
            case "Mountain":
                board_add_tile("M", "B", 0, 1, 2,board);
                board_add_tile("FW", "EHF", 5, 2, 2,board);
                board_add_tile("RP", "BS", 6, 2, 3,board);
                break;
            case "River":
                board_add_tile("R", "S", 0, 1, 2,board);
                board_add_tile("FP", "BES", 2, 2, 2,board);
                board_add_tile("WM", "FH", 3, 2, 3,board);
                break;
        }
       // board_add_tile("F", "F", 0, 1, 2);
        //board_add_tile("P", "BES", 0, 2, 2);
        //board_add_tile("RM", "BEH", 1, 2, 3);

        odd = 1;                // odd = 1 means every odd row will be pushed in
        max_row = 4;
        max_col = 6;
    }

    public static void place(tile2D[][] board) {            // temporary place test feature
        Scanner in = new Scanner(System.in);
        int x, y;
        System.out.print("enter x: ");
        x = in.nextInt();
        System.out.print("\nenter y: ");
        y = in.nextInt();

        //while (verify_tile_placement(x, y, getCheckBoardUpper(), getCheckBoardLower())) {
        while (!verify_tile(x, y,board)) {
            System.out.println("Please enter a valid tile placement!\n");
            System.out.print("enter x: ");
            x = in.nextInt();
            System.out.print("\nenter y: ");
            y = in.nextInt();
        }
        board_add_tile("RM", "BEH", 1, x, y,board);
    }


    public static void board_add_tile(String biome, String animals, int rotation, int row, int col, tile2D[][] board) { //TODO verify
        tile2D tile = new tile2D(biome, animals, rotation);
        board[row][col] = tile;
        int plusOne = 0, plusRow = 0, plusCol = 0;
        if (col % 2 == 1 && odd == 1 || col % 2 == 0 && odd == 0) plusOne = 1;

        if (row == 0) {
            if (!(tile.biome == "slot")) {
                indent_row(board);
                plusRow = 1;
            }
           // setCheckBoardUpper();
            max_row++;
        } else if (row >= max_row - 1) {
            //setCheckBoardLower();
            max_row++;
        }

        if (col == 0) {
            if (!(tile.biome == "slot")) {
                indent_col(board);
                plusCol = 1;
            }
            max_col++;
        } else if (col + plusOne >= max_col - 1) {
            max_col++;
        }
        place_slot_tiles2(row+plusRow, col+plusCol, board);
    }

    public static void place_animal_token(String animal,tile2D[][] board) { //TODO verify
        boolean availableTokenPlacement = false;

        for(int i = 0; i < max_row; i++){

            for(int j = 0; j < max_col; j++){
                if(board[i][j] != null){
                    if(board[i][j].getAnimals().contains(animal.toUpperCase())){
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


            while (verify_animal_token_placement(x, y, animal, board)) {
                System.out.println("Please enter a valid tile that can place this animal token onto it and hasn't been taken already!\n");
                System.out.print("enter x: ");
                x = in.nextInt();
                System.out.print("\nenter y: ");
                y = in.nextInt();
            }

            board[x][y].setAnimals(animal);
        }

        else{
            System.out.println("No available tiles to place token");
        }

    }

    public static void print_board(tile2D[][] board) {
        String row;
        System.out.println(Ex2D.column_numbers(max_col));
        for (int i = 0; i != max_row; i++) {                // printing the board + 1 empty row boarder
            if (i % 2 == 0 && odd == 1 || i % 2 == 1 && odd == 0) {
                row = Ex2D.row_printer(board[i], max_col, 0, String.valueOf(i));      // maxrow specifies lenght
            } else {
                row = Ex2D.row_printer(board[i], max_col, 1, String.valueOf(i));
            }
            System.out.println(row);
        }
        System.out.println("\n");
    }


    public static void indent_col(tile2D[][] board) {
        for (int i = 0; i < max_row + 1; i++) {
            tile2D curr = board[i][0];
            tile2D next;
            board[i][0] = null;
            for (int j = 0; j < max_col; j++) {
                next = board[i][j + 1];
                board[i][j + 1] = curr;
                curr = next;
            }
        }
    }

    public static void indent_row(tile2D[][] board) {
        for (int i = 0; i < max_col + 1; i++) {
            tile2D curr = board[0][i];
            tile2D next;
            board[0][i] = null;
            for (int j = 0; j < max_row; j++) {
                next = board[j + 1][i];
                board[j + 1][i] = curr;
                curr = next;
            }
        }
        changeOdd();
    }


    public static void place_slot_tiles(int x, int y, tile2D[][] board) {             // determines where to place slot tiles
        int plusOne = 0;
        if (x % 2 == 1 && odd == 0 || x % 2 == 0 && odd == 1) plusOne = 1;          // NOTE TO MICHAL MAKE VALIDATE ODD FUNCTION USING THIS LINE
        if (y-1>=0 && board[x][y-1] == null){
            board[x][y-1] = new tile2D("slot", "", 0);         // left
        }
        if (y-1<=MAXSIZE && board[x][y+1] == null){
            board[x][y+1] = new tile2D("slot", "", 0);         // right
        }
        if (y-1+plusOne>=0 && x-1>=0 && board[x-1][y-1+plusOne] == null){
            board[x-1][y-1+plusOne] = new tile2D("slot", "", 0);   // top left
        }
        if (y+plusOne<=MAXSIZE && x-1>=0 && board[x-1][y+plusOne] == null){
            board[x-1][y+plusOne] = new tile2D("slot", "", 0);     // top right
        }
        if (y-1+plusOne>=0 && x+1<=MAXSIZE && board[x+1][y-1+plusOne] == null){
            board[x+1][y-1+plusOne] = new tile2D("slot", "", 0);   // bottom left
        }
        if (y+plusOne<=MAXSIZE && x+1<=MAXSIZE && board[x+1][y+plusOne] == null){
            board[x+1][y+plusOne] = new tile2D("slot", "", 0);     // bottom right
        }
    }

    public static void place_slot_tiles2(int x, int y, tile2D[][] board) {             // determines where to place slot tiles
        int plusOne = 1;
        if (x % 2 == 0 && odd == 1) plusOne = 0;          // NOTE TO MICHAL MAKE VALIDATE ODD FUNCTION USING THIS LINE
        if (checkOddOrEven == 1 && odd == 0 && x % 2 != 0) plusOne = 0;

        if (y-1>=0 && board[x][y-1] == null){
            board[x][y-1] = new tile2D("slot", "", 0);         // left
        }
        if (y-1<=MAXSIZE && board[x][y+1] == null){
            board[x][y+1] = new tile2D("slot", "", 0);         // right
        }
        if (y-1+plusOne>=0 && x-1>=0 && board[x-1][y-1+plusOne] == null){
            board[x-1][y-1+plusOne] = new tile2D("slot", "", 0);   // top left
        }
        if (y+plusOne<=MAXSIZE && x-1>=0 && board[x-1][y+plusOne] == null){
            board[x-1][y+plusOne] = new tile2D("slot", "", 0);     // top right
        }
        if (y-1+plusOne>=0 && x+1<=MAXSIZE && board[x+1][y-1+plusOne] == null){
            board[x+1][y-1+plusOne] = new tile2D("slot", "", 0);   // bottom left
        }
        if (y+plusOne<=MAXSIZE && x+1<=MAXSIZE && board[x+1][y+plusOne] == null){
            board[x+1][y+plusOne] = new tile2D("slot", "", 0);     // bottom right
        }
    }

    public static boolean verify_tile(int x, int y, tile2D[][] board) {
        if(x >= 0 && x < MAXSIZE && y >= 0 && y < MAXSIZE){
            if(board[x][y] != null){
                if (board[x][y].getBiome().contains("slot")) {
                    return true;
                }
            }
        }

        return false;

    }


    public static boolean verify_animal_token_placement(int x, int y, String animalToken, tile2D[][] board){

        // first check if there is a tile present
        if(board[x][y] != null){

            //check if tile contains the animalToken letter and checks if tile hasn't been taken already by the animalToken
            if(board[x][y].getAnimals().contains(animalToken.toUpperCase()) && !board[x][y].getAnimals().equals(animalToken)){
                return false;
            }
        }
        return true;
    }



}

