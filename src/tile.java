import java.util.ArrayList;

public class tile {

    private String biome;
    private String animals;
    private int rotation;
    private int position;

    static ArrayList<ArrayList<tile>> board = new ArrayList<>();;

    public tile(String biome, String animals, int rotation, int position) {
        this.biome = biome;
        this.animals = animals;
        this.rotation = rotation;
        this.position = position;
    }

    public String getBiome() {
        return biome;
    }
    public String getAnimals() {
        return animals;
    }
    public int getRotation() {
        return rotation;
    }
    public int getPosition() {
        return position;
    }

    public void setAnimals(String animals) {
        this.animals = animals;
    }
    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
    public void setPosition(int position) {
        this.position = position;
    }


    public static void main(String[] args)
    {
        board.add(new ArrayList<>());
        board.add(new ArrayList<>());
        board.add(new ArrayList<>());
        board.add(new ArrayList<>());

        board_add_tile("F", "BES", 0, 0, 1);
        board_add_tile("RM", "BEH", 0, 1, 0);
        board_add_tile("WP", "FS", 0, 1, 1);
        //place_animal_token("b", 0, 0);
        print_board();
    }

    public static void board_add_tile(String biome, String animals, int rotation, int row, int pos) {
        tile tile = new tile(biome, animals, rotation, pos);
        board.get(row).add(tile);
    }

    public static void place_animal_token(String animals, int row, int pos) {
        board.get(row).get(pos).setAnimals(animals);
    }

    public static void print_board() {
        for (int i=0; i<board.size(); i++) {
            Ex.row_printer(board.get(i), 2);
        }
    }
}
