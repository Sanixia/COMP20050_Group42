import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
// Group 42
// Roshan, Michal
// Sanixia, glucoseIntolerant
public class Scoring_Setup extends Board {

    /**
     * This class is used to calculate the score of the board
     */
    private static int odd;

    private static Board[][] board;

    public Scoring_Setup(String biome, String animals, int rotation) {
        super(biome, animals, rotation);
    }

    public static void changeToNull(Board[][] board, int row, int col) {
        Scoring_Setup.board[row][col] = null;
    }
    public static Board[][] getBoard() {
        return board;
    }
    public static void setBoard(Board[][] board) {
        Board[][] copy = new Board[MAXSIZE][MAXSIZE];
        for (int i = 0; i < MAXSIZE; i++) {
            for (int j = 0; j < MAXSIZE; j++) {
                Board original = board[i][j];
                if (original == null) {
                    copy[i][j] = null;
                } else {
                    copy[i][j] = new Board(original.getBiome(), original.getAnimals(), original.getRotation());
                }
            }
        }
        Scoring_Setup.board = copy;
    }
    public static void setOdd(int odd) {
        Scoring_Setup.odd = odd;
    }

    public static int calculateSpace(int col) {
        if (odd == 0){
            if (col % 2 == 1) return 0;
            return 1;
        }
        else if(odd == 1){
            if (col % 2 == 1) return 1;
        }
        return 0;
    }

    public static void setBoardTile(int x, int y, Board tile) {
        board[x][y] = tile;
    }

    public static void setBoardAnimal(int x, int y, String animal) {
        Board new_tile = new Board(board[x][y].getBiome(), animal, getBoard()[x][y].getRotation());
        board[x][y] = new_tile;
    }

    /*  Scoring main function used for unit tests
        - loops through the board and calculates the score of the current tile based on type and card
        - arrays are used as memory to keep track of group based scoring cards
        - a seperate loop is run for elk 1 and 2 as they are removed from the board and would affect fox and hawk scoring
     */

    public static int[] scoring_setups(Board[][]board, int odd, int[] scoring_cards) {
        setBoard(board);
        setBoard(board);
        setOdd(odd);
        remove_slot();
        int fox_num=0, hawk_num=0, bear_num=0, salmon_score=0, elk_num=0;
        int[] habitat_scoring = {0,0,0,0,0};
        int[] bear_arr = new int[20], elk_arr = new int[20], fox_arr = new int[20];
        int b=0, e=0, f=0;      // indexes
        for (int i=0; i<MAXSIZE; i++) {
            for (int j=0; j<MAXSIZE; j++) {
                Board t = getBoard()[i][j];

                // TODO habitat scoring

                if (t!=null){
                    habitat_scoring = Scoring_Habitat_Tiles.habitat_score(i, j, habitat_scoring);       // F W R M P
                }


                if( t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='f') {            // FOX
                    //System.out.println("fox    ["+i+"]["+j+"] " + fox_scoring_cards(i, j, scoring_cards[2]));
                    if (scoring_cards[2]==2) {
                        fox_arr[f] = fox_scoring_cards(i, j, scoring_cards[2]);
                        f++;
                    }
                    else fox_num += fox_scoring_cards(i, j, scoring_cards[2]);
                }
                else if(t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='h') {        // HAWK
                   // System.out.println("hawk   ["+i+"]["+j+"] " + hawk_scoring_cards(i, j, scoring_cards[3]));
                    if(scoring_cards[3]==3) {
                        hawk_num += hawk_score_calculate(hawk_scoring_cards(i, j, scoring_cards[3]), scoring_cards[3]);
                    }
                    else{
                        hawk_num += hawk_scoring_cards(i, j, scoring_cards[3]);
                    }
                }
                else if(t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='b') {        // BEAR
                    // System.out.println("bear   ["+i+"]["+j+"] " + bear_scoring_cards(i, j, scoring_cards[0]));
                    if (scoring_cards[0]==3) {
                        bear_arr[b] = bear_scoring_cards(i, j, scoring_cards[0]);
                        b++;
                    }
                    else bear_num += bear_scoring_cards(i, j, scoring_cards[0]);
                }
                else if(t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='s') {        // SALMON
                    //System.out.println("salmon ["+i+"]["+j+"] " + salmon_scoring_cards(i, j, 3));
                    salmon_score += salmon_score_calculate(salmon_scoring_cards(i, j, scoring_cards[4]), scoring_cards[4]);
                }
            }
        }
        // separate loop for elks to not affect other tiles as elk are removed after scoring
        for (int i=0; i< MAXSIZE; i++) {
            for (int j = 0; j < MAXSIZE; j++) {

                Board t = getBoard()[i][j];

                if (t != null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0) == 'e') {       // ELK
                    if (scoring_cards[1]==3) {
                        elk_arr[e] = elk_scoring_cards(i, j, scoring_cards[1], 0);
                        e++;
                    }
                    else{
                        elk_num += elk_scoring_cards(i, j, scoring_cards[1], -1);
                    }

                }

            }
        }

