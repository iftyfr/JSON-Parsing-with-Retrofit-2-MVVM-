package talha.com.bd.hometask.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import talha.com.bd.hometask.remote.APIService;
import talha.com.bd.hometask.remote.RetrofitApiClient;

public class PersonRepository {
    private MutableLiveData<Person> data;

    public LiveData<Person> getPersonList() {
        if (data == null) {
            data = new MutableLiveData<>();
        }

        APIService apiService = RetrofitApiClient.getApiService();
        apiService.getPerson().enqueue(new Callback<Person>() {
            @Override
            public void onResponse(@NonNull Call<Person> call, @NonNull Response<Person> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Person> call, @NonNull Throwable t) {
                data.setValue(new Person(t.getMessage()));
            }
        });

        return data;
    }
}
