import java.util.*;


public class Display_And_Input {



    private static ArrayList<Player_Tracker> players_score_calculation = new ArrayList<>();

    private static ArrayList<String> playerNames = new ArrayList<>();

    private static ArrayList<Player_Tracker> players = new ArrayList<>();   //Array of objects to keep track of players


    private static int player_count = 0;

    public static void setPlayer_count(int player_count) {
        Display_And_Input.player_count--;
    }

    public static int getPlayer_count() {
        return player_count;
    }

    public ArrayList<String> getPlayerNames() {
        return playerNames;
    }

    public static ArrayList<Player_Tracker> getPlayers() {
        return players;
    }

    public static ArrayList<Player_Tracker> getPlayers_score_calculation() {
        return players_score_calculation;
    }









    public static void welcome(){
        /* welcome message */
        /* ask how many players */

        System.out.println("Welcome to Cascadia!");
        System.out.print("How many people are playing? Please enter 2, 3 or 4: ");
    }




    public static void num_players() {


        Scanner in = new Scanner(System.in);
        
        boolean validNumOfPlayers = false;

        do{
            try{

                player_count = in.nextInt();
                if (player_count == 1 || player_count == 2 || player_count == 3 || player_count == 4 ){
                    validNumOfPlayers = true;
                }
                else{
                    System.out.print("Please enter a number that is either 2, 3 or 4: ");
                }

            }
            catch (InputMismatchException ex) {
                System.out.print("Please enter a valid number (2, 3 or 4): ");
                in.nextLine();
            }
        }
        while (!validNumOfPlayers);




    }




    public static void player_names(){
        Scanner in = new Scanner(System.in);
        String temp_name;
        int i;



        boolean checkValidName;


        for (i = 0; i < getPlayer_count(); i++){
            checkValidName = false;
            System.out.print("\nPlayer " + (i+1) + " please enter your name: ");


            while(!checkValidName){
                temp_name = in.next();

                if (playerNames.contains(temp_name)){
                    System.out.print("Please enter a name that isn't already taken: ");
                }
                else{
                    playerNames.add(temp_name);
                    checkValidName = true;
                }
            }
        }
    }




    public static void randomised_order_players(){                                  // Might get rid of, seems redundant
        int i;

        System.out.println("The order in which players will play will be: ");

        Collections.shuffle(playerNames);

        for (i = 0; i < player_count; i++){
            System.out.println((i+1) + ") " + playerNames.get(i));

        }

    }





    public static void randomise_player_tiles_and_tokens(){

        int i;


        long seed = System.nanoTime();                                          // To have the same randomised list order for animals and biome tiles
        Collections.shuffle(Starter_Habitat.getStarter_Habitat_Tiles());

        Collections.shuffle(Habitat_Tiles.biome, new Random(seed));
        Collections.shuffle(Habitat_Tiles.animals, new Random(seed));
        Collections.shuffle(Wildlife_Tokens.tokens);


        for (i = 0; i < player_count; i++){

            players.add(new Player_Tracker(playerNames.get(i), Starter_Habitat.getStarter_Habitat_Tiles().get(i), 0, 0, 0, 0,0, 0));

        }
    }


    public static void display_tiles_and_tokens(boolean culling_trigger){
        display_tiles();
        System.out.println("Corresponding Wildlife Tokens (1 next to a token represents the habitat that is also 1 for example): \n");

        printTokens();
        if(culling_trigger == true){
            callTheCulling();
        }

    }

    public static void display_tiles(){                                    // Displays the habitat tiles
        int max = 8;
        tile2D[] row = new tile2D[max];
        int i;
        System.out.println("\nHabitat Tiles: \n");

        for (i = 0; i < 4; i++){
            row[i*2] = new tile2D(Habitat_Tiles.biome.get(i),  Habitat_Tiles.animals.get(i), 1);
            row[1+i*2] = new tile2D("space", "", 1);
        }
        System.out.println(Ex2D.num_printer(4) + "\n" + Ex2D.row_printer(row, max, 0, " ")+"\n");
    }

    public static void callTheCulling(){                                 // Calls the culling method

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
                        remove_token(j);
                    }
                    culling = getCulling(culling);
                    break;


                case 3:

                    cullingChoice = getCullingChoice(cullingChoice);
                    if(cullingChoice == 1){
                        culling = "";
                        for(j = 0; j < 3; j++){
                            remove_token(j);
                        }
                        culling = getCulling(culling);
                    }
                    else{
                        continueOption = 1;
                        culling = getCulling(culling);
                    }

                    break;

                case 2:

                    cullingChoice = getCullingChoice(cullingChoice);
                    if(cullingChoice == 1){
                        culling = "";
                        for(j=0; j < 2; j++){
                            remove_token(j);
                        }
                        remove_token(3);
                        culling = getCulling(culling);
                    }
                    else{
                        continueOption = 1;
                        culling = getCulling(culling);
                    }
                    break;

                case 1:

