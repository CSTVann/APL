import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Delete {
    private static Integer inputAccessEmployeeID;
    private static int choice;
    static Scanner scan = new Scanner(System.in);
    public static void execute() {
        List.retrieveListOfId();
        do {
            System.out.println("Input ID to access an employee you want to delete: ");
            inputAccessEmployeeID = Integer.valueOf(scan.nextLine());
        } while (!List.getListOfId().contains(inputAccessEmployeeID));
        readKey.setInputAccessEmployeeID(inputAccessEmployeeID);
        GS.read(inputAccessEmployeeID);
        readKey.readKeyAndInfo();

        menuOptions();
        returnChoice();
    }

    private static void menuOptions() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int choice;
        do {
            System.out.println("\n What do you want to do with the info above: \n" +
                    "0. Delete information\n" +
                    "1. Cancel\n");
            System.out.println("Choose options (from 0 to 1): ");
            choice = Integer.valueOf(scan.nextLine());

            switch (choice) {
                case 0:
                    deleteInformation();
                    break;
                case 1:
                    System.out.println("Cancellation requested.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select an option from 0 to 1.");
                    break;
            }
        } while (choice != 1);
    }

    private static void deleteInformation() {
    }


    private static void returnChoice() {
        switch (choice) {
            case 0:
                deleteEmployee();
                break;
            case 1:
                System.out.println("Stop Program");
                break;
            default:
                System.out.println(choice + "Select an option from 0 & 1.\n");
                menuOptions();
                returnChoice();
                break;
        }
    }

    private static void deleteEmployee(){
        Call<Employee> call = Main.retrofitAPI.deleteEmployee(readKey.getRightEmployeeKey());
        call.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                if (!response.isSuccessful()){
                    System.out.println("Code: " + response.code());
                    return;
                }
                System.out.println("Code: " + response.code());

                Menu.menuOptions();
                Menu.returnChoice();
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }
        });

    }
}
