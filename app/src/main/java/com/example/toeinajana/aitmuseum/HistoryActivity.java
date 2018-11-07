package com.example.toeinajana.aitmuseum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {


    TextView prve, next , textViking;
    ImageView viking2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        prve = (TextView) findViewById(R.id.prev);
        next = (TextView) findViewById(R.id.next);
        textViking = (TextView) findViewById(R.id.textViking);
        viking2 = (ImageView) findViewById(R.id.viking2);

        button = (Button) findViewById(R.id.button);
        popUpMenu();
    }


    public void popUpMenu () {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(HistoryActivity.this, button);
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){


                            case R.id.btn2:
                                Intent intent2 = new Intent(HistoryActivity.this, QrcodeActivity.class);
                                startActivity(intent2);
                                return true;

                            case R.id.btn3:
                                Intent intent3 = new Intent(HistoryActivity.this, CameraActivity.class);
                                startActivity(intent3);
                                return true;

                            case R.id.btn4:
                                Intent intent4 = new Intent(HistoryActivity.this, VisitActivity.class);
                                startActivity(intent4);
                                return true;

                            case R.id.btn5:
                                Intent intent5 = new Intent(HistoryActivity.this, GoogglePage.class);
                                startActivity(intent5);
                                return true;

                            case R.id.btn6:
                                Intent intent6 = new Intent(HistoryActivity.this, MainActivity.class);
                                startActivity(intent6);
                                return true;

                        }


                        /*int id = item.getItemId();


                        if (id == R.id.btn1) {

                            Intent intent = new Intent(MainActivity.this, SectionActivity.class);
                            startActivity(intent);
                            return false;


                        }*/

                        return true;
                    }
                });
                popupMenu.show();

            }
        });
    }

    public void prve (View view) {

        Intent intent = new Intent(HistoryActivity.this, MainActivity.class);
        startActivity(intent);


    }

    public void viking2 (View view) {

        Intent intent = new Intent(HistoryActivity.this, DetailPageActivity.class);
        startActivity(intent);


    }

    public void textViking (View view) {

        Intent intent = new Intent(HistoryActivity.this, DetailPageActivity.class);
        startActivity(intent);


    }




}
