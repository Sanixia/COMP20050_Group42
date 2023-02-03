public class Tile_Colours {
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";



    // Declaring the colors
    public static final String ANSI_black = "\u001B[30m";
    public static final String ANSI_red = "\u001B[31m";
    public static final String ANSI_green = "\u001B[32m";
    public static final String ANSI_yellow = "\u001B[33m";
    public static final String ANSI_blue = "\u001B[34m";
    public static final String ANSI_purple = "\u001B[35m";
    public static final String ANSI_cyan = "\u001B[36m";
    public static final String ANSI_white = "\u001B[37m";


    // Declaring the background colors
    public static final String ANSI_BACK_black = "\u001B[40m";
    public static final String ANSI_BACK_red = "\u001B[41m";
    public static final String ANSI_BACK_green = "\u001B[42m";
    public static final String ANSI_BACK_yellow = "\u001B[43m";
    public static final String ANSI_BACK_blue = "\u001B[44m";
    public static final String ANSI_BACK_purple = "\u001B[45m";
    public static final String ANSI_BACK_cyan = "\u001B[46m";
    public static final String ANSI_BACK_white = "\u001B[47m";


    // Main driver method
    public static void main(String[] args)
    {
        System.out.println(ANSI_BACK_green + "           " + ANSI_RESET
                + "\n" + ANSI_BACK_green + "   " + ANSI_RESET + " B H " + ANSI_BACK_cyan + "   " + ANSI_RESET
                + "\n" + ANSI_BACK_green + "   " + ANSI_RESET + " S   " + ANSI_BACK_cyan + "   " + ANSI_RESET
                + "\n" + ANSI_BACK_cyan + "           " + ANSI_RESET
        );

        System.out.println("\n" + ANSI_BACK_green + "           " + ANSI_RESET
                + "\n" + ANSI_BACK_green + "   " + ANSI_RESET + ANSI_cyan + " B " + ANSI_purple + "H " + ANSI_BACK_cyan + "   " + ANSI_RESET
                + "\n" + ANSI_BACK_green + "   " + ANSI_RESET + ANSI_red + " S   " + ANSI_BACK_cyan + "   " + ANSI_RESET
                + "\n" + ANSI_BACK_cyan + "           " + ANSI_RESET
        );
    }
}
