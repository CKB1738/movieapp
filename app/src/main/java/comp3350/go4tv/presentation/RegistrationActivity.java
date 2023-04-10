package comp3350.go4tv.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.go4tv.R;
import comp3350.go4tv.business.AccessUser;
import comp3350.go4tv.business.validator.EmailValidator;
import comp3350.go4tv.business.validator.FieldValidator;
import comp3350.go4tv.objects.User;

public class RegistrationActivity extends AppCompatActivity {

    EditText username, email, password;
    FieldValidator validUsername, validEmail, validPassword;
    Button signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        /*
         * Get the view for the all the fields on the Registration page
         */
        username = (EditText) findViewById(R.id.signUpUsername);
        email = (EditText) findViewById(R.id.signUpEmail);
        password = (EditText) findViewById(R.id.signUpPassword);
        signUpButton = (Button) findViewById(R.id.signUpButton);

        // Setting up listener for button
        username.addTextChangedListener(new ReusableTextWatcher(username));
        email.addTextChangedListener(new ReusableTextWatcher(email));
        password.addTextChangedListener(new ReusableTextWatcher(password));

        signUpButton.setOnClickListener(signUpButtonListener);
    }
    private View.OnClickListener signUpButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            signUpButtonClicked(v);
        }
    };

    private void signUpButtonClicked(View v) {
        /*
         * Get all the fields entered by the user
         * */
        validEmail = new EmailValidator(email.getText().toString());
        validUsername = new FieldValidator(username.getText().toString());
        validPassword = new FieldValidator(password.getText().toString());
        AccessUser accessUser = new AccessUser();
        if(validUsername.isValid() && validEmail.isValid() && validPassword.isValid()) {

            if(accessUser.findUser(username.getText().toString()) == null){
                User newUser = new User(username.getText().toString(),email.getText().toString(),password.getText().toString());
                accessUser.insertUser(newUser);
                Toast.makeText(this, "Sign Up successful, please sign in.", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(this, "User already exists, please sign in.", Toast.LENGTH_SHORT).show();

            }
            this.finish();
        }

        else {
            if (!validUsername.isValid()) {
                username.setError("Please enter a valid username.");
            }
            else if (!validEmail.isValid()) {
                email.setError("Please enter a valid email address.");
            }
            else if (!validPassword.isValid()) {
                password.setError("Please enter a valid password.");
            }

            Toast.makeText(this, "Please check the details entered", Toast.LENGTH_SHORT).show();
        }
    }
}