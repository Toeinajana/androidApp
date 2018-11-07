package com.example.toeinajana.aitmuseum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.ViewFlipper;



public class MainActivity extends AppCompatActivity {


    Button button;
    ViewFlipper slider;
    TextView prve, next, more1, more2, more3,textViking;
    ImageView viking2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        more1 = (TextView) findViewById(R.id.more);
        more2 = (TextView) findViewById(R.id.more2);
        more3 = (TextView) findViewById(R.id.more3);


        prve = (TextView) findViewById(R.id.prev);
        next = (TextView) findViewById(R.id.next);
        button = (Button) findViewById(R.id.button);
        slider = findViewById(R.id.slider);


        int pics[] = {R.drawable.ancient, R.drawable.group, R.drawable.kid, R.drawable.man, R.drawable.sport};


        textViking = (TextView) findViewById(R.id.textViking);
        viking2 = (ImageView) findViewById(R.id.viking2);




        popUpMenu();

        //loop for slider
        for (int pic : pics) picSlider(pic);

    }

    public void popUpMenu() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, button);
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {



                            case R.id.btn2:
                                Intent intent2 = new Intent(MainActivity.this, QrcodeActivity.class);
                                startActivity(intent2);
                                return true;

                            case R.id.btn3:
                                Intent intent3 = new Intent(MainActivity.this, CameraActivity.class);
                                startActivity(intent3);
                                return true;

                            case R.id.btn4:
                                Intent intent4 = new Intent(MainActivity.this, VisitActivity.class);
                                startActivity(intent4);
                                return true;

                            case R.id.btn5:
                                Intent intent5 = new Intent(MainActivity.this, GoogglePage.class);
                                startActivity(intent5);
                                return true;

                            case R.id.btn6:
                                Intent intent6 = new Intent(MainActivity.this, MainActivity.class);
                                startActivity(intent6);
                                return true;


                        }


                        return true;
                    }
                });
                popupMenu.show();

            }
        });
    }

    public void picSlider(int pic) {


        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(pic);

        slider.addView(imageView);
        slider.setFlipInterval(3000);
        slider.setAutoStart(true);

        //animation

        slider.setInAnimation(this, android.R.anim.slide_in_left);
        slider.setOutAnimation(this, android.R.anim.slide_out_right);


    }



    public void prve (View view) {

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);


    }

    public void more1 (View view) {

        Intent intent = new Intent(MainActivity.this, ScienceActivity.class);
        startActivity(intent);


    }

    public void more2 (View view) {

        Intent intent = new Intent(MainActivity.this, CultureActivity.class);
        startActivity(intent);


    }

    public void more3 (View view) {

        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(intent);


    }


    public void science (View view) {


    Intent intent = new Intent(MainActivity.this, DetailPageActivity.class);
    startActivity(intent);


}


}
