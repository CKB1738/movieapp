package comp3350.go4tv.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import comp3350.go4tv.R;
import comp3350.go4tv.application.Service;
import comp3350.go4tv.business.AccessMovie;
import comp3350.go4tv.objects.Movie;

public class MainPageActivity extends AppCompatActivity {
    Button profileButton;
    TextView movie1, movie2, movie3, movie4, movie5;
    ImageView image1, image2, image3, image4, image5;
    List<Movie> movies;
    String userName;
    AccessMovie accessMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("MainPage");
        setContentView(R.layout.activity_main_page);



        profileButton = (Button) findViewById(R.id.profileButton);
        profileButton.setOnClickListener(profileButtonListener);

        accessMovie = new AccessMovie(Service.getMoviePersistence());
        List<Movie> movies = accessMovie.getListOfMovie();
        movie1 = (TextView) findViewById(R.id.movieList1);
        movie1.setOnClickListener(movieClickListener);
        movie2 = (TextView) findViewById(R.id.movieList2);
        movie2.setOnClickListener(movieClickListener);
        movie3 = (TextView) findViewById(R.id.movieList3);
        movie3.setOnClickListener(movieClickListener);
        movie4 = (TextView) findViewById(R.id.movieList4);
        movie4.setOnClickListener(movieClickListener);
        movie5 = (TextView) findViewById(R.id.movieList5);
        movie5.setOnClickListener(movieClickListener);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        image5 = (ImageView) findViewById(R.id.image5);

        image1.setImageResource(R.drawable.litlle_dixie);
        image2.setImageResource(R.drawable.plane);
        image3.setImageResource(R.drawable.puss_in_boots);
        image4.setImageResource(R.drawable.black_panther);
        image5.setImageResource(R.drawable.knock_at_the_cabin);

        movie1.setText(movies.get(0).getName());
        movie2.setText(movies.get(1).getName());
        movie3.setText(movies.get(2).getName());
        movie4.setText(movies.get(3).getName());
        movie5.setText(movies.get(4).getName());

        Intent i = getIntent();
        userName = i.getStringExtra("username");
        String msg = "Hello " + userName + "\nWelcome to Go4TV, More movies are coming up soon!";
        ((TextView) findViewById(R.id.tempText)).setText(msg);

    }

    private View.OnClickListener profileButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            profileButtonClicked(v);
        }
    };

    private void profileButtonClicked(View v) {
        Intent i = new Intent(this, UserProfileActivity.class);
        i.putExtra("username", userName);
        startActivity(i);
    }

    private final View.OnClickListener movieClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int movieIndex = -1;
            switch (v.getId()) {
                case R.id.movieList1:
                    movieIndex = 0;
                    break;
                case R.id.movieList2:
                    movieIndex = 1;
                    break;
                case R.id.movieList3:
                    movieIndex = 2;
                    break;
                case R.id.movieList4:
                    movieIndex = 3;
                    break;
                case R.id.movieList5:
                    movieIndex = 4;
                    break;
            }

            if (movieIndex >= 0) {
                Intent intent = new Intent(MainPageActivity.this, MovieDetailsActivity.class);
                String dummyName = "Dummy Movie " + (movieIndex + 1);
                String dummyDescription = "This is a dummy description for Dummy Movie " + (movieIndex + 1);
                double dummyRating = 4.5;
                intent.putExtra("name", dummyName);
                intent.putExtra("description", dummyDescription);
                intent.putExtra("rating", dummyRating);
                startActivity(intent);

            }
        }
    };


}