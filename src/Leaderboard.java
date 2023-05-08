import java.util.Objects;

// todo add +3 / +1 to habitats
// todo add round number
// todo add "player" is in the lead!
public class Leaderboard extends Display_And_Input
{
    private static final int MAX = 14;
    private static int player_num = 0;
    private static int[] player1;
    private static int[] player2;
    private static int[] player3;
    private static int[] player4;
    private static String[] menu = {"Bear", "Elk", "Fox", "Hawk", "Salmon", "Forest", "Wetland", "River", "Mountain", "Prairie", "Nature Tokens","Total Animal", "Total Habitat", "Total Score" };
    
    public static void setPlayer_num(int player_num) {
        Leaderboard.player_num = player_num;
    }

    public static void setPlayer1(int[] player1) {
        Leaderboard.player1 = player1;
    }

    public static void setPlayer2(int[] player2) {
        Leaderboard.player2 = player2;
    }

    public static void setPlayer3(int[] player3) {
        Leaderboard.player3 = player3;
    }

    public static void setPlayer4(int[] player4) {
        Leaderboard.player4 = player4;
    }


    public static void board(int[] scoring_cards) {
        setPlayer_num(getPlayer_count());

        String[] player_names = new String[player_num];
        for (int i=0; i<player_num; i++) {
            //player_names[i] = "bob";
            player_names[i] = getPlayers().get(i).getPlayer_name();
        }

        setPlayer1( getData( 0, scoring_cards) );
        setPlayer2( getData( 1, scoring_cards) );
        setPlayer3( getData( 2, scoring_cards) );
        setPlayer4( getData( 3, scoring_cards) );

        int []player1_copy = new int[MAX], player2_copy = new int[MAX], player3_copy = new int[MAX], player4_copy = new int[MAX];
        System.arraycopy(player1, 0, player1_copy, 0, MAX);
        System.arraycopy(player2, 0, player2_copy, 0, MAX);
        System.arraycopy(player3, 0, player3_copy, 0, MAX);
        System.arraycopy(player4, 0, player4_copy, 0, MAX);

        getBonus();

        calculateTotals(0, player1);
        calculateTotals(1, player2);
        calculateTotals(2, player3);
        calculateTotals(3, player4);

        printLeaderboard(player_names, player1_copy, player2_copy, player3_copy, player4_copy);

        if (getPlayers().get(0).getPlayerTurn() == 20) {
            printWinner(player_names);
        }
    }

    public static void printLeaderboard(String[] player_names, int[] player1_copy, int[] player2_copy, int[] player3_copy, int[] player4_copy)
    {
        int index = 0;
        for (int i=0; i<20; i++) {
            if (i == 0 || i == 2 || i == 8 || i == 15 || i == 19)
            {
                System.out.println(" " + dashPrinter("-", 17 * (player_num + 1)-1));
            } else if (i == 1)
            {
                String str = "| " + append("Players", MAX);
                for (int j=0; j<player_num; j++) {
                    str += append(player_names[j], MAX);
                }
                System.out.println(str);
            } else if (i==17 || i ==18) {
                System.out.println( "| " + append(menu[index], MAX) + appendInt(player1[index], player1[index], MAX) + appendInt(player2[index], player2[index], MAX)
                        + appendInt(player3[index], player3[index], MAX) + appendInt(player4[index], player4[index], MAX));
                index++;
            } else
            {
                System.out.println( "| " + append(menu[index], MAX) + appendInt(player1[index], player1_copy[index], MAX) + appendInt(player2[index], player2_copy[index], MAX)
                        + appendInt(player3_copy[index], player3[index], MAX) + appendInt(player4_copy[index], player4[index], MAX));
                index++;
            }
        }
    }

