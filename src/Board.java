// Group 42
// Roshan, Michal
// Sanixia, glucoseIntolerant
import java.util.Random;
import java.util.Scanner;

public class Board extends Printer // todo comments
{
    /* board is a 26x26 adaptive board
       - it will extend itself or move everything once it reaches the limit
       - may have a tile or null
       - tiles can either be (game) tiles or spaces which are valid placement indicators
       - will always have a border when displayed
     */

    protected static final int MAXSIZE = 26;
    private String biome;
    private String animals;
    private int rotation;

    /*  Constructor for a tile on the board
        contains the biome(s) animal(s) and rotation
     */
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

    /*      Getting initial starter tiles
     */
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


    public static void place(boolean bot_player, Board[][] board, Player_Tracker player_tracker, Board tile) {
        long seed = System.nanoTime();
        Random random = new Random(seed);
        String temp_x = "", temp_y = "";
        int bot_x = 0, bot_y = 0;
        int x, y;

        if(bot_player){
            bot_x = random.nextInt(MAXSIZE) + 1;
            bot_y = random.nextInt(MAXSIZE) + 1;

            while (!verify_tile(bot_x, bot_y,board)) {
                bot_x = random.nextInt(MAXSIZE) + 1;
                bot_y = random.nextInt(MAXSIZE) + 1;
            }
            board_add_tile(tile.getBiome(), tile.getAnimals(), tile.getRotation(), bot_x, bot_y,board, player_tracker);
        }

        else{
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




    /*  Function to place a tile
     */
    public static void board_add_tile(String biome, String animals, int rotation, int row, int col, Board[][] board, Player_Tracker player_tracker) {
        Board tile = new Board(biome, animals, rotation);
        board[row][col] = tile;
        int plusOne = 0, plusRow = 0, plusCol = 0;
        if (col % 2 == 1 && player_tracker.getOdd() == 1 || col % 2 == 0 && player_tracker.getOdd() == 0) plusOne = 1;

        if (row == 0) {                                     // case: upperbounds of board
            if (!(tile.getBiome() == "slot")) { //TODO
                indent_row(board, player_tracker);          // everything will be pushed (indented) downwards
                plusRow = 1;
            }

            player_tracker.setmax_row();
        } else if (row >= player_tracker.getMax_row() - 1) {

            player_tracker.setmax_row();                    // normal case
        }

        if (col == 0) {                                     // case: leftbounds of board
            if (!(tile.getBiome() == "slot")) {
                indent_col(board, player_tracker);          // everything will be pushed (indented) rightwards
                plusCol = 1;
            }
            player_tracker.setmax_col();
        } else if (col + plusOne >= player_tracker.getMax_col() - 1) {  // normal case
            player_tracker.setmax_col();
        }
        place_slot_tiles(row+plusRow, col+plusCol, board, player_tracker);  // places slot tiles around the new tile
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



    public static void place_animal_token(boolean bot_player, String animal,Board[][] board, Player_Tracker player_tracker) {
        long seed = System.nanoTime();
        Random random = new Random(seed);
        int bot_x = 0;
        int bot_y = 0;
        if(availableTokenPlacement(animal, board, player_tracker)){

            if(bot_player){
                bot_x = random.nextInt(MAXSIZE) + 1;
                bot_y = random.nextInt(MAXSIZE) + 1;

                while (verify_animal_token_placement(bot_x, bot_y, animal, board)) {
                    bot_x = random.nextInt(MAXSIZE) + 1;
                    bot_y = random.nextInt(MAXSIZE) + 1;
                }
                if(board[bot_x][bot_y].getBiome().length() == 1){
                    player_tracker.setNature_tokens(player_tracker.getNature_tokens() + 1);
                    System.out.println("\nYou have gained a nature token, you now have " + player_tracker.getNature_tokens() + "!");
                }
                board[bot_x][bot_y].setAnimals(animal);
            }
            else{
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


        }
        else{
            System.out.println("No available tiles to place token!\n");
        }

    }

    // Moves every tile by 1 to the right

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

    // Moves every tile by 1 down
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
        player_tracker.changeOdd();         // has to account for it by changing if odd are indented
    }


    /*      Function that places down slot tiles
            - gets tile at board[x][y]
            - places slot tiles on the surrounding tiles that are null
     */

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
        if(x > 0 && x < MAXSIZE && y > 0 && y < MAXSIZE){
            if(board[x][y] != null){

                //check if tile contains the animalToken letter and checks if tile hasn't been taken already by the animalToken
                if(board[x][y].getAnimals().contains(animalToken.toUpperCase()) && !board[x][y].getAnimals().equals(animalToken)){
                    return false;
                }
            }
        }

        return true;
    }

    /*      Print board function
            - send the board in row by row to be printed
            - odd is sent in for the offset
            - will only print up until max row, max col
     */

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