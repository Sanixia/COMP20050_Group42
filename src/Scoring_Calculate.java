import java.util.ArrayList;

public class Scoring_Calculate extends Scoring_Setup
{
    public Scoring_Calculate(String biome, String animals, int rotation) {
        super(biome, animals, rotation);
    }

    public static int fox_scoring_1(int x, int y) {         // returns the number of unique animals around fox tile specified
        int score, b=0, e=0, f=0, s=0, h=0;
        for (int i=0; i<6; i++) {
            tile2D surrounding_tile = get_surrounding_tile(x, y, i+1);
            if (surrounding_tile!=null){
                if (surrounding_tile.getAnimals().charAt(0) == 'f') f=1;
                if (surrounding_tile.getAnimals().charAt(0) == 'e') e=1;
                if (surrounding_tile.getAnimals().charAt(0) == 'b') b=1;
                if (surrounding_tile.getAnimals().charAt(0) == 's') s=1;
                if (surrounding_tile.getAnimals().charAt(0) == 'h') h=1;
            }
        }
        score = b+e+f+s+h;
        return score;
    }

    public static int fox_scoring_2(int x, int y) {         // returns the number of unique pairs around fox tile specified
        int pairs=0, b=0, e=0, f=0, s=0, h=0;
        for (int i=0; i<6; i++) {
            tile2D surrounding_tile = get_surrounding_tile(x, y, i+1);
            if (surrounding_tile!=null){
                if(surrounding_tile.getAnimals().charAt(0) == 'f') f++;
                if(surrounding_tile.getAnimals().charAt(0) == 'e') e++;
                if(surrounding_tile.getAnimals().charAt(0) == 'b') b++;
                if(surrounding_tile.getAnimals().charAt(0) == 's') s++;
                if(surrounding_tile.getAnimals().charAt(0) == 'h') h++;
            }
        }
        if (b>=2) pairs++;
        if (e>=2) pairs++;
        if (f>=2) pairs++;
        if (s>=2) pairs++;
        if (h>=2) pairs++;
        return pairs;
    }

    public static int fox_scoring_3(int x, int y) {         // returns the score of fox tile specified
        int b=0, e=0, f=0, s=0, h=0;
        for (int i=0; i<6; i++) {
            tile2D surrounding_tile = get_surrounding_tile(x, y, i+1);
            if (surrounding_tile!=null){
                if(surrounding_tile.getAnimals().charAt(0) == 'f') f++;
                if(surrounding_tile.getAnimals().charAt(0) == 'e') e++;
                if(surrounding_tile.getAnimals().charAt(0) == 'b') b++;
                if(surrounding_tile.getAnimals().charAt(0) == 's') s++;
                if(surrounding_tile.getAnimals().charAt(0) == 'h') h++;
            }
        }
        return Math.max(b, Math.max(e, Math.max(f, Math.max(s, h))));
    }

    public static int bear_scoring_1(int x, int y) {                   // returns 1 if it's a pair of bears
        ArrayList<Integer> positions = new ArrayList<Integer>();

        for (int i=0; i<6; i++) {               // will only check to the right, bottom right, bottom left to not count any tiles that were before it
            tile2D surrounding_tile = get_surrounding_tile(x, y, i+1);
            if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == 'b'){
                positions.add(i+1);
            }
        }
        if (positions.size()==1) {
            int x2 = get_surrounding_row(x, y, positions.get(0));
            int y2 = get_surrounding_col(x, y, positions.get(0));

            for (int i=0; i<6; i++) {               // will only check to the right, bottom right, bottom left to not count any tiles that were before it
                tile2D surrounding_tile = get_surrounding_tile(x2, y2, i+1);
                if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == 'b'){
                    positions.add(i+1);
                }
            }

