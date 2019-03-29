package talha.com.bd.hometask.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import talha.com.bd.hometask.R;
import talha.com.bd.hometask.adapters.PersonAdapter;
import talha.com.bd.hometask.model.Person;
import talha.com.bd.hometask.model.SearchResult;
import talha.com.bd.hometask.viewmodel.PersonViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MyOnClickListener {

    private RecyclerView mRecyclerView;
    private PersonViewModel personViewModel;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.mainRecycler);
        mToolbar=findViewById(R.id.mToolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Home Task");

        personViewModel= ViewModelProviders.of(this).get(PersonViewModel.class);

        personViewModel.getPersonVal().observe(this, new Observer<Person>() {
            @Override
            public void onChanged(Person person) {
                List <SearchResult> searchResultList = person.getSearchResult();
                mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                mRecyclerView.setAdapter(new PersonAdapter(MainActivity.this, searchResultList,MainActivity.this));
            }
        });
    }

    @Override
    public void myOnClick(SearchResult searchResult) {

        Intent intent = new Intent(this,PersonDetailsActivity.class);
        intent.putExtra("MyOnClick", searchResult);
        startActivity(intent);
    }
}
