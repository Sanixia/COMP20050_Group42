// Group 42
// Roshan, Michal
// Sanixia, glucoseIntolerant

import java.util.Random;
import java.util.Scanner;


public class Command_State {

    /**
     * This class is used to determine the state of the game
     */




    // Choice used for main Cascadia function for different menu options
    private static int choice;
    static Command_State commandState = new Command_State(0,0);

    private static int habitat_choice_bot;
    private static int habitat_tile_choice = 0;


    public Command_State(int inputMenu, int menuInput){

        if(inputMenu == 1){ // main menu
            if (menuInput == 1 || menuInput == 2){
                state_type = state.MAIN_MENU;
                choice = menuInput;
            }
            else if(menuInput == 3){
                state_type = state.BOARD_MENU;
                choice = menuInput;
            }
            else if (menuInput == 4){
                state_type = state.QUIT;
            }
            else{
                state_type = state.MAIN_MENU;
                choice = 0;
            }
        }


        else if(inputMenu == 2){ // board menu

            if(menuInput == 1){
                state_type = state.HABITAT_MENU;
                choice = 1;
            }
            else if(menuInput == 2){
                state_type = state.NATURE_TOKEN_MENU;
                choice = 2;
            }
            else if(menuInput == 3){
                state_type = state.MAIN_MENU;
                choice = 3;
            }
            else{
                state_type = state.HABITAT_MENU;
                choice = 0;
            }

        }

        else if(inputMenu == 3){ // habitat menu
            if(menuInput == 1 || menuInput == 2 || menuInput == 3 || menuInput == 4){
                state_type = state.HABITAT_MENU;
                choice = menuInput;
                setHabitat_tile_choice(menuInput);
            }
            else{
                state_type = state.HABITAT_MENU;
                choice = 0;
            }

        }

        else if(inputMenu == 4){ // habitat rotation menu
            if(menuInput >= 1 && menuInput <= 6){
                state_type = state.TOKEN_MENU;
                choice = menuInput;
                setHabitat_tile_choice(0);
            }
            else{
                state_type = state.HABITAT_ROTATION;
                choice = habitat_tile_choice;
            }
        }

        else if (inputMenu == 5){ // token menu
            if(menuInput == 1){
                state_type = state.MAIN_MENU;
                choice = menuInput;
            }
            else if(menuInput == 2){
                state_type = state.MAIN_MENU;
                choice = menuInput;
            }
            else{
                state_type = state.TOKEN_MENU;
                choice = 0;
            }
        }

        else if(inputMenu == 6){ // nature token menu
            if(menuInput == 1 || menuInput == 2){
                state_type = state.HABITAT_MENU;
                choice = menuInput;
            }
            else if(menuInput == 3){
                state_type = state.HABITAT_MENU;
                choice = 0;
            }
            else{
                state_type = state.NATURE_TOKEN_MENU;
                choice = 0;
            }
        }

        else if(inputMenu == 7){ // any token menu
            if(menuInput == 1 || menuInput == 2 || menuInput == 3 || menuInput == 4){
                state_type = state.MAIN_MENU;
                choice = menuInput;
            }
            else{
                state_type = state.ANY_TOKEN;
                choice = 0;
            }
        }

        else if(inputMenu == 8){ // any number of tokens menu
            if(menuInput == 1 || menuInput == 2 || menuInput == 3 || menuInput == 4){
                state_type = state.MAIN_MENU;
                choice = menuInput;
            }
            else{
                state_type = state.ANY_NUMBER_TOKENS;
                choice = 0;
            }
        }


    }



    private static state state_type;           // Initializes the enum for state of the game



    public static Command_State get_input(int type_of_menu, boolean bot_players, Player_Tracker current_player) {

        menu_type(type_of_menu, commandState, bot_players, current_player);
        return commandState;
    }



