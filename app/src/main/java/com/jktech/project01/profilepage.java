package com.jktech.project01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class profilepage extends AppCompatActivity {

    private EditText nameEditText, emailEditText, phoneEditText, addressEditText;
    private RadioButton maleRadioButton, femaleRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        // Initialize EditText fields
        nameEditText = findViewById(R.id.textView2);
        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        phoneEditText = findViewById(R.id.editTextPhone);
        addressEditText = findViewById(R.id.editTextTextPostalAddress);

        // Initialize RadioButtons
        maleRadioButton = findViewById(R.id.radioButton);
        femaleRadioButton = findViewById(R.id.radioButton2);

        Button saveButton = findViewById(R.id.button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateForm()) {
                    // Process the form submission
                    saveChanges();
                } else {
                    Toast.makeText(profilepage.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button cancelButton = findViewById(R.id.button2);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle cancellation
                cancelChanges();
            }
        });

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean validateForm() {
        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String address = addressEditText.getText().toString().trim();

        // Check if any field is empty
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || (!maleRadioButton.isChecked() && !femaleRadioButton.isChecked())) {
            return false;
        }

        // You can add more specific validation rules here if needed (e.g., email format, phone number format)

        return true;
    }

    private void saveChanges() {
        // Here you can handle the form submission, such as saving data to a database
        // For demonstration purposes, we'll just display a toast message
        Toast.makeText(this, "Changes saved successfully!", Toast.LENGTH_SHORT).show();
    }

    private void cancelChanges() {
        // Handle cancellation, such as returning to the previous activity
        finish();
    }
}
