
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
                      Display_And_Input.getPlayers().get(i).setup_board(Display_And_Input.getPlayers().get(i).getStarter_tile(),Display_And_Input.getPlayers().get(i).getBoard(),   Display_And_Input.getPlayers().get(i));   //sets up board with starter tile from player
                  }
                  randomCheck = false;
              }



              if (command_state.isInPlay()){

                  boolean check_keystone = false;
                  int token_tile = -1;



                  if (command_state.getChoice() == 1){  // this is for the player menu which will be updated with more options

                      System.out.println("--- " + Display_And_Input.getPlayers().get(playerNum).getPlayer_name()+ "'s  Board --- \n");

                      Display_And_Input.getPlayers().get(playerNum).print_board(Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum));

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


                                      if(Habitat_Tiles.biome.get(command_state.getChoice() - 1).length() == 1) {
                                          check_keystone = true;
                                          token_tile = command_state.getChoice() - 1;
                                      }


                                      do{


                                          if(check_keystone == false){
                                              token_tile = command_state.getChoice() - 1;

                                              Display_And_Input.getPlayers().get(playerNum).print_board(Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum));
                                              Display_And_Input.display_tiles_and_tokens(playerNum);

                                              Display_And_Input.display_tile_rotation(command_state.getChoice());
                                              command_state = Command_State.get_input2(4);

                                              if(Command_State.getHabitat_tile_choice() == 0 && command_state.getChoice() == 1 || command_state.getChoice() == 2 || command_state.getChoice() == 3 || command_state.getChoice() == 4 || command_state.getChoice() == 5 || command_state.getChoice() == 6 || command_state.getChoice() == 7 ) {

                                                  Display_And_Input.getPlayers().get(playerNum).print_board(Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum));
                                                  Display_And_Input.place_tile(command_state.getChoice(), 0, Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum));
                                              }
                                          }
                                          else{
                                              Display_And_Input.getPlayers().get(playerNum).print_board(Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum));

                                                  Display_And_Input.place_tile(command_state.getChoice(), 0, Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum));
                                              }



                                              do{
                                                  Display_And_Input.remove_tile(token_tile);
                                                  display_board_tiles_tokens(playerNum, 5, command_state);  // token to place down

                                                  if(command_state.getChoice() == 1){
                                                      tile2D.place_animal_token( Wildlife_Tokens.tokens.get(token_tile) , Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum));

                                                      Display_And_Input.remove_token(token_tile);
                                                  }




                                              }while (command_state.isInTokenMenu());






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
            Display_And_Input.getPlayers().get(player_number).print_board(Display_And_Input.getPlayers().get(player_number).getBoard(), Display_And_Input.getPlayers().get(player_number));
            Display_And_Input.display_tiles_and_tokens(player_number);
            command_state = Command_State.get_input2(menu_number);
        }


    }

