package comp3350.go4tv.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import comp3350.go4tv.R;
import comp3350.go4tv.business.AccessMovie;
import comp3350.go4tv.objects.Movie;

public class MainPageActivity extends AppCompatActivity {
    Button profileButton;
    TextView movie1,movie2,movie3,movie4,movie5;
    ImageView image1,image2,image3,image4,image5;
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

        accessMovie = new AccessMovie();
        movies = accessMovie.getListOfMovie();
        movie1 = (TextView) findViewById(R.id.movieList1);
        movie2 = (TextView) findViewById(R.id.movieList2);
        movie3 = (TextView) findViewById(R.id.movieList3);
        movie4 = (TextView) findViewById(R.id.movieList4);
        movie5 = (TextView) findViewById(R.id.movieList5);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        image5 = (ImageView) findViewById(R.id.image5);

        image1.setImageResource(R.drawable.knock_at_the_cabin);
        image2.setImageResource(R.drawable.little_dixie);
        image3.setImageResource(R.drawable.plane);
        image4.setImageResource(R.drawable.puss_in_boots);
        image5.setImageResource(R.drawable.black_panther);

        movie1.setText(movies.get(1).getName());
        movie2.setText(movies.get(2).getName());
        movie3.setText(movies.get(3).getName());
        movie4.setText(movies.get(4).getName());
        movie5.setText(movies.get(0).getName());

        Intent i = getIntent();
        userName = i.getStringExtra("username");
        String msg = "Hello " + userName + "\nWelcome to Go4TV, More movies are coming up soon!";
        ((TextView)findViewById(R.id.tempText)).setText(msg);

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
}