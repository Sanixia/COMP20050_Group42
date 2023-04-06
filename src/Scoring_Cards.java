import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scoring_Cards extends Scoring_Setup
{
    public Scoring_Cards(String biome, String animals, int rotation) {
        super(biome, animals, rotation);
    }


    public static boolean deepContains(List<Integer[]> list, Integer[] probe) {
        for (Integer[] element : list) {
            if (Arrays.deepEquals(element, probe)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> get_surround_array(int x, int y, int start, int end, char animal) {
        ArrayList<Integer> surround_positions = new ArrayList<Integer>();
        for (int i=start; i<=end; i++) {
            Board surrounding_tile = get_surrounding_tile(x, y, i);
            if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == animal){
                surround_positions.add(i+1);
            }
        }
        return surround_positions;
    }

}
