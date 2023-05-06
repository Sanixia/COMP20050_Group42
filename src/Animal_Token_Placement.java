// Group 42
// Roshan, Michal
// Sanixia, glucoseIntolerant

/**
 * For optimising the animal token placement for the bot
 */



public class Animal_Token_Placement extends Scoring_Setup{


    private static int[] best_coordinates_token = new int[2];

    private static int best_token_score;


    public Animal_Token_Placement(String biome, String animals, int rotation) {
        super(biome, animals, rotation);
    }

    public static int[] getBest_coordinates_token() {
        return best_coordinates_token;
    }

    public static void setBest_coordinates_token(int[] best_coordinates_token) {
        Animal_Token_Placement.best_coordinates_token = best_coordinates_token;
    }


    public static int getBest_token_score() {
        return best_token_score;
    }

    public static void setBest_token_score(int best_token_score) {
        Animal_Token_Placement.best_token_score = best_token_score;
    }



    public static int[] optimal_token_placement(String token_to_choose, Player_Tracker player_tracker) {

        // sets the board to the current board and odd and calculates the current best score
        setBoard(player_tracker.getBoard());
        setOdd(player_tracker.getOdd());
        setBest_token_score(animal_scoring(new int[] {1,1,1,1,1}, player_tracker));
        setBest_coordinates_token(new int[] {-1,-1});

        find_valid_animal_placements(token_to_choose, player_tracker);

        return best_coordinates_token;
    }

    public static void find_valid_animal_placements(String token_to_choose, Player_Tracker player_tracker) {


        for(int i = 0; i < player_tracker.getMax_row(); i++){
            for(int j = 0; j < player_tracker.getMax_col(); j++){


                // if the tile is not null and the animal is the one we are looking for and the animal isnt already placed down, then set the board to the current board and calculate the best score
                if(getBoard()[i][j] != null && getBoard()[i][j].getAnimals().contains(token_to_choose.toUpperCase()) && !getBoard()[i][j].getAnimals().equals(token_to_choose)){
                    setBoard(player_tracker.getBoard());
                    calculate_best_animal_score(i, j, token_to_choose, player_tracker);

                }
            }
        }

    }

    public static void calculate_best_animal_score(int i, int j, String token_to_choose, Player_Tracker player_tracker) {

        // puts the animal token there and calculates the score
        setBoardAnimal(i, j, token_to_choose);
        int score = animal_scoring(new int[] {1,1,1,1,1}, player_tracker);;

        // if the score is better or equal to the current best score, then set the best score to the current score and set the best coordinates to the current coordinates
        if(score >= getBest_token_score()){
            setBest_token_score(score);
            setBest_coordinates_token(new int[] {i, j});
        }

    }



}
