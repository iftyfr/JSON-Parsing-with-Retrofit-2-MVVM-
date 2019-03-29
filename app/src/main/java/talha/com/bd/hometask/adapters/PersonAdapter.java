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

    private Context context;
    private List<SearchResult> searchResultList;
    private MyOnClickListener myOnClickListener;

    public PersonAdapter(Context context, List<SearchResult> searchResultList) {
        this.context = context;
        this.searchResultList = searchResultList;
    }

    public void setMyOnClickListener(MyOnClickListener clickListener) {
        this.myOnClickListener = clickListener;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.person_layout, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, final int position) {

        holder.userName.setText(searchResultList.get(position).getName());
        holder.occupation.setText(searchResultList.get(position).getWho());
        Glide.with(context.getApplicationContext()).load(searchResultList.get(position).getImage()).into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return searchResultList.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {
        private ImageView userImage;
        private TextView userName;
        private TextView occupation;

        PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            userImage = itemView.findViewById(R.id.userImage);
            userName = itemView.findViewById(R.id.userName);
            occupation = itemView.findViewById(R.id.occupation);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (myOnClickListener != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            myOnClickListener.myOnClick(position);
                        }
                    }
                }
            });
        }
    }
}
