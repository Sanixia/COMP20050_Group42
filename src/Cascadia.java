import java.sql.SQLOutput;
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

              command_state = Command_State.get_input2(1);   // Setting the command state

              if (randomCheck){
                  Display_And_Input.randomise_player_tiles_and_tokens();          // Has to do the randomization once else it will cause errors

                  for(int i = 0; i < Display_And_Input.getPlayer_count(); i++){
                      Display_And_Input.getPlayers().get(i).setup_board(Display_And_Input.getPlayers().get(i).getStarter_tile(),Display_And_Input.getPlayers().get(i).getBoard() );   //sets up board with starter tile from player
                  }
                  randomCheck = false;
              }



              if (command_state.isInPlay()){




                  if (command_state.getChoice() == 1){

                      System.out.println("--- " + Display_And_Input.getPlayers().get(playerNum).getPlayer_name()+ "'s  Board --- \n");

                      Display_And_Input.getPlayers().get(playerNum).print_board(Display_And_Input.getPlayers().get(playerNum).getBoard());

                      Display_And_Input.display_tiles_and_tokens(playerNum);

                  }

                  else if (command_state.getChoice() == 2){

                      Display_And_Input.getPlayers().get(playerNum).setPlayerTurn();  //increments turn by 1 each time this is called

                      if( Display_And_Input.getPlayers().get(playerNum).getPlayerTurn() < 3){
                          if (playerNum == Display_And_Input.getPlayer_count() - 1){    //resets to the start of the player list
                              playerNum = 0;
                          }
                          else{
                              playerNum++;
                          }
                          System.out.println(Display_And_Input.getPlayers().get(playerNum).getPlayer_name() + " is up...");
                      }

                      else{




                          Display_And_Input.getPlayers().remove(Display_And_Input.getPlayers().get(playerNum));

                          Display_And_Input.setPlayer_count(Display_And_Input.getPlayer_count());

                          System.out.println("You have no more turns left, preparing to calculate your score...");
                      }

                  }



                  else if (command_state.getChoice() == 3){   // this is for the board menu which will be updated with more options




                      do {
                          display_board_tiles_tokens(playerNum, 2, command_state);




                          if(command_state.getChoice() == 1){  // this is for the habitat board menu which will be updated with more options

                              do{
                                  display_board_tiles_tokens(playerNum, 3, command_state);    // habitat to place down


                                  if(command_state.getChoice() == 1 || command_state.getChoice() == 2 || command_state.getChoice() == 3 || command_state.getChoice() == 4){








                                      do{
                                          display_board_tiles_tokens(playerNum, 4, command_state);


                                          if(command_state.getChoice() == 1){
                                              do{

                                                  display_board_tiles_tokens(playerNum, 5, command_state);


                                              }while (command_state.isInTokenMenu());
                                          }





                                      }while (command_state.isInHabitatRotationMenu());
                                  }
                                  else{
                                        System.out.println("Invalid input, please try again");
                                  }



                              }while (command_state.isInHabitatBoardMenu());
                          }






                      }while (!command_state.isInMainMenu());
                  }




              }

          }while (!command_state.isQuit());

          Command_State.quitMessage();
        }


        public static void display_board_tiles_tokens(int player_number, int menu_number, Command_State command_state){
            Display_And_Input.getPlayers().get(player_number).print_board(Display_And_Input.getPlayers().get(player_number).getBoard());
            Display_And_Input.display_tiles_and_tokens(player_number);
            command_state = Command_State.get_input2(menu_number);
        }


    }
