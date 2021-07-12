package com.example.avaliacao2bimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //atributos
    private TextView lblNome;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private ImageView imgApp;
    private EditText txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


}