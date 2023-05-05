// Group 42
// Roshan, Michal
// Sanixia, glucoseIntolerant

/**
 * Optimal tile placement for the bots, strategy would be habitat tile placements
 */
public class Bot_Scoring extends Board{


    public Bot_Scoring(String biome, String animals, int rotation) {
        super(biome, animals, rotation);
    }


    private static int[] best_coordinates = new int[2];


    private static int best_habitat_to_choose;

    private static int best_rotation;
    private static int best_score = 0;

    public static int[] getBest_coordinates() {
        return best_coordinates;
    }

    public static int getBest_score() {
        return best_score;
    }

    public static void setBest_score(int best_score) {
        Bot_Scoring.best_score = best_score;
    }

    public static void setBest_coordinates(int[] best_coordinates) {
        Bot_Scoring.best_coordinates = best_coordinates;
    }

    public static int getBest_rotation() {
        return best_rotation;
    }

    public static void setBest_rotation(int best_rotation) {
        Bot_Scoring.best_rotation = best_rotation;
    }


    public static int getBest_habitat_to_choose() {
        return best_habitat_to_choose;
    }

    public static void setBest_habitat_to_choose(int best_habitat_to_choose) {
        Bot_Scoring.best_habitat_to_choose = best_habitat_to_choose;
    }


    // TODO remember to add in something to check the animal tokens inside the habitat tiles if we do optimal token placement too


    public static int get_optimal_habitat_placement(Player_Tracker player_tracker){

        String current_habitat = "";

        setBest_score(0);
        Scoring_Setup.setBoard(player_tracker.getBoard());
        Scoring_Setup.setOdd(player_tracker.getOdd());

        for(int i = 0; i < 4; i++){
            current_habitat = Habitat_Tiles.biome.get(i);
            find_valid_tiles(player_tracker, current_habitat, i);
        }

        return getBest_habitat_to_choose();

    }

    public static void find_valid_tiles(Player_Tracker player_tracker, String habitat, int habitat_index){




        // checks the bots board to see if it contains the specific habitat tile
        for(int i = 0; i < player_tracker.getMax_row(); i++){
            for(int j = 0; j < player_tracker.getMax_col(); j++){

              // Board tile =  player_tracker.getBoard()[i][j];

                Board tile = Scoring_Setup.getBoard()[i][j];


               // keystone tile
                if(habitat.length() == 1){
                    if (tile != null && tile.getBiome().contains(habitat)){

                        check_slot_and_rotations(player_tracker, habitat, i, j, habitat_index);
                    }
                }
                else if(habitat.length() == 2){
                    if (tile != null && (tile.getBiome().contains(habitat.substring(0, 1)) || tile.getBiome().contains(habitat.substring(1, 2)))){

                        check_slot_and_rotations(player_tracker, habitat, i, j, habitat_index);
                    }
                }

            }
        }
    }


    public static void check_slot_and_rotations(Player_Tracker player_tracker, String habitat, int x, int y, int habitat_index){

        int x2 = x;
        int y2 = y;



        // checks 6 positions around the habitat
        for(int i = 1; i <= 6; i++){
            Board available_tiles = Scoring_Setup.get_surrounding_tile(x2, y2, i); // should be slot tile found

            // finds available slots around a given habitat
            if (available_tiles != null && available_tiles.getBiome().equals("slot")){

                int[] coordinates = Scoring_Cards.get_surrounding_tile_coordinates(x2, y2, i);
                x2 = coordinates[0];
                y2 = coordinates[1];

                if(x2 >= 0 && x2 < MAXSIZE && y2 >= 0 && y2 < MAXSIZE){


                    // for keystone tiles
                    if(habitat.length() == 1){

                        Board current_habitat_check = new Board(Habitat_Tiles.biome.get(habitat_index), Habitat_Tiles.animals.get(habitat_index), 6);
                        //Board.board_add_tile(Habitat_Tiles.biome.get(habitat_index), Habitat_Tiles.animals.get(habitat_index), 6, x2, y2, player_tracker.getBoard(), player_tracker );


                        Scoring_Setup.setBoardTile(Scoring_Setup.getBoard(), x2, y2, current_habitat_check);

                        int[] habitat_score = new int[5];

                        int habitat_array_index_1 = Scoring_Habitat_Tiles.habitat_to_score(habitat.charAt(0));

                        habitat_score =  Scoring_Habitat_Tiles.habitat_score(x2, y2, habitat_score);

                        update_score(habitat_score, habitat_array_index_1, x2, y2, 6, habitat_index);

                        //Board.board_add_tile(Habitat_Tiles.biome.get(habitat_index), Habitat_Tiles.animals.get(habitat_index), 6, x2, y2, player_tracker.getBoard(), player_tracker );

                        Scoring_Setup.setBoardTile(Scoring_Setup.getBoard(), x2, y2, available_tiles);
                        //player_tracker.setBoardTile(player_tracker.getBoard(), x2, y2, available_tiles);
                    }

                    // for two habitat tiles
                    else{

                        // checks 6 rotations for the best score
                        for(int j = 0; j < 6; j++){

                            Board current_habitat_check = new Board(Habitat_Tiles.biome.get(habitat_index), Habitat_Tiles.animals.get(habitat_index), j);
                            //Board.board_add_tile(Habitat_Tiles.biome.get(habitat_index), Habitat_Tiles.animals.get(habitat_index), j, x2, y2, player_tracker.getBoard(), player_tracker );


                           //Scoring_Setup.setBoardTile(player_tracker.getBoard(), x2, y2, current_habitat_check);
                            Scoring_Setup.setBoardTile(Scoring_Setup.getBoard(), x2, y2, current_habitat_check);

                            int[] habitat_score = new int[5];

                            int habitat_array_index_1 = Scoring_Habitat_Tiles.habitat_to_score(habitat.charAt(0));
                            int habitat_array_index_2 = Scoring_Habitat_Tiles.habitat_to_score(habitat.charAt(1));

                            habitat_score =  Scoring_Habitat_Tiles.habitat_score(x2, y2, habitat_score);  // { F, W, R, M, P}

                            update_score(habitat_score, habitat_array_index_1, x2, y2, j, habitat_index);
                            update_score(habitat_score, habitat_array_index_2, x2, y2, j, habitat_index);

                            //player_tracker.setBoardTile(player_tracker.getBoard(), x2, y2, available_tiles);
                            Scoring_Setup.setBoardTile(Scoring_Setup.getBoard(), x2, y2, available_tiles);

                            //Board.board_add_tile(Habitat_Tiles.biome.get(habitat_index), Habitat_Tiles.animals.get(habitat_index), j, x2, y2, player_tracker.getBoard(), player_tracker );

                        }


                    }

                    // returns it back to being a slot tile

                }
            }

            x2 = x;
            y2 = y;

        }
    }


    public static void update_score(int[] habitat_score, int habitat_array_index, int x, int y, int rotation, int habitat_index){

        if(habitat_score[habitat_array_index] >= getBest_score()){

            int totalscore = 0;

            for(int i = 0; i < 5; i++){
                totalscore += habitat_score[i];
            }

            // sets the new best score, coordinates, the best selected tile in the game (out of 4) and rotation for the bot to use
            if (totalscore > getBest_score()){
                setBest_score(totalscore);
            }else{
                setBest_score(habitat_score[habitat_array_index]);  // { F, W, R, M, P}
            }

            setBest_coordinates(new int[] {x,y});
            setBest_habitat_to_choose(habitat_index);
            setBest_rotation(rotation);

        }
    }


}
