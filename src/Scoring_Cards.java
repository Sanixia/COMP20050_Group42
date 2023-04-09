import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Group 42
// Roshan, Michal
// Sanixia, glucoseIntolerant
public class Scoring_Cards extends Scoring_Setup
{
    public Scoring_Cards(String biome, String animals, int rotation) {
        super(biome, animals, rotation);
    }

    public static ArrayList<Integer> get_surround_array(int x, int y, int start, int end, char animal) {    // returns a tile around specified tile
        ArrayList<Integer> surround_positions = new ArrayList<Integer>();
        for (int i=start; i<=end; i++) {
            Board surrounding_tile = get_surrounding_tile(x, y, i);
            if (surrounding_tile!=null && surrounding_tile.getAnimals().charAt(0) == animal){
                surround_positions.add(i+1);
            }
        }
        return surround_positions;
    }


    public static int[] get_surrounding_tile_coordinates(int x, int y, int pos) {     // returns a tile around specified tile
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
        if (row==x && col==y) return new int[] {-1,-1};
        return new int[] {row, col};
    }

    public static int[] get_surrounding_tile_hawk(int x, int y, int pos) {     // returns a tile around specified tile
        int plusOne = calculateSpace(x);
        int row = x;
        int col = y;
        int[] arr = {-1,-1};
        if (pos==1 && row-1>=0 && col-1+plusOne>=0) {
            row -= 2;
            col -= 1;                                     // top left
        } if (pos==2 && row-1>=0 && col+plusOne<=MAXSIZE) {
            row -= 2;
            col += 1;                                         // top right
        } if (pos==3 && col+1<=MAXSIZE) {
            col += 2;                                                  // right
        }if (pos==4 && row+1<=MAXSIZE && col+plusOne<=MAXSIZE) {
            row += 2;
            col += 1;                                         // bottom right
        }if (pos==5 && row+1<=MAXSIZE && col-1+plusOne<=MAXSIZE) {
            row += 2;
            col -= 1;                                     // bottom left
        }if (pos==6 && col-1>=0) {
            col -= 2;                                                  // left
        }

        if (row==x && col==y) return new int[] {-1,-1};
        return new int[] {row, col};
    }

    public static int get_surrounding_row(int x, int y, int pos) {     // returns row of specified surround tile
        int row = x;
        if (pos==1||pos==2) return row-1;
        if (pos==4||pos==5) return row+1;
        return row;
    }

    public static int get_surrounding_col(int x, int y, int pos) {     // returns column of specified surround tile
        int plusOne = calculateSpace(x);
        int col = y;
        if (!(pos==3 || pos==6)) col += plusOne;
        if (pos==1 || pos==5 || pos==6) return col-1;
        else if (pos==3) return col+1;
        return col;
    }

    public static boolean check_beside(int a, int b) {   // checks if two positions are beside each other
        return (a == 6 && b == 1) || (a == 1 && b == 6) || (a - b == 1 || b - a == 1);
    }

    public static int reverse_position(int x) {    // returns the opposite position
        return switch (x) {
            case 1 -> 4;
            case 2 -> 5;
            case 3 -> 6;
            case 4 -> 1;
            case 5 -> 2;
            case 6 -> 3;
            default -> 0;
        };
    }

    public static boolean deepContains(List<Integer[]> list, Integer[] probe) {
        for (Integer[] element : list) {
            if (Arrays.deepEquals(element, probe)) {
                return true;
            }
        }
        return false;
    }
}
