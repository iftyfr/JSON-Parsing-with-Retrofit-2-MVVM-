package talha.com.bd.hometask.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import talha.com.bd.hometask.model.Person;

public interface APIService {

    @GET("/bins/15baeq")
    Call<Person> getPerson();
}
