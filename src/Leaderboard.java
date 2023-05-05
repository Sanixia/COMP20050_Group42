public class Leaderboard extends Display_And_Input
{
    private static final String dashes_12 = "-- -- -- -- -- -- ";
    private static final String dashes_2 = "-- ";
    private static final String hr = "| ";


    public static void board() {
        int player_num = getPlayer_count();

        String p = "tatsu", b="14", e="12", f="7", h="9", s="13", F="3", W="2", R="8", M="2", P="3";
        String[] arr = {p, b, e, f, h, s, F, W, R, M, P, "34", "51", "85"};
        String[] menu = {"Players", "Bear", "Elk", "Fox", "Hawk", "Salmon", "Forest", "Wetland", "River", "Mountain", "Prairie", "Total Animal", "Total Habitat", "Total Score" };


        String player1name = getPlayers().get(0).getPlayer_name();
        String player2name = getPlayers().get(1).getPlayer_name();
        String player3name = null;
        String player4name = null;

        int[] player1 = new int[12];
        int[] player2 = new int[12];
        int[] player3 = new int[12];
        int[] player4 = new int[12];

        if (player_num == 3) {
            player3name = getPlayers().get(2).getPlayer_name();
        } if (player_num == 4) {
            player4name = getPlayers().get(3).getPlayer_name();
        }




        for (int i=0; i<player1.length; i++) {
            // player1[i] = Display_And_Input.
        }


        int index = 0;

        for (int i=0; i<19; i++) {
            if (i == 0 || i == 2 || i == 8 || i == 14 || i == 18) {
                System.out.println(dashes_12 + dashes_12 + dashes_12 + dashes_2);
            } else if (i == 1) {
                System.out.println(hr + append(menu[index], 14) + hr + append(arr[index], 11) + hr + append(arr[index], 11) + hr + append(arr[index], 11) + hr);
            } else {
                System.out.println(hr + append(menu[index], 14) + hr + append(arr[index], 11) + hr + append(arr[index], 11) + hr + append(arr[index], 11) + hr);
                index++;
            }
        }
    }

    public static String append(String str, int x) {
        while (str.length() < x) {
            str+=" ";
        }
        return str;
    }

//    public static String[] totals(String[] player) {
//        player[11] = player[1] + player[2] + player[3] + player[4] + player[5];
//        return null;
//    }

    public static int[] getData(int[] player, int playernum) {

        for (int i=0; i<10; i++) {

        }
        return null;
    }

    public static void main(String[] args) {
        board();
    }
}