    public static Command_State menu_type(int type_of_menu, Command_State commandState, boolean bot_players, Player_Tracker current_player){
        Scanner in = new Scanner(System.in);
        int int_input;
        String user_input = "";
        int bot_input = 0;
        int menu_type = 0;
        String menu_type_string = "";
        long seed = System.nanoTime();
        Random random = new Random(seed);

        switch(type_of_menu){
                case 0:
                    main_menu();
                    menu_type_string = "Please enter 1, 2, 3 or 4.";
                    break;
                case 1:
                    main_menu();
                    menu_type = 1;
                    menu_type_string = "Please enter 1, 2, 3 or 4.";
                    if(bot_players){
                        bot_input = 3;
                        break;
                    }
                    break;
                case 2:
                    board_menu();
                    menu_type = 4;
                    menu_type_string = "Please enter 1, 2 or 3.";
                    if(bot_players){
                        bot_input = 1;
                        break;
                    }
                    break;
                case 3:
                    habitat_menu();
                    menu_type = 1;
                    menu_type_string = "Please enter 1, 2, 3 or 4.";
                    if(bot_players){


                        // bot_input = random.nextInt(4) + 1;  previously a random input bot

                        bot_input = Habitat_Tile_Placement.get_optimal_habitat_placement(current_player) + 1;
                        setHabitat_choice_bot(bot_input);
                        break;
                    }
                    break;
                case 4:
                    habitat_rotation();
                    menu_type = 3;
                    menu_type_string = "Please enter 1, 2, 3, 4, 5 or 6.";
                    if(bot_players){
                        //bot_input = random.nextInt(6) + 1;

                        bot_input = Habitat_Tile_Placement.getBest_rotation() + 1; // as it goes from 0-5 for rotation, need to add 1
                        break;
                    }
                    break;
                case 5:
                    token_menu();
                    menu_type = 2;
                    menu_type_string = "Please enter 1 or 2.";
                    if(bot_players){
                         //bot_input = 1; //Previously random input bot always selected a token
                        int[] check_for_coordinates = new int[] {-1,-1};

                        check_for_coordinates = Animal_Token_Placement.optimal_token_placement(Wildlife_Tokens.tokens.get(getHabitat_choice_bot() - 1), current_player);

                        if(check_for_coordinates[0] != -1){ // if the coordinates are not -1, then the token can be placed
                            bot_input = 1;
                        }
                        else{
                            bot_input = 2;
                        }
                        break;
                    }
                    break;
                case 6:
                    nature_token_menu();
                    menu_type = 4;
                    menu_type_string = "Please enter 1, 2 or 3.";
                    break;
                case 7:
                    any_token();
                    menu_type = 1;
                    menu_type_string = "Please enter 1, 2, 3 or 4.";
                    break;
                case 8:
                    any_number_tokens();
                    menu_type = 1;
                    menu_type_string = "Please enter 1, 2, 3 or 4.";
                    break;
            }

            if(!bot_players){
                user_input = in.nextLine();
            }


            if (isValid(user_input, menu_type,bot_players)) {
                if(bot_players){
                    commandState = new Command_State(type_of_menu, bot_input);
                    return commandState;
                }

                int_input = Integer.parseInt(user_input);
                commandState = new Command_State(type_of_menu, int_input);

                return commandState;

            } else {
                System.out.println(menu_type_string);
                if(type_of_menu != 1) {
                    commandState = new Command_State(type_of_menu, 0);
                    return commandState;
                }
            }

        return commandState = new Command_State(type_of_menu, 0);
    }

    public static void board_menu(){
        System.out.println("\n\nEnter a command from the menu (1, 2 or 3) ");
        System.out.println("1) Select a habitat tile to be placed on the board");
        System.out.println("2) Nature Token Options");
        System.out.print("3) Back to main menu\n-> ");
    }

    public static void habitat_menu(){
        System.out.println("\n\nEnter which habitat tile you want to place down (1, 2, 3 or 4) ");
        System.out.print("-> ");
    }

