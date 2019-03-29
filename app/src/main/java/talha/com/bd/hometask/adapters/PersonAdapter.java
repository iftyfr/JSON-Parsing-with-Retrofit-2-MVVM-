package talha.com.bd.hometask.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import talha.com.bd.hometask.R;
import talha.com.bd.hometask.model.Person;
import talha.com.bd.hometask.model.SearchResult;
import talha.com.bd.hometask.view.MyOnClickListener;
import talha.com.bd.hometask.view.PersonDetailsActivity;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    Context context;
    List<SearchResult> searchResultList;
    MyOnClickListener myOnClickListener;

    public PersonAdapter(Context context, List<SearchResult> searchResultList, MyOnClickListener myOnClickListener) {
        this.context = context;
        this.searchResultList = searchResultList;
        this.myOnClickListener = myOnClickListener;
    }


    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.person_layout,parent,false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, final int position) {

        holder.userName.setText(searchResultList.get(position).getName());
        holder.occupation.setText(searchResultList.get(position).getWho());
        Glide.with(context.getApplicationContext()).load(searchResultList.get(position).getImage()).into(holder.userImage);
        holder.personCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnClickListener.myOnClick(searchResultList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return searchResultList.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        private ImageView userImage;
        private TextView userName;
        private TextView occupation;
        private CardView personCardView;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            userImage = itemView.findViewById(R.id.userImage);
            userName = itemView.findViewById(R.id.userName);
            occupation = itemView.findViewById(R.id.occupation);
            personCardView = itemView.findViewById(R.id.personCardView);

        }
    }
}
