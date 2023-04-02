import java.util.Arrays;
import java.util.Random;

public class WildLife_Scoring_Card {


    public static int[] scoring_card_array(int[] array){
        long seed = System.nanoTime();
        Random random = new Random(seed);

        for(int i = 0; i < 5; i++){
            array[i] = random.nextInt(3) + 1;
        }
        return array;
    }

    public static void print_scoring_card(int[] array){
        scoring_card_array(array);
        System.out.println("\n\n----- SCORING CARDS FOR EACH WILDLIFE -----\n\n");

        for(int i = 0; i < 5; i++){
            switch (i){
                case 0 -> bear(array[i]);
                case 1 -> elk(array[i]);
                case 2 -> fox(array[i]);
                case 3 -> hawk(array[i]);
                case 4 -> salmon(array[i]);
            }
        }
    }

    public static void bear (int type_of_card){
        if(type_of_card == 1){
            System.out.println("----- BEAR SCORING CARD (A) -----\n");
            System.out.println("Score points for total number of pairs of Bears.");
            System.out.println("A pair of Bears is exactly two Bears adjacent to each other with no other adjacent Bears.\n\n");
        }
        else if(type_of_card == 2){
            System.out.println("----- BEAR SCORING CARD (B) -----\n");
            System.out.println("Score 10 points per group of 3 Bears only.");
            System.out.println("A group of 3 Bears is exactly three Bears adjacent to each other with no other adjacent Bears.\n\n");
        }
        else if(type_of_card == 3){
            System.out.println("----- BEAR SCORING CARD (C) -----\n");
            System.out.println("Score points for each group of one, two or three Bears");
            System.out.println("Each group of Bears may not have any other Bears adjacent to it.");
            System.out.println("If you have one of each group of Bears, you get a bonus of 3 points.\n\n");
        }
    }

    public static void elk (int type_of_card){
        if(type_of_card == 1){
            System.out.println("----- ELK SCORING CARD (A) -----\n");
            System.out.println("Score points for each straight line of adjacent Elk, depending on the number of Elk in the line.");
            System.out.println("A straight line of Elk is a line of Elk that are adjacent to each other with no other adjacent Elk.");
            System.out.println("Lines do not need to be horizontal.\n\n");
        }
        else if (type_of_card == 2) {
            System.out.println("----- ELK SCORING CARD (B) -----\n");
            System.out.println("Score points for each contiguous group of adjacent Elk in any shape, depending on the size of the group.\n\n");
        }
        else if(type_of_card == 3){
            System.out.println("----- ELK SCORING CARD (C) -----\n");
            System.out.println("Score points for each group of Elk in each exact shape (or 1, 2 3 and 4).");
            System.out.println("Two groups of Elk may be adjacent to one another, however, each Elk may only be count for a single group. ");
            System.out.println("Groups may be rotated\n\n");
        }
    }

    public static void fox (int type_of_card){
        if(type_of_card == 1){
            System.out.println("----- FOX SCORING CARD (A) -----\n");
            System.out.println("Score points for each Fox, depending on the number of unique,wildlife types adjacent to it.");
            System.out.println("Other Foxes may be scored as unique when scoring each Fox.\n\n");
        }
        else if(type_of_card == 2){
            System.out.println("----- FOX SCORING CARD (B) -----\n");
            System.out.println("Score points for each Fox, depending on the number of unique pairs of other wildlife types adjacent to it.");
            System.out.println("Other adjacent Fox pairs do not score.");
            System.out.println("Each pair of other wildlife must be unique - the same wildlife may not count for more than one pair, even if four or six of that wildlife are adjacent.");
            System.out.println("Pairs of wildlife do not need to be adjacent to each other.\n\n");
        }
        else if(type_of_card == 3){
            System.out.println("----- FOX SCORING CARD (C) -----\n");
            System.out.println("Score points for each Fox, depending on the number of a single wildlife type adjacent to it. ");
            System.out.println("Other adjacent Foxes may not be scored.\n\n");
        }
    }

    public static void hawk (int type_of_card){
        if(type_of_card == 1){
            System.out.println("----- HAWK SCORING CARD (A) -----\n");
            System.out.println("Score points for each Hawk for total number of Hawks that are not adjacent to any other Hawks.\n\n");
        }
        else if(type_of_card == 2){
            System.out.println("----- HAWK SCORING CARD (B) -----\n");
            System.out.println("Score points for each Hawk, based on it's line of sight to any other Hawks that are not directly adjacent.");
            System.out.println("Line of sight is not interrupted by a gap in Habitat Tiles, or by other wildlife.\n\n");
        }
        else if(type_of_card == 3){
            System.out.println("----- HAWK SCORING CARD (C) -----\n");
            System.out.println("Score 3 points for each pair of Hawks that share a direct line of sight between them.");
            System.out.println("Each Hawk may be counted as part of multiple pairs.");
            System.out.println("Line of sight is not interrupted by a gap in Habitat Tiles, or by other wildlife.\n\n");
        }
    }

    public static void salmon (int type_of_card){
        if(type_of_card == 1){
            System.out.println("----- SALMON SCORING CARD (A) -----\n");
            System.out.println("Score points for each run of Salmon, depending on the number/length of Salmon in the run.");
            System.out.println("A run if defined as a group of adjacent Salmon where each Salmon is adjacent to no more than no more than two other Salmon.");
            System.out.println("A group of three Salmon in a triangle shape may count as a run, but no other Salmon may be attached to this run.");
            System.out.println("Each run of Salmon may not have any other Salmon adjacent to it.\n\n");
        }
        else if(type_of_card == 2){
            System.out.println("----- SALMON SCORING CARD (B) -----\n");
            System.out.println("Score points for each run of Salmon, depending on the number/length of Salmon in the run.");
            System.out.println("A run if defined as a group of adjacent Salmon where each Salmon is adjacent to no more than no more than two other Salmon.");
            System.out.println("A group of three Salmon in a triangle shape may count as a run, but no other Salmon may be attached to this run.");
            System.out.println("Each run of Salmon may not have any other Salmon adjacent to it.\n\n");
        }
        else if(type_of_card == 3){
            System.out.println("----- SALMON SCORING CARD (C) -----\n");
            System.out.println("Score points for each run of Salmon, depending on the number/length of Salmon in the run.");
            System.out.println("A run if defined as a group of adjacent Salmon where each Salmon is adjacent to no more than no more than two other Salmon.");
            System.out.println("A group of three Salmon in a triangle shape may count as a run, but no other Salmon may be attached to this run.");
            System.out.println("Each run of Salmon may not have any other Salmon adjacent to it.\n\n");
        }

    }

}
