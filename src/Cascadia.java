
public class Cascadia extends Display_And_Input{

    /**
     * This is the main class for the Cascadia game
     * It will run the game and call all the other classes
     * Use Command_State to get the input from the user and set the state of the game with ease using do while loops
     * You can select 1 player for quickly checking how the game works
     */




    private static int playerNum = 0;
    private static boolean culling_trigger = true;

    private static int[] player_scoring_card = new int[5];

    private static int player_turns_over = 0;

    private static Command_State command_state;

    public static void main(String[] args)
    {


        welcome();
        num_players();
        player_names();
        randomised_order_players();
        WildLife_Scoring_Setup.scoring_card_array(player_scoring_card);
        WildLife_Scoring_Setup.print_scoring_card(player_scoring_card);

        boolean randomCheck = true;                     // check for one randomisation of tiles



        do{



            command_state = Command_State.get_input(1);   // Setting the command state


            if (randomCheck){
                randomise_player_tiles_and_tokens();          // Has to do the randomization once else it will cause errors

                for(int i = 0; i < getPlayer_count(); i++){
                    getPlayers().get(i).setup_board(getPlayers().get(i).getStarter_tile(),getPlayers().get(i).getBoard(),   getPlayers().get(i));   //sets up board with starter tile from player
                }
                randomCheck = false;
            }


            if (command_state.isInPlay()){ // this is for the main game so it loops to not quit unless option 4 or players turns have all been ended
                boolean check_keystone = false;
                boolean nature_option_menu = false;

                int place_tile = -1;





                if (command_state.getChoice() == 1){  // this is to check what the current player's board, habitat tiles and tokens are


                    System.out.println("--- " + getPlayers().get(playerNum).getPlayer_name()+ "'s  Board --- \n");

                    getPlayers().get(playerNum).print_board(getPlayers().get(playerNum).getBoard(), getPlayers().get(playerNum));

                    display_tiles_and_tokens(culling_trigger);
                    culling_trigger = false;


                }

                else if (command_state.getChoice() == 2){    // this is for the player to end their turn without placing a tile and token
                    next_player_turn();

                }



                else if (command_state.getChoice() == 3){   // this is for the board menu



                    do {

                        if(player_turns_over == getPlayer_count()){
                            System.out.println("All players have ended their turns");
                            break;
                        }



                        if(!nature_option_menu){
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

                                        if(!check_keystone){ // if the tile is not a keystone

                                            getPlayers().get(playerNum).print_board(getPlayers().get(playerNum).getBoard(), getPlayers().get(playerNum)); //prints board
                                            display_tiles_and_tokens(culling_trigger);

                                            display_tile_rotation(place_tile);
                                            command_state = Command_State.get_input(4);

                                            //selects the rotation of the tile
                                            if(Command_State.getHabitat_tile_choice() == 0 && (command_state.getChoice() == 1 || command_state.getChoice() == 2 || command_state.getChoice() == 3 || command_state.getChoice() == 4 || command_state.getChoice() == 5 || command_state.getChoice() == 6 || command_state.getChoice() == 7 )) {

                                                getPlayers().get(playerNum).print_board(getPlayers().get(playerNum).getBoard(), getPlayers().get(playerNum));
                                                place_tile(place_tile, command_state.getChoice()-1, getPlayers().get(playerNum).getBoard(), getPlayers().get(playerNum));
                                                proper_input = false;
                                            }

                                        }

                                        else{ // if the tile is a keystone

                                            getPlayers().get(playerNum).print_board(getPlayers().get(playerNum).getBoard(), getPlayers().get(playerNum));
                                            place_tile(place_tile, 0, getPlayers().get(playerNum).getBoard(), getPlayers().get(playerNum));
                                            proper_input = false;
                                        }

                                        if (!proper_input) {
                                            do {

                                                if(player_turns_over == getPlayer_count()){
                                                    System.out.println("All players have ended their turns");
                                                    break;
                                                }

                                                remove_tile(place_tile);

                                                if(nature_option_menu){

                                                    do{
                                                        display_board_tiles_tokens(playerNum, 7, command_state, culling_trigger);

                                                        if(command_state.getChoice() == 1 || command_state.getChoice() == 2 || command_state.getChoice() == 3 || command_state.getChoice() == 4){

                                                            place_tile = command_state.getChoice() - 1;

                                                            if(Board.availableTokenPlacement(Wildlife_Tokens.tokens.get(place_tile), getPlayers().get(playerNum).getBoard(), getPlayers().get(playerNum))){
                                                                display_token(place_tile);
                                                                Board.place_animal_token(Wildlife_Tokens.tokens.get(place_tile), getPlayers().get(playerNum).getBoard(), getPlayers().get(playerNum));
                                                                remove_token(place_tile);


                                                                next_player_turn();

                                                            }
                                                            else{
                                                                System.out.println("You can't place that token as there is no available tiles for it");

                                                                next_player_turn();


                                                            }



                                                        }


                                                    }while(command_state.isInAnyTokenMenu());

                                                }

                                                else{ // if the player did not choose to place a nature token down, then the player will be prompted to place a token down
                                                    if(Board.availableTokenPlacement(Wildlife_Tokens.tokens.get(place_tile), getPlayers().get(playerNum).getBoard(), getPlayers().get(playerNum))){
                                                        display_board_tiles_tokens(playerNum, 5, command_state, culling_trigger);  // token menu to place down

                                                        if (command_state.getChoice() == 1) {
                                                            display_token(place_tile);
                                                            Board.place_animal_token(Wildlife_Tokens.tokens.get(place_tile), getPlayers().get(playerNum).getBoard(), getPlayers().get(playerNum));
                                                            remove_token(place_tile);
                                                        }

                                                        getPlayers().get(playerNum).print_board(getPlayers().get(playerNum).getBoard(), getPlayers().get(playerNum));
                                                        display_tiles_and_tokens(culling_trigger);
                                                        next_player_turn();
                                                    }
                                                    else{
                                                        System.out.println("You can't place down that animal token as there is no available tiles for it!");

                                                        next_player_turn();

                                                    }
                                                }



                                            } while (command_state.isInTokenMenu());
                                        }

                                    }while (command_state.isInHabitatRotationMenu());
                                }

                            }while (command_state.isInHabitatBoardMenu());

                        }

                        else if (command_state.getChoice() == 2){ // nature token menu


                            do{

                                if(player_turns_over == getPlayer_count()){
                                    System.out.println("All players have ended their turns");
                                    break;
                                }


                                if(getPlayers().get(playerNum).getNature_tokens() == 0){
                                    System.out.println("You have no nature tokens!");
                                    command_state.setState_type_habitat_menu();
                                }
                                else{
                                    display_board_tiles_tokens(playerNum, 6, command_state, culling_trigger);  // nature token menu to place down

                                    if(command_state.getChoice() == 1) {
                                        command_state.setChoice(1);// nature token menu to place down
                                        getPlayers().get(playerNum).setNature_tokens(getPlayers().get(playerNum).getNature_tokens() - 1);
                                        nature_option_menu = true;
                                    }

                                    else if(command_state.getChoice() == 2){
                                        getPlayers().get(playerNum).setNature_tokens(getPlayers().get(playerNum).getNature_tokens() - 1);

                                        do{

                                            if(player_turns_over == getPlayer_count()){
                                                System.out.println("All players have ended their turns");
                                                break;
                                            }

                                            command_state = Command_State.get_input(8); // nature token option 2 for selecting any number of tokens to remove

                                            if(command_state.getChoice() == 1 || command_state.getChoice() == 2 || command_state.getChoice() == 3 || command_state.getChoice() == 4){
                                                nature_token_any_number(command_state.getChoice());
                                            }

                                        }while(command_state.isInAnyNumberTokenMenu());

                                        next_player_turn();

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
        getPlayers().get(player_number).print_board(getPlayers().get(player_number).getBoard(), getPlayers().get(player_number));
        display_tiles_and_tokens(culling_t);
        command_state = Command_State.get_input(menu_number);

        culling_trigger = false;
    }

    public static void next_player_turn(){
        getPlayers().get(playerNum).setPlayerTurn();  //increments turn by 1 each time this is called

        if (getPlayers().get(playerNum).getPlayerTurn() < 20) {
            if (playerNum == getPlayer_count() - 1) {    //resets to the start of the player list
                playerNum = 0;
            } else {
                playerNum++;
            }
            System.out.println("\n\n" + getPlayers().get(playerNum).getPlayer_name() + " is up!");
            culling_trigger = true;

            Command_State.setToMainMenu(command_state);
        }
        else {

            player_turns_over++;

            if (getPlayers().size() == player_turns_over) {
                System.out.println("You have no more turns left, calculating score for everyone...\n\n");
                WildLife_Scoring_Setup.print_scoring_card(player_scoring_card);
                for(int i = 0; i < getPlayers().size(); i++){

                    Scoring_Setup.scoring_setup(  getPlayers().get(i).getBoard(), // scoring setup
                            getPlayers().get(i).getOdd(),
                            getPlayers().get(i).getMax_col(),
                            getPlayers().get(i).getMax_row(),
                            player_scoring_card,
                            getPlayers().get(i).getPlayer_name(),
                            getPlayers().get(i).getNature_tokens());

                }

               Command_State.setToQuit(command_state);

            }
            else {
                System.out.println("You have no more turns left, calculating score once everyone is done...");
                if (playerNum == getPlayer_count() - 1) {    //resets to the start of the player list
                    playerNum = 0;
                } else {
                    playerNum++;
                }
                System.out.println("\n\n" + getPlayers().get(playerNum).getPlayer_name() + " is up!");
                culling_trigger = true;
            }
        }


    }





}

