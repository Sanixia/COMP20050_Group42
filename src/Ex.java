import java.util.ArrayList;

public class Ex
{
    // Declaring constants to make printing more efficient
    // Naming scheme: sp6_R refers to 6 empty spaces with a reset
    private static final String reset = Tile_Colours.RESET;
    private static final String sp12_R = "            " + reset;
    private static final String sp6_R = "      " + reset;
    private static final String sp3_R = "   " + reset;
    private static final String sp12 = "            ";
    private static final String sp6 = "      ";
    private static final String sp3 = "   ";

    // half and full empty tile spaces for the board
    private static final String half_tile = "H_null_null";
    private static final String tile = "T_null_null";
    private static final String newline = "\n";


    // function which gets the necessary biome colours before passing on to main print function
    // Note: cases aren't commutative i.e. FW works but WF does not
    public static String print_tile_setup(String tile)
    {
        // TODO make those 5 lines into function
        String[] arrOfStr = tile.split("_");

        String biome_tile = arrOfStr[0];
        //Integer rotation = Integer.parseInt(arrOfStr[1]);
        String rotation = arrOfStr[1];
        String animals = arrOfStr[2] + "   "; // adding 3 empty spaces to avoid program crashing in middle_section function

        String col1 = null, col2 = null;

        switch (biome_tile) {
            case "H": return empty_half_tiles();
            case "T": return empty_tiles();
            case "F": col1=Tile_Colours.FOREST_COLOUR;  break;
            case "W": col1=Tile_Colours.WETLAND_COLOUR;  break;
            case "R": col1=Tile_Colours.RIVER_COLOUR;  break;
            case "M": col1=Tile_Colours.MOUNTAIN_COLOUR;  break;
            case "P": col1=Tile_Colours.PRAIRIE_COLOUR;  break;
            case "FW": col1=Tile_Colours.FOREST_COLOUR; col2=Tile_Colours.WETLAND_COLOUR; break;
            case "FR": col1=Tile_Colours.FOREST_COLOUR; col2=Tile_Colours.RIVER_COLOUR; break;
            case "FM": col1=Tile_Colours.FOREST_COLOUR; col2=Tile_Colours.MOUNTAIN_COLOUR; break;
            case "FP": col1=Tile_Colours.FOREST_COLOUR; col2=Tile_Colours.PRAIRIE_COLOUR; break;
            case "WR": col1=Tile_Colours.WETLAND_COLOUR; col2=Tile_Colours.RIVER_COLOUR; break;
            case "WM": col1=Tile_Colours.WETLAND_COLOUR; col2=Tile_Colours.MOUNTAIN_COLOUR; break;
            case "WP": col1=Tile_Colours.WETLAND_COLOUR; col2=Tile_Colours.PRAIRIE_COLOUR; break;
            case "RM": col1=Tile_Colours.RIVER_COLOUR; col2=Tile_Colours.MOUNTAIN_COLOUR; break;
            case "RP": col1=Tile_Colours.RIVER_COLOUR; col2=Tile_Colours.PRAIRIE_COLOUR; break;
            case "MP": col1=Tile_Colours.MOUNTAIN_COLOUR; col2=Tile_Colours.PRAIRIE_COLOUR; break;
            default: break;
        }
        return tile_printout(col1, col2, rotation, animals);
    }

    public static String tile_printout(String colour1, String colour2, String rotation, String animals)
    {
        // Printing keystone tiles
        if (colour2 == null)
        {
            return long_section(colour1) + body(colour1, colour1, animals) + long_section(colour1);
        }

        // Switch case for printing double biome tiles in each of their rotations
        else {
            switch (rotation) {
                case "1": return long_section_dual(colour2, colour1) + body(colour2, colour1, animals) + long_section_dual(colour2, colour1);

                case "2": return long_section(colour2) + body(colour2, colour1, animals) + long_section(colour1);

                case "3": return long_section(colour2) + body(colour1, colour2, animals) + long_section(colour1);

                case "4": return long_section_dual(colour1, colour2) + body(colour1, colour2, animals) + long_section_dual(colour1, colour2);

                case "5": return long_section(colour1) + body(colour1, colour2, animals) + long_section(colour2);

                case "6": return long_section(colour1) + body(colour2, colour1, animals) + long_section(colour2);
                default:
                    break;
            }
        }
        return null;
    }

    // Prints out one coloured roof / floors
    public static String long_section(String colour) {
        return colour + sp12_R + "\n";
    }

    // Prints out two coloured roof / floor for when the double biomes are divided vertically
    public static String long_section_dual(String colour1, String colour2) {
        return colour1 + sp6 + colour2 +sp6_R + "\n";
    }