                    cullingChoice = getCullingChoice(cullingChoice);
                    if(cullingChoice == 1){
                        culling = "";

                        for(j = 2; j < 4; j++){
                            remove_token(j);
                        }
                        remove_token(0);
                        culling = getCulling(culling);
                    }
                    else{
                        continueOption = 1;
                        culling = getCulling(culling);
                    }
                    break;

                case 0:

                    cullingChoice = getCullingChoice(cullingChoice);
                    if(cullingChoice == 1){
                        culling = "";
                        Wildlife_Tokens.tokens.remove(1);
                        Wildlife_Tokens.tokens.remove(1);
                        Wildlife_Tokens.tokens.remove(1);
                        culling = getCulling(culling);
                    }
                    else{
                        continueOption = 1;
                        culling = getCulling(culling);
                    }
                    break;

            }


            printTokens();

            if (continueOption == 1) {
                numForCulling = 5;
            }
            else{
                numForCulling = cullingCheck(culling);
            }




        }
    }

    public static int getCullingChoice(int cullingChoice){

        Scanner in = new Scanner(System.in);

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


    public static void printTokens(){
        int k;

        for (k = 0; k < 4; k++){
            String animal = Wildlife_Tokens.tokens.get(k);
            switch(animal){
                case "e":
                    animal = " ----->  Elk";
                    break;
                case "h":
                    animal = " ----->  Hawk";
                    break;
                case "b":
                    animal = " ----->  Bear";
                    break;
                case "s":
                    animal = " ----->  Salmon";
                    break;
                case "f":
                    animal = " ----->  Fox";
                    break;
            }
            System.out.println((k + 1) + ". " + Starter_Tile_Printer.token_printer(Wildlife_Tokens.tokens.get(k)) + animal);
        }
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

    public static void display_tile_rotation(int tile_number){  // TODO uses same method as display tiles could be optimised also change for keystone tile to display one rotation

        System.out.println("\n\n-- Tile Rotation Options -- ");

        int max = 12;
        tile2D[] row = new tile2D[max];
        int i;
        System.out.println("\nHabitat Tiles: \n");

        for (i = 0; i < 6; i++){
            row[i*2] = new tile2D(Habitat_Tiles.biome.get(tile_number),  Habitat_Tiles.animals.get(tile_number), i);
            row[1+i*2] = new tile2D("space", "", 1);
        }
        System.out.println(Ex2D.num_printer(6) + "\n" + Ex2D.row_printer(row, max, 0, " ")+"\n");
    }

    public static void place_tile(int tile_number, int rotation, tile2D[][] board, Player_Tracker player){

        tile2D tile = new tile2D(Habitat_Tiles.biome.get(tile_number), Habitat_Tiles.animals.get(tile_number), rotation);
        tile2D.place(tile_number, board, player, tile);

    }


    public static void remove_tile(int tile_number){
        String temp_biome;
        String temp_animal;


                temp_biome = Habitat_Tiles.biome.get(4);
                temp_animal = Habitat_Tiles.animals.get(4);

                Habitat_Tiles.biome.set(4, Habitat_Tiles.biome.get(tile_number));
                Habitat_Tiles.animals.set(4, Habitat_Tiles.animals.get(tile_number));

                Habitat_Tiles.biome.set(tile_number, temp_biome);
                Habitat_Tiles.animals.set(tile_number, temp_animal);

                Habitat_Tiles.biome.remove(4);
                Habitat_Tiles.animals.remove(4);


    }


    public static void remove_token(int token_tile){
        String temp_token;

        temp_token = Wildlife_Tokens.tokens.get(4);

        Wildlife_Tokens.tokens.set(4, Wildlife_Tokens.tokens.get(token_tile));
        Wildlife_Tokens.tokens.set(token_tile, temp_token);

        Wildlife_Tokens.tokens.remove(4);


    }

    public static void display_token(int animal_token){
        System.out.println("\n" + (animal_token + 1) + ". " + Starter_Tile_Printer.token_printer(Wildlife_Tokens.tokens.get(animal_token))); //TODO GET RID OF SATRTER TILE PRINTER
    }

    public static void nature_token_any_number(int number_of_tokens){
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> tokens = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        int i;
        int token_choice_int;

        if(number_of_tokens == 4){
            System.out.println("Removing all current tokens with new ones!");
            for(i = 0; i<4;i++){
                remove_token(i);
            }
        }

        else{
            for(i = 0; i < number_of_tokens; i++){


                do{
                    System.out.println("Please enter the token number you would like to remove that's available and valid: ");
                    String token_choice = in.nextLine();

                    while (tile2D.verify_valid_number(token_choice) == false) {

                        System.out.println("Please enter a valid number: ");
                        token_choice = in.nextLine();

                    }

                    token_choice_int = Integer.parseInt(token_choice);

                }while(!tokens.contains(token_choice_int));


                tokens.remove(Integer.valueOf(token_choice_int)); // removes the token from the list of available tokens so it wouldn't repeat
                display_token(token_choice_int-1);
                System.out.println("Removing that token now!\n\n");
                remove_token(token_choice_int-1);
            }
        }

    }







}










