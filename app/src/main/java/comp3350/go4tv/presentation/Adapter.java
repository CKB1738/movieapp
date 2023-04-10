package comp3350.go4tv.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import comp3350.go4tv.R;
import comp3350.go4tv.objects.Movie;

public class Adapter extends RecyclerView.Adapter<movieViewHolder> {


    private Context context;
    private List<Movie> movies;

    public Adapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }



    @NonNull
    @Override
    public movieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new movieViewHolder(LayoutInflater.from(context).inflate(R.layout.movielist,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull movieViewHolder holder, int position) {
        holder.movieName.setText(movies.get(position).getName());
        holder.poster.setImageResource(movies.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
