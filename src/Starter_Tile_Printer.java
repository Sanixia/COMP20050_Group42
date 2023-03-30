public class Starter_Tile_Printer {


    public static String token_printer(String animal) {
        String colour;
        String reset  = Tile_Colours.RESET;
        switch (animal) {
            case "b" : colour = Tile_Colours.BEAR_COLOUR_BACKGROUND;
                return colour + " B " + reset;
            case "e": colour = Tile_Colours.ELK_COLOUR_BACKGROUND;
                return colour + " E " + reset;
            case "f": colour = Tile_Colours.FOX_COLOUR_BACKGROUND;
                return colour + " F " + reset;
            case "h": colour = Tile_Colours.HAWK_COLOUR_BACKGROUND;
                return colour + " H " +  reset ;
            case "s": colour = Tile_Colours.SALMON_COLOUR_BACKGROUND;
                return colour + " S " +  reset;
            default:
                return null;
        }
    }

}
