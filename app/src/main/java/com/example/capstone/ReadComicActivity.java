package com.example.capstone;

import android.content.Intent;
import android.graphics.BlurMaskFilter;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.capstone.fragments.ChapterAdapter;
import com.example.capstone.fragments.ListAdapter;
import com.example.capstone.utils.MyRecycleItemClick;

import java.util.ArrayList;
import java.util.List;

import Pojos.DataAllComics;
import Pojos.HeaderAllComics;
import ratofit.RestService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ReadComicActivity extends AppCompatActivity {

    TextView tvTitle;
    ImageView imgBack;
    ImageView imgFav;
    ImageView imageComic;
    TextView textComic,tvSynopsis;
    RecyclerView rvChapters;
    List<DataAllComics> dataAllComicsList;
    List<String> chapterTitles;
    DataAllComics dataAllComics;
    String comicName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getSupportActionBar().hide();

        setContentView(R.layout.activity_read_comic);

        imgBack = findViewById(R.id.back);
        imgFav = findViewById(R.id.imgFav);
        imageComic = findViewById(R.id.imageComic);
        textComic = findViewById(R.id.tv);
        tvTitle = findViewById(R.id.title);
        tvSynopsis = findViewById(R.id.tvSynopsis);


        Intent intent = getIntent();
        dataAllComics = (DataAllComics) intent.getSerializableExtra("COMICDATA");


        Glide.with(this)
                .load(dataAllComics.getCoverImage())
                .into(imageComic);


        getAllComics();


        imgFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




        chapterTitles = new ArrayList<>();
        chapterTitles.add("Chapter 1");
        chapterTitles.add("Chapter 2");
        chapterTitles.add("Chapter 3");
        chapterTitles.add("Chapter 4");
        chapterTitles.add("Chapter 5");
        chapterTitles.add("Chapter 6");



        rvChapters = findViewById(R.id.rvChapters);
       // rvChapters.setLayoutManager( new GridLayoutManager(this, 2));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvChapters.setLayoutManager( layoutManager);
        ChapterAdapter mAdapter = new ChapterAdapter(dataAllComicsList,dataAllComics.getCoverImage(), chapterTitles,this);
        rvChapters.setAdapter(mAdapter);

        rvChapters.addOnItemTouchListener(new MyRecycleItemClick(this, new MyRecycleItemClick.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position) {

                dataAllComics = dataAllComicsList.get(position);

                Intent intent = new Intent(getApplicationContext(), ReadDescActvity.class);
                intent.putExtra("COMICDATA",dataAllComics);
                intent.putExtra("POSITION", position+1);
                intent.putExtra("NAME", comicName);
                startActivity(intent);

            }
        }));






        tvTitle.setText(dataAllComics.getComicTitle());
        comicName = dataAllComics.getComicTitle();
        tvSynopsis.setText(dataAllComics.getSynopsis());
        tvSynopsis.setMovementMethod(new ScrollingMovementMethod());


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void getAllComics(){


        RestService service = GlobalApp.getRestService();

        service.getAllComics(new Callback<HeaderAllComics>() {
            @Override
            public void success(HeaderAllComics data, Response response) {

                boolean success = data.isIsSuccess();

                if (success) {

                    dataAllComicsList = data.getResult();
                    ArrayList<String> items = new ArrayList<String>();

                   // bindAdapter(dataAllComicsList);

                 /*   for (int i = 0; i < dataAllComicsList.size(); i++) {
                        dataAllComics = dataAllComicsList.get(i);
                        items.add(dataAllComics.getAccountName());
                        ids.add(dataAllComics.getAccountID());
                    }

                    if (items.size() > 0) {
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Activity_AddCouponManually.this, android.R.layout.simple_spinner_dropdown_item, items);

                        spn_provider.setAdapter(adapter);

                    } else {
                        Toast.makeText(Activity_AddCouponManually.this, "No provider is available ", Toast.LENGTH_LONG).show();
                        spn_provider.setAdapter(null);
                    }*/






                } else {

                }

            }

            @Override
            public void failure(RetrofitError error) {
                // showError(error.getMessage(),error.getMessage());
            }
        });
    }

}
