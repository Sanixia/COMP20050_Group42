public class Starter_Tile_Printer {

    // Note: N will represent null animal
    private static final String bigBlank = "            ";
    private static final String smallBlank = "   ";
    private static final String blankSix = "\n      ";



    // Hardcoded for now
    public static void starter_tile_printout(String starterType) {

        switch (starterType) {
            case "Forest":

                System.out.println(blankSix + Tile_Colours.FOREST_COLOUR + bigBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + " E  " + Tile_Colours.ELK_COLOUR + "  " + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + "      " + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.FOREST_COLOUR + bigBlank + Tile_Colours.RESET
                );
                System.out.println(Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.WETLAND_COLOUR + bigBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.HAWK_COLOUR + " H  " + Tile_Colours.ELK_COLOUR + "E " + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.FOX_COLOUR + " F  " + Tile_Colours.SALMON_COLOUR + "S " + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.BEAR_COLOUR + " B    " + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + "      " + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.RIVER_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.PRAIRIE_COLOUR + bigBlank + Tile_Colours.RESET
                );
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



                /*
                System.out.print(Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.MOUNTAIN_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + " B  " + Tile_Colours.ELK_COLOUR + "H " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET  + Tile_Colours.MOUNTAIN_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + " B  " + Tile_Colours.ELK_COLOUR + "H " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + " S    " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + " S    " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.MOUNTAIN_COLOUR + bigBlank+ Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR + bigBlank+ Tile_Colours.RESET
                );

                 */




                /* 2 tiles seperated

                System.out.print(2 + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                        + "\n1" + Tile_Colours.MOUNTAIN_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + " B  " + Tile_Colours.ELK_COLOUR + "H " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n2" + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + " S    " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n4" + Tile_Colours.MOUNTAIN_COLOUR + bigBlank+ Tile_Colours.RESET
                );
                System.out.println(3 + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                        +"\n3" + bigBlank + Tile_Colours.MOUNTAIN_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + " B  " + Tile_Colours.ELK_COLOUR + "H " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        +"\n5" + bigBlank + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + " S    " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        +"\n7" + bigBlank + Tile_Colours.MOUNTAIN_COLOUR + bigBlank+ Tile_Colours.RESET
                );

                */

                /*
                System.out.println(Tile_Colours.FOREST_COLOUR + "           " + Tile_Colours.RESET
                        + "\n" + Tile_Colours.FOREST_COLOUR + "   " + Tile_Colours.RESET + " B H " + Tile_Colours.MOUNTAIN_COLOUR + "   " + Tile_Colours.RESET
                        + "\n" + Tile_Colours.FOREST_COLOUR + "   " + Tile_Colours.RESET + " S   " + Tile_Colours.MOUNTAIN_COLOUR + "   " + Tile_Colours.RESET
                        + "\n" + Tile_Colours.MOUNTAIN_COLOUR + "           " + Tile_Colours.RESET
                );
                 */


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



                /*     USED FOR SPRINT 2

                System.out.println( blankSix + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.MOUNTAIN_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + " B  " + Tile_Colours.ELK_COLOUR + "H " + Tile_Colours.BLUE_BACKGROUND + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + " S    " + Tile_Colours.BLUE_BACKGROUND + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.BLUE_BACKGROUND + bigBlank+ Tile_Colours.RESET
                );

                System.out.println( blankSix + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.BLUE_BACKGROUND+ smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + " B  " + Tile_Colours.ELK_COLOUR + "H " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.BLUE_BACKGROUND + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + " S    " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.BLUE_BACKGROUND + "            " + Tile_Colours.RESET
                );

                System.out.println( blankSix + Tile_Colours.BLUE_BACKGROUND + "      " + Tile_Colours.MOUNTAIN_COLOUR + "      " + Tile_Colours.RESET
                        + blankSix + Tile_Colours.BLUE_BACKGROUND+ smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + " B  " + Tile_Colours.ELK_COLOUR + "H " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.BLUE_BACKGROUND + smallBlank + Tile_Colours.RESET + Tile_Colours.ELK_COLOUR + " S    " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.BLUE_BACKGROUND + "      " + Tile_Colours.MOUNTAIN_COLOUR + "      " + Tile_Colours.RESET
                );

                 */

        }

    }


    // Idea: array.split ex, FM_B for forest mountian bear, then
    /*public static String[] habitat_tile_setup(String biomeTile) {

        return switch (biomeTile) {
            case "FW" -> new String[]{Tile_Colours.FOREST_COLOUR, Tile_Colours.WETLAND_COLOUR};
            case "FR" -> new String[]{Tile_Colours.FOREST_COLOUR, Tile_Colours.RIVER_COLOUR};
            case "FM" -> new String[]{Tile_Colours.FOREST_COLOUR, Tile_Colours.MOUNTAIN_COLOUR};
            case "FP" -> new String[]{Tile_Colours.FOREST_COLOUR, Tile_Colours.PRAIRIE_COLOUR};
            case "WR" -> new String[]{Tile_Colours.WETLAND_COLOUR, Tile_Colours.RIVER_COLOUR};
            case "WM" -> new String[]{Tile_Colours.WETLAND_COLOUR, Tile_Colours.MOUNTAIN_COLOUR};
            case "WP" -> new String[]{Tile_Colours.WETLAND_COLOUR, Tile_Colours.PRAIRIE_COLOUR};
            case "RM" -> new String[]{Tile_Colours.RIVER_COLOUR, Tile_Colours.MOUNTAIN_COLOUR};
            case "RP" -> new String[]{Tile_Colours.RIVER_COLOUR, Tile_Colours.PRAIRIE_COLOUR};
            case "MP" -> new String[]{Tile_Colours.MOUNTAIN_COLOUR, Tile_Colours.PRAIRIE_COLOUR};
            case "F" -> new String[]{Tile_Colours.FOREST_COLOUR};
            case "W" -> new String[]{Tile_Colours.WETLAND_COLOUR};
            case "R" -> new String[]{Tile_Colours.RIVER_COLOUR};
            case "M" -> new String[]{Tile_Colours.MOUNTAIN_COLOUR};
            case "P" -> new String[]{Tile_Colours.PRAIRIE_COLOUR};
            default -> new String[]{};
        };



    }

    public static void habitat_tile_printout(String[] biomeTile, String animalTile) {
        if (biomeTile.length == 1){
            System.out.println(blankSix + biomeTile[0] + bigBlank + Tile_Colours.RESET
                    + blankSix + biomeTile[0] + smallBlank + Tile_Colours.RESET + Tile_Colours.FOX_COLOUR + " " + "F" + "  " + Tile_Colours.RESET + "  " + biomeTile[0] + smallBlank + Tile_Colours.RESET
                    + blankSix + biomeTile[0] + smallBlank + Tile_Colours.RESET  + "      " + biomeTile[0] + smallBlank + Tile_Colours.RESET
                    + blankSix + biomeTile[0] + bigBlank + Tile_Colours.RESET
            );
        }
        else{
            System.out.println(biomeTile[0] + bigBlank + Tile_Colours.RESET
                    + "\n" + biomeTile[0] + smallBlank + Tile_Colours.RESET + Tile_Colours.SALMON_COLOUR + " " + "S" + "  " + Tile_Colours.ELK_COLOUR + "E" + " " + biomeTile[1] + smallBlank + Tile_Colours.RESET
                    + "\n" + biomeTile[0] + smallBlank + Tile_Colours.RESET + Tile_Colours.HAWK_COLOUR + " " + "H" + "    " + biomeTile[1] + smallBlank + Tile_Colours.RESET
                    + "\n" + biomeTile[1] + bigBlank + Tile_Colours.RESET
            );
        }
    }

     */

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
