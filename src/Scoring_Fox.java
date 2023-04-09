// Group 42
// Roshan, Michal
// Sanixia, glucoseIntolerant
public class Scoring_Fox extends Scoring_Cards
{
    public Scoring_Fox(String biome, String animals, int rotation) {
        super(biome, animals, rotation);
    }

    public static int fox_scoring_A(int x, int y) {         // returns the number of unique animals around fox tile specified
        int score, b=0, e=0, f=0, s=0, h=0;
        for (int i=1; i<=6; i++) {
            Board surrounding_tile = get_surrounding_tile(x, y, i);
            if (surrounding_tile!=null){                                    // checks for unique animals
                if (surrounding_tile.getAnimals().charAt(0) == 'f') f=1;
                else if (surrounding_tile.getAnimals().charAt(0) == 'e') e=1;
                else if (surrounding_tile.getAnimals().charAt(0) == 'b') b=1;
                else if (surrounding_tile.getAnimals().charAt(0) == 's') s=1;
                else if (surrounding_tile.getAnimals().charAt(0) == 'h') h=1;
            }
        }
        score = b+e+f+s+h;
        return score;
    }

    public static int fox_scoring_B(int x, int y) {         // returns the number of unique pairs around fox tile specified
        int pairs=0, b=0, e=0, f=0, s=0, h=0;
        for (int i=1; i<=6; i++) {
            Board surrounding_tile = get_surrounding_tile(x, y, i);
            if (surrounding_tile!=null){                    // checks for pairs
                if(surrounding_tile.getAnimals().charAt(0) == 'e') e++;
                else if(surrounding_tile.getAnimals().charAt(0) == 'b') b++;
                else if(surrounding_tile.getAnimals().charAt(0) == 's') s++;
                else if(surrounding_tile.getAnimals().charAt(0) == 'h') h++;
            }
        }
        if (b>=2) pairs++;
        if (e>=2) pairs++;
        if (s>=2) pairs++;
        if (h>=2) pairs++;
        return pairs;
    }

    public static int fox_scoring_C(int x, int y) {         // returns the score of fox tile specified
        int b=0, e=0, f=0, s=0, h=0;
        for (int i=1; i<=6; i++) {
            Board surrounding_tile = get_surrounding_tile(x, y, i);
            if (surrounding_tile!=null){                     // same as fox but adds +1 for every appearance
                if(surrounding_tile.getAnimals().charAt(0) == 'e') e++;
                else if(surrounding_tile.getAnimals().charAt(0) == 'b') b++;
                else if(surrounding_tile.getAnimals().charAt(0) == 's') s++;
                else if(surrounding_tile.getAnimals().charAt(0) == 'h') h++;
            }
        }
        return Math.max(b, Math.max(e, Math.max(s, h)));    // returns the max animals
    }
}
