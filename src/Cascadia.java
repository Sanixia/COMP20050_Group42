import java.util.Scanner;

public class Cascadia
{

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

    public static void main(String[] args)
    {
        Command_State command_state;

            Display_And_Input.welcome();
            Display_And_Input.num_players();
            Display_And_Input.player_names();
            Display_And_Input.randomised_order_players();

            boolean randomCheck = true;                     // check for one randomisation of tiles
            int playerNum = 0;



          do{
              command_state = Command_State.get_Input();   // Setting the command state Play or Quit



              if (command_state.isInPlay()){

                  if (randomCheck){
                      Display_And_Input.randomise_player_tiles_and_tokens();          // Has to do the randomistion once else it will cause errors
                      randomCheck = false;
                  }


                  if (command_state.getChoice() == 1){

                      Display_And_Input.display_tiles_and_tokens(playerNum);
                  }

                  else if (command_state.getChoice() == 2){



                      if (playerNum == Display_And_Input.getPlayer_count() - 1){    //resets to the start of the player list
                          playerNum = 0;
                      }
                      else{
                          playerNum++;
                      }
                      System.out.println("Next player is up...");

                  }




              }

          }while (!command_state.isQuit());
          Command_State.quitMessage();
        }


    }
