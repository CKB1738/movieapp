package comp3350.go4tv.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import comp3350.go4tv.R;

public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        // Get the movie details from the intent
        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name", "Movie Name");
        String description = extras.getString("description", "Movie Description");
        double rating = extras.getDouble("rating", 0);

        // Display the movie details in the UI
        TextView nameTextView = findViewById(R.id.movieName);
        TextView descriptionTextView = findViewById(R.id.movieDescription);
        TextView ratingTextView = findViewById(R.id.movieRating);

        nameTextView.setText(name);
        descriptionTextView.setText(description);
        ratingTextView.setText("Rating: " + rating + "/5");
    }
}
