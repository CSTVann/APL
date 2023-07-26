
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.Map;


public class GS {
    public static ArrayList<Integer> tempTestList = new ArrayList<>();
    public static void read(int inputAccessEmployeeID){
        Call<Map<String, Employee>> call = Main.retrofitAPI.getEmployee();
        call.enqueue(new Callback<Map<String, Employee>>() {
            @Override
            public void onResponse(Call<Map<String, Employee>> call, Response<Map<String, Employee>> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    return;
                }

                Map<String, Employee> employeeMap = response.body();
                AsciiTable employeeTable = new AsciiTable();
                for (Map.Entry<String, Employee> entry : employeeMap.entrySet()) {
                    //String employeeKey = entry.getKey();
                    Employee employee = entry.getValue();
                    //System.out.println("Key: " + employeeKey);
                    if(employee.getEmployeeID() == inputAccessEmployeeID){
                        System.out.println(employee.toString());
                    }
                }
            }
            @Override
            public void onFailure(Call<Map<String, Employee>> call, Throwable throwable) {
                System.out.println("Code: " + throwable.getMessage());
            }
        });
    }

}
