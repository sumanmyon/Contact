package com.example.suman.contact.LoginAndSignUpPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suman.contact.MainActivity;
import com.example.suman.contact.R;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button login, signup;
    private TextView forgetPassword;

    private void castEveryThingHere() {
        username = (EditText)findViewById(R.id.editText_username_login);
        password = (EditText)findViewById(R.id.editText_password_login);
        login = (Button)findViewById(R.id.button_login);
        signup = (Button)findViewById(R.id.button_signup_login);
        forgetPassword = (TextView)findViewById(R.id.textView_forget_pass_login);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //TODO make activity full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        castEveryThingHere();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email ="";
                String pass ="";
                email = username.getText().toString();
                pass = password.getText().toString();

                if(!email.equals("") && !pass.equals("")){
                    loginPage(email, pass);
                }else {
                    if(email.equals("")){
                        username.setError("Username required");
                    }
                    if(pass.equals("")){
                        password.setError("Password required");
                    }
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signupPage();
            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgetPasswordPage();
            }
        });

    }

    private void loginPage(String email, String pass) {
        //Toast.makeText(LoginActivity.this,"Successfully login",Toast.LENGTH_LONG).show();
        Intent mainIntent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(mainIntent);
        finish();
    }

    private void signupPage() {
        Intent signupIntent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(signupIntent);
        finish();
    }

    private void forgetPasswordPage() {
        Intent forgetIntent = new Intent(LoginActivity.this, ForgetPasswordPage.class);
        startActivity(forgetIntent);
        finish();
    }

}