    public static void habitat_rotation(){
        System.out.println("\n\nEnter which way you want to rotate the habitat tile (1, 2, 3, 4, 5 or 6)");
        System.out.print("-> ");
    }

    public static void token_menu(){
        System.out.println("\n\nDo you want to place down the token from the habitat tile you selected (1 for yes or 2 for no)?");
        System.out.print("-> ");
    }

    public static void main_menu(){
        System.out.println("\n\nEnter a command from the menu (1, 2, 3 or 4) ");
        System.out.println("1) Show current player's board, habitat tiles and tokens");
        System.out.println("2) Next player's turn");
        System.out.println("3) Show board + options for player");
        System.out.print("4) Quit\n-> ");
    }

    public static void nature_token_menu(){
        System.out.println("\n\nEnter a command from the menu (1, 2 or 3) ");
        System.out.println("1) Pick any habitat and token and place down");
        System.out.println("2) Pick ANY number of tokens to get rid of");
        System.out.println("3) Exit this menu");

    }

    public static void any_token(){
        System.out.println("\n\nWhich animal token do you want to place down (1, 2, 3 or 4)? ");
        System.out.print("-> ");
    }

    public static void any_number_tokens(){
        System.out.println("\n\nPlease enter the number of tokens you would like to replace (1,2,3 or 4) ");
        System.out.print("-> ");
    }




    private enum state {                    // states for game which can be added to later
        MAIN_MENU,
        BOARD_MENU,

        HABITAT_MENU,

        HABITAT_ROTATION,

        TOKEN_MENU,

        NATURE_TOKEN_MENU,

        ANY_TOKEN,

        ANY_NUMBER_TOKENS,

        SCORE,
        QUIT
    }


    public static boolean isValid(String input, int menu, boolean bot_players){
        if(bot_players){
            return true;
        }
        if(menu == 1){
            return input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4");
        }
        else if (menu == 2){
            return input.equals("1") || input.equals("2");
        }
        else if(menu == 3){
            return input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5") || input.equals("6");

        }
        else if(menu == 4){
            return input.equals("1") || input.equals("2") || input.equals("3");
        }
        return false;

    }

    public boolean isQuit(){
        return state_type == state.QUIT;
    }

    public boolean isInPlay() {
        return state_type != state.QUIT;
    }

    public boolean isInMainMenu(){
        return state_type == state.MAIN_MENU;
    }

    public boolean isInHabitatRotationMenu(){
        return state_type == state.HABITAT_ROTATION;
    }

    public boolean isInHabitatBoardMenu(){
        return state_type == state.HABITAT_MENU;
    }

    public boolean isInTokenMenu(){
        return state_type == state.TOKEN_MENU;
    }

    public boolean isInAnyTokenMenu(){
        return state_type == state.ANY_TOKEN;
    }

    public static void quitMessage(){
        System.out.println("\nGame ended! Thanks for playing!");
    }


    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public static int getHabitat_tile_choice() {
        return habitat_tile_choice;
    }

    public static void setHabitat_tile_choice(int habitat_tile_choice) {
        Command_State.habitat_tile_choice = habitat_tile_choice;
    }

    public static void setToMainMenu(Command_State command_state) {
        Command_State.state_type = state.MAIN_MENU;
    }

    public static void setToQuit(Command_State command_state) {
        Command_State.state_type = state.QUIT;
    }


    public void setState_type_habitat_menu(){
        Command_State.state_type = state.HABITAT_MENU;
    }

    public boolean isInNatureTokenMenu(){
        return state_type == state.NATURE_TOKEN_MENU;
    }

    public boolean isInAnyNumberTokenMenu(){
        return state_type == state.ANY_NUMBER_TOKENS;
    }

    public static int getHabitat_choice_bot() {
        return habitat_choice_bot;
    }

    public static void setHabitat_choice_bot(int habitat_choice_bot) {
        Command_State.habitat_choice_bot = habitat_choice_bot;
    }







}
