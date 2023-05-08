import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Culling {

    public static void callTheCulling(boolean bot_player){                                 // Calls the culling method

        String culling = "";
        int numForCulling, j;
        int cullingChoice = 0, continueOption = 0;

        culling = getCulling(culling);

        numForCulling = cullingCheck(culling);

        while(numForCulling != 5){


            switch(numForCulling){
                case 4:
                    System.out.println("Culling initiated as there has been 4 tokens that are the same, replacing tokens!");
                    culling = "";

                    for (j = 0; j < 4; j++){
                        Display_And_Input.remove_token(j);
                    }
                    culling = getCulling(culling);
                    break;


                case 3:

                    cullingChoice = getCullingChoice(cullingChoice, bot_player);
                    if(cullingChoice == 1){
                        culling = "";
                        for(j = 0; j < 3; j++){
                            Display_And_Input.remove_token(j);
                        }
                        culling = getCulling(culling);
                    }
                    else{
                        continueOption = 1;
                        culling = getCulling(culling);
                    }

                    break;

                case 2:

                    cullingChoice = getCullingChoice(cullingChoice, bot_player);
                    if(cullingChoice == 1){
                        culling = "";
                        for(j=0; j < 2; j++){
                            Display_And_Input.remove_token(j);
                        }
                        Display_And_Input.remove_token(3);
                        culling = getCulling(culling);
                    }
                    else{
                        continueOption = 1;
                        culling = getCulling(culling);
                    }
                    break;

                case 1:

                    cullingChoice = getCullingChoice(cullingChoice, bot_player);
                    if(cullingChoice == 1){
                        culling = "";

                        for(j = 2; j < 4; j++){
                            Display_And_Input.remove_token(j);
                        }
                        Display_And_Input.remove_token(0);
                        culling = getCulling(culling);
                    }
                    else{
                        continueOption = 1;
                        culling = getCulling(culling);
                    }
                    break;

                case 0:

                    cullingChoice = getCullingChoice(cullingChoice, bot_player);
                    if(cullingChoice == 1){
                        culling = "";
                        for(j = 1; j < 4; j++){
                            Display_And_Input.remove_token(j);
                        }
                        culling = getCulling(culling);
                    }
                    else{
                        continueOption = 1;
                        culling = getCulling(culling);
                    }
                    break;

            }


            Display_And_Input.printTokens();

            if (continueOption == 1) {
                numForCulling = 5;
            }
            else{
                numForCulling = cullingCheck(culling);
            }




        }
    }

    public static int getCullingChoice(int cullingChoice, boolean bot_player){

        Scanner in = new Scanner(System.in);

        if(bot_player){
            long seed = System.nanoTime();
            Random random = new Random(seed);

            cullingChoice = random.nextInt(2) + 1;
            return cullingChoice;
        }

        System.out.println("Optional culling identified as 3 tiles are the same, would you like to get rid of the 3 or continue?");
        System.out.print("Please enter 1 for yes or 2 to continue (1/2): ");

        boolean validInput = false;

        do{
            try{

                cullingChoice = in.nextInt();
                if (cullingChoice == 1 || cullingChoice == 2){

                    validInput = true;
                }

                else{
                    System.out.print("Please enter a number that is either 1 for yes or 2 to continue: ");
                }

            }

            catch (InputMismatchException ex) {
                System.out.print("Please enter a valid number (1 for yes and 2 to continue): ");
                in.nextLine();
            }
        }
        while (!validInput);

        return cullingChoice;

    }


    public static String getCulling(String culling){
        int i;

        for (i = 0; i < 4; i++){
            culling = culling + Wildlife_Tokens.tokens.get(i);
        }
        return culling;
    }


    //have to determine which token is the one being left over for the culling in the 3 case
    public static int cullingCheck(String cullingWord){
        char firstLetter = cullingWord.charAt(0);
        char secondLetter = cullingWord.charAt(1);
        char thirdLetter = cullingWord.charAt(2);
        char fourthLetter = cullingWord.charAt(3);




        boolean firstThreeSame = firstLetter == secondLetter && secondLetter == thirdLetter ;
        boolean lastThreeSame = secondLetter == thirdLetter && thirdLetter == fourthLetter;
        boolean firstAndLastTwoSame = firstLetter == thirdLetter && thirdLetter == fourthLetter;
        boolean firstTwoAndLastSame = firstLetter == secondLetter && secondLetter == fourthLetter;
        boolean allSame = firstLetter == secondLetter && secondLetter == thirdLetter && thirdLetter == fourthLetter;

        if (allSame){
            return 4;
        }
        else if(firstThreeSame){
            return 3;
        }
        else if(firstTwoAndLastSame){
            return 2;
        }
        else if(firstAndLastTwoSame){
            return 1;
        }
        else if(lastThreeSame){
            return 0;
        }

        else{
            return 5;
        }

    }

}
