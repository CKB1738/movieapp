package comp3350.go4tv.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import comp3350.go4tv.R;
import comp3350.go4tv.business.AccessFavouriteMovie;
import comp3350.go4tv.objects.Movie;

public class FavouriteListActivity extends AppCompatActivity {

    private String username;

    private List<Movie> movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_list);
        setTitle("My Movies");
        Intent i = getIntent();

        username = i.getStringExtra("username");

        AccessFavouriteMovie accessFavouriteMovie = new AccessFavouriteMovie();

        movies = accessFavouriteMovie.getListOfMovies(username);




//        ((TextView)findViewById(R.id.movie1)).setText(username);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(getApplicationContext(), movies));



    }
}