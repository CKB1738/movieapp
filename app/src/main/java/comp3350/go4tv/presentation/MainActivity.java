package comp3350.go4tv.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import comp3350.go4tv.R;
import comp3350.go4tv.business.AccessUser;
import comp3350.go4tv.business.validator.EmailValidator;
import comp3350.go4tv.business.validator.FieldValidator;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    FieldValidator validUsername, validPassword;
    Button signInButton, signUpButton;

    AccessUser accessUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.signInUsername);
        password = (EditText) findViewById(R.id.signInPassword);

        signInButton = (Button) findViewById(R.id.signInButton);
        signUpButton = (Button) findViewById(R.id.signUpButton);

        signInButton.setOnClickListener(signInButtonListener);
        signUpButton.setOnClickListener(signUpButtonListener);
    }

    private View.OnClickListener signInButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            signInButtonClicked(v);
        }
    };

    private View.OnClickListener signUpButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            signUpButtonClicked(v);
        }
    };

    private void signInButtonClicked(View v) {
        /*
         * Get all the fields entered by the user
         * */
        validUsername = new FieldValidator(username.getText().toString());
        validPassword = new FieldValidator(password.getText().toString());
        accessUser = new AccessUser();
        //valid username and password
        if(validUsername.isValid() && validPassword.isValid() && accessUser.verifyUser(username.getText().toString(),password.getText().toString())) {
            Toast.makeText(this, "Sign In successful", Toast.LENGTH_SHORT).show();

                //after sign in go to temp main page
                Intent i = new Intent(this, MainPageActivity.class);
                i.putExtra("username", username.getText().toString());
                startActivity(i);


        }
        else{
            if (!validUsername.isValid()) {
                username.setError("Please enter a valid username.");
            }
            else if (!validPassword.isValid()) {
                password.setError("Please enter a valid password.");
            }
            Toast.makeText(this, "Please check your username and password", Toast.LENGTH_SHORT).show();
        }
    }

    private void signUpButtonClicked(View v) {
        Intent i = new Intent(this,RegistrationActivity.class);
        startActivity(i);
    }
}