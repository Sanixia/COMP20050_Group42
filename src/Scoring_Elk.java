import java.util.ArrayList;
// Group 42
// Roshan, Michal
// Sanixia, glucoseIntolerant
public class Scoring_Elk extends Scoring_Cards
{

    public Scoring_Elk(String biome, String animals, int rotation) {
        super(biome, animals, rotation);
    }


    public static int elk_scoring_A(int x, int y, int pos) {
        ArrayList<Integer> positions = new ArrayList<Integer>();
        int elk_score = 1;
        int x2 = x, y2 = y;
        int[] coordinates = new int[2];
        Board surrounding_tile = null;
        for (int i=2; i<6; i++) {
            if(pos == -1){ // the first tile
                surrounding_tile = get_surrounding_tile(x2, y2, i);
                coordinates = get_surrounding_tile_coordinates(x2, y2, i);
            }
            else{
                i = 5;
                surrounding_tile = get_surrounding_tile(x2, y2, pos);
                coordinates = get_surrounding_tile_coordinates(x2, y2, pos);

            }
            if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == 'e'){
                if(pos == -1){
                    positions.add(i);
                }
                else{
                    positions.add(pos);
                }
                break;
            }

        }
        if (positions.size()==0){

            changeToNull(getBoard(), x2, y2);

            return elk_score;  // base case
        }

        else{

            changeToNull(getBoard(), x, y); // makes current tile null so it doesn't count it again

            x2 = coordinates[0];
            y2 = coordinates[1];

            return elk_score + elk_scoring_A(x2, y2, positions.get(0));
        }
    }

    public static int elk_scoring_B(int x, int y) {
        int check = 0;
        int elk_total = 1;


        ArrayList<Integer[]> elk_found = new ArrayList<Integer[]>();
        int[] surrounding_tile = {-1,-1};

        int[] original_tile = {-1,-1}; // used to check if the tile is the same as the original tile


        changeToNull(getBoard(), x, y); // makes current tile null so it doesn't count it again

        for (int i=0; i<6; i++) {
            surrounding_tile = get_surrounding_tile_coordinates(x, y, i+1);
            if (!(surrounding_tile[0] < 0 || surrounding_tile[1] < 0 || surrounding_tile[0] > Board.MAXSIZE || surrounding_tile[1] > Board.MAXSIZE) &&
                    getBoard()[surrounding_tile[0]][surrounding_tile[1]] != null &&
                    getBoard()[surrounding_tile[0]][surrounding_tile[1]].getAnimals().charAt(0) == 'e'){

                elk_found.add(new Integer [] {surrounding_tile[0], surrounding_tile[1]});
                elk_total++;
            }
        }


        while(check < elk_found.size()){ // while there are still tiles to check

            for (int j=0; j<6; j++) {
                surrounding_tile = get_surrounding_tile_coordinates(elk_found.get(check)[0], elk_found.get(check)[1], j+1);

                original_tile[0] = elk_found.get(check)[0];
                original_tile[1] = elk_found.get(check)[1];

                if (!(surrounding_tile[0] < 0 || surrounding_tile[1] < 0 || surrounding_tile[0] > Board.MAXSIZE || surrounding_tile[1] > Board.MAXSIZE) &&
                        getBoard()[surrounding_tile[0]][surrounding_tile[1]] != null &&
                        getBoard()[surrounding_tile[0]][surrounding_tile[1]].getAnimals().charAt(0) == 'e' &&
                        !deepContains(elk_found, new Integer[] {surrounding_tile[0], surrounding_tile[1]})) {

                    elk_found.add(new Integer[] {surrounding_tile[0], surrounding_tile[1]});
                    changeToNull(getBoard(), surrounding_tile[0], surrounding_tile[1]);
                    elk_total++;

                }

            }
            changeToNull(getBoard(), elk_found.get(check)[0],  elk_found.get(check)[1]);
            check++;
        }


        return elk_score_calculate(elk_total, null, 2);
    }


    public static int elk_scoring_C(int x, int y) {         // Lets call our tile at Board[x][y] T
        ArrayList<Integer> positions = new ArrayList<Integer>();

        for (int i = 1; i <= 6; i++) {
            Board surrounding_tile = get_surrounding_tile(x, y, i);
            if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == 'e'){
                positions.add(i);
            }
        }

        if (positions.size()==0) {                      // case 1: T has no surround tiles
            //System.out.println("\n1");
            return 1;
        }

        int x1 = get_surrounding_row(x, y, positions.get(0));       // gets coordinates of t1 and declares new surround array for it
        int y1 = get_surrounding_col(x, y, positions.get(0));
        ArrayList<Integer> positions1 = new ArrayList<Integer>();

        if (positions.size()==1) {                      // case 2: 1 surround tiles t1
            for (int i = 1; i <= 6; i++) {
                Board surrounding_tile = get_surrounding_tile(x1, y1, i);                           // checks surrounding tiles of t1
                if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == 'e'){
                    positions1.add(i);
                }
            }

            if (positions1.size() == 1) {               // if t1 has 1 surrounding tile it can only be T
                //System.out.println("\n2");
                return 2;
            }           // NOTE* this will be valid returned twice by each tile in the pair so the score for it is divided by 2 when calculated
            return 0;
        }

        int x2 = get_surrounding_row(x, y, positions.get(1));
        int y2 = get_surrounding_col(x, y, positions.get(1));
        ArrayList<Integer> positions2 = new ArrayList<Integer>();

        for (int i = 1; i <= 6; i++) {
            Board surrounding_tile = get_surrounding_tile(x1, y1, i);
            if (surrounding_tile != null && surrounding_tile.getAnimals().charAt(0) == 'e') {
                positions1.add(i);
            }
        }

        for (int i = 1; i <= 6; i++) {
            Board surrounding_tile = get_surrounding_tile(x2, y2, i);
            if (surrounding_tile != null && surrounding_tile.getAnimals().charAt(0) == 'e') {
                positions2.add(i);
            }
        }

        if (positions.size()==2) {          // case 3: 2 surround tiles t1, t2
            if (check_beside(positions.get(0), positions.get(1)) && positions1.size()==2 && positions2.size()==2)
            { // if t1 and t2 are beside each other, they are in a correct shape + checks if all tiles have 2 other surrounding tiles
                return 3;
            }
        }       // NOTE* divided by 3 when calculated

        if (positions.size()==3) {          // case 4: 3 surround tiles t1, t2, t3, only triggered for the 2 inner tiles of the 4 elk shape
            int x3 = get_surrounding_row(x, y, positions.get(2));
            int y3 = get_surrounding_col(x, y, positions.get(2));
            ArrayList<Integer> positions3 = new ArrayList<Integer>();

            for (int i = 1; i <= 6; i++) {
                Board surrounding_tile = get_surrounding_tile(x3, y3, i);
                if (surrounding_tile != null && surrounding_tile.getAnimals().charAt(0) == 'e') {
                    positions3.add(i);
                }
            }

            int beside = 0;
            if (check_beside(positions.get(0),positions.get(1))) beside ++;
            if (check_beside(positions.get(0),positions.get(2))) beside ++;
            if (check_beside(positions.get(1),positions.get(2))) beside ++;

            if (beside==2 && positions1.size() + positions2.size() + positions3.size() == 7) {  // checks if 2 of the above beside stateents hold and if the total surround = 7
                //System.out.println("\n4");
                return 4;
            }   // score will be div by 2 in the end
        }
        return 0;
    }
}
