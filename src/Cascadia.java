
public class Cascadia
{
    static int playerNum = 0;
    static boolean culling_trigger = true;

    static int[] player_scoring_card = new int[5];

    public static void main(String[] args)
    {
        Command_State command_state;

        Display_And_Input.welcome();
        Display_And_Input.num_players();
        Display_And_Input.player_names();
        Display_And_Input.randomised_order_players();
        WildLife_Scoring_Setup.scoring_card_array(player_scoring_card);
        WildLife_Scoring_Setup.print_scoring_card(player_scoring_card);

        boolean randomCheck = true;                     // check for one randomisation of tiles



        do{


            command_state = Command_State.get_input(1);   // Setting the command state



            if (randomCheck){
                Display_And_Input.randomise_player_tiles_and_tokens();          // Has to do the randomization once else it will cause errors

                for(int i = 0; i < Display_And_Input.getPlayer_count(); i++){
                    Display_And_Input.getPlayers().get(i).setup_board(Display_And_Input.getPlayers().get(i).getStarter_tile(),Display_And_Input.getPlayers().get(i).getBoard(),   Display_And_Input.getPlayers().get(i));   //sets up board with starter tile from player
                }
                randomCheck = false;
            }



            if (command_state.isInPlay()){ // this is for the main game so it loops to not quit unless option 4 or players turns have all been ended
                boolean check_keystone = false;
                boolean nature_option_menu = false;

                int place_tile = -1;





                if (command_state.getChoice() == 1){  // this is to check what the current player's board, habitat tiles and tokens are


                    System.out.println("--- " + Display_And_Input.getPlayers().get(playerNum).getPlayer_name()+ "'s  Board --- \n");

                    Display_And_Input.getPlayers().get(playerNum).print_board(Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum));

                    Display_And_Input.display_tiles_and_tokens(culling_trigger);
                    culling_trigger = false;


                }

                else if (command_state.getChoice() == 2){    // this is for the player to end their turn without placing a tile and token
                    next_player_turn(command_state);

                }



                else if (command_state.getChoice() == 3){   // this is for the board menu

                    do {
                        if(nature_option_menu == false){
                            display_board_tiles_tokens(playerNum, 2, command_state, culling_trigger); // won't display the habitat menu if player already chose something from the nature token menu and skips straight to selecting a habitat tile
                        }


                        if(command_state.getChoice() == 1){  // this is for the habitat board menu

                            do{
                                display_board_tiles_tokens(playerNum, 3, command_state, culling_trigger);    // choose habitat to place down



                                if(command_state.getChoice() == 1 || command_state.getChoice() == 2 || command_state.getChoice() == 3 || command_state.getChoice() == 4){


                                    if(Habitat_Tiles.biome.get(command_state.getChoice() - 1).length() == 1) { // checks if the biome is a keystone
                                        check_keystone = true;

                                    }
                                    place_tile = command_state.getChoice() - 1; // sets the tile to be placed


                                    do{
                                        boolean proper_input = true;

                                        if(check_keystone == false){

                                            Display_And_Input.getPlayers().get(playerNum).print_board(Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum)); //prints board
                                            Display_And_Input.display_tiles_and_tokens(culling_trigger);

                                            Display_And_Input.display_tile_rotation(place_tile);
                                            command_state = Command_State.get_input(4);

                                            //selects the rotation of the tile
                                            if(Command_State.getHabitat_tile_choice() == 0 && (command_state.getChoice() == 1 || command_state.getChoice() == 2 || command_state.getChoice() == 3 || command_state.getChoice() == 4 || command_state.getChoice() == 5 || command_state.getChoice() == 6 || command_state.getChoice() == 7 )) {

                                                Display_And_Input.getPlayers().get(playerNum).print_board(Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum));
                                                Display_And_Input.place_tile(place_tile, command_state.getChoice()-1, Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum));
                                                proper_input = false;
                                            }

                                        }

                                        else{
                                            Display_And_Input.getPlayers().get(playerNum).print_board(Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum));

                                            Display_And_Input.place_tile(place_tile, 0, Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum));
                                            proper_input = false;
                                        }

                                        if (proper_input == false) {
                                            do {
                                                Display_And_Input.remove_tile(place_tile);

                                                if(nature_option_menu == true){



                                                    do{
                                                        display_board_tiles_tokens(playerNum, 7, command_state, culling_trigger);

                                                        if(command_state.getChoice() == 1 || command_state.getChoice() == 2 || command_state.getChoice() == 3 || command_state.getChoice() == 4){

                                                            place_tile = command_state.getChoice() - 1;

                                                            if(Board.availableTokenPlacement(Wildlife_Tokens.tokens.get(place_tile), Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum))){
                                                                Display_And_Input.display_token(place_tile);
                                                                Board.place_animal_token(Wildlife_Tokens.tokens.get(place_tile), Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum));
                                                                Display_And_Input.remove_token(place_tile);

                                                            }
                                                            else{
                                                                System.out.println("You can't place that token as there is no available tiles for it");
                                                            }

                                                            next_player_turn(command_state);

                                                        }


                                                    }while(command_state.isInAnyTokenMenu());

                                                }

                                                else{ // if the player did not choose to place a nature token down, then the player will be prompted to place a token down
                                                    if(Board.availableTokenPlacement(Wildlife_Tokens.tokens.get(place_tile), Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum))){
                                                        display_board_tiles_tokens(playerNum, 5, command_state, culling_trigger);  // token menu to place down

                                                        if (command_state.getChoice() == 1) {
                                                            Display_And_Input.display_token(place_tile);
                                                            Board.place_animal_token(Wildlife_Tokens.tokens.get(place_tile), Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum));
                                                            Display_And_Input.remove_token(place_tile);
                                                        }

                                                        Display_And_Input.getPlayers().get(playerNum).print_board(Display_And_Input.getPlayers().get(playerNum).getBoard(), Display_And_Input.getPlayers().get(playerNum));
                                                        Display_And_Input.display_tiles_and_tokens(culling_trigger);
                                                    }
                                                    else{
                                                        System.out.println("You can't place that token as there is no available tiles for it");

                                                    }


                                                    // next player turn

                                                    next_player_turn(command_state);

                                                }



                                            } while (command_state.isInTokenMenu());
                                        }

                                    }while (command_state.isInHabitatRotationMenu());
                                }

                            }while (command_state.isInHabitatBoardMenu());

                        }

                        else if (command_state.getChoice() == 2){ // nature token menu


                            do{
                                //Display_And_Input.getPlayers().get(playerNum).setNature_tokens(1);

                                if(Display_And_Input.getPlayers().get(playerNum).getNature_tokens() == 0){
                                    System.out.println("You have no nature tokens!");
                                    command_state.setState_type_habitat_menu();
                                }
                                else{
                                    display_board_tiles_tokens(playerNum, 6, command_state, culling_trigger);  // nature token menu to place down

                                    if(command_state.getChoice() == 1) {
                                        command_state.setChoice(1);// nature token menu to place down
                                        Display_And_Input.getPlayers().get(playerNum).setNature_tokens(Display_And_Input.getPlayers().get(playerNum).getNature_tokens() - 1);
                                        nature_option_menu = true;
                                    }

                                    else if(command_state.getChoice() == 2){
                                        Display_And_Input.getPlayers().get(playerNum).setNature_tokens(Display_And_Input.getPlayers().get(playerNum).getNature_tokens() - 1);

                                        do{
                                            command_state = Command_State.get_input(8); // nature token option 2 for selecting any number of tokens to remove

                                            if(command_state.getChoice() == 1 || command_state.getChoice() == 2 || command_state.getChoice() == 3 || command_state.getChoice() == 4){
                                                Display_And_Input.nature_token_any_number(command_state.getChoice());
                                            }

                                        }while(command_state.isInAnyNumberTokenMenu());

                                        next_player_turn(command_state);

                                    }
                                }

                            }while(command_state.isInNatureTokenMenu());
                        }

                    }while (!command_state.isInMainMenu());
                }
            }

        }while (!command_state.isQuit());

        Command_State.quitMessage();
    }


    public static void display_board_tiles_tokens(int player_number, int menu_number, Command_State command_state, boolean culling_t){
        Display_And_Input.getPlayers().get(player_number).print_board(Display_And_Input.getPlayers().get(player_number).getBoard(), Display_And_Input.getPlayers().get(player_number));
        Display_And_Input.display_tiles_and_tokens(culling_t);
        command_state = Command_State.get_input(menu_number);

        culling_trigger = false;
    }

    public static void next_player_turn(Command_State command_state){
        Display_And_Input.getPlayers().get(playerNum).setPlayerTurn();  //increments turn by 1 each time this is called

        if (Display_And_Input.getPlayers().get(playerNum).getPlayerTurn() < 2) {
            if (playerNum == Display_And_Input.getPlayer_count() - 1) {    //resets to the start of the player list
                playerNum = 0;
            } else {
                playerNum++;
            }
            System.out.println("\n\n" + Display_And_Input.getPlayers().get(playerNum).getPlayer_name() + " is up!");
            culling_trigger = true;

        } else {

            Display_And_Input.getPlayers_score_calculation().add(Display_And_Input.getPlayers().get(playerNum));  // adds player to the list of players who have finished their turns

            Display_And_Input.getPlayers().remove(Display_And_Input.getPlayers().get(playerNum)); // removes player from the list of players who have not finished their turns

            Display_And_Input.setPlayer_count(Display_And_Input.getPlayer_count()); // decrements the player count by 1

            if (Display_And_Input.getPlayers().size() == 0) {
                System.out.println("You have no more turns left, calculating score for everyone...\n\n");
                WildLife_Scoring_Setup.print_scoring_card(player_scoring_card);
                for(int i = 0; i < Display_And_Input.getPlayers_score_calculation().size(); i++){

                    Scoring_Setup.scoring_setup(  Display_And_Input.getPlayers_score_calculation().get(i).getBoard(), // scoring setup
                            Display_And_Input.getPlayers_score_calculation().get(i).getOdd(),
                            Display_And_Input.getPlayers_score_calculation().get(i).getMax_col(),
                            Display_And_Input.getPlayers_score_calculation().get(i).getMax_row(),
                            player_scoring_card,
                            Display_And_Input.getPlayers_score_calculation().get(i).getPlayer_name(),
                            Display_And_Input.getPlayers_score_calculation().get(i).getNature_tokens());

                }

                command_state.setToQuit();

            } else {
                System.out.println("You have no more turns left, calculating score once everyone is done...");
                culling_trigger = true;
            }
        }
    }





}

