// Group 42
// Roshan, Michal
// Sanixia, glucoseIntolerant
import java.util.Scanner;

public class Board extends Printer // todo comments
{

    protected static final int MAXSIZE = 26;
    private String biome;
    private String animals;
    private int rotation;
    public Board(String biome, String animals, int rotation) {
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


    public static void main(String[] args) {
        //Board t = new Board("F", "BES", 0);           // can test printing out individual tiles
        //System.out.println(Board.print_tile_setup(t));

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
            //System.out.println(max_col);
            //System.out.println(max_row);
        }
    }

    public static void setup(String setup_board, Board[][] board, Player_Tracker player_tracker) {
        player_tracker.setOdd(1);

        switch(setup_board){
            case "Forest":
                board_add_tile("F", "E", 0, 1, 2, board, player_tracker);
                board_add_tile("RM", "BEH", 3, 2, 2,board, player_tracker);
                board_add_tile("WP", "FS", 6, 2, 3,board, player_tracker);
                break;
            case "Prairie":
                board_add_tile("P", "F", 0, 1, 2,board, player_tracker);
                board_add_tile("WR", "FHS", 5, 2, 2,board, player_tracker);
                board_add_tile("FM", "BE", 0, 2, 3,board, player_tracker);
                break;
            case "Wetland":
                board_add_tile("W", "H", 0, 1, 2,board, player_tracker);
                board_add_tile("FR", "EHS", 2, 2, 2,board, player_tracker);
                board_add_tile("MP", "BF", 3, 2, 3,board, player_tracker);
                break;
            case "Mountain":
                board_add_tile("M", "B", 0, 1, 2,board, player_tracker);
                board_add_tile("FW", "EHF", 5, 2, 2,board, player_tracker);
                board_add_tile("RP", "BS", 6, 2, 3,board, player_tracker);
                break;
            case "River":
                board_add_tile("R", "S", 0, 1, 2,board, player_tracker);
                board_add_tile("FP", "BES", 2, 2, 2,board, player_tracker);
                board_add_tile("WM", "FH", 3, 2, 3,board, player_tracker);
                break;
        }

        player_tracker.setMax_row_change(4);
        player_tracker.setMax_col_change(6);

    }


    public static void place(int tile_number, Board[][] board, Player_Tracker player_tracker, Board tile) {

        String temp_x = "", temp_y = "";
        int x, y;

        System.out.println("Greyed out tiles are valid placements!\n");

        x = Integer.parseInt(valid_row_column(temp_x, 1));
        y = Integer.parseInt(valid_row_column(temp_y, 2));



        while (!verify_tile(x, y,board)) {
            System.out.println("Please enter a valid tile placement!\n");


            x = Integer.parseInt(  valid_row_column(temp_x, 1));
            y = Integer.parseInt(valid_row_column(temp_y, 2));
        }

        board_add_tile(tile.getBiome(), tile.getAnimals(), tile.getRotation(), x, y,board, player_tracker);
    }

    public static String valid_row_column(String temp, int row_or_column){
        Scanner in = new Scanner(System.in);

        if(row_or_column == 1){
            System.out.print("Which row? : ");
            temp = in.nextLine();
            while(!verify_valid_number(temp)){
                System.out.println("Please enter a valid number!\n");
                System.out.print("Which row? : ");
                temp = in.nextLine();
            }
        }
        else if(row_or_column == 2){
            System.out.print("Which column? :  ");
            temp = in.nextLine();

            while (!verify_valid_number(temp)) {
                System.out.println("Please enter a valid number!\n");
                System.out.print("Which column? : ");
                temp = in.nextLine();
            }
        }

        return temp;
    }

