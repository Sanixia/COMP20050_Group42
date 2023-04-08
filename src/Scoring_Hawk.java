import java.util.ArrayList;
// Group 42
// Roshan, Michal
// Sanixia, glucoseIntolerant
public class Scoring_Hawk extends Scoring_Cards
{
    public Scoring_Hawk(String biome, String animals, int rotation) {
        super(biome, animals, rotation);
    }

    private static ArrayList<Integer[]> hawk_found = new ArrayList<Integer[]>();
    public static ArrayList<Integer[]> getHawk_found() {
        return hawk_found;
    }

    public static int hawk_scoring_1(int x, int y) {     // returns 1 if hawk tile specified is valid and 0 otherwise
        int num_hawks=1;
        ArrayList<String> animals = new ArrayList<String>();

        for (int i=0; i<6; i++) {
            Board surrounding_tile = get_surrounding_tile(x, y, i+1);
            if (surrounding_tile!=null){
                animals.add(surrounding_tile.getAnimals());
            }
        }
        if (animals.contains("h")) num_hawks=0;
        return num_hawks;
    }

    public static int hawk_scoring_2(int x, int y) {    // returns 1 if hawk tile specified is valid and 0 otherwise
        int num_hawks=0;
        int check = 0;


        int x2 = x, y2 = y;

        Board surrounding_tile = null;
        int[] coordinates = new int[2];
        ArrayList<Integer> animals = new ArrayList<Integer>();

        for (int i=0; i<6; i++) {
            surrounding_tile = get_surrounding_tile(x2, y2, i + 1);
            if (surrounding_tile != null && surrounding_tile.getAnimals().charAt(0) == 'h') {
                return 0;

            } else if (surrounding_tile != null && Character.isUpperCase(surrounding_tile.getAnimals().charAt(0))) {
                animals.add(i + 1);
            }
        }

        if(animals.size() == 0) {
            return 0;
        }

        for(int j = 0; j < animals.size(); j++) {

            coordinates = get_surrounding_tile_hawk(x2, y2, animals.get(j));
            if (coordinates[0] < 0 || coordinates[1] < 0 || coordinates[0] >= MAXSIZE || coordinates[1] >= MAXSIZE) {
                continue;
            }
            if(getBoard()[coordinates[0]][coordinates[1]]  == null  || getBoard()[coordinates[0]][coordinates[1]].getAnimals().charAt(0) != 'h'){
                continue;
            }


            for(int k = 0; k < 6; k++) {
                surrounding_tile = get_surrounding_tile(coordinates[0], coordinates[1], k + 1);

                if ((k + 1 != reverse_position(animals.get(j))) && (surrounding_tile == null || surrounding_tile.getAnimals().charAt(0) != 'h')) {
                    check++;
                }
            }

            if(check < 5){
                check = 0;
                continue;
            }
            else{
                num_hawks = 1;
            }
            check = 0;

        }
        return num_hawks;


    }

    public static int hawk_scoring_3(int x, int y) {

        int num_hawks=0;

        int x2 = x, y2 = y;

        int[] surrounding_tile_original = {x2,y2};
        Board surrounding_tile = null;
        int[] coordinates = new int[2];
        ArrayList<Integer> animals = new ArrayList<Integer>();



        for (int i=0; i<6; i++) {
            surrounding_tile = get_surrounding_tile(x2, y2, i + 1);
            if (surrounding_tile != null && surrounding_tile.getAnimals().charAt(0) == 'h') {
                return 0;
            } else if (surrounding_tile != null && Character.isUpperCase(surrounding_tile.getAnimals().charAt(0))) {
                animals.add(i + 1);
            }
        }

        if(animals.size() == 0) {
            return 0;
        }


        for(int j = 0; j < animals.size(); j++) {

            surrounding_tile = get_surrounding_tile(x2, y2, animals.get(j));



            coordinates = get_surrounding_tile_coordinates(x2, y2, animals.get(j));
            if (coordinates[0] < 0 || coordinates[1] < 0 || coordinates[0] >= MAXSIZE || coordinates[1] >= MAXSIZE) {
                continue;
            }
            x2 = coordinates[0];
            y2 = coordinates[1];



            while (surrounding_tile != null && Character.isUpperCase(surrounding_tile.getAnimals().charAt(0))) {
                coordinates = get_surrounding_tile_coordinates(x2, y2, animals.get(j));
                surrounding_tile = get_surrounding_tile(x2, y2, animals.get(j));

                if (coordinates[0] < 0 || coordinates[1] < 0 || coordinates[0] >= MAXSIZE || coordinates[1] >= MAXSIZE) {

                    x2 = surrounding_tile_original[0];
                    y2 = surrounding_tile_original[1];
                    break;
                }

                if (surrounding_tile != null && surrounding_tile.getAnimals().charAt(0) == 'h') {
                    if(!deepContains(hawk_found, new Integer[]{coordinates[0], coordinates[1]})){
                        num_hawks++;
                    }
                    x2 = surrounding_tile_original[0];
                    y2 = surrounding_tile_original[1];
                    break;
                }

                if(surrounding_tile == null){
                    x2 = surrounding_tile_original[0];
                    y2 = surrounding_tile_original[1];
                    break;
                }

                x2 = coordinates[0];
                y2 = coordinates[1];
            }

        }

        hawk_found.add(new Integer[]{x, y});
        return num_hawks;

    }
}
