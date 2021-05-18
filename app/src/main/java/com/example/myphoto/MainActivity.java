package com.example.myphoto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnFoto;
    ImageView ivFoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFoto = (Button) findViewById(R.id.btnFoto);
        ivFoto = (ImageView) findViewById(R.id.ivFoto);

    btnFoto.setOnClickListener(new View.OnClickListener()
    {
    @Override
    public void onClick(View view)
    {
        Capturar();}
    });

    }

    public void Capturar()
    {
        Toast.makeText(this, "Comenzando Camara", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 1);
    }

    //Se debe sobreescribir un metodo que lanza la camara

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK)
        {
            Bundle ext = data.getExtras();
            Bitmap bmp = (Bitmap) ext.get("data");
            ivFoto.setImageBitmap(bmp);
        }
    }
}
