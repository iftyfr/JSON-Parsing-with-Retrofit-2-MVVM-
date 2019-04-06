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

    private ImageView personImage;
    private TextView personName;
    private TextView personOccup;
    private TextView personMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);

        personImage = findViewById(R.id.personImageView);
        personName = findViewById(R.id.user_name);
        personOccup = findViewById(R.id.occup);
        personMobile = findViewById(R.id.mobile);
        CardView detailCard = findViewById(R.id.detailCard);
        Toolbar detailToolbar = findViewById(R.id.detailToolbar);

        setSupportActionBar(detailToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Product Details");
        }

        SearchResult searchResult = (SearchResult) getIntent().getSerializableExtra("MyOnClick");
        if (searchResult != null) {
            setPersonDetails(searchResult);
        }

        detailCard.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in));
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
