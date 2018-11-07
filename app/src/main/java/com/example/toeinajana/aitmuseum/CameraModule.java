package com.example.toeinajana.aitmuseum;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.zxing.integration.android.IntentIntegrator;

import java.io.File;

public class CameraModule extends Activity {


    Button button;
    ImageView imageViewCamera;
    //static final int CAM_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_module);

        button = (Button) findViewById(R.id.button);
        //imageView = (ImageView) findViewById(R.id.image_view);
        Button btnCamera = (Button) findViewById(R.id.btnCamera);

        imageViewCamera = (ImageView) findViewById(R.id.imageViewCamera);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       super.onActivityResult(requestCode,resultCode,data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        imageViewCamera.setImageBitmap(bitmap);


    }

}
