package com.jktech.project01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    EditText nameEditText, emailEditText, phoneEditText, passwordEditText, confirmPasswordEditText;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        signUpButton = findViewById(R.id.signUpButton);

        // Set onClickListener for sign up button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve entered information
                String name = nameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String phone = phoneEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();

                // Validate if all fields are not empty
                if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()) {
                    // Check if password matches confirm password
                    if (password.equals(confirmPassword)) {
                        // Implement sign up functionality here
                        // For now, let's just show a toast message
                        Toast.makeText(MainActivity3.this, "Sign Up successful with name: " + name + ", email: " + email + ", phone: " + phone + ", password: " + password, Toast.LENGTH_SHORT).show();

                        // Start navigationdrawer activity after sign up
                        startActivity(new Intent(MainActivity3.this, navigationdrawer.class));
                    } else {
                        // Show error message if passwords do not match
                        Toast.makeText(MainActivity3.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Show error message if any field is empty
                    Toast.makeText(MainActivity3.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
