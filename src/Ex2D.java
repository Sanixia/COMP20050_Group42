public class Ex2D
{
    // Declaring constants to make printing more efficient
    // Naming scheme: sp6_R refers to 6 empty spaces with a reset
    private static final String reset = Tile_Colours.RESET;
    private static final String sp12_R = "            " + reset;
    private static final String sp6_R = "      " + reset;
    private static final String sp3_R = "   " + reset;
    private static final String sp6 = "      ";
    private static final String sp3 = "   ";
    private static final String newline = "\n";

    public static String column_numbers(int max_col) {
        String row_str = "  ";

        for (int i=0; i<max_col; i++) {
            row_str+= sp6 + "    ";
            if (i<9) row_str += " ";
            row_str+= i;
        }
        return row_str;
    }


    public static String row_printer(tile2D[] arr, int max, int space, String row_num) {
        int pos;
        String row_str, line_1 = "\t", line_2 = row_num + "  ", line_3 = "\t", line_4 = "\t", tile_print;
        tile2D t;

        if (row_num.length() == 1) line_2+=" ";

        if (space == 1){
            line_1 += splitter(blank_space(), 0);
            line_2 += splitter(blank_space(), 1);
            line_3 += splitter(blank_space(), 2);
            line_4 += splitter(blank_space(), 3);
            max--;
        }

        for (int i=0; i<max; i++) {
            t = arr[i];
            tile_print = print_tile_setup(t);

            line_1 += splitter(tile_print, 0);
            line_2 += splitter(tile_print, 1);
            line_3 += splitter(tile_print, 2);
            line_4 += splitter(tile_print, 3);
        }

        row_str = line_1 + "\n" + line_2 + "\n" + line_3 + "\n" + line_4;
        return row_str;
    }

    // function which gets the necessary biome colours before passing on to main print function
    // Note: cases aren't commutative i.e. FW works but WF does not
    public static String print_tile_setup(tile2D tile)
    {
        if (tile == null) return null;

        String biome_tile = tile.getBiome();
        String animals = tile.getAnimals() + "   "; // adding 3 empty spaces to avoid program crashing in middle_section function
        int rotation = tile.getRotation();

        String col1 = null, col2 = null;

        switch (biome_tile) {
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

    public static String tile_printout(String colour1, String colour2, int rotation, String animals)
    {
        // Printing keystone tiles
        if (colour2 == null)
        {
            return long_section(colour1) + body(colour1, colour1, animals) + long_section(colour1);
        }

        // Switch case for printing double biome tiles in each of their rotations
        else {
            switch (rotation) {
                case 1: return long_section_dual(colour2, colour1) + body(colour2, colour1, animals) + long_section_dual(colour2, colour1);

                case 2: return long_section(colour2) + body(colour2, colour1, animals) + long_section(colour1);

                case 3: return long_section(colour2) + body(colour1, colour2, animals) + long_section(colour1);

                case 4: return long_section_dual(colour1, colour2) + body(colour1, colour2, animals) + long_section_dual(colour1, colour2);

                case 5: return long_section(colour1) + body(colour1, colour2, animals) + long_section(colour2);

                case 6: return long_section(colour1) + body(colour2, colour1, animals) + long_section(colour2);
                default:
                    return long_section(colour1) + body(colour2, colour1, animals) + long_section(colour2);
            }
        }
    }

    //// Line by line printing functions
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

            case 'b': colour = Tile_Colours.BEAR_COLOUR_BACKGROUND;
                return colour + " B " + reset;
            case 'e': colour = Tile_Colours.ELK_COLOUR_BACKGROUND;
                return colour + " E " + reset;
            case 'f': colour = Tile_Colours.FOX_COLOUR_BACKGROUND;
                return colour + " F " + reset;
            case 'h': colour = Tile_Colours.HAWK_COLOUR_BACKGROUND;
                return colour + " H " +  reset;
            case 's': colour = Tile_Colours.SALMON_COLOUR_BACKGROUND;
                return colour + " S " +  reset;
            default:
                return sp3;
        }
    }


    public static String blank_tile() {
        return empty_left() + empty_right() + newline + empty_body() + newline + empty_left() + empty_right();
    }
    public static String blank_left() {
        return empty_left() + newline + empty_left_side() + newline + empty_left_side() + newline + empty_left();
    }
    public static String blank_right() {
        return empty_left() + newline + empty_left_side() + newline + empty_left_side() + newline + empty_left();
    }
    public static String blank_space() {
        return empty() + newline + empty() + newline + empty() + newline + empty();
    }


    public static String empty_left() {
        return "+-----";
    }
    public static String empty() {
        return "      ";
    }
    public static String empty_right() {
        return "-----+";
    }
    public static String empty_left_side() {
        return "|     ";
    }
    public static String empty_right_side() {
        return "     |";
    }
    public static String empty_body() {
        return empty_left_side() + empty_right_side() + newline + empty_left_side() + empty_right_side();
    }



    public static String splitter(String str, int line) {
        if (str == null) str = blank_tile();
        if (str.contains("\n")) {
            String[] arr_tile = str.split("\n");
            return arr_tile[line];
        } else {
            return str;
        }
    }
}
