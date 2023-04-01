import java.util.ArrayList;
import java.util.Arrays;

public class Habitat_Tiles
{
    /* System of using 2 arrays to create the habitat tiles, one for biomes, the other for the animals that can be placed
       A given index for the biome array will correspond to the animals array

       For biomes:  F - Forest, W - Wetland, R - River, M - Mountain, P - Prairie
       For animals: B - Grizzly Bear, E - Roosevelt Elk, F - Red Fox, H - Red Tailed Hawk, S - Chinook Salmon

       All tiles are exact to the ones from the original game */

    static ArrayList<String> biome = new ArrayList<>(
            Arrays.asList("F","F","F","F","F",  "W","W","W","W","W",  "R","R","R","R","R",  "M","M","M","M","M",  "P","P","P","P","P",
                    "FW","FW","FW","FW","FW","FW",  "FR","FR","FR","FR","FR","FR",  "FM","FM","FM","FM","FM","FM",
                    "FP","FP","FP","FP","FP","FP",  "WR","WR","WR","WR","WR","WR",  "WM","WM","WM","WM","WM","WM",
                    "WP","WP","WP","WP","WP","WP",  "RM","RM","RM","RM","RM","RM",  "RP","RP","RP","RP","RP","RP",
                    "MP","MP","MP","MP","MP","MP")
    );

    static ArrayList<String> animals = new ArrayList<>(
            Arrays.asList("E","B","B","F","F",  "B","B","F","F","F","F",  "B","B","F","F","F","F",  "B","B","F","F","F","F",  "B","B","F","F","F","F",
                    "B","B","F","F","F","F",  "B","B","F","F","F","F",  "B","B","F","F","F","F",
                    "B","B","F","F","F","F",  "B","B","F","F","F","F",  "B","B","F","F","F","F",
                    "B","B","F","F","F","F",  "B","B","F","F","F","F",  "B","B","F","F","F","F",
                    "B","B","F","F","F","F")
    );



};




