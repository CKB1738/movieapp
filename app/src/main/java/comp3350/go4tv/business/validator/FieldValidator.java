package comp3350.go4tv.business.validator;

public class FieldValidator {
    private String fieldString;

    public FieldValidator(String fieldString) {
        this.fieldString = fieldString;

    }

    public boolean isValid() {
        if(fieldString.length() != 0) {
            return true;
        }
        else{
            return false;
        }

    }
}