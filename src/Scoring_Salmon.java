import java.util.ArrayList;
// Group 42
// Roshan, Michal
// Sanixia, glucoseIntolerant
public class Scoring_Salmon extends Scoring_Cards
{

    public Scoring_Salmon(String biome, String animals, int rotation) {
        super(biome, animals, rotation);
    }



    private static ArrayList<Integer[]> salmon_found = new ArrayList<Integer[]>();



    private static int index_salmon = 1;

    public static ArrayList<Integer[]> getSalmon_found() {
        return salmon_found;
    }

    public static void setIndex_salmon(int index_salmon) {
        Scoring_Salmon.index_salmon = index_salmon;
    }

    public static int getIndex_salmon() {
        return index_salmon;
    }

    public static void increaseSalmonIndex() {
        Scoring_Salmon.index_salmon++;
    }

    public static int salmon_scoring(int x, int y, int scoring_card) {

        int x2 = x, y2 = y;
        int amount_of_salmon = 0;
        int check_if_in_list = 0;
        Integer[] original_tile = {x2, y2};
        int[] surrounding_tile = new int[2];
        int original_salmon_amount = 0;
        Integer[] temp_salmon_found = new Integer[2];


        for(int i=0; i<6; i++){
            surrounding_tile = get_surrounding_tile_coordinates(x2, y2, i+1);

            if (!(surrounding_tile[0] < 0 || surrounding_tile[1] < 0 || surrounding_tile[0] >= Board.MAXSIZE || surrounding_tile[1] >= Board.MAXSIZE) &&
                    getBoard()[surrounding_tile[0]][surrounding_tile[1]] != null && getBoard()[surrounding_tile[0]][surrounding_tile[1]].getAnimals().charAt(0) == 's'){


                if(deepContains(salmon_found, new Integer[]{surrounding_tile [0], surrounding_tile [1]})){
                    check_if_in_list--;


                }
                else{
                    temp_salmon_found = new Integer[]{surrounding_tile [0], surrounding_tile [1]};
                    amount_of_salmon++;
                }

            }
        }

        if (amount_of_salmon == 0){

            if(check_if_in_list == -1){

                if(deepContains(salmon_found, original_tile)){
                    return 0;
                }

                return 1;
            }

            else if (check_if_in_list < -1){
                return 0;
            }

            return 1;

        }

        if(check_if_in_list != 0 || amount_of_salmon > 1){
            return 0;
        }



        if(amount_of_salmon == 1 && check_if_in_list == 0){

            salmon_found.add(original_tile);
            salmon_found.add(temp_salmon_found);

            x2 = salmon_found.get(getIndex_salmon())[0];
            y2 = salmon_found.get(getIndex_salmon())[1];



            while(amount_of_salmon > 0){
                original_salmon_amount = amount_of_salmon;
                original_tile = new Integer[]{x2, y2};

                for(int j = 0; j < 6; j++){
                    surrounding_tile = get_surrounding_tile_coordinates(x2, y2, j+1);

                    if (!(surrounding_tile[0] < 0 || surrounding_tile[1] < 0 || surrounding_tile[0] >= Board.MAXSIZE || surrounding_tile[1] >= Board.MAXSIZE) &&
                            getBoard()[surrounding_tile[0]][surrounding_tile[1]] != null &&
                            getBoard()[surrounding_tile[0]][surrounding_tile[1]].getAnimals().charAt(0) == 's' &&
                            !deepContains(salmon_found, new Integer[]{surrounding_tile [0], surrounding_tile [1]})){

                        temp_salmon_found = new Integer[]{surrounding_tile [0], surrounding_tile [1]};
                        amount_of_salmon++;
                    }
                }
                if(amount_of_salmon > original_salmon_amount+1){
                    amount_of_salmon = original_salmon_amount;

                    increaseSalmonIndex();
                    increaseSalmonIndex();

                    break;
                }

                else if(amount_of_salmon == original_salmon_amount+1){

                    salmon_found.add(temp_salmon_found);
                    increaseSalmonIndex();
                    x2 = salmon_found.get(getIndex_salmon())[0];
                    y2 = salmon_found.get(getIndex_salmon())[1];

                }
                else if(amount_of_salmon == original_salmon_amount){
                    increaseSalmonIndex();
                    increaseSalmonIndex();
                    amount_of_salmon++;
                    break;
                }


            }

        }

        return amount_of_salmon;

    }


}
