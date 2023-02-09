public class Experimental_Printer
{
    private static final String sp12_R = "            " + Tile_Colours.RESET;
    private static final String sp6_R = "      " + Tile_Colours.RESET;
    private static final String sp3_R = "   " + Tile_Colours.RESET;
    private static final String sp6 = "      ";
    private static final String sp3 = "   ";


    public static String print_tile_setup(String biome_tile, int rotation, String animals)
    {
        String col1 = null, col2 = null;
        String animals_with_space = animals + "   ";

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
        return tile_printout(col1, col2, rotation, animals_with_space);
    }


    public static String tile_printout(String colour1, String colour2, int rotation, String animals)
    {
        // Single biome tiles
        if (colour2 == null)
        {
            return long_section(colour1) + body(colour1, colour1, animals) + long_section(colour1);
        }

        // double biome tiles
        else {
            switch (rotation) {
                case 1: return long_section(colour1) + body(colour2, colour1, animals) + long_section(colour2);

                case 2: return long_section_dual(colour2, colour1) + body(colour2, colour1, animals) + long_section_dual(colour2, colour1);

                case 3: return long_section(colour2) + body(colour2, colour1, animals) + long_section(colour1);

                case 4: return long_section(colour2) + body(colour1, colour2, animals) + long_section(colour1);

                case 5: return long_section_dual(colour1, colour2) + body(colour1, colour2, animals) + long_section_dual(colour1, colour2);

                case 6: return long_section(colour1) + body(colour1, colour2, animals) + long_section(colour2);

                default:
                    break;
            }
        }
        return null;
    }


    public static String long_section(String colour) {
        return colour + sp12_R + "\n";
    }

    public static String long_section_dual(String colour1, String colour2) {
        return colour1 + sp6 + colour2 +sp6_R + "\n";
    }

    public static String body(String colour1, String colour2, String animals) {
        return sides_section(colour1) + middle_section(animals.charAt(0)) + middle_section(animals.charAt(1)) + sides_section(colour2) + "\n"
                + sides_section(colour1) + middle_section(animals.charAt(2)) + sp3 + sides_section(colour2) +"\n";
    }

    public static String sides_section(String colour) {
        return colour + sp3_R;
    }

    public static String middle_section(char animal) {
        switch (animal) {
            case 'B':
                return " B ";
            case 'E':
                return " E ";
            case 'F':
                return " F ";
            case 'H':
                return " H ";
            case 'S':
                return " S ";
            default:
                return sp3;
        }
    }


    public static void main(String[] args)
    {
        System.out.println(print_tile_setup("FW", 1,"EHS") + "POSITION 1");
        System.out.println(print_tile_setup("FW", 2,"B") + "POSITION 2");
        System.out.println(print_tile_setup("FW", 3,"BS") + "POSITION 3");
        System.out.println(print_tile_setup("FW", 4,"EFH") + "POSITION 4");
        System.out.println(print_tile_setup("FW", 5,"FH") + "POSITION 5");
        System.out.println(print_tile_setup("FW", 6,"S") + "POSITION 6");
        System.out.println(print_tile_setup("RM", 3,"H"));
        System.out.println(print_tile_setup("RP", 5,"BFS"));
        System.out.println(print_tile_setup("M", 3,"BE"));
/*
        String m = "E";
        m = m + "  ";
        char a = m.charAt(1);
        char b;
        char c;

        System.out.println(a);
 */
    }

}
