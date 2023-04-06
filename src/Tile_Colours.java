public class Tile_Colours
{
    //// File that contains all colours for Biomes and Animals

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Biome colours
    public static final String FOREST_COLOUR = "\033[42m";  // DARK GREEN
    public static final String MOUNTAIN_COLOUR = "\033[48;5;250m";// GREY
    public static final String PRAIRIE_COLOUR= "\033[0;103m";// YELLOW
    public static final String WETLAND_COLOUR = "\033[48;5;154m";// LIGHT GREEN
    public static final String RIVER_COLOUR = "\033[0;104m";// BLUE
    public static final String HIGHLIGHT_SLOT_COLOUR = "\u001B[47m";    // Slot tile colour

    // Animals placed down colours
    public static final String HAWK_COLOUR = "\033[38;5;69m";   // CYAN
    public static final String BEAR_COLOUR = "\033[38;5;94m";  // GOLDEN BROWN
    public static final String FOX_COLOUR = "\033[38;5;166m";  // ORANGE
    public static final String ELK_COLOUR = "\033[38;5;106m";  // GREEN
    public static final String SALMON_COLOUR = "\033[38;5;160m";    // RED

    // Background colours
    public static final String HAWK_COLOUR_BACKGROUND = "\033[48;5;69m";   // CYAN
    public static final String BEAR_COLOUR_BACKGROUND = "\033[48;5;94m";  // GOLDEN BROWN
    public static final String FOX_COLOUR_BACKGROUND = "\033[48;5;166m";  // ORANGE
    public static final String ELK_COLOUR_BACKGROUND = "\033[48;5;106m";  // GREEN
    public static final String SALMON_COLOUR_BACKGROUND = "\033[48;5;160m";    // RED
}
