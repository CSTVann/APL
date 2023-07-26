
import retrofit2.Call;
import retrofit2.Callback;
import java.util.Map;
import java.util.Scanner;
import retrofit2.Response;
import java.util.ArrayList;
public class List {
    private static ArrayList<Integer> listOfId = new ArrayList();
    private static int listSize;
    static Scanner scan = new Scanner(System.in);
    public static void retrieveListOfId(){
        Call<Map<String, Employee>> call = Main.retrofitAPI.getEmployee();
        call.enqueue(new Callback<Map<String, Employee>>() {
            @Override
            public void onResponse(Call<Map<String, Employee>> call, Response<Map<String, Employee>> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    return;}
                Map<String, Employee> employeeMap = response.body();
                employeeMap.forEach((key, employee) -> {
                    listOfId.add(employee.getEmployeeID());
                    listSize++;
                });}
            @Override
            public void onFailure(Call<Map<String, Employee>> call, Throwable throwable) {
                System.out.println("Code: " + throwable.getMessage());
            }});}
    public static ArrayList<Integer> getListOfId() {
        return listOfId;
    }
    public static Integer getListSize(){return listSize;}

}