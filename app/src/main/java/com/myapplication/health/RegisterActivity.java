package com.myapplication.health;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity{
    EditText etName,etMobbileNo,etEmailId,etUsername,etPassword;
    Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        setTitle("Registration Activity");
        etName = findViewById(R.id.etRegisterName);
        etEmailId = findViewById(R.id.etRegistrationEmailId);
        etMobbileNo = findViewById(R.id.etRegistrationMobileNumber);
        etUsername = findViewById(R.id.etRegisterUsername);
        etPassword = findViewById(R.id.etRegistrationPassword);
        btnRegister = findViewById(R.id.btnRegistrationRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etName.getText().toString().isEmpty()) {
                    etName.setError("Please Enter Your name");
                } else if (etMobbileNo.getText().toString().isEmpty()) {
                    etMobbileNo.setError("Please Enter Your mobile no.");
                } else if (etMobbileNo.getText().toString().length() != 10) {
                    etMobbileNo.setError("Invalid mobile number");
                } else if (etEmailId.getText().toString().isEmpty()) {
                    etEmailId.setError("please enter email id");

                } else if (!etEmailId.getText().toString().contains("@") ||
                        !etEmailId.getText().toString().contains(".com")) {
                    etEmailId.setError("please enter valid emai id");
                } else if (etUsername.getText().toString().isEmpty()) {
                    etMobbileNo.setError("Please Enter Your username");

                } else if (etUsername.getText().toString().length() < 8) {
                    etUsername.setError("Username must be greater than 8");
                } else if (!etUsername.getText().toString().matches(",*[A-Z].*")) {
                    etUsername.setError("please enter 1 uppercase");


                } else if (etPassword.getText().toString().isEmpty()) {
                    etPassword.setError("enter your password");
                } else if (etPassword.getText().toString().length() < 8) {
                    etPassword.setError("password must be greater than 8");
                } else {
                    Toast.makeText(RegisterActivity.this, "Registration successfully done", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }   }
