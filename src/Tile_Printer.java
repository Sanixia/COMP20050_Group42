public class Tile_Printer {

    // Note: N will represent null animal
    private static final String bigBlank = "            ";
    private static final String smallBlank = "   ";
    private static final String blankSix = "\n      ";

    public static void starter_tile_printout(String starterType){

        switch (starterType){
            case "Forest":

                System.out.println(blankSix + Tile_Colours.FOREST_COLOUR + bigBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.FOREST_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.FOREST_COLOUR + bigBlank+ Tile_Colours.RESET
                );
                System.out.println(Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.WETLAND_COLOUR + bigBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.MOUNTAIN_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.RIVER_COLOUR+ smallBlank + Tile_Colours.RESET  + Tile_Colours.PRAIRIE_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.WETLAND_COLOUR+ smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.RIVER_COLOUR + bigBlank+ Tile_Colours.RESET + Tile_Colours.PRAIRIE_COLOUR+ bigBlank+ Tile_Colours.RESET
                );
                break;
            case "Mountain":

                System.out.println( blankSix + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.MOUNTAIN_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.MOUNTAIN_COLOUR + bigBlank+ Tile_Colours.RESET
                );

                System.out.println(Tile_Colours.FOREST_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.RIVER_COLOUR + bigBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.FOREST_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET  + Tile_Colours.PRAIRIE_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.RIVER_COLOUR+ smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.WETLAND_COLOUR + bigBlank+ Tile_Colours.RESET + Tile_Colours.PRAIRIE_COLOUR+ bigBlank+ Tile_Colours.RESET
                );



                /*
                System.out.print(Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.MOUNTAIN_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET  + Tile_Colours.MOUNTAIN_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.MOUNTAIN_COLOUR + bigBlank+ Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR + bigBlank+ Tile_Colours.RESET
                );

                 */




                /* 2 tiles seperated

                System.out.print(2 + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                        + "\n1" + Tile_Colours.MOUNTAIN_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n2" + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n4" + Tile_Colours.MOUNTAIN_COLOUR + bigBlank+ Tile_Colours.RESET
                );
                System.out.println(3 + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                        +"\n3" + bigBlank + Tile_Colours.MOUNTAIN_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        +"\n5" + bigBlank + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
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
                        + blankSix + Tile_Colours.PRAIRIE_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.PRAIRIE_COLOUR + bigBlank+ Tile_Colours.RESET
                );
                System.out.println(Tile_Colours.WETLAND_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.FOREST_COLOUR+ bigBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.WETLAND_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET  + Tile_Colours.MOUNTAIN_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.FOREST_COLOUR+ smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.RIVER_COLOUR + bigBlank+ Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR+ bigBlank+ Tile_Colours.RESET
                );
                break;

            case "Wetland":
                System.out.println(blankSix + Tile_Colours.WETLAND_COLOUR + bigBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.WETLAND_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.WETLAND_COLOUR + bigBlank+ Tile_Colours.RESET
                );
                System.out.println(Tile_Colours.RIVER_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.PRAIRIE_COLOUR+ bigBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.RIVER_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET  + Tile_Colours.MOUNTAIN_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.PRAIRIE_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.PRAIRIE_COLOUR+ smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.FOREST_COLOUR + bigBlank+ Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR+ bigBlank+ Tile_Colours.RESET
                );
                break;

            case "River":
                System.out.println(blankSix + Tile_Colours.RIVER_COLOUR + bigBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.RIVER_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.RIVER_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.RIVER_COLOUR + bigBlank+ Tile_Colours.RESET
                );
                System.out.println(Tile_Colours.PRAIRIE_COLOUR + bigBlank + Tile_Colours.RESET + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.PRAIRIE_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET  + Tile_Colours.WETLAND_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.PRAIRIE_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.FOREST_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.WETLAND_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.MOUNTAIN_COLOUR+ smallBlank + Tile_Colours.RESET
                        + "\n" + Tile_Colours.FOREST_COLOUR + bigBlank+ Tile_Colours.RESET + Tile_Colours.WETLAND_COLOUR+ bigBlank+ Tile_Colours.RESET
                );



                /*     USED FOR SPRINT 2

                System.out.println( blankSix + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.MOUNTAIN_COLOUR+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.BLUE_BACKGROUND + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.BLUE_BACKGROUND + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.BLUE_BACKGROUND + bigBlank+ Tile_Colours.RESET
                );

                System.out.println( blankSix + Tile_Colours.MOUNTAIN_COLOUR + bigBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.BLUE_BACKGROUND+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.BLUE_BACKGROUND + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.BLUE_BACKGROUND + "            " + Tile_Colours.RESET
                );

                System.out.println( blankSix + Tile_Colours.BLUE_BACKGROUND + "      " + Tile_Colours.MOUNTAIN_COLOUR + "      " + Tile_Colours.RESET
                        + blankSix + Tile_Colours.BLUE_BACKGROUND+ smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " B  " + Tile_Colours.GREEN_BOLD + "H " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.BLUE_BACKGROUND + smallBlank + Tile_Colours.RESET + Tile_Colours.GREEN_BOLD + " S    " + Tile_Colours.MOUNTAIN_COLOUR + smallBlank + Tile_Colours.RESET
                        + blankSix + Tile_Colours.BLUE_BACKGROUND + "      " + Tile_Colours.MOUNTAIN_COLOUR + "      " + Tile_Colours.RESET
                );

                 */
                break;
        }

    }

    public static void habitat_tile_printout(String t){

    }
}
