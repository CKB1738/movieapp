package comp3350.go4tv.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import comp3350.go4tv.R;
import comp3350.go4tv.business.AccessUser;
import comp3350.go4tv.objects.User;

public class UserProfileActivity extends AppCompatActivity {
    EditText email, password;
    TextView username;
    Button showFavouriteListButton, updateEmailButton, updatePasswordButton;
    AccessUser accessUser;
    User currentUser;
    String usernameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Profile");
        setContentView(R.layout.activity_user_profile);

        accessUser = new AccessUser();
        username = (TextView) findViewById(R.id.profileUsername);
        email = (EditText) findViewById(R.id.profileEmail);
        password = (EditText) findViewById(R.id.profilePassword);


        updateEmailButton = (Button) findViewById(R.id.updateEmail);
        updatePasswordButton = (Button) findViewById(R.id.updatePassword);
        showFavouriteListButton = (Button) findViewById(R.id.movieListButton);

        updateEmailButton.setOnClickListener(updateEmailButtonListener);
        updatePasswordButton.setOnClickListener(updatePasswordButtonListener);
        showFavouriteListButton.setOnClickListener(showFavouriteListButtonListener);

        Intent i = getIntent();
        usernameString = i.getStringExtra("username");
        currentUser = accessUser.findUser(usernameString);

        username.setText(currentUser.getUserName());
        email.setText(currentUser.getEmail());
        password.setText(currentUser.getPassword());

        //set onclick listening
    }


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

    private View.OnClickListener showFavouriteListButtonListener = new View.OnClickListener(){

        @Override public void onClick(View v){
            showMyFavouriteList(v);
        }
    };


    private void showMyFavouriteList(View v){

        Intent i  = new Intent(this, FavouriteListActivity.class);
        i.putExtra("username",usernameString);
        startActivity(i);

    }
    private void updateEmailButtonClicked(View v) {
        String newEmail = email.getText().toString();
        User currUser = accessUser.updateUser(usernameString, currentUser.getPassword(), newEmail);

        email.setText(currUser.getEmail());
        Toast.makeText(this, "Successfully updated email.", Toast.LENGTH_SHORT).show();
    }

    private void updatePasswordButtonClicked(View v) {
        String newPassword = password.getText().toString();

        User currUser = accessUser.updateUser(usernameString, newPassword, currentUser.getEmail());
        password.setText(currUser.getPassword());
        Toast.makeText(this, "Successfully updated password.", Toast.LENGTH_SHORT).show();
    }
}