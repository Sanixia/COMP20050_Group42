import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Display_And_Input {
    private ArrayList<String> playerNames = new ArrayList<>();
    private static int player_count = 0;
    Scanner in;

    public static int getPlayer_count() {
        return player_count;
    }

    public ArrayList<String> getPlayerNames() {
        return playerNames;
    }



    public void welcome(){
        /* welcome message */
        /* ask how many players */

        System.out.println("Welcome to Cascadia!");
        System.out.println("How many people are playing? Please enter 2, 3 or 4: ");
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
                    System.out.println("Please enter a number that is either 2, 3, 4: ");
                }

            }
            catch (InputMismatchException ex) {
                System.out.println("Please enter a valid number.");
                in.nextLine();
            }
        }
        while (!validNumOfPlayers);




    }

    public static boolean isNameValid (String name){
        return name.isBlank();
    }

    public void player_names(){
        System.out.println("\nPlayer 1 please enter your name: ");

        boolean validAllNames = false;
        boolean checkValidName = false;

        do{
            String player_one = in.next();
        }
        while(!validAllNames){
            if ()
        }







        String player_one = in.next();

        System.out.println("\nPlayer 2 please enter your name: ");
        String player_two = in.next();

        if (player_count >= 3) {
            String player_three;
            if (player_count == 4) {
                String player_four;
            }
        }
    }
}
