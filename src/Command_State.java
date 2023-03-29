
import java.util.Scanner;

public class Command_State {


    // Choice used for main Cascadia function for different menu options
    private static int choice;




    private static int habitat_tile_choice = 0;
    /*public Command_State(int inputMainMenu, int inputBoardMenu, int mainMenuInput, int boardMenuInput){

        if(inputMainMenu == 1){
            if (mainMenuInput == 1){
                state_type = state.MAIN_MENU;
                choice = 1;
            }
            else if (mainMenuInput == 2){
                state_type = state.MAIN_MENU;
                choice = 2;
            }
            else if(mainMenuInput == 3){
                state_type = state.BOARD_MENU;
                choice = 3;
            }
            else if (mainMenuInput == 4){
                state_type = state.QUIT;
            }
        }


        else if(inputBoardMenu == 1){

            if(boardMenuInput == 1){
                state_type = state.BOARD_MENU;
                choice = 3;
            }
            else if(boardMenuInput == 2){
                state_type = state.MAIN_MENU;
                choice = 1;
            }

        }


    }

     */

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
                state_type = state.MAIN_MENU;
                choice = 0;
            }
            else{
                state_type = state.HABITAT_MENU;
                choice = 0;
            }

        }

        else if(inputMenu == 3){ //
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


    }

    private static state state_type;           // Initializes the enum for state of the game

    /*public static Command_State get_Input(){
        Scanner in = new Scanner(System.in);
        boolean check = false;

        Command_State commandState = null;

        if(choice == 3){

            while(!check){
                board_menu();
                String user_input_2 = in.nextLine();

                if(isValid(user_input_2, 2)){
                    if (user_input_2.equals("1")){
                        commandState = new Command_State(0, 1, 0, 1);
                        check = true;
                    }
                    else if(user_input_2.equals("2")){
                        commandState = new Command_State(0, 1, 0, 2);
                        check = true;
                    }
                }

                else{
                    System.out.println("Please enter 1, 2 or 3.");
                }

            }

        }




        else{
            while(!check){
                main_menu();
                String user_input = in.nextLine();

                if(isValid(user_input, 1)){                                        //checks for valid user input and then goes through the options by calling the commandState for the type of state
                    if (user_input.equals("1")){
                        commandState = new Command_State(1, 0, 1, 0);
                        check = true;
                    }
                    else if(user_input.equals("2")){
                        commandState = new Command_State(1, 0, 2, 0);
                        check = true;
                    }
                    else if(user_input.equals("3")){


                        commandState = new Command_State(1, 0, 3, 1);
                        check = true;
                    }


                    else{
                        commandState = new Command_State(1, 0, 4, 0);
                        check = true;
                    }

                }
                else{
                    System.out.println("Please enter 1, 2, 3 or 4.");

                }
            }
        }


        return commandState;




    }

     */


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

                if (isValid(user_input, 2)) {

                    int_input = Integer.parseInt(user_input);
                    commandState = new Command_State(2, int_input);
                    check = true;

                } else {
                    System.out.println("Please enter 1 or 2.");
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

        else if(type_of_menu == 5){
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


























        return commandState;




    }

    public static void board_menu(){
        System.out.println("\n\nEnter a command from the menu (1 or 2) ");
        System.out.println("1) Select a habitat tile to be placed on the board");
        System.out.print("2) Back to main menu\n-> ");
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
        System.out.println("\n\nDo you want to place down the token from the habitat tile you selected (1 for yes or 2 for no)");
        System.out.print("-> ");
    }

    public static void main_menu(){
        System.out.println("\n\nEnter a command from the menu (1, 2, 3 or 4) ");
        System.out.println("1) Show current player's board, habitat tiles and tokens");
        System.out.println("2) Next player's turn");
        System.out.println("3) Show board + options for player");
        System.out.print("4) Quit\n-> ");
    }



    private enum state {                    // states for game which can be added to later
        MAIN_MENU,
        BOARD_MENU,

        HABITAT_MENU,

        HABITAT_ROTATION,

        TOKEN_MENU,
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






}
