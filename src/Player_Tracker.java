// Group 42
// Roshan, Michal
// Sanixia, glucoseIntolerant
public class Player_Tracker {

    /**
     * Player_Tracker class is used to keep track of the player's name, starter tile, player turn, nature tokens, and board
     */

    private final String player_name;
    private final String starter_tile;
    private int player_turn = 0;
    private int nature_tokens = 0;
    private static final int MAXSIZE = 26;

    private Board[][] board;
    private int max_col;         // adjusts 'length' of board
    private int max_row;         // adjusts 'height' of board
    private int  odd;         // 1 if odd rows are at the front
    private int checkOddOrEven;


    public Player_Tracker(String player_name, String starter_tile, int player_turn, int nature_tokens, int max_row, int max_col, int odd, int checkOddOrEven){

        this.player_name = player_name;
        this.starter_tile = starter_tile;

        this.player_turn = player_turn;
        this.nature_tokens = nature_tokens;

        this.board = new Board[MAXSIZE][MAXSIZE];
        this.max_row = max_row;
        this.max_col = max_col;
        this.odd = odd;
        this.checkOddOrEven = checkOddOrEven;


    }

    public void setup_board(String setup_board, Board[][] board,  Player_Tracker player){
        Board.setup(setup_board, board, player);
    }

    public void print_board(Board[][] board, Player_Tracker player){
        Board.print_boards(board, player.max_col, player.max_row, player.odd);
    }

    public String getPlayer_name() {
        return player_name;
    }

    public  String getStarter_tile() {
        return starter_tile;
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

    public Board[][] getBoard() {
        return board;
    }

    public void setBoardTile(Board[][] board, int x, int y, Board tile) {
        this.getBoard()[x][y] = tile;
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