        int fox_score = fox_score_calculate(fox_num, scoring_cards[2], fox_arr);
        int bear_score = bear_score_calculate(bear_num, bear_arr, scoring_cards[0]);
        System.out.println("\n\nTotal Fox score:" + fox_score);

        int hawk_score = 0;

        if(scoring_cards[3]==1 || scoring_cards[3]==2) {
            hawk_score = hawk_score_calculate(hawk_num, scoring_cards[3]);
            System.out.println("Total Hawk score:" + hawk_score);
        }
        else{
            hawk_score = hawk_num;
            System.out.println("Total Hawk score:" + hawk_score);
        }

        System.out.println("Total Bear score:" + bear_score);
        System.out.println("Total Salmon score:" + salmon_score);

        int elk_score = 0;

        if(scoring_cards[1]==2 || scoring_cards[1]==1){
            elk_score = elk_num;
            System.out.println("Total Elk score:" + elk_score);
        }
        else{
            elk_score = elk_score_calculate(elk_num, elk_arr, scoring_cards[1]);
            System.out.println("Total Elk score:" + elk_score);
        }

        System.out.println("Total Habitat score:" + Arrays.toString(habitat_scoring));

        // b e f h s || F W R M P
        return new int[]{bear_score, elk_score, fox_score, hawk_score, salmon_score, habitat_scoring[0], habitat_scoring[1], habitat_scoring[2], habitat_scoring[3], habitat_scoring[4]};
    }


    /* Pass on to animal scoring cards
     */

    public static int fox_scoring_cards(int x, int y, int card) {
        return switch (card) {
            case 1 -> Scoring_Fox.fox_scoring_A(x, y);
            case 2 -> Scoring_Fox.fox_scoring_B(x, y);
            case 3 -> Scoring_Fox.fox_scoring_C(x, y);
            default -> 0;
        };
    }

    public static int hawk_scoring_cards(int x, int y, int card) {
        return switch (card) {
            case 1 -> Scoring_Hawk.hawk_scoring_A(x, y);
            case 2 -> Scoring_Hawk.hawk_scoring_B(x, y);
            case 3 -> Scoring_Hawk.hawk_scoring_C(x, y);
            default -> 0;
        };
    }

    public static int bear_scoring_cards(int x, int y, int card) {
        return switch (card) {
            case 1 -> Scoring_Bear.bear_scoring_A(x, y);
            case 2 -> Scoring_Bear.bear_scoring_B(x, y);
            case 3 -> Scoring_Bear.bear_scoring_C(x, y);
            default -> 0;
        };
    }

    public static int elk_scoring_cards(int x, int y, int card, int pos) {

        return switch (card) {
            case 1 -> elk_score_calculate(Scoring_Elk.elk_scoring_A(x, y, pos), null, card);
            case 2 -> Scoring_Elk.elk_scoring_B(x, y);
            case 3 -> Scoring_Elk.elk_scoring_C(x, y);
            default -> 0;
        };
    }

    public static int salmon_scoring_cards(int x, int y, int card) {
        return Scoring_Salmon.salmon_scoring(x, y, card);
    }


    /*  Animal score calculations
     */
    public static int fox_score_calculate(int f, int card, int[] fox_arr) {
        switch (card) {
            case 0:
                return 0;
            case 2:
                int one_pair=0, two_pair=0, three_pair=0;
                for (int fox : fox_arr) {
                    if (fox == 1) one_pair++;
                    if (fox == 2) two_pair++;
                    if (fox == 3) three_pair++;
                }
                return one_pair*2 + two_pair*5 + three_pair*8;
            default:
                return f;
        }
    }

    public static int hawk_score_calculate(int h, int card) {
        switch (card) {
            case 1:
                if (h == 0) return 0;
                if (h == 1) return 2;
                if (h == 2) return 5;
                if (h == 3) return 8;
                if (h == 4) return 11;
                if (h == 5) return 14;
                if (h == 6) return 18;
                if (h == 7) return 22;
                return 26;
            case 2:
                if (h == 0) return 0;
                if (h == 1) return 2;
                if (h == 2) return 5;
                if (h == 3) return 9;
                if (h == 4) return 12;
                if (h == 5) return 16;
                if (h == 6) return 20;
                if (h == 7) return 24;
                return 28;
            case 3:
                return h*3;
            default:
                return 0;
        }

    }

    public static int bear_score_calculate(int b, int[] bear_arr, int card) {
        switch (card) {
            case 1:
                b = b / 2;
                if (b == 0) return 0;
                if (b == 1) return 4;
                if (b == 2) return 11;
                if (b == 3) return 19;
                return 27;
            case 2:
                b = b / 3;
                if (b == 0) return 0;
                return b*10;
            case 3:
                int one=0, two=0, three=0, three_b=0, bonus=0;
                for (int bear_shape : bear_arr) {
                    if (bear_shape == 1) one++;
                    if (bear_shape == 2) two++;
                    if (bear_shape == 3) three++;
                    if (bear_shape == 4) three_b++;
                }
                three = three/3;
                two = two/2;
                three += three_b;
                if (one>0 && two>0 && three>0) bonus=3;
                return one*2 + two*5 + three*8 + bonus;
            default:
                return 0;
        }
    }

    public static int elk_score_calculate(int e, int[] elk_arr, int card) {
        switch(card){
            case 1:
                if (e == 0) return 0;
                if (e == 1) return 2;
                if (e == 2) return 5;
                if (e == 3) return 9;
                return 13;
            case 2:
                if (e == 0) return 0;
                if (e == 1) return 2;
                if (e == 2) return 4;
                if (e == 3) return 7;
                if (e == 4) return 10;
                if (e == 5) return 14;
                if (e == 6) return 18;
                if (e == 7) return 23;
                return 28;
            case 3:
                int one=0, two=0, three=0, four=0;
                for (int elk_shape : elk_arr) {
                    if (elk_shape == 1) one++;
                    if (elk_shape == 2) two++;
                    if (elk_shape == 3) three++;
                    if (elk_shape == 4) four++;
                }
                two = two/2;
                three = three/3;
                four = four/2;
                return one*2 + two*5 + three*9 + four*13;
            default: return 0;
        }
    }

    public static int salmon_score_calculate(int s, int card) {
        switch(card){
            case 1:
                if (s == 0) return 0;
                if (s == 1) return 2;
                if (s == 2) return 4;
                if (s == 3) return 7;
                if (s == 4) return 11;
                if (s == 5) return 15;
                if (s == 6) return 20;
                return 26;
            case 2:
                if (s == 0) return 0;
                if (s == 1) return 2;
                if (s == 2) return 4;
                if (s == 3) return 8;
                return 12;
            case 3:
                if (s == 0) return 0;
                if (s == 1) return 2;
                if (s == 2) return 4;
                if (s == 3) return 9;
                if (s == 4) return 11;
                return 17;
            default:
                return 0;
        }
    }

    /* Function that takes in coordinates x and y and position                       1     2
        returns the tile in the desired position                                  6    tile   3
        in relation to the tile provided                                             5     4
     */

    public static Board get_surrounding_tile(int x, int y, int pos) {     // returns a tile around specified tile
        int plusOne = calculateSpace(x);
        int row = x;
        int col = y;
        if (pos==1 && row-1>=0 && col-1+plusOne>=0) {
            row--;
            col += plusOne - 1;                                     // top left
        } if (pos==2 && row-1>=0 && col+plusOne<=MAXSIZE) {
            row--;
            col += plusOne;                                         // top right
        } if (pos==3 && col+1<=MAXSIZE) {
            col++;                                                  // right
        }if (pos==4 && row+1<=MAXSIZE && col+plusOne<=MAXSIZE) {
            row++;
            col += plusOne;                                         // bottom right
        }if (pos==5 && row+1<=MAXSIZE && col-1+plusOne<=MAXSIZE) {
            row++;
            col += plusOne - 1;                                     // bottom left
        }if (pos==6 && col-1>=0) {
            col--;                                                  // left
        }
        if (row==x && col==y) return null;
        if(row<0 || row>=MAXSIZE || col<0 || col>=MAXSIZE) return null;
        return board[row][col];
    }


    /*      Function that removes all slot spaces on the board
     */

    public static void remove_slot() {
        for (int i = 0; i < MAXSIZE; i++) {
            for (int j = 0; j < MAXSIZE; j++) {
                if (board[i][j]!=null && (board[i][j].getBiome()).length() == 4){ //(board[i][j].getBiome(), "slot")) {
                    board[i][j] = null;
                }
            }
        }
    }



    /*      Actual main scoring function that's used in game
     */
    public static void scoring_setup(Player_Tracker player_tracker, int[] scoring_cards) {

        int max_col = player_tracker.getMax_col();
        int max_row = player_tracker.getMax_row();
        int odd = player_tracker.getOdd();
        String name = player_tracker.getPlayer_name();
        int nature_tokens = player_tracker.getNature_tokens();

        Board[][] board = player_tracker.getBoard();


        setBoard(board);
        setOdd(odd);

        remove_slot();         // slots are also counted as tiles so they need to be removed at the start
        print_boards(board, max_col, max_row, odd);

        int fox_num=0, hawk_num=0, bear_num=0, salmon_score=0, elk_num=0;

        int[] bear_arr = new int[20],  elk_arr = new int[20], fox_arr = new int [20];
        int b=0, e=0, f=0;
        int[] habitat_scoring = {0,0,0,0,0};

        for (int i=0; i< max_row; i++) {
            for (int j=0; j< max_col; j++) {




                Board t = getBoard()[i][j];


                if (t!=null){
                    habitat_scoring = Scoring_Habitat_Tiles.habitat_score(i, j, habitat_scoring);   // HABITAT SCORING
                }



                if( t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='f') {            // FOX

                    if (scoring_cards[2]==2) {
                        fox_arr[f] = fox_scoring_cards(i, j, scoring_cards[2]);
                        f++;
                    }
                    else fox_num += fox_scoring_cards(i, j, scoring_cards[2]);
                }

                if(t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='h') {           // HAWK
                    if(scoring_cards[3]==3) {
                        hawk_num += hawk_score_calculate(hawk_scoring_cards(i, j, scoring_cards[3]), scoring_cards[3]);
                    }
                    else{
                        hawk_num += hawk_scoring_cards(i, j, scoring_cards[3]);
                    }
                }

                if(t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='b') {          // BEAR

                    if (scoring_cards[0]==3) {
                        bear_arr[b] = bear_scoring_cards(i, j, scoring_cards[0]);
                        b++;
                    }
                    else bear_num += bear_scoring_cards(i, j, scoring_cards[0]);
                }
                if(t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='s') {        // SALMON

                    salmon_score += salmon_score_calculate(salmon_scoring_cards(i, j, scoring_cards[4]), scoring_cards[4]);
                }
            }
        }

        for (int i=0; i< max_row; i++) {           // ELK
            for (int j = 0; j < max_col; j++) {

                Board t = getBoard()[i][j];

                if (t != null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0) == 'e') {
                    if (scoring_cards[1]==3) {
                        elk_arr[e] = elk_scoring_cards(i, j, scoring_cards[1], 0);
                        e++;
                    }
                    else{
                        elk_num += elk_scoring_cards(i, j, scoring_cards[1], -1);
                    }

                }

            }
        }

        int fox_score = fox_score_calculate(fox_num, scoring_cards[2], fox_arr);
        int bear_score = bear_score_calculate(bear_num, bear_arr, scoring_cards[0]);
        System.out.println("\n\nTotal Fox score: " + fox_score);

        int hawk_score = 0;

        if(scoring_cards[3]==1 || scoring_cards[3]==2) {
            hawk_score = hawk_score_calculate(hawk_num, scoring_cards[3]);
            System.out.println("Total Hawk score: " + hawk_score);
        }
        else{
            hawk_score = hawk_num;
            System.out.println("Total Hawk score: " + hawk_score);
        }

        System.out.println("Total Bear score: " + bear_score);
        System.out.println("Total Salmon score: " + salmon_score);

        int elk_score = 0;

        if(scoring_cards[1]==2 || scoring_cards[1]==1){
            elk_score = elk_num;
            System.out.println("Total Elk score: " + elk_score);
        }
        else {
            elk_score = elk_score_calculate(elk_num, elk_arr, scoring_cards[1]);
            System.out.println("Total Elk score: " + elk_score);
        }

        System.out.println("Total Nature Tokens: " + nature_tokens);

        System.out.println("\n\nHabitat scoring: ");
        System.out.println("Forest: " + habitat_scoring[0]);
        System.out.println("Wetland: " + habitat_scoring[1]);
        System.out.println("River: " + habitat_scoring[2]);
        System.out.println("Mountain: " + habitat_scoring[3]);
        System.out.println("Prairie: " + habitat_scoring[4]);

        int total_habitat_score = 0;
        for (int i=0; i<5; i++) {
            total_habitat_score += habitat_scoring[i];
        }

        System.out.println("\nTotal score for " + name + " is: " + (fox_score + hawk_score + bear_score + salmon_score + elk_score + nature_tokens + total_habitat_score + "\n\n\n\n"));

    }

    public static int animal_scoring(int[] scoring_cards, Player_Tracker player_tracker) {

        Scoring_Salmon.getSalmon_found().clear();
        Scoring_Salmon.setIndex_salmon(0);
        Scoring_Hawk.getHawk_found().clear();

        remove_slot();

        int fox_num=0, hawk_num=0, bear_num=0, salmon_score=0, elk_num=0;

        int[] bear_arr = new int[20], elk_arr = new int[20], fox_arr = new int[20];
        int b=0, e=0, f=0;      // indexes

        for (int i=0; i<player_tracker.getMax_row(); i++) {
            for (int j=0; j<player_tracker.getMax_col(); j++) {

                Board t = getBoard()[i][j];

                if( t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='f') {            // FOX

                    if (scoring_cards[2]==2) {
                        fox_arr[f] = fox_scoring_cards(i, j, scoring_cards[2]);
                        f++;
                    }
                    else fox_num += fox_scoring_cards(i, j, scoring_cards[2]);
                }
                else if(t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='h') {        // HAWK

                    if(scoring_cards[3]==3) {
                        hawk_num += hawk_score_calculate(hawk_scoring_cards(i, j, scoring_cards[3]), scoring_cards[3]);
                    }
                    else{
                        hawk_num += hawk_scoring_cards(i, j, scoring_cards[3]);
                    }
                }
                else if(t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='b') {        // BEAR

                    if (scoring_cards[0]==3) {
                        bear_arr[b] = bear_scoring_cards(i, j, scoring_cards[0]);
                        b++;
                    }
                    else bear_num += bear_scoring_cards(i, j, scoring_cards[0]);
                }
                else if(t!=null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0)=='s') {        // SALMON

                    salmon_score += salmon_score_calculate(salmon_scoring_cards(i, j, scoring_cards[4]), scoring_cards[4]);
                }
            }
        }
        // separate loop for elks to not affect other tiles as elk are removed after scoring
        for (int i=0; i< player_tracker.getMax_row(); i++) {
            for (int j = 0; j < player_tracker.getMax_col(); j++) {

                Board t = getBoard()[i][j];

                if (t != null && !t.getAnimals().isBlank() && t.getAnimals().charAt(0) == 'e') {       // ELK
                    if (scoring_cards[1]==3) {
                        elk_arr[e] = elk_scoring_cards(i, j, scoring_cards[1], 0);
                        e++;
                    }
                    else{
                        elk_num += elk_scoring_cards(i, j, scoring_cards[1], -1);
                    }

                }

            }
        }



        int fox_score = fox_score_calculate(fox_num, scoring_cards[2], fox_arr);
        int bear_score = bear_score_calculate(bear_num, bear_arr, scoring_cards[0]);
        System.out.println("\n\nTotal Fox score:" + fox_score);

        int hawk_score = 0;

        if(scoring_cards[3]==1 || scoring_cards[3]==2) {
            hawk_score = hawk_score_calculate(hawk_num, scoring_cards[3]);
            System.out.println("Total Hawk score:" + hawk_score);
        }
        else{
            hawk_score = hawk_num;
            System.out.println("Total Hawk score:" + hawk_score);
        }


        System.out.println("Total Bear score:" + bear_score);
        System.out.println("Total Salmon score:" + salmon_score);

        int elk_score = 0;

        if(scoring_cards[1]==2 || scoring_cards[1]==1){
            elk_score = elk_num;
            System.out.println("Total Elk score:" + elk_score);
        }
        else{
            elk_score = elk_score_calculate(elk_num, elk_arr, scoring_cards[1]);
            System.out.println("Total Elk score:" + elk_score);
        }


        return fox_score + hawk_score + bear_score + elk_score + salmon_score;
    }



    public static void main(String[] args) {
        Board[][] b = new Board[MAXSIZE][MAXSIZE];
        b[1][2] = new Board("WP", "EFS", 3);
        b[1][1] = new Board("WP", "E", 2);
        b[2][1] = new Board("WM", "F", 1);
        b[2][2] = new Board("P", "E", 6);

        b[3][0] = new Board("FR", "E", 0);
        b[3][1] = new Board("WR", "E", 5);
        b[3][2] = new Board("FM", "B", 0);

        b[4][1] = new Board("WR", "E", 2);
        b[4][2] = new Board("R", "E", 6);

        Board.print_boards(b, 10, 10, 1);

        //int score = scoring_setups(b, 1, new int[] {1,1,1,1,1});
        int score[] = scoring_setups(b, 1, new int[] {1,1,1,1,1});
        System.out.println(score);
    }
}