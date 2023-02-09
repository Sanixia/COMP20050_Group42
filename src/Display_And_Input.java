import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Display_And_Input {
    private static ArrayList<String> playerNames = new ArrayList<>();
    private static int player_count = 0;


    public static int getPlayer_count() {
        return player_count;
    }

    public ArrayList<String> getPlayerNames() {
        return playerNames;
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
        int i = 0;
        int numPlayer;



        boolean checkValidName;


        for (i = 0; i < getPlayer_count(); i++){
            numPlayer = i+1;
            checkValidName = false;
            System.out.print("\nPlayer " + numPlayer + " please enter your name: ");


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

    public static void randomised_order(){
        int i;
        System.out.println("The order in which players will play will be: ");
        Collections.shuffle(playerNames);

        for (i = 0; i < player_count; i++){
            System.out.println((i+1) + ") " + playerNames.get(i));
        }

    }


}
