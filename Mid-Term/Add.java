import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Scanner;
public class Add {
    private static int insertID;
    private static String insertfirstname;
    private static String insertlastname;
    private static String insertposition;
    private static double insalary;
    private static String indepartment;
    private static Employee inputEmployee;
    private static int choice;

    static Scanner scan = new Scanner(System.in);

    public static void execute(){
        List.retrieveListOfId();
        do {
            System.out.print("");
        } while (!List.getListOfId().contains(insertID));

        for(int i = 0; i <= List.getListSize(); i++){
            if(!List.getListOfId().contains(i)){
                insertID = i;
            }
        }

        System.out.println("Employee ID: " + insertID);

        System.out.println("First Name: ");
        insertfirstname = scan.nextLine();

        System.out.println("Last Name: ");
        insertlastname = scan.nextLine();

        System.out.println("Position: ");
        insertposition = scan.nextLine();

        System.out.println("Salary: ");
        insalary = Double.valueOf(scan.nextLine());

        System.out.println("Deparment: ");
        indepartment = scan.nextLine();

        inputEmployee = new Employee(insertID, insertfirstname, insertlastname, insertposition, insalary, indepartment);
        System.out.println("Info\n");
        System.out.println(inputEmployee);

        menuOptions();
        returnChoice();
    }

    private static void menuOptions(){
        System.out.println("\n What do you want to do with the info above: \n" +
                "0. Add to Database\n" +
                "1. Re-input info\n" +
                "2. Cancel\n");
        System.out.println("Choose options (from 0 to 2): ");
        choice = Integer.valueOf(scan.nextLine());
    }

    private static void returnChoice(){
        if(choice == 0) {
            createEmployee();
        }else if(choice == 1){
            execute();
        }else if(choice == 2){
            System.out.println("End Program");
        }else {
            System.out.println(choice + " is not in the menu. Please select an option from 0 to 2. Thanks!\n");
            menuOptions();
            returnChoice();
        }
    }

    private static void createEmployee(){
        Employee employees = inputEmployee;
        Call<Employee> call = Main.retrofitAPI.createEmployee(employees);
        call.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                handleResponse(response);
                Menu.menuOptions();
                Menu.returnChoice();
            }

            private void handleResponse(Response<Employee> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    return;
                }

                Employee employeeRespond = response.body();
                String content = "";
                content += "#Code: " + response.code();
                System.out.println(content);
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable throwable) {
                System.out.println("Code: " + throwable.getMessage());
            }
        });
    }
}
