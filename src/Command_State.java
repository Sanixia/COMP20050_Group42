import java.util.Locale;
import java.util.Scanner;

public class Command_State {


    // Choice used for main Cascadia function for different menu options
    private static int choice;
    public Command_State(int inputMainMenu, int inputBoardMenu, int mainMenuInput, int boardMenuInput){

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
                choice = 4;
            }
            else if(boardMenuInput == 2){
                state_type = state.BOARD_MENU;
                choice = 5;
            }
            else{
                state_type = state.MAIN_MENU;
                choice = 1;
            }
        }


    }

    private static state state_type;           // Initializes the enum for state of the game

    public static Command_State get_Input(){
        Scanner in = new Scanner(System.in);
        boolean check = false;

        Command_State commandState = null;

        if(choice == 3){
            while(!check){
                System.out.println("\n\nEnter a command from the menu (1, 2, or 3) ");
                System.out.println("1) Select a habitat tile to be placed on the board");
                System.out.println("2) Select a token to be placed on the board");
                System.out.println("3) Back to main menu");

                String user_input_2 = in.nextLine();

                if(isValid(user_input_2)){
                    if (user_input_2.equals("1")){
                        commandState = new Command_State(0, 1, 0, 1);
                        check = true;
                    }
                    else if(user_input_2.equals("2")){
                        commandState = new Command_State(0, 1, 0, 2);
                        check = true;
                    }
                    else{
                        commandState = new Command_State(0, 1, 0, 3);
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
                System.out.println("\n\nEnter a command from the menu (1, 2, 3 or 4) ");
                System.out.println("1) Show current player's starter habitat tile, habitat tiles and tokens");
                System.out.println("2) Next player's turn");
                System.out.println("3) Show board");
                System.out.println("4) Quit");

                String user_input = in.nextLine();

                if(isValid(user_input)){                                        //checks for valid user input and then goes through the options by calling the commandState for the type of state
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




    private enum state {                    // states for game which can be added to later
        MAIN_MENU,
        BOARD_MENU,
        QUIT
    }


    public static boolean isValid(String input){
        return input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4");
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

    public static void quitMessage(){
        System.out.println("\nYou have quit the game.");
    }


    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }






}
