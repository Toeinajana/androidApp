package com.example.toeinajana.aitmuseum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class DetailPageActivity extends AppCompatActivity {


    TextView prve, next;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        prve = (TextView) findViewById(R.id.prev);
        next = (TextView) findViewById(R.id.next);

        button = (Button) findViewById(R.id.button);
        popUpMenu();


    }



    public void popUpMenu () {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(DetailPageActivity.this, button);
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){



                            case R.id.btn2:
                                Intent intent2 = new Intent(DetailPageActivity.this, QrcodeActivity.class);
                                startActivity(intent2);
                                return true;

                            case R.id.btn3:
                                Intent intent3 = new Intent(DetailPageActivity.this, CameraActivity.class);
                                startActivity(intent3);
                                return true;

                            case R.id.btn4:
                                Intent intent4 = new Intent(DetailPageActivity.this, VisitActivity.class);
                                startActivity(intent4);
                                return true;

                            case R.id.btn5:
                                Intent intent5 = new Intent(DetailPageActivity.this, GoogglePage.class);
                                startActivity(intent5);
                                return true;

                            case R.id.btn6:
                                Intent intent6 = new Intent(DetailPageActivity.this, MainActivity.class);
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



    public void prve (View view) {

        Intent intent = new Intent(DetailPageActivity.this, HistoryActivity.class);
        startActivity(intent);


    }
}
