package com.jktech.project01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    EditText emailEditText, passwordEditText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        // Initialize views
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passWord);
        loginButton = findViewById(R.id.loginButton);

        // Set onClickListener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve entered email and password
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validate if email and password are not empty
                if (!email.isEmpty() && !password.isEmpty()) {
                    // Implement login functionality here
                    // For now, let's just show a toast message
                    Toast.makeText(MainActivity2.this, "Login clicked with email: " + email + " and password: " + password, Toast.LENGTH_SHORT).show();

                    // Start navigationdrawer activity after login
                    startActivity(new Intent(MainActivity2.this, navigationdrawer.class));
                } else {
                    // Show error message if email or password is empty
                    Toast.makeText(MainActivity2.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
