package comp3350.go4tv.business.validator;

import android.util.Patterns;

import androidx.core.util.PatternsCompat;

public class EmailValidator extends FieldValidator{
    private String emailString;
    public EmailValidator(String emailString) {
        super(emailString);
        this.emailString = emailString;
    }

    @Override
    public boolean isValid() {
        if(super.isValid() && PatternsCompat.EMAIL_ADDRESS.matcher(emailString).matches()){
            return true;
        }
        else {
            return false;
        }
    }
}