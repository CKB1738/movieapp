package comp3350.go4tv.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import comp3350.go4tv.R;
import comp3350.go4tv.application.Main;
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
        copyDatabaseToDevice();
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

    private void copyDatabaseToDevice() {
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);

            Main.setDBPathName(dataDirectory.toString() + "/" + Main.getDBPathName());

        } catch (final IOException ioe) {
            Messages.warning(this, "Unable to access application data: " + ioe.getMessage());
        }
    }

    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];
            Log.d("FILE", copyPath);
            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
           // if(true){
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }


}