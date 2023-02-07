import java.util.ArrayList;
import java.util.Arrays;
public class Wildlife_Tokens {
    static ArrayList<String> tokens = new ArrayList<>(
            Arrays.asList("B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B","B",
                    "E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E",
                    "F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F",
                    "H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H",
                    "S","S","S","S","S","S","S","S","S","S","S","S","S","S","S","S","S","S","S","S")
    );

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            System.out.println((i+1) +"  "+ tokens.get(i));
        }
    }
}
