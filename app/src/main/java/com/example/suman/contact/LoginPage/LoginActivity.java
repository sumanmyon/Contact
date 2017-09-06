package com.example.suman.contact.LoginPage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.suman.contact.MainActivity;
import com.example.suman.contact.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            callme();
    }

    private void callme() {
        Toast.makeText(LoginActivity.this,"hi",Toast.LENGTH_LONG).show();
    }
}
