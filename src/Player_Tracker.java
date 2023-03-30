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
    private int max_col;         // adjusts 'length' of board
    private int max_row;         // adjusts 'height' of board
    private int  odd;         // 1 if odd rows are at the front
    private int checkOddOrEven;










    public Player_Tracker(String player_name, String starter_tile, int player_turn, int nature_tokens, int max_row, int max_col, int odd, int checkOddOrEven){

        this.player_name = player_name;
        this.starter_tile = starter_tile;

        this.player_turn = player_turn;
        this.nature_tokens = nature_tokens;

        this.board = new tile2D[MAXSIZE][MAXSIZE];
        this.max_row = max_row;
        this.max_col = max_col;
        this.odd = odd;
        this.checkOddOrEven = checkOddOrEven;


    }


    public void setup_board(String setup_board, tile2D[][] board,  Player_Tracker player){
        tile2D.setup(setup_board, board, player);
    }

    public void print_board(tile2D[][] board, Player_Tracker player){
        tile2D.print_board(board, player);
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

    public void setNature_tokens(int nature_tokens) {
        this.nature_tokens = nature_tokens;
    }

    public tile2D[][] getBoard() {
        return board;
    }

    public void setMax_row_change(int max_row){
        this.max_row = max_row;
    }
    public void setMax_col_change(int max_col){
        this.max_col = max_col;
    }

    public void setmax_row() {
        max_row++;
    }

    public void setmax_col() {
        max_col++;
    }


    public int getCheckOddOrEven() {
        return checkOddOrEven;
    }

    public void setChangeOddOrEven(){
        if(checkOddOrEven == 0) checkOddOrEven = 1;
        else checkOddOrEven = 0;
    }


    public void changeOdd(){
        if (odd == 1) odd = 0;
        else odd = 1;
        setChangeOddOrEven();
    }

    public int getMax_col() {
        return max_col;
    }

    public int getMax_row() {
        return max_row;
    }

    public int getOdd() {
        return odd;
    }

    public int setOdd(int odd) {
        return this.odd = odd;
    }


}
