package comp3350.go4tv.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import comp3350.go4tv.R;

public class MainPageActivity extends AppCompatActivity {
    Button profileButton;
    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("MainPage");
        setContentView(R.layout.activity_main_page);

        profileButton = (Button) findViewById(R.id.profileButton);
        profileButton.setOnClickListener(profileButtonListener);

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
        Intent i = new Intent(this,UserProfile.class);
        i.putExtra("username", userName);
        startActivity(i);
    }
}