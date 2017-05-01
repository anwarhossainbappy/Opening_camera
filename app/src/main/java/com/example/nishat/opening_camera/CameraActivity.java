package com.example.nishat.opening_camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
    }

    private static final int REQ_CODE_TAKE_PICTURE=30222;
    public void takePicture(View view) {
        Intent picIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(picIntent,REQ_CODE_TAKE_PICTURE);
    }

    protected void onActivityResult(int reqCode, int resultCode, Intent intent){
        if(reqCode == REQ_CODE_TAKE_PICTURE
                && resultCode == RESULT_OK)  {
            Bitmap bmp = (Bitmap) intent.getExtras().get("data");
            ImageView img = (ImageView) findViewById(R.id.photo);
            img.setImageBitmap(bmp);
        }
    }
}
