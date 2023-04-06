import java.util.ArrayList;

public class Scoring_Elk extends Scoring_Cards
{

    public Scoring_Elk(String biome, String animals, int rotation) {
        super(biome, animals, rotation);
    }


    public static int elk_scoring_1(int x, int y, int pos) {         // TODO
        ArrayList<Integer> positions = new ArrayList<Integer>();
        int elk_score = 1;
        int x2 = x, y2 = y;
        int[] coordinates = new int[2];
        Board surrounding_tile = null;
        for (int i=2; i<5; i++) {
            if(pos == -1){
                surrounding_tile = get_surrounding_tile(x2, y2, i);
                coordinates = get_surrounding_tile_coordinates(x2, y2, i);
            }
            else{
                i = 4;
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
//            changeToNull(board, x2, y2);
            return elk_score;  // base case
        }

        else{

            changeToNull(getBoard(), x, y); // makes current tile null // may need to change to x2, y2
            //changeToNull(board, x2, y2);
            x2 = coordinates[0];
            y2 = coordinates[1];

            return elk_score + elk_scoring_1(x2, y2, positions.get(0));
        }
    }

    public static int elk_scoring_2(int x, int y) {         // TODO
        int check = 0;
        int elk_total = 1;


        ArrayList<Integer[]> elk_found = new ArrayList<Integer[]>();
        int[] surrounding_tile = {-1,-1};

        int[] original_tile = {-1,-1};


        changeToNull(getBoard(), x, y);

        for (int i=0; i<6; i++) {
            surrounding_tile = get_surrounding_tile_coordinates(x, y, i+1);
            if (!(surrounding_tile[0] < 0 || surrounding_tile[1] < 0 || surrounding_tile[0] > Board.MAXSIZE || surrounding_tile[1] > Board.MAXSIZE) && getBoard()[surrounding_tile[0]][surrounding_tile[1]] != null && getBoard()[surrounding_tile[0]][surrounding_tile[1]].getAnimals().charAt(0) == 'e'){

                elk_found.add(new Integer [] {surrounding_tile[0], surrounding_tile[1]});
                elk_total++;
            }
        }


        while(check < elk_found.size()){

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


        return elk_score_calculate(elk_total, 2);
    }


    public static int elk_scoring_3(int x, int y) {         // TODO
        return 0;
    }
}
