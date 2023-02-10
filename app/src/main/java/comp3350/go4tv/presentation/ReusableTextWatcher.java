package comp3350.go4tv.presentation;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class ReusableTextWatcher implements TextWatcher {
    private EditText editText;

    public ReusableTextWatcher(EditText editText) {
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable field) {
        if (editText.length() == 0) {
            editText.setError("Field cannot be empty!");
        }
    }
}