package com.example.val;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

        // Set TextWatchers for real-time validation
        editTextUsername.addTextChangedListener(usernameTextWatcher);
        editTextPassword.addTextChangedListener(passwordTextWatcher);
    }

    // TextWatcher for Username validation
    private final TextWatcher usernameTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // No action needed here
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            validateUsername(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            // No action needed here
        }
    };

    // TextWatcher for Password validation
    private final TextWatcher passwordTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // No action needed here
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            validatePassword(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            // No action needed here
        }
    };

    // Method to validate username as it's being typed
    private void validateUsername(String username) {
        if (TextUtils.isEmpty(username)) {
            editTextUsername.setError("Username cannot be empty");
        } else if (!username.matches("^(?=.*[0-9]).+[a-zA-Z0-9]+$")) {
            editTextUsername.setError("Username should contain at least one number and only alphabets or numbers");
        } else {
            editTextUsername.setError(null); // Clear the error if valid
        }
    }

    // Method to validate password as it's being typed
    private void validatePassword(String password) {
        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Password cannot be empty");
        } else if (!password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{6,}$")) {
            editTextPassword.setError("Password must have 1 uppercase, 1 number, and 1 special character");
        } else {
            editTextPassword.setError(null); // Clear the error if valid
        }
    }
}
