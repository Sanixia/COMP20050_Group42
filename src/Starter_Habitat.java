import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;


public class Starter_Habitat {

    //array split for animal colour print out

    public static ArrayList<String> getStarter_Habitat_Tiles() {
        return Starter_Habitat_Tiles;
    }


    public static void setStarter_Habitat_Tiles(ArrayList<String> starter_Habitat_Tiles) {
        Starter_Habitat_Tiles = starter_Habitat_Tiles;
    }

    private static ArrayList<String> Starter_Habitat_Tiles = new ArrayList<>(
            Arrays.asList("Forest",
                        "Mountain",
                        "Prairie",
                        "Wetland",
                        "River"
            ));







}
