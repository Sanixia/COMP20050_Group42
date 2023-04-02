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

        for(int i = 0; i < 5; i++){

        }
    }

    public static void bear (int type_of_card){
        if(type_of_card == 1){
            System.out.println("----- BEAR SCORING CARD (A) -----\n");
            System.out.println("Score points for total number of pairs of Bears.");
            System.out.println("A pair of Bears is exactly two Bears adjacent to each\nother with no other adjacent Bears.");
        }
        else if(type_of_card == 2){
            System.out.println("----- BEAR SCORING CARD (B) -----\n");
            System.out.println("Score 10 points per group of 3 Bears only.");
            System.out.println("A group of 3 Bears is exactly three Bears adjacent to each\nother with no other adjacent Bears.");
        }
        else if(type_of_card == 3){
            System.out.println("----- BEAR SCORING CARD (C) -----\n");
            System.out.println("Score points shown for each group of one, two or three Bears");
            System.out.println("Each group of Bears may not have any other Bears adjacent to it.");
            System.out.println("If you have one of each group of Bears, you get a bonus of 3 points.");
        }
    }

    public static void elk (int type_of_card){
        if(type_of_card == 1){
            System.out.println("----- ELK SCORING CARD (A) -----\n");
            System.out.println("Score points for each straight line of adjacent Elk, depending on the number of Elk in the line.");
            System.out.println("A straight line of Elk is a line of Elk that are adjacent to each other with no other adjacent Elk.");
            System.out.println("Lines do not need to be horizontal.");
        }
        else if (type_of_card == 2) {
            System.out.println("----- ELK SCORING CARD (B) -----\n");
            System.out.println("Score points for each continguous group of adjacent Elk in any shape, depending on the size of the group.");
        }
        else if(type_of_card == 3){
            System.out.println("----- ELK SCORING CARD (C) -----\n");
            System.out.println("Score points for each contiguous group of adjacent Elk in any shape, depending on the size of the group.");
            System.out.println("If you have one of each group of Elk, you get a bonus of 3 points.");
        }
    }

    public static void fox (int type_of_card){
        System.out.println("----- FOX SCORING CARD (A) -----\n");

    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(scoring_card_array(new int[5])));
        System.out.println("There is a table in each wildlife scoring card. The table contains points for wildlife\n" +
                "arrangements of increasing numbers. If an arrangement contains more wildlife than the\n" +
                "largest arrangement in the table, then use the number for the largest arrangement. The rule\n" +
                "is no extra points for overpopulation. For example, for Elk Scoring Card (A), if a straight line\n" +
                "of Elk in the board game has more than four Elk, then the number of points would be 13,\n" +
                "equal to the largest arrangement in the table.\n" +
                "In scoring at the end, finding the best score (optimal solution) may require exploring a large\n" +
                "number of combinations for some wildlife. In this case, your goal is not to develop the most\n" +
                "efficient optimal algorithm since it is not a requirement or feature. Instead, you should aim to\n" +
                "develop a fast algorithm that gives you a near-optimal solution.\n" +
                "Bear\n" +
                "1. For Bear Scoring Gard (A), score points based on the total number of pairs of bears.\n" +
                "Once you select a pair, all the bears adjacent to the bears in this pair must be\n" +
                "excluded from further scoring. Find the score in the table using the number as input.\n" +
                "2. For Bear Scoring Gard (B), ten points per group of 3 bears only. Once you score for a\n" +
                "group, all the bears adjacent to the bears in this group must be excluded from further\n" +
                "scoring.\n" +
                "3. For Bear Scoring Gard (C), first find a group of 3 bears. If you find one, you score 8\n" +
                "points. Exclude all bears adjacent to this group. Then, find a group of 2 bears. If you\n" +
                "find one, you get an extra 5 points. Exclude all bears adjacent to this group. Then,\n" +
                "find a group of one bear. If you find one, you get an extra 2 points. If you have three\n" +
                "groups of bears now, you get a bonus of 3 points.\n" +
                "Fox\n" +
                "1. For Fox Scoring Gard (A), for each fox, find the number of unique wildlifes (including\n" +
                "a fox) adjacent to it. Find the score in the table using the number as input. Each fox is\n" +
                "independently scored. All the unique animals adjacent to a fox must be included in\n" +
                "the scoring even if they are shared with an adjacent fox.\n" +
                "2. For Fox Scoring Gard (B), for each fox, find the number of unique wildlife pairs\n" +
                "(excluding a pair of foxes) adjacent to it. Two or more of the same wildlife will count\n" +
                "as one pair and need not be adjacent to each other. Find the score in the table using\n" +
                "the number as input.\n" +
                "3. For Fox Scoring Gard (C), for each fox, find the number of similar wildlifes (excluding\n" +
                "a fox) directly adjacent to it. Only score the most abundant animal type. For example,\n" +
                "assuming you are using hexagonal tiles, if you have 4 Salmon and 2 elk directly\n" +
                "adjacent to a fox, the number will be 4. Find the score in the table using the number\n" +
                "as input.\n" +
                "Elk\n" +
                "1. For Elk Scoring Gard (A), score points for each straight line of elk. Lines can have\n" +
                "any direction. By definition, a straight line will not have any bend while passing\n" +
                "through the centres of the tiles containing the elk. Find the score in the table using\n" +
                "the length of the line as input. If an elk is a part of two or more lines, select a line with\n" +
                "the largest length. Remove that line of elk. Then proceed to score the remaining elk.\n" +
                "2. For Elk Scoring Gard (B), score points for a contiguous group of adjacent elk in any\n" +
                "shape. Select a group that would obtain the largest score using the table provided.\n" +
                "Remove that group of elk. Then proceed to score the remaining elk.\n" +
                "3. For Elk Scoring Gard (C), first find the group of 4 elk in the shape shown on the card.\n" +
                "If you find one, you score 13 points. Exclude this group. Then, find a group of 3 elk. If\n" +
                "you find one, you score 9 points. Exclude this group. Then, find a group of 2 elk. If\n" +
                "you find one, you score 5 points. Exclude this group. Then, find a group of 1 elk. If\n" +
                "you find one, you score 2 points. Exclude this group.\n" +
                "Hawk\n" +
                "1. For Hawk Scoring Gard (A), select a hawk. Remove (or cross out) all hawks adjacent\n" +
                "to this hawk. Proceed in this fashion. Then, find the score in the table using the\n" +
                "number of hawks that remain.\n" +
                "2. For Hawk Scoring Gard (B), shortlist the hawks as described for scoring card A. Now\n" +
                "find a direct line of sight between a pair of hawks. Note a line has two endpoints. It is\n" +
                "a straight line with no bends. A direct line of sight will have two hawks at its end\n" +
                "points. In the middle, there must be only one habitat tile without any wildlife in it. Find\n" +
                "the score in the table using the number of hawks");
    }
}