    public static boolean verify_valid_number(String number){
        try{
            Integer.parseInt(number);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }




    public static void board_add_tile(String biome, String animals, int rotation, int row, int col, Board[][] board, Player_Tracker player_tracker) {
        Board tile = new Board(biome, animals, rotation);
        board[row][col] = tile;
        int plusOne = 0, plusRow = 0, plusCol = 0;
        if (col % 2 == 1 && player_tracker.getOdd() == 1 || col % 2 == 0 && player_tracker.getOdd() == 0) plusOne = 1;

        if (row == 0) {
            if (!(tile.getBiome() == "slot")) { //TODO
                indent_row(board, player_tracker);
                plusRow = 1;
            }

            player_tracker.setmax_row();
        } else if (row >= player_tracker.getMax_row() - 1) {

            player_tracker.setmax_row();
        }

        if (col == 0) {
            if (!(tile.getBiome() == "slot")) {
                indent_col(board, player_tracker);
                plusCol = 1;
            }
            player_tracker.setmax_col();
        } else if (col + plusOne >= player_tracker.getMax_col() - 1) {
            player_tracker.setmax_col();
        }
        place_slot_tiles(row+plusRow, col+plusCol, board, player_tracker);
    }

    public static boolean availableTokenPlacement(String animal, Board[][] board, Player_Tracker player_tracker){
        for(int i = 0; i < player_tracker.getMax_row(); i++){

            for(int j = 0; j < player_tracker.getMax_col(); j++){
                if(board[i][j] != null){
                    if(board[i][j].getAnimals().contains(animal.toUpperCase())){
                        return true;
                    }
                }
            }
        }
        return false;
    }



    public static void place_animal_token(String animal,Board[][] board, Player_Tracker player_tracker) {

        if(availableTokenPlacement(animal, board, player_tracker)){
            Scanner in = new Scanner(System.in);
            String temp_x = "", temp_y = "";
            int x, y;

            x = Integer.parseInt(  valid_row_column(temp_x, 1));
            y = Integer.parseInt(valid_row_column(temp_y, 2));

            // verify that there is available tiles that can place a token on


            while (verify_animal_token_placement(x, y, animal, board)) {
                System.out.println("Please enter a valid tile that can place this animal token onto it and hasn't been taken already!\n");
                x = Integer.parseInt(  valid_row_column(temp_x, 1));
                y = Integer.parseInt(valid_row_column(temp_y, 2));
            }

            if(board[x][y].getBiome().length() == 1){
                player_tracker.setNature_tokens(player_tracker.getNature_tokens() + 1);
                System.out.println("\nYou have gained a nature token, you now have " + player_tracker.getNature_tokens() + "!");
            }
            board[x][y].setAnimals(animal);

        }
        else{
            System.out.println("No available tiles to place token!\n");
        }

    }

    public static void indent_col(Board[][] board, Player_Tracker player_tracker) {
        for (int i = 0; i < player_tracker.getMax_row() + 1; i++) {
            Board curr = board[i][0];
            Board next;
            board[i][0] = null;
            for (int j = 0; j < player_tracker.getMax_col(); j++) {
                next = board[i][j + 1];
                board[i][j + 1] = curr;
                curr = next;
            }
        }
    }

    public static void indent_row(Board[][] board, Player_Tracker player_tracker) {
        for (int i = 0; i < player_tracker.getMax_col() + 1; i++) {
            Board curr = board[0][i];
            Board next;
            board[0][i] = null;
            for (int j = 0; j < player_tracker.getMax_row(); j++) {
                next = board[j + 1][i];
                board[j + 1][i] = curr;
                curr = next;
            }
        }
        player_tracker.changeOdd();
    }


    public static void place_slot_tiles(int x, int y, Board[][] board, Player_Tracker player_tracker) {             // determines where to place slot tiles
        int plusOne = 1;
        if (x % 2 == 0 && player_tracker.getOdd() == 1) plusOne = 0;
        if (player_tracker.getCheckOddOrEven() == 1 && player_tracker.getOdd() == 0 && x % 2 != 0) plusOne = 0;

        if (y-1>=0 && board[x][y-1] == null){
            board[x][y-1] = new Board("slot", "", 0);         // left
        }
        if (y-1<=MAXSIZE && board[x][y+1] == null){
            board[x][y+1] = new Board("slot", "", 0);         // right
        }
        if (y-1+plusOne>=0 && x-1>=0 && board[x-1][y-1+plusOne] == null){
            board[x-1][y-1+plusOne] = new Board("slot", "", 0);   // top left
        }
        if (y+plusOne<=MAXSIZE && x-1>=0 && board[x-1][y+plusOne] == null){
            board[x-1][y+plusOne] = new Board("slot", "", 0);     // top right
        }
        if (y-1+plusOne>=0 && x+1<=MAXSIZE && board[x+1][y-1+plusOne] == null){
            board[x+1][y-1+plusOne] = new Board("slot", "", 0);   // bottom left
        }
        if (y+plusOne<=MAXSIZE && x+1<=MAXSIZE && board[x+1][y+plusOne] == null){
            board[x+1][y+plusOne] = new Board("slot", "", 0);     // bottom right
        }
    }

    public static boolean verify_tile(int x, int y, Board[][] board) {
        if(x >= 0 && x < MAXSIZE && y >= 0 && y < MAXSIZE){
            if(board[x][y] != null){
                if (board[x][y].getBiome().contains("slot")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean verify_animal_token_placement(int x, int y, String animalToken, Board[][] board){

        // first check if there is a tile present
        if(board[x][y] != null){

            //check if tile contains the animalToken letter and checks if tile hasn't been taken already by the animalToken
            if(board[x][y].getAnimals().contains(animalToken.toUpperCase()) && !board[x][y].getAnimals().equals(animalToken)){
                return false;
            }
        }
        return true;
    }


    public static void print_boards(Board[][] board, int Max_col, int Max_row, int odd) {
        String row;
        System.out.println(column_numbers(Max_col));
        for (int i = 0; i != Max_row; i++) {                // printing the board + 1 empty row boarder
            if (i % 2 == 0 && odd == 1 || i % 2 == 1 && odd == 0) {
                row = row_printer(board[i], Max_col,0, String.valueOf(i));      // maxrow specifies lenght
            } else {
                row = row_printer(board[i], Max_col, 1, String.valueOf(i));
            }
            System.out.println(row);
        }
        System.out.println("\n");
    }
}