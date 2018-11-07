package com.example.toeinajana.aitmuseum;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;

public class CameraActivity extends AppCompatActivity {


    //public static final int CAMERA_REQUEST=9999;

    TextView prve, next;

    Button button, camerabtn;

    //ImageView imageView_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);


        prve = (TextView) findViewById(R.id.prev);
        next = (TextView) findViewById(R.id.next);

        button = (Button) findViewById(R.id.button);
         camerabtn = (Button) findViewById(R.id.camerabtn);

        //imageView_1 = (ImageView) findViewById(R.id.imageView_1);


        popUpMenu();


    }



    public void popUpMenu () {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(CameraActivity.this, button);
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){


                            case R.id.btn2:
                                Intent intent2 = new Intent(CameraActivity.this, QrcodeActivity.class);
                                startActivity(intent2);
                                return true;

                            case R.id.btn3:
                                Intent intent3 = new Intent(CameraActivity.this, CameraActivity.class);
                                startActivity(intent3);
                                return true;

                            case R.id.btn4:
                                Intent intent4 = new Intent(CameraActivity.this, VisitActivity.class);
                                startActivity(intent4);
                                return true;

                            case R.id.btn5:
                                Intent intent5 = new Intent(CameraActivity.this, GoogglePage.class);
                                startActivity(intent5);
                                return true;

                            case R.id.btn6:
                                Intent intent6 = new Intent(CameraActivity.this, MainActivity.class);
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

        Intent intent = new Intent(CameraActivity.this, MainActivity.class);
        startActivity(intent);


    }

    public void cameraModule (View view){

        Intent intent = new Intent(CameraActivity.this, CameraModule.class);
        startActivity(intent);


    }


   /* public void OpenCamera(View view) {


        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAMERA_REQUEST)
        {
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            imageView_1.setImageBitmap(bitmap);

        }



    }*/
}
