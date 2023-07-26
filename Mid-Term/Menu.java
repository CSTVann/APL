import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
public class Menu {
    private static int choice;
    static Scanner scan = new Scanner(System.in);
    public static void menuOptions(){
        System.out.println("Menu\n" +
                "0. End\n" +
                "1. Add Employee\n" +
                "2. View List\n" +
                "3. Change Information\n" +
                "4. Delete Employee ");
        System.out.println("Choose options (from 0 to 4): ");
        choice = Integer.valueOf(scan.nextLine());
    }
    public static void returnChoice() {
        Map<Integer, Consumer<Void>> choiceMap = new HashMap<>();
        choiceMap.put(0, (Void) -> {
            System.out.println("End Program");
            System.exit(0);
        });
        choiceMap.put(1, (Void) -> Add.execute());
        choiceMap.put(2, (Void) -> Read.execute());
        choiceMap.put(3, (Void) -> Upd.execute());
        choiceMap.put(4, (Void) -> Delete.execute());

        Consumer<Void> selectedAction = choiceMap.getOrDefault(choice, (Void) -> {
            System.out.println(choice + " is not in the menu. Please select an option from 0 to 4. Thanks!");
            menuOptions();
            returnChoice();
        });

        selectedAction.accept(null);
    }
}