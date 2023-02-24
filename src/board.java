import java.util.ArrayList;

public class board {

    private String biome;
    private String animals;
    private int rotation;
    private double position;

    static ArrayList<ArrayList<board>> board = new ArrayList<>();;

    public board(String biome, String animals, int rotation, double position) {
        this.biome = biome;
        this.animals = animals;
        this.rotation = rotation;
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
    public double getPosition() {
        return position;
    }

    public void setAnimals(String animals) {
        this.animals = animals;
    }
    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
    public void setPosition(double position) {
        this.position = position;
    }


    public static void main(String[] args)
    {
        board_add_tile("F", "BES", 0, 0, 0);
    }

    public static void board_add_tile(String biome, String animals, int rotation, int row, int pos) {
        board tile = new board(biome, animals, rotation, pos);

        board.add(new ArrayList<>());
        board.add(new ArrayList<>());
        board.add(new ArrayList<>());
        board.get(row).add(tile);
        print_board();
        board.get(row).get(pos).setAnimals("e");
        print_board();
    }

    public static void print_board() {
        for (int i=0; i<board.size(); i++) {
            Ex.row_printer(board.get(i));
        }
    }
}
