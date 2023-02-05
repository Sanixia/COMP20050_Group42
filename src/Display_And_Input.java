import java.util.Random;
import java.util.Scanner;


public class Display_And_Input {



    public void welcome(){
        /* welcome message */
        /* ask how many players */

        System.out.println("Welcome to Cascadia!");
        System.out.println("How many people are playing? Please enter 2, 3 or 4: ");
    }

    public static void controller() {

        Scanner in = new Scanner(System.in);
        int player_count = in.nextInt();

        /* enter player names */

        System.out.println("\nPlayer 1 please enter your name: ");
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
