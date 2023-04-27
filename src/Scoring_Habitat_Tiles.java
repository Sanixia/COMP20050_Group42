public class Scoring_Habitat_Tiles extends Scoring_Cards{


    public Scoring_Habitat_Tiles(String biome, String animals, int rotation) {
        super(biome, animals, rotation);
    }

    public static int[] habitat_score(int x, int y, int[] habitat_tiles){

        Board current_habitat = getBoard()[x][y];


        switch (current_habitat.getBiome().charAt(0)) {
            case 'F' -> habitat_tiles = forest_score();
            case 'R' -> habitat_tiles = river_score();
            case 'P' -> habitat_tiles = prairie_score();
            case 'M' -> habitat_tiles = mountain_score();
            case 'W' -> habitat_tiles = wetland_score();
        }

        if(current_habitat.getBiome().length() == 2){

            // get the second habitat
            char second_habitat = current_habitat.getBiome().charAt(1);


            // get the score of the second habitat
            switch (second_habitat) {
                case 'F' -> habitat_tiles = forest_score();
                case 'R' -> habitat_tiles = river_score();
                case 'P' -> habitat_tiles = prairie_score();
                case 'M' -> habitat_tiles = mountain_score();
                case 'W' -> habitat_tiles = wetland_score();
            }
        }

        return habitat_tiles;

    }


    public static int[] forest_score(){
        return null;
    }

    public static int[] river_score(){
        return null;
    }

    public static int[] prairie_score(){
        return null;
    }

    public static int[] mountain_score(){
        return null;
    }

    public static int[] wetland_score(){
       return null;
    }







}
