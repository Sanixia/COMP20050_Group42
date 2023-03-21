import java.util.Scanner;

public class Cascadia
{


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

              command_state = Command_State.get_Input();   // Setting the command state
              if (randomCheck){
                  Display_And_Input.randomise_player_tiles_and_tokens();          // Has to do the randomization once else it will cause errors
                  randomCheck = false;
              }



              if (command_state.isInPlay()){




                  if (command_state.getChoice() == 1){

                      Display_And_Input.display_tiles_and_tokens(playerNum);
                  }

                  else if (command_state.getChoice() == 2){

                      Display_And_Input.getPlayers().get(playerNum).setPlayerTurn(Display_And_Input.getPlayers().get(playerNum).getPlayerTurn());  //increments turn by 1 each time this is called


                      if (playerNum == Display_And_Input.getPlayer_count() - 1){    //resets to the start of the player list
                          playerNum = 0;
                      }
                      else{
                          playerNum++;
                      }
                      System.out.println(Display_And_Input.getPlayers().get(playerNum).getPlayer_name() + " is up...");

                  }



                  else if (command_state.getChoice() == 3){   // this is for the board menu which will be updated with more options




                      do {
                          Display_And_Input.display_tiles_and_tokens(playerNum);
                          command_state = Command_State.get_Input();               //will be updated to have options for select tile and token






                      }while (!command_state.isInMainMenu());
                  }




              }

          }while (!command_state.isQuit());
          Command_State.quitMessage();
        }


    }
