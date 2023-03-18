////TODO CAN DELETE FILE LATER REPLACED BY EX.java
public class Tile_Printer
{
    // Declaring constants to make printing more efficient
    // Naming scheme: sp6_R refers to 6 empty spaces with a reset
    private static final String reset = Tile_Colours.RESET;
    private static final String sp12_R = "            " + reset;
    private static final String sp6_R = "      " + reset;
    private static final String sp3_R = "   " + reset;
    private static final String sp6 = "      ";
    private static final String sp3 = "   ";


    // function which gets the necessary biome colours before passing on to main print function
    // Note: cases aren't commutative i.e. FW works but WF does not
    public static String print_tile_setup(String biome_tile, int rotation, String animals)
    {
        String col1 = null, col2 = null;
        String animals_with_space = animals + "   ";        // adding 3 empty spaces to avoid program crashing in middle_section function

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
        // Printing keystone tiles
        if (colour2 == null)
        {
            return long_section(colour1) + body(colour1, colour1, animals) + long_section(colour1);
        }

        // Switch case for printing double biome tiles in each of their rotations
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


    public static void main(String[] args)  // some tests
    {
        System.out.println(print_tile_setup("FW", 1,"EHS") + "POSITION 1");
        System.out.println(print_tile_setup("FW", 2,"B") + "POSITION 2");
        System.out.println(print_tile_setup("FW", 3,"BS") + "POSITION 3");
        System.out.println(print_tile_setup("FW", 4,"EFH") + "POSITION 4");
        System.out.println(print_tile_setup("FW", 5,"FH") + "POSITION 5");
        System.out.println(print_tile_setup("FW", 6,"S") + "POSITION 6\n\n");
        System.out.println(print_tile_setup("RM", 3,"H"));
        System.out.println(print_tile_setup("R", 3,"BE"));
        System.out.println(print_tile_setup("WP", 5,"BFS"));
        System.out.println(print_tile_setup("M", 3,"BE"));
    }
}
