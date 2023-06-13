import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Friend> friends = new ArrayList<>();

        // Create Friend objects and add data
        Friend friend1 = new Friend(101, "Mr A", 10, "Inside class M1");
        friend1.addPhoneNumber("Cellcard:  01234567");
        friend1.addPhoneNumber("Smart:  0104356783");

        Friend friend2 = new Friend(102, "Mr B", 40 , "From Cambodia");
        friend2.addPhoneNumber("Cellcard:  0184356783");
        friend2.addPhoneNumber("Smart:  080134324");

        Friend friend3 = new Friend(203, "MRs C", 30, "N/A");
        friend3.addPhoneNumber("Cellcard:  019123213");
        friend3.addPhoneNumber("Smart:  0783146324");



        // Add Friend objects to the ArrayList
        friends.add(friend1);
        friends.add(friend2);
        friends.add(friend3);

        // Output friends' data to the console
        for (int i = 0; i < friends.size(); i++) {
            System.out.println("Friend index = " + i);
            friends.get(i).display();
            System.out.println();
        }
    }
}
