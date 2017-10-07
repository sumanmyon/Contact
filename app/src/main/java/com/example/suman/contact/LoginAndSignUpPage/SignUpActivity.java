package com.example.suman.contact.LoginAndSignUpPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.suman.contact.R;

public class SignUpActivity extends AppCompatActivity {

    private EditText email, username, password, repassword;
    private Button signup;

    private void castEveryThingHere() {
        email = (EditText)findViewById(R.id.editText_email_signup);
        username = (EditText)findViewById(R.id.editText_username_signup);
        password =(EditText)findViewById(R.id.editText_password_signup);
        repassword = (EditText)findViewById(R.id.editText_repassword_signup);
        signup = (Button)findViewById(R.id.button_signup);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //TODO make activity full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        castEveryThingHere();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail="", user="", pass="", repass="";
                mail = email.getText().toString();
                user = username.getText().toString();
                pass = password.getText().toString();
                repass = repassword.getText().toString();

                if(!mail.equals("") && !user.equals("") && !pass.equals("") && !repass.equals("")){
                    if(pass.equals(repass)){
                        signupPage(mail, user, pass, repass);

                    }else {
                        password.setError("Confirm Password");
                        repassword.setError("Confirm Password");
                    }

                }else {
                    if(mail.equals("")){
                        email.setError("Email required");
                    }
                    if(user.equals("")){
                        username.setError("Username required");
                    }
                    if(pass.equals("")){
                        password.setError("Password required");
                    }
                    if(repass.equals("")){
                        repassword.setError("Retype Password");
                    }
                }
            }
        });

    }

    private void signupPage(String mail, String user, String pass, String repass) {
        Toast.makeText(SignUpActivity.this,"Successful",Toast.LENGTH_LONG).show();

        Intent loginIntent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }


}
