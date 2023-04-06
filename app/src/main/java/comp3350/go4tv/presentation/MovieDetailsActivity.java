package comp3350.go4tv.presentation;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import comp3350.go4tv.R;
import comp3350.go4tv.application.Service;
import comp3350.go4tv.business.AccessFavouriteMovie;
import comp3350.go4tv.objects.Movie;


public class MovieDetailsActivity extends AppCompatActivity {

    String userName;
    Button favouriteButton;
    String movieName;
    String movieDescription;
    String movieRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        favouriteButton = (Button) findViewById(R.id.favouriteButton);
        favouriteButton.setOnClickListener(favouriteButtonListener);

        Intent i = getIntent();
        movieName = i.getStringExtra("movieName");
        movieDescription = i.getStringExtra("movieDescription");
        movieRating = i.getStringExtra("movieRating");
        userName = i.getStringExtra("userName");
        // Display the movie details in the UI
        TextView nameTextView = findViewById(R.id.movieName);
        TextView descriptionTextView = findViewById(R.id.movieDescription);
        TextView ratingTextView = findViewById(R.id.movieRating);

        nameTextView.setText(movieName);
        descriptionTextView.setText(movieDescription);
        ratingTextView.setText(movieRating);
    }

    private final View.OnClickListener favouriteButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            favouriteButtonClicked(v);
        }
    };

    private void favouriteButtonClicked(View v) {

        AccessFavouriteMovie accessFavouriteMovie = new AccessFavouriteMovie(Service.getFavouriteMoviePersistence());

        Movie currMovie = accessFavouriteMovie.addToList(userName,movieName);
        if(currMovie == null){
            Toast.makeText(this, "This Movie is already in your list", Toast.LENGTH_SHORT).show();

        }

        else if(currMovie.getName().equals(movieName)){
            Toast.makeText(this, "Add successful", Toast.LENGTH_SHORT).show();

        }

        else{
            Toast.makeText(this, "Something bad happened, please try again later", Toast.LENGTH_SHORT).show();

        }
    }
}
