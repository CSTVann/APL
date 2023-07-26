import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface RAPI {

    @GET(".json")
    Call<Map<String, Employee>> getEmployee();
    @POST(".json")
    Call<Employee> createEmployee(@Body Employee employee);

    @PATCH("{key}.json")
    Call<Employee> patchEmployee(@Path("key") String key, @Body Employee employee);

    @DELETE("{key}.json")
    Call<Employee> deleteEmployee(@Path("key") String key);

}
