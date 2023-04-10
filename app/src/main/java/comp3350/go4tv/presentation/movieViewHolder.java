package comp3350.go4tv.presentation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import comp3350.go4tv.R;

public class movieViewHolder extends RecyclerView.ViewHolder {

     ImageView poster;//movie poster
     TextView movieName;//movie name
    public movieViewHolder(@NonNull View itemView) {
        super(itemView);
        this.movieName = itemView.findViewById(R.id.movieName);
        this.poster = itemView.findViewById(R.id.poster);



    }
}
