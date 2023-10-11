package com.codewithmanav.room;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GetImage extends AppCompatActivity {

    Button takeImg;
    ImageView setImg;

    private  final int Req_code = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_image);


        takeImg = (Button) findViewById(R.id.openCam);
        setImg = (ImageView) findViewById(R.id.imageCam);



        takeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(getImage,Req_code);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode==Req_code){


                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                setImg.setImageBitmap(bitmap);

            }
        }
    }
}