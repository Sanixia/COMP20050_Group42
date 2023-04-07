import java.util.ArrayList;

public class Scoring_Bear extends Scoring_Cards
{
    public Scoring_Bear(String biome, String animals, int rotation) {
        super(biome, animals, rotation);
    }

    public static int bear_scoring_1(int x, int y) {                   // returns 1 if it's a pair of bears


        ArrayList<Integer> positions = new ArrayList<Integer>();

        for (int i=0; i<6; i++) {               // will only check to the right, bottom right, bottom left to not count any tiles that were before it
            Board surrounding_tile = get_surrounding_tile(x, y, i+1);
            if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == 'b'){
                positions.add(i+1);
            }
        }


        //ArrayList<Integer> positions = new ArrayList<Integer>(get_surround_array(x, y, 1, 6, 'b'));

        if (positions.size()==1) {
            int x2 = get_surrounding_row(x, y, positions.get(0));
            int y2 = get_surrounding_col(x, y, positions.get(0));


            for (int i=0; i<6; i++) {               // will only check to the right, bottom right, bottom left to not count any tiles that were before it
                Board surrounding_tile = get_surrounding_tile(x2, y2, i+1);
                if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == 'b'){
                    positions.add(i+1);
                }
            }




            //positions.addAll(get_surround_array(x2, y2, 1, 6, 'b'));

            if (positions.size()==2) return 1;
        }

        return 0;
    }

    public static int bear_scoring_2(int x, int y) {        // TODO
        ArrayList<Integer> positions = get_surround_array(x, y, 1, 6, 'b');

        if (positions.size()==2) {
            int x1 = get_surrounding_row(x, y, positions.get(0));
            int y1 = get_surrounding_col(x, y, positions.get(0));
            int x2 = get_surrounding_row(x, y, positions.get(1));
            int y2 = get_surrounding_col(x, y, positions.get(1));
            ArrayList<Integer> positions1 = new ArrayList<Integer>();
            ArrayList<Integer> positions2 = new ArrayList<Integer>();


            for (int i = 0; i < 6; i++) {
                Board surrounding_tile = get_surrounding_tile(x1, y1, i + 1);
                if (surrounding_tile != null && surrounding_tile.getAnimals().charAt(0) == 'b') {
                    positions1.add(i + 1);
                }
            }

            for (int i = 0; i < 6; i++) {
                Board surrounding_tile = get_surrounding_tile(x2, y2, i + 1);
                if (surrounding_tile != null && surrounding_tile.getAnimals().charAt(0) == 'b') {
                    positions2.add(i + 1);
                }
            }

            if (check_beside(positions.get(0), positions.get(1)) && positions1.size()==2 && positions2.size()==2) {
                return 1;
            }
            if (positions1.size() == 1 && positions2.size() == 1) {
                return 3;
            }

        }
        return 0;
    }



    public static int bear_scoring_3(int x, int y) {        // TODO
        ArrayList<Integer> positions = new ArrayList<Integer>();

        for (int i=0; i<6; i++) {               // will only check to the right, bottom right, bottom left to not count any tiles that were before it
            Board surrounding_tile = get_surrounding_tile(x, y, i+1);
            if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == 'b'){
                positions.add(i+1);
            }
        }

        if (positions.size()==0) return 1;

        int x1 = get_surrounding_row(x, y, positions.get(0));
        int y1 = get_surrounding_col(x, y, positions.get(0));
        if (positions.size()==1) {
            for (int i=0; i<6; i++) {               // will only check to the right, bottom right, bottom left to not count any tiles that were before it
                Board surrounding_tile = get_surrounding_tile(x1, y1, i+1);
                if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == 'b'){
                    positions.add(i+1);
                }
            }

            if (positions.size()==2) return 2;
        }
        if (positions.size()==2) {
            int x2 = get_surrounding_row(x, y, positions.get(1));
            int y2 = get_surrounding_col(x, y, positions.get(1));
            ArrayList<Integer> positions1 = new ArrayList<Integer>();
            ArrayList<Integer> positions2 = new ArrayList<Integer>();

            for (int i = 0; i < 6; i++) {
                Board surrounding_tile = get_surrounding_tile(x1, y1, i + 1);
                if (surrounding_tile != null && surrounding_tile.getAnimals().charAt(0) == 'b') {
                    positions1.add(i + 1);
                }
            }

            for (int i = 0; i < 6; i++) {
                Board surrounding_tile = get_surrounding_tile(x2, y2, i + 1);
                if (surrounding_tile != null && surrounding_tile.getAnimals().charAt(0) == 'b') {
                    positions2.add(i + 1);
                }
            }

            if (check_beside(positions.get(0), positions.get(1)) && positions1.size()==2 && positions2.size()==2) {
                return 3;
            }
            if (positions1.size() == 1 && positions2.size() == 1) {
                return 4;
            }
        }
        return 0;
    }

}
