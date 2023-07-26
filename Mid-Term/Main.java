import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Main {

    public static String URL ="https://apl-midterm-default-rtdb.firebaseio.com/";
    public static RAPI retrofitAPI;

    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitAPI = retrofit.create(RAPI.class);

        System.out.println("Hey there! I just want to inform you that this code is intended for discussion purposes only. Please don’t use it for your final submission. Thanks!");

        // Header
        System.out.println("Employee Information");

        Menu.menuOptions();
        Menu.returnChoice();
    }
}