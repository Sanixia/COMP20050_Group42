public class Starter_Tile_Printer {

    // Note: N will represent null animal
    private static final String bigBlank = "            ";
    private static final String smallBlank = "   ";
    private static final String blankSix = "\n      ";




    // Hardcoded for now
    public static void starter_tile_printout(String starterType) {

        switch (starterType) {
            case "Forest":



                tile.setupBoard();

                tile.board_add_tile("F","E" , 0, 0, 1);
                tile.board_add_tile("RM","BEH" , 6, 1, 0);
                tile.board_add_tile("WP","FS" , 6, 1, 1);
                tile.print_board();








                /*
                Ex.tile.add(half_tile);
                Ex.tile.add(Ex.encoder("F", "0", "E"));
                Ex.tile.add(newline);
                Ex.tile.add(Ex.encoder("RM", "5", "BEH"));
                Ex.tile.add(Ex.encoder("WP", "6", "FS"));
                Ex.printTiles();
                 */



                break;
            case "Mountain":

                System.out.println(blankSix + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.BEAR_COLOUR + " B  " + Tile_Colours.ELK_COLOUR + "  " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + "      " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                );

                System.out.println(Tile_Colours.FOREST_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.RIVER_COLOUR + bigBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.HAWK_COLOUR + " H  " + Tile_Colours.ELK_COLOUR + "E " + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.BEAR_COLOUR + " B  " + Tile_Colours.SALMON_COLOUR + "S " + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.FOX_COLOUR + " F    " + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + "      " + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.WETLAND_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.PRAIRIE_COLOUR + bigBlank + Tile_Colours.RESET
                );



                break;

            case "Prairie":
                System.out.println(blankSix + Tile_Colours.PRAIRIE_COLOUR + bigBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.FOX_COLOUR + " F  " + Tile_Colours.ELK_COLOUR + "  " + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + "      " + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.PRAIRIE_COLOUR + bigBlank + Tile_Colours.RESET
                );
                System.out.println(Tile_Colours.WETLAND_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.FOREST_COLOUR + bigBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.SALMON_COLOUR + " S  " + Tile_Colours.HAWK_COLOUR + "H " + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.BEAR_COLOUR + " B  " + Tile_Colours.ELK_COLOUR + "E " + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.FOX_COLOUR + " F    " + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + "      " + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.RIVER_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                );
                break;

            case "Wetland":
                System.out.println(blankSix + Tile_Colours.WETLAND_COLOUR + bigBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.HAWK_COLOUR + " H  " + Tile_Colours.ELK_COLOUR + "  " + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + "      " + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.WETLAND_COLOUR + bigBlank + Tile_Colours.RESET
                );
                System.out.println(Tile_Colours.RIVER_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.PRAIRIE_COLOUR + bigBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.SALMON_COLOUR + " S  " + Tile_Colours.ELK_COLOUR + "E " + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.BEAR_COLOUR + " B  " + Tile_Colours.FOX_COLOUR + "F " + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.HAWK_COLOUR + " H    " + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + "      " + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.FOREST_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                );
                break;

            case "River":
                System.out.println(blankSix + Tile_Colours.RIVER_COLOUR + bigBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.SALMON_COLOUR + " S  " + Tile_Colours.ELK_COLOUR + "  " + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + "      " + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.RIVER_COLOUR + bigBlank + Tile_Colours.RESET
                );
                System.out.println(Tile_Colours.PRAIRIE_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.SALMON_COLOUR + " S  " + Tile_Colours.ELK_COLOUR + "E " + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.FOX_COLOUR + " F  " + Tile_Colours.HAWK_COLOUR + "H " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.BEAR_COLOUR + " B    " + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + "      " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.FOREST_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.WETLAND_COLOUR + bigBlank + Tile_Colours.RESET
                );
        }
    }


    public static String token_printer(String animal) {
        String colour;
        String reset  = Tile_Colours.RESET;
        switch (animal) {
            case "B" : colour = Tile_Colours.BEAR_COLOUR_BACKGROUND;
                return colour + " B " + reset;
            case "E": colour = Tile_Colours.ELK_COLOUR_BACKGROUND;
                return colour + " E " + reset;
            case "F": colour = Tile_Colours.FOX_COLOUR_BACKGROUND;
                return colour + " F " + reset;
            case "H": colour = Tile_Colours.HAWK_COLOUR_BACKGROUND;
                return colour + " H " +  reset ;
            case "S": colour = Tile_Colours.SALMON_COLOUR_BACKGROUND;
                return colour + " S " +  reset;
            default:
                return null;
        }
    }

}
