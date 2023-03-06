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
import comp3350.go4tv.objects.User;

public class UserProfileActivity extends AppCompatActivity {
    EditText username, email, password;
    Button updateUsernameButton, updateEmailButton, updatePasswordButton;
    AccessUser accessUser;
    User currentUser;
    String usernameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Profile");
        setContentView(R.layout.activity_user_profile);

        accessUser = new AccessUser();
        username = (EditText) findViewById(R.id.profileUsername);
        email = (EditText) findViewById(R.id.profileEmail);
        password = (EditText) findViewById(R.id.currentUserPassword);
        updateUsernameButton = (Button) findViewById(R.id.updateUsername);
        updateEmailButton = (Button) findViewById(R.id.updateEmail);
        updatePasswordButton = (Button) findViewById(R.id.updatePassword);

        Intent i = getIntent();
        usernameString = i.getStringExtra("username");
        currentUser = accessUser.findUser(usernameString);

        username.setText(currentUser.getUserName());
        email.setText(currentUser.getEmail());
        password.setText(currentUser.getPassword());

    }

    private View.OnClickListener updateProfileButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            updateUsernameButtonClicked(v);
        }
    };

    private View.OnClickListener updateEmailButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            updateEmailButtonClicked(v);
        }
    };

    private View.OnClickListener updatePasswordButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {updatePasswordButtonClicked(v);}
    };

    private void updateUsernameButtonClicked(View v) {
        String newUsername = username.getText().toString();
        accessUser.updateUser(usernameString, newUsername, currentUser.getPassword(), currentUser.getEmail());
        Toast.makeText(this, "Successfully updated username.", Toast.LENGTH_SHORT).show();

    }

    private void updateEmailButtonClicked(View v) {
        String newEmail = email.getText().toString();
        accessUser.updateUser(usernameString, usernameString, currentUser.getPassword(), newEmail);
        Toast.makeText(this, "Successfully updated email.", Toast.LENGTH_SHORT).show();
    }

    private void updatePasswordButtonClicked(View v) {
        String newPassword = password.getText().toString();
        accessUser.updateUser(usernameString, usernameString, newPassword, currentUser.getEmail());
        Toast.makeText(this, "Successfully updated password.", Toast.LENGTH_SHORT).show();
    }
}