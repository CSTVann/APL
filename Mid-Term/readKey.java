
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class readKey {
    private static String rightEmployeeKey;
    private static Double oldSalary;
    private static Integer oldEmployeeId;
    private static Integer inputAccessEmployeeID;
    static Scanner scan = new Scanner(System.in);

    public static void readKeyAndInfo(){
        Call<Map<String, Employee>> call = Main.retrofitAPI.getEmployee();
        call.enqueue(new Callback<Map<String, Employee>>() {
            @Override
            public void onResponse(Call<Map<String, Employee>> call, Response<Map<String, Employee>> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    return;
                }

                Map<String, Employee> employeeMap1 = response.body();
                employeeMap1.entrySet().stream()
                        .filter(entry -> entry.getValue().getEmployeeID() == inputAccessEmployeeID)
                        .findFirst()
                        .ifPresent(entry -> {
                            rightEmployeeKey = entry.getKey();
                            oldSalary = entry.getValue().getSalary();
                            oldEmployeeId = entry.getValue().getEmployeeID();
                        });

            }
            @Override
            public void onFailure(Call<Map<String, Employee>> call, Throwable throwable) {
                System.out.println("Code: " + throwable.getMessage());
            }
        });
    }

    public static String getRightEmployeeKey() {
        return rightEmployeeKey;
    }
    public static Double getOldSalary() {
        return oldSalary;
    }
    public static Integer getOldEmployeeId() {
        return oldEmployeeId;
    }
    public static void setInputAccessEmployeeID(Integer inputAccessEmployeeID) {
        readKey.inputAccessEmployeeID = inputAccessEmployeeID;
    }
}