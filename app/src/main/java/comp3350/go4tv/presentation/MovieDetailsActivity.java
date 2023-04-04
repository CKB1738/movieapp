package comp3350.go4tv.presentation;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import comp3350.go4tv.R;



public class MovieDetailsActivity extends AppCompatActivity {

    String userName;
    Button favouriteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        favouriteButton = (Button) findViewById(R.id.favouriteButton);
        favouriteButton.setOnClickListener(favouriteButtonListener);


        // Get the movie details from the intent
//        Bundle extras = getIntent().getExtras();
//        String name = extras.getString("name", "Movie Name");
//        String description = extras.getString("description", "Movie Description");
//        double rating = extras.getDouble("rating", 0);
        Intent i = getIntent();
        String movieName = i.getStringExtra("movieName");
        String movieDescription = i.getStringExtra("movieDescription");
        String movieRating = i.getStringExtra("movieRating");
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
        Intent i = new Intent(this, MainPageActivity.class);
        i.putExtra("movieName", userName);
        startActivity(i);
    }
}
