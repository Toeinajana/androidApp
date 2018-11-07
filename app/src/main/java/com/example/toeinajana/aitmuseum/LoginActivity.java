package com.example.toeinajana.aitmuseum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {

    ImageView ggLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //fbLogin = (ImageView) findViewById(R.id.fb);
        ggLogin = (ImageView) findViewById(R.id.gg);

    }



    public void ggLogin (View view) {

        Intent intent = new Intent(LoginActivity.this, GoogglePage.class);
        startActivity(intent);


    }
}
