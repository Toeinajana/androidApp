package com.example.toeinajana.aitmuseum;

import android.app.Activity;
import android.content.Intent;

import android.net.Uri;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class QrcodeActivity extends AppCompatActivity {


    TextView prve, next, textViewShow;
    Button button, scan_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);



        scan_btn = (Button) findViewById(R.id.scan_btn);


        final Activity activity = this;
        scan_btn.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {

             IntentIntegrator integrator = new IntentIntegrator(activity);
             integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
             integrator.setPrompt("Scan");
             integrator.setCameraId(0);
             integrator.setBarcodeImageEnabled(false);
             integrator.initiateScan();


         }
                                    });


        prve = (TextView) findViewById(R.id.prev);
        next = (TextView) findViewById(R.id.next);


        textViewShow = (TextView) findViewById(R.id.textViewShow);
        button = (Button) findViewById(R.id.button);
        popUpMenu();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode,data);

        if(result!= null){

            if(result.getContents() == null){
                Toast.makeText(this, "You cancel the scanning", Toast.LENGTH_LONG).show();
            }

            if(Patterns.WEB_URL.matcher(result.getContents()).matches()) {
                // Open URL
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(result.getContents()));
                startActivity(browserIntent);
            }

            else {

                textViewShow.setText(String.valueOf(result.getContents()));

                //Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();


            }
        }
        else {

            textViewShow.setText(String.valueOf(result.getContents()));

            //super.onActivityResult(requestCode,resultCode,data);
        }


        textViewShow.setText(String.valueOf(result.getContents()));
        //super.onActivityResult(requestCode, resultCode, data);
    }




    public void popUpMenu () {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(QrcodeActivity.this, button);
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){


                            case R.id.btn2:
                                Intent intent2 = new Intent(QrcodeActivity.this, QrcodeActivity.class);
                                startActivity(intent2);
                                return true;

                            case R.id.btn3:
                                Intent intent3 = new Intent(QrcodeActivity.this, CameraActivity.class);
                                startActivity(intent3);
                                return true;

                            case R.id.btn4:
                                Intent intent4 = new Intent(QrcodeActivity.this, VisitActivity.class);
                                startActivity(intent4);
                                return true;

                            case R.id.btn5:
                                Intent intent5 = new Intent(QrcodeActivity.this, GoogglePage.class);
                                startActivity(intent5);
                                return true;

                            case R.id.btn6:
                                Intent intent6 = new Intent(QrcodeActivity.this, MainActivity.class);
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

        Intent intent = new Intent(QrcodeActivity.this, MainActivity.class);
        startActivity(intent);


    }



}