    // Prints out the body of a tile; the sides, animals and empty spaces
    public static String body(String colour1, String colour2, String animals) {
        return sides_section(colour1) + middle_section(animals.charAt(0)) + middle_section(animals.charAt(1)) + sides_section(colour2) + "\n"
                + sides_section(colour1) + middle_section(animals.charAt(2)) + sp3 + sides_section(colour2) +"\n";
    }

    public static String sides_section(String colour) {
        return colour + sp3_R;
    }

    // Printing out animal (or empty) character spaces with their respective colours
    public static String middle_section(char animal) {
        String colour;
        switch (animal) {
            case 'B': colour = Tile_Colours.BEAR_COLOUR;
                return " " + colour + "B" + reset + " ";
            case 'E': colour = Tile_Colours.ELK_COLOUR;
                return " " + colour + "E" + reset + " ";
            case 'F': colour = Tile_Colours.FOX_COLOUR;
                return " " + colour + "F" + reset + " ";
            case 'H': colour = Tile_Colours.HAWK_COLOUR;
                return " " + colour + "H" +  reset + " ";
            case 'S': colour = Tile_Colours.SALMON_COLOUR;
                return " " + colour + "S" +  reset + " ";
            default:
                return sp3;
        }
    }

    public static String empty_half_tiles() {
        return sp6;
    }

    public static String empty_tiles() {
        return sp12;
    }

    static ArrayList<String> board = new ArrayList<>();


    public static void main(String[] args)
    {



        board.add(half_tile);
        board.add(encoder("F", "0", "E"));
        board.add(newline);
        board.add(encoder("RM", "5", "BEH"));
        board.add(encoder("WP", "6", "FS"));

        /*
        //board.add(half_tile);
        board.add(encoder("M", "1", "B"));
        board.add(encoder("FW", "5", "EHF"));
        board.add(encoder("RP", "6", "BS"));

        board.add(half_tile);
        board.add(encoder("W", "1", "H"));
        board.add(encoder("FR", "2", "EHS"));
        board.add(encoder("MP", "3", "BF"));


        board.add(half_tile);
        board.add(encoder("P", "1", "F"));
        board.add(encoder("WR", "5", "FHS"));
        board.add(encoder("FM", "6", "BE"));



        board.add(half_tile);
        board.add(encoder("F", "1", "E"));
        board.add(encoder("RM", "2", "BEH"));
        board.add(encoder("WP", "6", "FS"));

        board.add(half_tile);
        board.add(encoder("R", "1", "S"));
        board.add(encoder("FP", "2", "BES"));
        board.add(encoder("WM", "3", "FH"));
         */

        /* // old tile printer
        for (int n=0; n<board.size(); n++) {
            System.out.println(Tile_Printer.print_tile_setup(board.get(n)));
        } */



        // TODO put into a FUNCTION

        int n = board.size();

        String row, line_1 = "", line_2 = "", line_3 = "", line_4 = ""; //, tile_str;

        for (int i=0; i<n; i++) {
            // tile_str = board.get(i);

            if (!board.get(i).equals(newline)) {
                String tile = print_tile_setup(board.get(i));
                line_1 += splitter(tile, 0);
                line_2 += splitter(tile, 1);
                line_3 += splitter(tile, 2);
                line_4 += splitter(tile, 3);
            }

            if (board.get(i) == newline || i == n-1) {
                row = line_1 + "\n" + line_2 + "\n" + line_3 + "\n" + line_4;
                System.out.println(row);
                row = "";
                line_1 = "";
                line_2 = "";
                line_3 = "";
                line_4 = "";
            }
        }

        /* // can be used to test singular tiles
        System.out.println(print_tile_setup("FW", 1,"EHS") + "POSITION 1");
        System.out.println(print_tile_setup("FW", 2,"B") + "POSITION 2");
        System.out.println(print_tile_setup("FW", 3,"BS") + "POSITION 3");
        System.out.println(print_tile_setup("FW", 4,"EFH") + "POSITION 4");
        System.out.println(print_tile_setup("FW", 5,"FH") + "POSITION 5");
        System.out.println(print_tile_setup("FW", 6,"S") + "POSITION 6");
        */
    }

    public static String encoder(String b, String r, String a) { // encodes strings into 1 String
        return b + "_" + r + "_" + a;
    }

    public static String splitter(String str, int line) {

        if (str.contains("\n")) {
            String[] arr_tile = str.split("\n");
            return arr_tile[line];
        } else {
            return str;
        }




    }
}
                