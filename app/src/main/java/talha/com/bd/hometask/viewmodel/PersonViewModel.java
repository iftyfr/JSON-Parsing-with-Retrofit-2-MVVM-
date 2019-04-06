package talha.com.bd.hometask.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import talha.com.bd.hometask.model.Person;
import talha.com.bd.hometask.model.PersonRepository;
import talha.com.bd.hometask.remote.RetrofitApiClient;

public class PersonViewModel extends AndroidViewModel {

    private LiveData <Person> person;

    public PersonViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData <Person> getPersonVal(){
        if (person == null){
            person = new PersonRepository().getPersonList();
        }
        return person;
    }
}
