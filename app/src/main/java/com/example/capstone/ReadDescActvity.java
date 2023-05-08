package com.example.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import Pojos.DataAllComics;

public class ReadDescActvity extends AppCompatActivity {

    TextView tvComicTitle,tvChapTitle,tvDesc;
    ImageView imgBack;
    DataAllComics dataAllComics;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_readcomic);

        tvComicTitle = findViewById(R.id.tvtitle);
        tvChapTitle = findViewById(R.id.tvChapTitle);
        tvDesc = findViewById(R.id.tvChap);
        imgBack = findViewById(R.id.back);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        dataAllComics = (DataAllComics) intent.getSerializableExtra("COMICDATA");
        int pos = intent.getIntExtra("POSITION",0);
        String comicName = intent.getStringExtra("NAME");

        tvComicTitle.setText(comicName);
        tvChapTitle.setText("Chapter" + " " + pos );
        tvDesc.setText(dataAllComics.getDescription());
    }
}
