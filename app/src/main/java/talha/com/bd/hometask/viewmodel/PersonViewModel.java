package talha.com.bd.hometask.viewmodel;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import talha.com.bd.hometask.model.Person;
import talha.com.bd.hometask.remote.RetrofitApiClient;

public class PersonViewModel extends ViewModel {

    private LiveData <Person> person;
    private RetrofitApiClient retrofitApiClient = new RetrofitApiClient();


    public LiveData <Person> getPersonVal(){
        if (person == null){
            person = retrofitApiClient.getPersontList();
        }
        return person;
    }
}
