import java.util.*;
// Group 42
// Roshan, Michal
// Sanixia, glucoseIntolerant

public class Display_And_Input {

    /**
     * This class is used to display output to users like tiles and habitats and receives input from users too
     */

    private static ArrayList<Player_Tracker> players_score_calculation = new ArrayList<>();

    private static ArrayList<String> playerNames = new ArrayList<>();

    private static ArrayList<Player_Tracker> players = new ArrayList<>();   //Array of objects to keep track of players and bots


    private static boolean bot_vs_bot = false; //true if bot vs bot

    private static boolean bot_vs_human = false; //true if bot vs human

    private static int bot_count = 0;
    private static int player_count = 0;

    public static boolean isBot_players() {
        return bot_vs_bot;
    }

    public static int getBot_count() {
        return bot_count;
    }

    public static void setBot_count(int bot_count) {
        Display_And_Input.bot_count = bot_count;
    }


    public static void setPlayer_count(int player_count) {
        Display_And_Input.player_count = player_count;
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

  //  public static ArrayList<Player_Tracker> getPlayers_score_calculation() {
  //      return players_score_calculation;
  //   }









    public static void welcome(){
        /* welcome message */
        /* ask how many players */

        System.out.println("Welcome to Cascadia!");
        System.out.println("How many people are playing?");
        System.out.println("Enter 2, 3 or 4 for human players.");
        System.out.println("Enter 5 for bot vs bot.");
        System.out.println("Enter 6 for bot vs human.");
        System.out.print("-> ");
    }




    public static void num_players() {


        Scanner in = new Scanner(System.in);

        boolean validNumOfPlayers = false;

        do{
            try{

                player_count = in.nextInt();
                if (player_count == 1 || player_count == 2 || player_count == 3 || player_count == 4 || player_count == 5 || player_count == 6){

                    if(player_count == 5){
                        number_of_bots(player_count);
                        bot_vs_bot = true;
                    }
                    else if(player_count == 6){
                        number_of_bots(player_count);
                        bot_vs_human = true;
                    }

                    validNumOfPlayers = true;
                }

                else{
                    System.out.print("Please enter a number that is either 2, 3, 4, 5 or 6: ");
                }

            }
            catch (InputMismatchException ex) {
                System.out.print("Please enter a valid number (2, 3, 4, 5 or 6): ");
                in.nextLine();
            }
        }
        while (!validNumOfPlayers);




    }


    public static void number_of_bots(int choice) {
        Scanner in = new Scanner(System.in);
        boolean validNumOfBots = false;
        int num_of_bots = 0;

        if (choice == 5) {
            System.out.println("How many bots do you want to play against each other? Enter (2, 3 or 4)");
            System.out.println("-> ");
            do {
                try {
                    num_of_bots = in.nextInt();
                    if (num_of_bots == 2 || num_of_bots == 3 || num_of_bots == 4) {
                        validNumOfBots = true;
                    } else {
                        System.out.print("Please enter a number that is either 2, 3 or 4: ");
                    }
                } catch (InputMismatchException ex) {
                    System.out.print("Please enter a valid number (2, 3 or 4): ");
                    in.nextLine();
                }
            }
            while (!validNumOfBots);

            setBot_count(num_of_bots);
            player_count = num_of_bots;
        }

        else{
            System.out.println("How many bots do you want to play against? Enter (1, 2 or 3)");
            System.out.println("-> ");
            do {
                try {
                    num_of_bots = in.nextInt();
                    if (num_of_bots == 1 || num_of_bots == 2 || num_of_bots == 3) {
                        validNumOfBots = true;
                    } else {
                        System.out.print("Please enter a number that is either 1, 2 or 3: ");
                    }
                } catch (InputMismatchException ex) {
                    System.out.print("Please enter a valid number (1,2 or 3): ");
                    in.nextLine();
                }
            }
            while (!validNumOfBots);

            setBot_count(num_of_bots);
            player_count = num_of_bots + 1;
        }

    }






    public static void player_names(){
        Scanner in = new Scanner(System.in);
        String temp_name;
        boolean checkValidName;
        int amount_of_names_to_add = getPlayer_count();

        // for bot vs bot(s)
        if(bot_vs_bot){
            bot_names();
            amount_of_names_to_add = 0;
        }

        // for bot vs human
        if(bot_vs_human){
            bot_names();
            amount_of_names_to_add = player_count - getBot_count();
        }


        for (int i = 0; i < amount_of_names_to_add; i++){

                checkValidName = false;
                System.out.print("\nPlayer " + (i+1) + " please enter your name: ");


                while(!checkValidName){
                    temp_name = in.nextLine();

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

    public static void bot_names(){

        for(int i = 0; i < getBot_count(); i++){
            playerNames.add("BotGPT " + (i + 1));
        }

    }




    public static void randomised_order_players(){                                 // TODO maybe redundant

        long seed = System.nanoTime();

        System.out.println("The order in which players will play will be: \n");

        Collections.shuffle(playerNames, new Random(seed));
        Collections.shuffle(getPlayers(), new Random(seed));

        for (int i = 0; i < player_count; i++){
            System.out.println((i+1) + ") " + playerNames.get(i));

        }

    }





    public static void randomise_player_tiles_and_tokens(){

        long seed = System.nanoTime();                                          // To have the same randomised list order for animals and biome tiles
        Collections.shuffle(Starter_Habitat.getStarter_Habitat_Tiles());

        Collections.shuffle(Habitat_Tiles.biome, new Random(seed));
        Collections.shuffle(Habitat_Tiles.animals, new Random(seed));
        Collections.shuffle(Wildlife_Tokens.tokens);

    }

    public static void add_bots_or_humans(){

        int amount_to_create = player_count;
        int j = 0;

        if(bot_vs_human){
            for(int i = 0; i < getBot_count(); i++){
                players.add(new Bot(playerNames.get(i), Starter_Habitat.getStarter_Habitat_Tiles().get(i), 0, 0, 0, 0, 0, 0));
            }

            j = getBot_count();
        }

        for (int i = j ; i < amount_to_create; i++){

            if(bot_vs_bot){
                players.add(new Bot(playerNames.get(i), Starter_Habitat.getStarter_Habitat_Tiles().get(i), 0, 0, 0, 0, 0, 0));
            }
            else{
                players.add(new Player_Tracker(playerNames.get(i), Starter_Habitat.getStarter_Habitat_Tiles().get(i), 0, 0, 0, 0,0, 0));
            }
        }




    }


    public static void display_tiles_and_tokens(boolean culling_trigger, boolean bot_player){
        display_tiles();
        System.out.println("Corresponding Wildlife Tokens (1 next to a token represents the habitat that is also 1 for example): \n");

        printTokens();
        if(culling_trigger){
            callTheCulling(bot_player);
        }

    }

    public static void display_tiles(){                                    // Displays the habitat tiles
        int max = 8, rotation = 0;
        Board[] row = new Board[max];
        int i;
        System.out.println("\nHabitat Tiles: \n");

        for (i = 0; i < 4; i++){

            // keystone tile check
            if(Habitat_Tiles.biome.get(i).length() == 1){
                row[i*2] = new Board(Habitat_Tiles.biome.get(i),  Habitat_Tiles.animals.get(i), 6);
                row[1+i*2] = new Board("space", "", 6);
            }
            else{
                row[i*2] = new Board(Habitat_Tiles.biome.get(i),  Habitat_Tiles.animals.get(i), 1);
                row[1+i*2] = new Board("space", "", 1);
            }

        }
        System.out.println(Board.num_printer(4) + "\n" + Board.row_printer(row, max, 0, " ")+"\n");
    }

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
                        remove_token(j);
                    }
                    culling = getCulling(culling);
                    break;


                case 3:

                    cullingChoice = getCullingChoice(cullingChoice, bot_player);
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

                    cullingChoice = getCullingChoice(cullingChoice, bot_player);
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

                    cullingChoice = getCullingChoice(cullingChoice, bot_player);
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

                    cullingChoice = getCullingChoice(cullingChoice, bot_player);
                    if(cullingChoice == 1){
                        culling = "";
                        for(j = 1; j < 4; j++){
                            remove_token(j);
                        }
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
            System.out.println((k + 1) + ". " + Board.middle_section(Wildlife_Tokens.tokens.get(k).charAt(0)) + animal);
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

    public static void display_tile_rotation(int tile_number){

        System.out.println("\n\n-- Tile Rotation Options -- ");

        int max = 12;
        Board[] row = new Board[max];
        int i;
        System.out.println("\nHabitat Tiles: \n");

        for (i = 0; i < 6; i++){
            row[i*2] = new Board(Habitat_Tiles.biome.get(tile_number),  Habitat_Tiles.animals.get(tile_number), i);
            row[1+i*2] = new Board("space", "", 1);
        }
        System.out.println(Board.num_printer(6) + "\n" + Board.row_printer(row, max, 0, " ")+"\n");
    }

    public static void place_tile(int tile_number, boolean bot_players, int rotation, Board[][] board, Player_Tracker player){

        Board tile = new Board(Habitat_Tiles.biome.get(tile_number), Habitat_Tiles.animals.get(tile_number), rotation);
        Board.place(bot_players, board, player, tile);

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
        System.out.println("\n" + (animal_token + 1) + ". " + Board.middle_section(Wildlife_Tokens.tokens.get(animal_token).charAt(0)));
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

                    while (!Board.verify_valid_number(token_choice)) {

                        System.out.println("Please enter a valid number: ");
                        token_choice = in.nextLine();

                    }

                    token_choice_int = Integer.parseInt(token_choice);

                }while(!tokens.contains(token_choice_int));


                tokens.remove(Integer.valueOf(token_choice_int)); // removes the token from the list of available tokens, so it wouldn't repeat
                display_token(token_choice_int-1);
                System.out.println("Removing that token now!\n\n");
                remove_token(token_choice_int-1);
            }
        }

    }


    public static boolean is_it_bot(Player_Tracker player_tracker){
        return player_tracker.getClass() == Bot.class;
    }


}










