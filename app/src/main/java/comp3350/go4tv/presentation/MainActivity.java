package comp3350.go4tv.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import comp3350.go4tv.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchSignUp(View v){

//        launch sign up page after click sin up button
        Intent i = new Intent(this,RegistrationActivity.class);
        startActivity(i);
    }

    public void launchHomepage(View v){
        //launch homepage after sign in veryfied
        Intent i = new Intent(this, MainPageActivity.class);
        String userName = ((EditText)findViewById(R.id.usernameInput)).getText().toString();
        i.putExtra("username",userName);
        startActivity(i);
    }
}