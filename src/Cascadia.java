import java.util.Scanner;

public class Cascadia
{
    public static void controller()
    {
        /* welcome message */

        System.out.println("Welcome to Cascadia!");

        /* ask how many players */

        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter the number of players (2-4): ");
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

        /* rng player order */
        /* show 4 habitat tiles and 4 paired tokens */

        /* starter habitats randomly generated for each player */


        // upon a players turn :
        /* pick tile
           next command to show their habitat
           quit command to terminate program */


        // NOTES:
        /* there are only 5 possible starter tiles to rng (check manual)
           60 double habitat tiles (10 unique types) ,
           25 keystone tiles (5 unique types) */

        /* 2 players: 43 tiles }
           3 players: 63 tiles } 20 per player +3 for habitat
           4 players: 83 tiles } */
    }
    public static void main(String[] args)
    {
        controller();
    }

    /* welcome message */

    /* ask how many players */
    /* enter player names */

    /* rng player order */
    /* show 4 habitat tiles and 4 paired tokens */

    /* starter habitats randomly generated for each player */


    // upon a players turn :
        /* pick tile
           next command to show their habitat
           quit command to terminate program */


    // NOTES:
        /* there are only 5 possible starter tiles to rng (check manual)
           60 double habitat tiles (10 unique types) ,
           25 keystone tiles (5 unique types) */

        /* 2 players: 43 tiles }
           3 players: 63 tiles } 20 per player +3 for habitat
           4 players: 83 tiles } */

        /* to rotate have a how many times rotate clockwise */
}