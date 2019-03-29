package talha.com.bd.hometask.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import talha.com.bd.hometask.R;
import talha.com.bd.hometask.adapters.PersonAdapter;
import talha.com.bd.hometask.model.SearchResult;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PersonDetailsActivity extends AppCompatActivity  {

    private PersonAdapter personAdapter;
    private ImageView personImage;
    private TextView personName;
    private TextView personOccup;
    private TextView personMobile;
    private SearchResult searchResult;
    private CardView detailCard;
    private Toolbar detailToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);
        setTitle("Person Details");

        searchResult = (SearchResult) getIntent().getSerializableExtra("MyOnClick");

        personImage = findViewById(R.id.personImageView);
        personName = findViewById(R.id.user_name);
        personOccup = findViewById(R.id.occup);
        personMobile = findViewById(R.id.mobile);
        detailCard = findViewById(R.id.detailCard);
        detailToolbar = findViewById(R.id.detailToolbar);

        setSupportActionBar(detailToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Product Details");
        }

        setPersonDetails(searchResult);

        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        detailCard.startAnimation(anim);

    }


    public void setPersonDetails(SearchResult searchResult) {
        personName.setText(searchResult.getName());
        personOccup.setText(searchResult.getWho());
        personMobile.setText(searchResult.getUser());
        Glide.with(this).load(searchResult.getImage()).into(personImage);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
