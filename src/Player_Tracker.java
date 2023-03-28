import java.util.ArrayList;

public class Player_Tracker {

    private String player_name;

    private String starter_tile;

    private ArrayList<String> habitat_tiles = new ArrayList<>();


    private ArrayList<String> animal_tiles = new ArrayList<>();



    private int player_turn = 0;



    private int nature_tokens = 0;
    private static final int MAXSIZE = 26;



    private tile2D[][] board;









    //Used in the arraylist to keep track of players and their tiles and tokens
    //public Player_Tracker(String player_name, String starter_tile, ArrayList<String> habitat_tiles, ArrayList<String> animal_tiles){

    public Player_Tracker(String player_name, String starter_tile, int player_turn, int nature_tokens){

        this.player_name = player_name;
        this.starter_tile = starter_tile;
        //this.habitat_tiles = habitat_tiles;
        //this.animal_tiles = animal_tiles;

        this.player_turn = player_turn;
        this.nature_tokens = nature_tokens;
        this.board = new tile2D[MAXSIZE][MAXSIZE];









    }


    public static void setup_board(String setup_board){
        tile2D.setup(setup_board);
    }

    public static void print_board(tile2D[][] board){
        tile2D.print_board(board);
    }



    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public  String getStarter_tile() {
        return starter_tile;
    }

    public void setStarter_tile(String starter_tile) {
        this.starter_tile = starter_tile;
    }

    public ArrayList<String> getHabitat_tiles() {
        return this.habitat_tiles;
    }

    public void setHabitat_tiles(ArrayList<String> habitat_tiles) {
        this.habitat_tiles = habitat_tiles;
    }



    public ArrayList<String> getAnimal_tiles() {
        return animal_tiles;
    }

    public void setAnimal_tiles(ArrayList<String> animal_tiles) {
        this.animal_tiles = animal_tiles;
    }

    public int getPlayerTurn() {
        return player_turn;
    }

    public void setPlayerTurn() {
        this.player_turn++;
    }

    public int getNature_tokens() {
        return nature_tokens;
    }

    public void setNature_tokens() {
        this.nature_tokens = nature_tokens;
    }

    public tile2D[][] getBoard() {
        return board;
    }


}
