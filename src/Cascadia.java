import java.util.Scanner;

public class Cascadia
{
    public static void controller()
    {
        /* welcome message */

        System.out.println("Welcome to Cascadia!");

        /* ask how many players */

        Scanner in = new Scanner(System.in);

            /// ! this needs to be fixed apparently

        int player_count = 0;
        while (player_count >= 2 && player_count <= 4) {
            System.out.println("\nEnter the number of players (2-4): ");
            player_count = in.nextInt();
        }


        /* enter player names */

        System.out.println("\nPlayer 1 please enter your name: ");
        String player_one = in.next();

        System.out.println("\nPlayer 2 please enter your name: ");
        String player_two = in.next();

        if (player_count >= 3) {
            System.out.println("\nPlayer 3 please enter your name: ");
            String player_three = in.next();
            if (player_count == 4) {
                System.out.println("\nPlayer 4 please enter your name: ");
                String player_four = in.next();
            }
        }

        System.out.println("random message for now");

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
        Tile_Printer.habitat_tile_printout(Tile_Printer.habitat_tile_setup("FW"), "BES");
        Tile_Printer.starter_tile_printout("Mountain");
        Tile_Printer.starter_tile_printout("Prairie");
        Tile_Printer.starter_tile_printout("Wetland");
        Tile_Printer.starter_tile_printout("Forest");
        Tile_Printer.starter_tile_printout("River");
        Display_And_Input.welcome();
        Display_And_Input.num_players();
        Display_And_Input.player_names();
        Display_And_Input.randomised_order_players();
        Display_And_Input.randomise_player_tiles_and_tokens();

    }
}