import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Display_And_Input {


    private static ArrayList<String> playerNames = new ArrayList<>();

    private static ArrayList<Experimental_Player_Tracker> players = new ArrayList<>();
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




    public static void randomised_order_players(){
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




        Collections.shuffle(Starter_Habitat.getStarter_Habitat_Tiles());
        Collections.shuffle(Habitat_Tiles.biome);
        Collections.shuffle(Wildlife_Tokens.tokens);


        for (i = 0; i < player_count; i ++){
            temp_biomes.clear();

            for (k = 0; k < 20; k++){
                temp_biomes.add(Habitat_Tiles.biome.get(0));
                Habitat_Tiles.biome.remove(0);

            }

            for (j = 0; j < 4; j ++){
                temp_tokens.add(Wildlife_Tokens.tokens.get(0));
                Habitat_Tiles.biome.remove(0);
            }

            players.add(new Experimental_Player_Tracker(playerNames.get(i), Starter_Habitat.getStarter_Habitat_Tiles().get(i), temp_biomes, temp_tokens));
        }



    }






}
