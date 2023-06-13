import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Friend> friends = new ArrayList<>();

        // Create Friend objects and add data
        Friend friend1 = new Friend(101, "Mr A", 10, "Inside class M1");
        friend1.addPhoneNumber("Cellcard");
        friend1.addPhoneNumber("01234567");

        Friend friend2 = new Friend(102, "Mr B", 20, "Inside class M2");
        friend2.addPhoneNumber("Smart");
        friend2.addPhoneNumber("0104356783");

        // Add Friend objects to the ArrayList
        friends.add(friend1);
        friends.add(friend2);

        // Output friends' data to the console
        for (int i = 0; i < friends.size(); i++) {
            System.out.println("Friend index = " + i);
            friends.get(i).display();
            System.out.println();
        }
    }
}
