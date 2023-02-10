import java.util.Locale;
import java.util.Scanner;

public class Command_State {


    // Choice used for main Cascadia function for different menu options
    private int choice;
    public Command_State(int input){

        if (input == 1){
            state_type = state.PLAY;
            this.choice = 1;
        }
        else if (input == 2){
            state_type = state.PLAY;
            this.choice = 2;
        }
        else if (input == 3){
            state_type = state.QUIT;
        }

    }

    private static state state_type;           // Initiliases the enum for state of the game

    public static Command_State get_Input(){
        Scanner in = new Scanner(System.in);
        boolean check = false;
        Command_State commandState = null;

        while(!check){
            System.out.println("\n\nEnter a command from the menu (1, 2 or 3) ");
            System.out.println("1) Show starter habitat, habitats and tokens");
            System.out.println("2) Next player habitat");
            System.out.println("3) Quit");

            String user_input = in.nextLine();

            if(isValid(user_input)){                                        //checks for valid user input and then goes through the options by calling the commandState for the type fo state
                if (user_input.equals("1")){
                    commandState = new Command_State(1);
                    check = true;
                }
                else if(user_input.equals("2")){
                    commandState = new Command_State(2);
                    check = true;
                }
                else{
                    commandState = new Command_State(3);
                    check = true;
                }

            }
            else{
                System.out.println("Please enter 1, 2 or 3.");

            }
        }

        return commandState;




    }


    private enum state {                    // states for game which can be added to later
        PLAY,
        QUIT
    }


    public static boolean isValid(String input){
        return input.equals("1") || input.equals("2") || input.equals("3");
    }

    public boolean isQuit(){
        return state_type == state.QUIT;
    }

    public boolean isInPlay() {
        return state_type == state.PLAY;
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
