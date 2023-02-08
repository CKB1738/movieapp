package comp3350.go4tv.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import comp3350.go4tv.R;

public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("MainPage");
        setContentView(R.layout.activity_main_page);
        Intent i = getIntent();
        String userName = i.getStringExtra("username");
        String msg = "Hello " + userName + "\nWelcome to Go4TV, More movies are coming up soon!";
        ((TextView)findViewById(R.id.tempText)).setText(msg);
    }
}