package comp3350.go4tv.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import comp3350.go4tv.R;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void launchLogInPage(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}