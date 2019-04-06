package talha.com.bd.hometask.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import talha.com.bd.hometask.model.Person;

public class RetrofitApiClient {
    private static final String BASE_URL = "https://api.myjson.com";
    private static Retrofit retrofit = null;

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private RetrofitApiClient() {
    }

    private static Retrofit getClient() {
        if (retrofit == null) {
            synchronized (RetrofitApiClient.class) { //thread safe Singleton implementation
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build();
                }
            }
        }

        return retrofit;
    }

    public static APIService getApiService() {
        return getClient().create(APIService.class);
    }
}
