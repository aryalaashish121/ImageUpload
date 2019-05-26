package com.example.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HeroActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonbrowse,buttonAddHero,buttonUpload;
    ImageView imageViewBrowsedImage;
    EditText editTextName,editTextDesc,editTextImage;
    Uri imageUri;
    Bitmap bitmap;
    private static final int PICK_IMaGE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);

        editTextName = findViewById(R.id.et_name);
        editTextDesc = findViewById(R.id.etDesc);
        editTextImage = findViewById(R.id.etImage);
        imageViewBrowsedImage = findViewById(R.id.ivImageBrowsed);

        buttonbrowse = findViewById(R.id.btnBrowse);
        buttonAddHero = findViewById(R.id.addHero);
        buttonUpload = findViewById(R.id.btUpload);

        buttonbrowse.setOnClickListener(this);
        buttonUpload.setOnClickListener(this);
        buttonAddHero.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnBrowse){
            openGallary();
        }
        if(v.getId()==R.id.btUpload){

        }
        if(v.getId()==R.id.addHero){

        }

    }

    private void openGallary(){
        Intent gallery = new Intent();
        gallery.setType("image/*;");
        gallery.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(gallery,"Choose Image"),PICK_IMaGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==PICK_IMaGE && resultCode==RESULT_OK){


                try {
                    imageUri = data.getData();
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
                    imageViewBrowsedImage.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
