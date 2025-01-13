package com.myapplication.health;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

        public class LoginActivity extends AppCompatActivity {
            EditText etUsername, etPassword;
            CheckBox cbShowHidePassword;
            Button btnlogin;
            ImageView ivPlus;

            SharedPreferences preferences;//used to store temp data
            SharedPreferences.Editor editor;//used to put or edit the temp data
            @SuppressLint("MissingInflatedId")
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                EdgeToEdge.enable(this);
                setContentView(R.layout.activity_login);
                setTitle("Login Activity");


                preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                editor = preferences.edit();
                if (preferences.getBoolean("isLogin", false)) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }


                etUsername = findViewById(R.id.etLoginUsername);
                etPassword = findViewById(R.id.etLoginPassword);
                cbShowHidePassword = findViewById(R.id.cvLoginShowHidePassword);
                btnlogin = findViewById(R.id.btnLoginLogin);
                ivPlus = findViewById(R.id.ivPlus);

                cbShowHidePassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                    @Override

                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            etPassword.setTransformationMethod(cbShowHidePassword.getTransformationMethod());
                        } else {
                            etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

                        }
                    }
                });
                btnlogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (etUsername.getText().toString().isEmpty())
                        {
                            etUsername.setError("please Enter your username");

                        }  else if (etPassword.getText().toString().isEmpty()) {
                            etPassword.setError("Please Enter Your Password");

                        } else if (etUsername.getText().toString().length()<8) {
                            etUsername.setError("Please Enter 8 character username");
                        } else if (etPassword.getText().toString().length()<8) {
                            etPassword.setError("Please enter 8 character password");



                        }else
                        {
                            Toast.makeText(LoginActivity.this,"Login Successfully Done",Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(LoginActivity.this,HomeActivity.class);

                            editor.putBoolean("isLogin",true).commit();
                            startActivity(intent);
                        }
                    }
                });
                ivPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i =new Intent(LoginActivity.this,RegisterActivity.class);
                        startActivity(i);

                    }
                });

    }
}