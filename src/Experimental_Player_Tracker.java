import java.util.ArrayList;

public class Experimental_Player_Tracker {

    private String player_name;

    private String starter_tile;

    private ArrayList<String> habitat_tiles = new ArrayList<>();

    private ArrayList<String> wildlife_tokens = new ArrayList<>();

    private ArrayList<String> animal_tiles = new ArrayList<>();









    //Used in the arraylist to keep track of players and their tiles and tokens
    public Experimental_Player_Tracker(String player_name, String starter_tile, ArrayList<String> habitat_tiles, ArrayList<String> animal_tiles, ArrayList<String> wildlife_tokens){

        this.player_name = player_name;
        this.starter_tile = starter_tile;
        this.habitat_tiles = habitat_tiles;
        this.animal_tiles = animal_tiles;
        this.wildlife_tokens = wildlife_tokens;





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
        return habitat_tiles;
    }

    public void setHabitat_tiles(ArrayList<String> habitat_tiles) {
        this.habitat_tiles = habitat_tiles;
    }


    public ArrayList<String> getWildlife_tokens() {
        return wildlife_tokens;
    }

    public void setWildlife_tokens(ArrayList<String> wildlife_tokens) {
        this.wildlife_tokens = wildlife_tokens;
    }


    public ArrayList<String> getAnimal_tiles() {
        return animal_tiles;
    }

    public void setAnimal_tiles(ArrayList<String> animal_tiles) {
        this.animal_tiles = animal_tiles;
    }



}
