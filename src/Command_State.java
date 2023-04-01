
import java.util.Scanner;

public class Command_State {


    // Choice used for main Cascadia function for different menu options
    private static int choice;




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
            if(menuInput == 1 || menuInput == 2 || menuInput == 3 || menuInput == 4 || menuInput == 5 || menuInput == 6 || menuInput == 7){
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
                choice = 0;
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
            else{
                state_type = state.HABITAT_MENU;
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


    }



    private static state state_type;           // Initializes the enum for state of the game



    public static Command_State get_input2(int type_of_menu) {
        Scanner in = new Scanner(System.in);
        int int_input;
        boolean check = false;
        String user_input;

        Command_State commandState = null;


        if (type_of_menu == 1) {

            while (!check) {
                main_menu();
                user_input = in.nextLine();

                if (isValid(user_input, 1)) {

                    int_input = Integer.parseInt(user_input);
                    commandState = new Command_State(1, int_input);
                    check = true;

                } else {
                    System.out.println("Please enter 1, 2, 3 or 4.");
                }
            }



        } else if (type_of_menu == 2) {

            while (!check) {
                board_menu();
                user_input = in.nextLine();

                if (isValid(user_input, 4)) {

                    int_input = Integer.parseInt(user_input);
                    commandState = new Command_State(2, int_input);
                    check = true;

                } else {
                    System.out.println("Please enter 1, 2 or 3.");
                    commandState = new Command_State(2, 0);
                    check = true;
                }

            }


        } else if (type_of_menu == 3) {      // habitat select menu


            while (!check) {
                habitat_menu();
                user_input = in.nextLine();

                if (isValid(user_input, 1)) {
                    int_input = Integer.parseInt(user_input);

                    commandState = new Command_State(3, int_input);
                    check = true;

                }
                else{
                    System.out.println("Please enter 1, 2, 3 or 4.");
                    commandState = new Command_State(3, 0);
                    check = true;
                }


            }
        }
        else if (type_of_menu == 4) {      // habitat rotation menu

            while (!check) {
                habitat_rotation();
                user_input = in.nextLine();

                if (isValid(user_input, 3)) {
                    int_input = Integer.parseInt(user_input);

                    commandState = new Command_State(4, int_input);
                    check = true;

                }
                else{
                    System.out.println("Please enter 1, 2, 3, 4, 5 or 6");
                    commandState = new Command_State(4, 0);
                    check = true;
                }
            }

        }

        else if(type_of_menu == 5){ // token menu
            while (!check) {
                token_menu();
                user_input = in.nextLine();

                if (isValid(user_input, 2)) {
                    int_input = Integer.parseInt(user_input);

                    commandState = new Command_State(5, int_input);
                    check = true;

                }
                else{
                    System.out.println("Please enter 1 or 2.");
                    commandState = new Command_State(5, 0);
                    check = true;
                }
            }
        }

        else if(type_of_menu == 6){ // nature token menu
            while (!check) {
                nature_token_menu();
                user_input = in.nextLine();

                if (isValid(user_input, 4)) {
                    int_input = Integer.parseInt(user_input);

                    commandState = new Command_State(6, int_input);
                    check = true;

                }
                else{
                    System.out.println("Please enter 1, 2 or 3.");
                    commandState = new Command_State(6, 0);
                    check = true;
                }
            }
        }

        else if(type_of_menu == 7){  // picking any token selection
            while (!check) {
                any_token();
                user_input = in.nextLine();

                if (isValid(user_input, 4)) {
                    int_input = Integer.parseInt(user_input);

                    commandState = new Command_State(7, int_input);
                    check = true;

                }
                else{
                    System.out.println("Please enter 1, 2, 3 or 4.");
                    commandState = new Command_State(7, 0);
                    check = true;
                }
            }
        }


        return commandState;

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
        System.out.println("-> ");
    }



    private enum state {                    // states for game which can be added to later
        MAIN_MENU,
        BOARD_MENU,

        HABITAT_MENU,

        HABITAT_ROTATION,

        TOKEN_MENU,

        NATURE_TOKEN_MENU,

        ANY_TOKEN,

        SCORE,
        QUIT
    }


    public static boolean isValid(String input, int menu){
        if(menu == 1){
            return input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4");
        }
        else if (menu == 2){
            return input.equals("1") || input.equals("2");
        }
        else if(menu == 3){
            return input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5") || input.equals("6") || input.equals("7");

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
        System.out.println("\nYou have quit the game.");
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

    public void setState_type() {
        Command_State.state_type = state.QUIT;
    }
    public void setState_habitat_menu(){
        Command_State.state_type = state.HABITAT_MENU;
    }



    public void setState_type_habitat_menu(){
        Command_State.state_type = state.HABITAT_MENU;
    }

    public boolean isInNatureTokenMenu(){
        return state_type == state.NATURE_TOKEN_MENU;
    }







}
