import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;



public class Display_And_Input {




    private static ArrayList<String> playerNames = new ArrayList<>();

    private static ArrayList<Experimental_Player_Tracker> players = new ArrayList<>();   //Array of objects to keep track of players
    private static int player_count = 0;


    public static int getPlayer_count() {
        return player_count;
    }

    public ArrayList<String> getPlayerNames() {
        return playerNames;
    }

    public static ArrayList<Experimental_Player_Tracker> getPlayers() {
        return players;
    }







    public static void welcome(){
        /* welcome message */
        /* ask how many players */

        System.out.println("Welcome to Cascadia!");
        System.out.print("How many people are playing? Please enter 2, 3 or 4: ");
    }




    public static void num_players() {


        Scanner in = new Scanner(System.in);
        
        boolean validNumOfPlayers = false;

        do{
            try{

                player_count = in.nextInt();
                if (player_count == 2 || player_count == 3 || player_count == 4){
                    validNumOfPlayers = true;
                }
                else{
                    System.out.print("Please enter a number that is either 2, 3 or 4: ");
                }

            }
            catch (InputMismatchException ex) {
                System.out.print("Please enter a valid number (2, 3 or 4): ");
                in.nextLine();
            }
        }
        while (!validNumOfPlayers);




    }




    public static void player_names(){
        Scanner in = new Scanner(System.in);
        String temp_name;
        int i;



        boolean checkValidName;


        for (i = 0; i < getPlayer_count(); i++){
            checkValidName = false;
            System.out.print("\nPlayer " + (i+1) + " please enter your name: ");


            while(!checkValidName){
                temp_name = in.next();

                if (playerNames.contains(temp_name)){
                    System.out.print("Please enter a name that isn't already taken: ");
                }
                else{
                    playerNames.add(temp_name);
                    checkValidName = true;
                }
            }
        }
    }




    public static void randomised_order_players(){                                  // Might get rid of, seems redundant
        int i;

        System.out.println("The order in which players will play will be: ");

        Collections.shuffle(playerNames);




        for (i = 0; i < player_count; i++){
            System.out.println((i+1) + ") " + playerNames.get(i));

        }

    }





    public static void randomise_player_tiles_and_tokens(){

        int i, j, k;
        ArrayList<String> temp_biomes = new ArrayList<>();
        ArrayList<String> temp_tokens = new ArrayList<>();
        ArrayList<String> temp_animals = new ArrayList<>();


        long seed = System.nanoTime();                                          // To have the same randomised list order for animals and biome tiles
        Collections.shuffle(Starter_Habitat.getStarter_Habitat_Tiles());

        Collections.shuffle(Habitat_Tiles.biome, new Random(seed));
        Collections.shuffle(Habitat_Tiles.animals, new Random(seed));
        Collections.shuffle(Wildlife_Tokens.tokens);


        for (i = 0; i < player_count; i++){
            temp_biomes.clear();                                                                    // Needs to be cleared every i loop
            temp_animals.clear();

            for (k = 0; k < 20; k++){
                temp_biomes.add(Habitat_Tiles.biome.get(0));                                        // adds tiles to temp and removes them from the original
                Habitat_Tiles.biome.remove(0);

                temp_animals.add(Habitat_Tiles.animals.get(0));
                Habitat_Tiles.animals.remove(0);

            }
            temp_tokens.clear();
            for (j = 0; j < 4; j ++){
                temp_tokens.add(Wildlife_Tokens.tokens.get(0));
                Wildlife_Tokens.tokens.remove(0);
            }

            //Calls the constructor

            players.add(new Experimental_Player_Tracker(playerNames.get(i), Starter_Habitat.getStarter_Habitat_Tiles().get(i), temp_biomes, temp_animals, temp_tokens));

        }
    }






    public static void display_tiles_and_tokens(int player){

        int i, j;

        System.out.println(players.get(player).getPlayer_name() + "'s  Tiles: \n");
        System.out.println("Starter Tile: \n");
        Tile_Printer.starter_tile_printout(players.get(player).getStarter_tile());

        System.out.println("\nHabitat Tiles: \n");
        for (i = 0; i < 4; i++){
            System.out.println(Experimental_Printer.print_tile_setup(players.get(player).getHabitat_tiles().get(i), 1, players.get(player).getAnimal_tiles().get(i) ));
        }

        System.out.println("Wildlife Tokens: \n");

        for (j = 0; j < 4; j++){
            System.out.println(Tile_Printer.token_printer(players.get(player).getWildlife_tokens().get(j)));
        }




    }
}