            if (positions.size()==2) return 1;
        }

        return 0;
    }

    public static int bear_scoring_2(int x, int y) {        // TODO
        return 0;
    }
    public static int bear_scoring_3(int x, int y) {        // TODO
        return 0;
    }

    public static int salmon_scoring_2(int x, int y) {      // TODO complete
        ArrayList<Integer> positions = new ArrayList<Integer>();

        for (int i=0; i<6; i++) {               // will only check to the right, bottom right, bottom left to not count any tiles that were before it
            tile2D surrounding_tile = get_surrounding_tile(x, y, i+1);
            if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == 's'){
                positions.add(i+1);
            }
        }
        if (positions.size()==0) return 1;
        if (positions.size()==1) {
            int salmon_count=0;
            while (positions.size()<3) {
                salmon_count++;
                int x2 = get_surrounding_row(x, y, positions.get(0));
                int y2 = get_surrounding_col(x, y, positions.get(0));
                positions.clear();

                for (int i=0; i<6; i++) {
                    tile2D surrounding_tile = get_surrounding_tile(x2, y2, i+1);
                    if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == 's'){
                        positions.add(i+1);
                    }
                }
            }
            return salmon_count;

        }
        return 0;
    }

    public static int salmon_scoring_1(int x, int y) {      // TODO
        ArrayList<Integer> positions = new ArrayList<Integer>();
        int num_salmon=0, previous;

        for (int i=0; i<6; i++) {               // will only check to the right, bottom right, bottom left to not count any tiles that were before it
            tile2D surrounding_tile = get_surrounding_tile(x, y, i+1);
            if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == 's'){
                positions.add(i+1);
            }
        }
        System.out.println("a");
        if (positions.size()==0) return 1;
        if (positions.size()==1) {
            int temp;
            int x2 = get_surrounding_row(x, y, positions.get(0));
            int y2 = get_surrounding_col(x, y, positions.get(0));
            previous = reverse_position(positions.get(0));
            positions.add(0);
            num_salmon++;
            System.out.println("b");

            while(positions.size()>1) {
                System.out.println("c");
                num_salmon++;
                positions.clear();
                for (int i=0; i<6; i++) {
                    tile2D surrounding_tile = get_surrounding_tile(x2, y2, i+1);
                    if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == 's'){
                        positions.add(i+1);
                    }
                }

                if (positions.size()==2 && check_beside(positions.get(0), positions.get(1))) {
                    if (positions.get(0)==previous) {
                        temp = x2;
                        x2 = get_surrounding_row(x2, y2, positions.get(0));
                        y2 = get_surrounding_col(temp, y2, positions.get(0));
                    } else {
                        temp = x2;
                        x2 = get_surrounding_row(x2, y2, positions.get(1));
                        y2 = get_surrounding_col(temp, y2, positions.get(1));
                    }
                } else {
                    return num_salmon;
                }
            }
        }
        return 0;
    }

    public static int salmon_scoring_3(int x, int y) {      // TODO
        return 0;
    }


    public static int elk_scoring_1(int x, int y) {         // TODO
        ArrayList<Integer> positions = new ArrayList<Integer>();

        for (int i=2; i<5; i++) {
            tile2D surrounding_tile = get_surrounding_tile(x, y, i+1);
            if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == 'e'){
                positions.add(i+1);
            }
        }
        if (positions.size()==0) return 1;  // base case

        if (positions.size()>1) {
        }

        return 0;
    }

    public static int elk_scoring_2(int x, int y) {         // TODO
        return 0;
    }

    public static int elk_scoring_3(int x, int y) {         // TODO
        return 0;
    }


    public static int hawk_scoring_1(int x, int y) {     // returns 1 if hawk tile specified is valid and 0 otherwise
        int num_hawks=1;
        ArrayList<String> animals = new ArrayList<String>();

        for (int i=0; i<6; i++) {
            tile2D surrounding_tile = get_surrounding_tile(x, y, i+1);
            if (surrounding_tile!=null){
                animals.add(surrounding_tile.getAnimals());
            }
        }
        if (animals.contains("h")) num_hawks=0;
        return num_hawks;
    }

    public static int hawk_scoring_2(int x, int y) {        // TODO
        return 0;
    }

    public static int hawk_scoring_3(int x, int y) {        // TODO
        return 0;
    }


    public static void tile_scoring(int x, int y, int MAXSIZE) {        // todo implement last
        //String biome = board[x][y].getBiome();
    }
}
