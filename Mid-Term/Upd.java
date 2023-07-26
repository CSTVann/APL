
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Upd {
    private static Integer inputAccessEmployeeID;
    //private static Integer updateEmployeeID;
    private static String updateFirstName;
    private static String updateLastName;
    private static String updatePosition;
    private static Double updateSalary;
    private static String updateWorkDepartment;
    private static Employee updateEmployee;
    private static int choice;
    static Scanner scan = new Scanner(System.in);

    public static void execute() {
        List.retrieveListOfId();
        do {
            System.out.println("Input ID to access an employee you want to change: ");
            inputAccessEmployeeID = Integer.valueOf(scan.nextLine());
        } while (!List.getListOfId().contains(inputAccessEmployeeID));

        readKey.setInputAccessEmployeeID(inputAccessEmployeeID);
        GS.read(inputAccessEmployeeID);
        readKey.readKeyAndInfo();

        Runnable sleepTask = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        sleepTask.run();


        /*
        System.out.println("Update employee ID: ");
        String employeeIdInput = scan.nextLine();
        updateEmployeeID = employeeIdInput.isEmpty() ? readKey.getOldEmployeeId() : Integer.parseInt(employeeIdInput);
         */

        System.out.println("Update First name: ");
        updateFirstName = scan.nextLine();
        updateFirstName = updateFirstName.isEmpty() ? null : updateFirstName;
        System.out.println("Update Last name: ");
        updateLastName = scan.nextLine();
        updateLastName = updateLastName.isEmpty() ? null : updateLastName;
        System.out.println("Update Position: ");
        updatePosition = scan.nextLine();
        updatePosition = updatePosition.isEmpty() ? null : updatePosition;
        System.out.println("Update Salary: ");
        String salaryInput = scan.nextLine();
        updateSalary = salaryInput.isEmpty() ? readKey.getOldSalary() : Double.parseDouble(salaryInput);
        System.out.println("Update Department: ");
        updateWorkDepartment = scan.nextLine();
        updateWorkDepartment = updateWorkDepartment.isEmpty() ? null : updateWorkDepartment;

        updateEmployee = new Employee(readKey.getOldEmployeeId(), updateFirstName, updateLastName, updatePosition, updateSalary, updateWorkDepartment);
        System.out.println("Info\n");
        System.out.println(updateEmployee);

        menuOptions();
        returnChoice();
    }
    private static void menuOptions(){
        System.out.println("\n What do you want to do with the info above: \n" +
                "0. Add update info to Database\n" +
                "1. Re-input info\n" +
                "2. Cancel\n");
        System.out.println("Choose options (from 0 to 2): ");
        choice = Integer.valueOf(scan.nextLine());
    }

    private static void returnChoice() {
        switch (choice) {
            case 0:
                updateEmployee();
                break;
            case 1:
                execute();
                break;
            case 2:
                System.out.println("End Program");
                break;
            default:
                System.out.println(choice + " is not in the menu. Please select an option from 0 to 2. Thanks!\n");
                menuOptions();
                returnChoice();
                break;
        }
    }

    private static void updateEmployee(){
        Employee employee = updateEmployee;
        Call<Employee> call = Main.retrofitAPI.patchEmployee(readKey.getRightEmployeeKey(), employee);
        call.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    return;
                }

                Employee employeeRespond = response.body();
                String content = "#Code: " + response.code();
                System.out.println(content);

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