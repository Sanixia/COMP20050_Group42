import java.util.ArrayList;

public class Scoring_Habitat_Tiles extends Scoring_Cards{


    public Scoring_Habitat_Tiles(String biome, String animals, int rotation) {
        super(biome, animals, rotation);
    }

    public static int[] habitat_score(int x, int y, int[] habitat_tiles){

        Board current_habitat = getBoard()[x][y];

        // if the habitat is a single biome

        if(current_habitat.getBiome().length() == 1){
            habitat_tiles = calculate_habitat_score(current_habitat.getBiome().charAt(0), 1, x, y, habitat_tiles);
        }

        // if the habitat is a double biome eg, "RM"
        else{
            habitat_tiles = calculate_habitat_score(current_habitat.getBiome().charAt(0), 2, x, y, habitat_tiles);
            habitat_tiles = calculate_habitat_score(current_habitat.getBiome().charAt(1), 2, x, y, habitat_tiles);
        }

        return habitat_tiles;

    }

    // TODO make an x and y getter for board tiles

    public static int[] calculate_habitat_score(char habitat, int amount_of_habitats_to_check, int x, int y, int[] habitat_tiles) {


        ArrayList<Integer[]> tiles_found = new ArrayList<Integer[]>();
        int x2 = x, y2 = y;
        int tiles_found_index = 0;
        int habitat_index = habitat_to_score(habitat);

        // add the current tile to the list of tiles found so it doesn't get checked again
        tiles_found.add(new Integer[]{x2, y2});
        Board current_tile;


        // keep increasing tiles_found index until all tiles have been checked in arraylist (which increases when it finds some as well)
        while (tiles_found_index < tiles_found.size()) {

            x2 = tiles_found.get(tiles_found_index)[0];
            y2 = tiles_found.get(tiles_found_index)[1];

            current_tile = getBoard()[tiles_found.get(tiles_found_index)[0]][tiles_found.get(tiles_found_index)[1]];


            // if the habitat is a keystone biome or not
            if (current_tile.getBiome().length() == 1) {
                amount_of_habitats_to_check = 1;
            } else {
                amount_of_habitats_to_check = 2;
            }


            if (amount_of_habitats_to_check == 1) {

                // check all 6 surrounding tiles
                for (int i = 0; i < 6; i++) {

                    // if the tile is not null and the tile is the same biome as the habitat we are checking
                    if (get_surrounding_tile(x2, y2, i + 1) != null && get_surrounding_tile(x2, y2, i + 1).getBiome().contains(Character.toString(habitat))) {

                        // if the colour is in position 1 or 2 eg, "RM"
                        int index_of_character = get_surrounding_tile(x2, y2, i + 1).getBiome().indexOf(habitat);

                        // check if it is in the correct rotation to touching the current tile
                        if (check_rotation(i + 1, get_surrounding_tile(x2, y2, i + 1), index_of_character)) {


                            int[] coordinates = get_surrounding_tile_coordinates(x2, y2, i + 1);

                            // if it is not already contained in the arraylist, add it
                            if (!deepContains(tiles_found, new Integer[]{coordinates[0], coordinates[1]})) {
                                tiles_found.add(new Integer[]{coordinates[0], coordinates[1]});
                            }

                        }

                    }
                }
            }

            else{

                int index_of_current_tile  = current_tile.getBiome().indexOf(habitat);

                if(index_of_current_tile == 0){

                }



            }

            tiles_found_index++;

        }


        if (tiles_found.size() > habitat_tiles[habitat_index]) {
            habitat_tiles[habitat_index] = tiles_found.size();
        }

        return habitat_tiles;
    }



    public static boolean check_rotation(int i, Board current_habitat, int index_of_character){
        int rotation = current_habitat.getRotation();

        if(index_of_character == 0){

            switch (i){
                case 1:
                    return (rotation == 1 || rotation == 2 || rotation == 3 || rotation == 6);

                case 2:
                    return (rotation == 2 || rotation == 3 || rotation == 4 || rotation == 6);

                case 3:
                    return (rotation == 3 || rotation == 4 || rotation == 5 || rotation == 6);

                case 4:
                    return (rotation == 0 || rotation == 4 || rotation == 5 || rotation == 6);

                case 5:
                    return (rotation == 0 || rotation == 1 || rotation == 5 || rotation == 6);

                case 6:
                    return (rotation == 0 || rotation == 1 || rotation == 2 || rotation == 6);
            }
        }

        else {

            switch (i) {
                case 1:
                    return (rotation == 0 || rotation == 4 || rotation == 5 || rotation == 6);

                case 2:
                    return (rotation == 0 || rotation == 1 || rotation == 5 || rotation == 6);

                case 3:
                    return (rotation == 0 || rotation == 1 || rotation == 2 || rotation == 6);

                case 4:
                    return (rotation == 1 || rotation == 2 || rotation == 3 || rotation == 6);

                case 5:
                    return (rotation == 2 || rotation == 3 || rotation == 4 || rotation == 6);

                case 6:
                    return (rotation == 3 || rotation == 4 || rotation == 5 || rotation == 6);
            }
        }


        return false;
    }


    public static int habitat_to_score(char habitat){

        return switch (habitat) {
            case 'F' -> 0;
            case 'W' -> 1;
            case 'R' -> 2;
            case 'M' -> 3;
            case 'P' -> 4;
            default -> -1; // for errors
        };

    }











}
