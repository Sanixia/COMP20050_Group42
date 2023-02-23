import java.util.ArrayList;

public class Player_Tracker {

    private String player_name;

    private String starter_tile;

    private ArrayList<String> habitat_tiles = new ArrayList<>();


    private ArrayList<String> animal_tiles = new ArrayList<>();



    private int playerTurn = 0;



    private ArrayList<String> nature_tokens = new ArrayList<>();







    //Used in the arraylist to keep track of players and their tiles and tokens
    //public Player_Tracker(String player_name, String starter_tile, ArrayList<String> habitat_tiles, ArrayList<String> animal_tiles){

    public Player_Tracker(String player_name, String starter_tile){

        this.player_name = player_name;
        this.starter_tile = starter_tile;
        //this.habitat_tiles = habitat_tiles;
        //this.animal_tiles = animal_tiles;

        this.playerTurn = getPlayerTurn();
        this.nature_tokens = getNature_tokens();






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
        return playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = getPlayerTurn() + 1;
    }

    public ArrayList<String> getNature_tokens() {
        return nature_tokens;
    }

    public void setNature_tokens(ArrayList<String> nature_tokens) {
        this.nature_tokens = nature_tokens;
    }


}