    public static void printWinner(String[] player_names) {
        int h1 = player1[12], h2 = player2[12], h3 = player3[12], h4 = player4[12];
        int highscore = Math.max(h1 ,Math.max(h2 ,Math.max(h3 , h4)));

        int winners = 0;

        if (h1 == highscore) {
            winners++;
        }
        if (h2 == highscore) {
            winners++;
        }
        if (h3 == highscore) {
            winners++;
        }
        if (h4 == highscore) {
            winners++;
        }

        if (winners == 1) {
            if (h1 == highscore) System.out.println( "--< " +player_names[0] + " HAS WON THE GAME WITH " + player1[13] + " POINTS >--");
            if (h2 == highscore) System.out.println( "--< " +player_names[1] + " HAS WON THE GAME WITH " + player2[13] + " POINTS >--");
            if (h3 == highscore) System.out.println( "--< " +player_names[2] + " HAS WON THE GAME WITH " + player3[13] + " POINTS >--");
            if (h4 == highscore) System.out.println( "--< " +player_names[3] + " HAS WON THE GAME WITH " + player4[13] + " POINTS >--");
        }
        
        else {
            int n_tokens[] = {0,0,0,0};
            if (h1 == highscore) {
                System.out.println( player_names[0] + " DRAWS WITH " + player1[13] + " POINTS");
                n_tokens[0] = player1[10];
            }
            if (h2 == highscore) {
                System.out.println( player_names[1] + " DRAWS WITH " + player2[13] + " POINTS");
                n_tokens[1] = player2[10];
            }
            if (h3 == highscore) {
                System.out.println( player_names[2] + " DRAWS WITH " + player3[13] + " POINTS");
                n_tokens[2] = player3[10];
            }
            if (h4 == highscore) {
                System.out.println( player_names[3] + " DRAWS WITH " + player4[13] + " POINTS");
                n_tokens[3] = player4[10];
            }
            int maxtokens = Math.max(n_tokens[0] ,Math.max(n_tokens[1] ,Math.max(n_tokens[2] , n_tokens[3])));

            if (n_tokens[0] == maxtokens) System.out.println( player_names[0] + " WONS AS THEY HAD " + player1[13] + " NATURE TOKENS");
            if (n_tokens[1] == maxtokens) System.out.println( player_names[1] + " WONS AS THEY HAD " + player2[13] + " NATURE TOKENS");
            if (n_tokens[2] == maxtokens) System.out.println( player_names[2] + " WONS AS THEY HAD " + player3[13] + " NATURE TOKENS");
            if (n_tokens[3] == maxtokens) System.out.println( player_names[3] + " WONS AS THEY HAD " + player4[13] + " NATURE TOKENS");
        }


    }

    public static int[] getData(int player, int[]scoring_cards) {

        if (player+1 > player_num) return new int[] {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};

        Board[][] b = getPlayers().get(player).getBoard();
        int[] scorescopy = Scoring_Setup.scoring_setups(b, getPlayers().get(player).getOdd(), scoring_cards);


        int[] scores = new int[MAX];

        System.arraycopy(scorescopy, 0, scores, 0, 10);

        scores[10] = getPlayers().get(player).getNature_tokens();
        calculateTotals(player, scores);
        return scores;
    }

    public static void calculateTotals(int player, int[] scores) {
        if (player+1 > player_num) {
            return;
        }
        scores[11] = scores[0] +  scores[1] + scores[2] + scores[3] + scores[4];
        scores[12] = scores[5] +  scores[6] + scores[7] + scores[8] + scores[9] + scores[10];
        scores[13] = scores[12] + scores[11];
    }

    public static String[] getBonus() {
        for (int i=5; i<10; i++) {
            int h1 = player1[i], h2 = player2[i], h3 = player3[i], h4 = player4[i];

            if (player_num == 2)
            {
                if (h1 > h2) player1[i] += 2;
                else if (h2 > h1) player2[i] += 2;
                else {
                    player1[i] += 1;
                    player2[i] += 1;
                }
            } else
            {
                int max = Math.max(h1 ,Math.max(h2 ,Math.max(h3 , h4)));
                int biggest_number = 0;
                int bonus = 0;

                if (h1 == max) biggest_number++;
                if (h2 == max) biggest_number++;
                if (h3 == max) biggest_number++;
                if (h4 == max) biggest_number++;

                if (biggest_number == 2) {
                    bonus = 2;
                } else if (biggest_number == 3) {
                    bonus = 1;
                }

                if (biggest_number == 1) {
                    int max2 = 0;

                    if (h1 == max)  {
                        player1[i] += 3;
                        max2 = Math.max(h2 ,Math.max(h3 , h4));
                    }
                    else if (h2 == max) {
                        player2[i] += 3;
                        max2 = Math.max(h1 ,Math.max(h3 , h4));
                    }
                    else if (h3 == max) {
                        player3[i] += 3;
                        max2 = Math.max(h2 ,Math.max(h1 , h4));
                    }
                    if (h4 == max) {
                        player4[i] += 3;
                        max2 = Math.max(h2 ,Math.max(h3 , h1));
                    }

                    if (h1 == max2) player1[i] += 1;
                    if (h2 == max2) player2[i] += 1;
                    if (h3 == max2) player3[i] += 1;
                    if (h4 == max2) player4[i] += 1;
                }

                else {
                    if (h1 == max) player1[i] += bonus;
                    if (h2 == max) player2[i] += bonus;
                    if (h3 == max) player3[i] += bonus;
                    if (h4 == max) player4[i] += bonus;
                }
            }
        }
        return null;
    }

    public static String appendInt(int numToPrint, int num2,  int x) {
        String str = Integer.toString(numToPrint);

        if (numToPrint != num2) {
            int diff = Math.abs(numToPrint - num2);
            str += " (+" + diff + ")";
        }

        return append(str, x);
    }

    public static String append(String str, int x) {
        if (Objects.equals(str, "-1") || str.isBlank()) {
            return "";
        }
        while (str.length() <= x) {
            str+=" ";
            if (str.length() <= x) str = " " + str;     // centers data in tables
        }
        str+="| ";
        return str;
    }

    public static String dashPrinter(String str, int max) {
        String s = str;
        while (str.length() < max) {
            str+=s;
        }
        return str;
    }

}