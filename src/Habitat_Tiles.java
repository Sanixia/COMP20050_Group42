public class Habitat_Tiles
{
    /* System of using 2 arrays to create the habitat tiles, one for biomes, the other for the animals that can be placed
       A given index for the biome array will correspond to the animals array

       For biomes:  F - Forest, W - Wetland, R - River, M - Mountain, P - Prairie
       For animals: B - Grizzly Bear, E - Roosevelt Elk, F - Red Fox, H - Red Tailed Hawk, S - Chinook Salmon

       All tiles are exact to the ones from the original game */


    // Note: change to arraylist later
    public static String[] biome = {"F","F","F","F","F", "W","W","W","W","W", "R","R","R","R","R", "M","M","M","M","M", "P","P","P","P","P",
                      "FW","FW","FW","FW","FW","FW", "FR","FR","FR","FR","FR","FR", "FM","FM","FM","FM","FM","FM", "FP","FP","FP","FP","FP","FP",
                      "WR","WR","WR","WR","WR","WR", "WM","WM","WM","WM","WM","WM", "WP","WP","WP","WP","WP","WP",
                      "RM","RM","RM","RM","RM","RM", "RP","RP","RP","RP","RP","RP", "MP","MP","MP","MP","MP","MP"};
                                // B, E, F, H, S   // RM    RP    MP
    public static String[] animals = {"E","B","B","F","F", "H","F","F","S","S", "S","B","B","E","E", "B","E","E","H","H", "F","E","E","S","S",
                        "BES","BF","BS","FH","ES","EH", "EFH","FS","BE","EH","BF","BS", "BEF","BEH","EF","EH","BF","BH", "EFS","BF","FS","BE","EF","ES",
                        "BHS","BS","HS","FH","BH","FS", "BHS","BES","BS","HS","EH","EF", "EFS","FHS","FH","EF","ES","HS",
                        "BHS","BE","BH","EH","HS","BS", "BFS","BFH","FH","EH","ES","BF", "BEF","BFS","BS","EH","FH","ES"};

    public static void main(String[] args) {
        for (int i = 0; i < 85; i++) {
            System.out.println(i + " biome: " + biome[i] + "   animal: " +animals[i]);
        }
    };
};




