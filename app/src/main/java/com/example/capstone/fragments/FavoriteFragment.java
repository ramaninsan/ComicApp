package com.example.capstone.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.capstone.GlobalApp;
import com.example.capstone.R;
import com.example.capstone.ReadComicActivity;
import com.example.capstone.utils.MyRecycleItemClick;

import java.util.ArrayList;
import java.util.List;

import Pojos.DataAllComics;
import Pojos.HeaderAllComics;
import ratofit.RestService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class FavoriteFragment extends Fragment {


    View v;
    RecyclerView rcView;

    private List<DataAllComics> dataAllComicsList;
    FavoriteAdapter mAdapter;
    DataAllComics dataAllComics;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_favorite, container, false);
        rcView  = v.findViewById(R.id.rvFav);
        getAllComics();

        rcView.addOnItemTouchListener(new MyRecycleItemClick(getActivity(), new MyRecycleItemClick.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position) {

                dataAllComics = dataAllComicsList.get(position);

                Intent intent = new Intent(getActivity(), ReadComicActivity.class);
                intent.putExtra("COMICDATA",dataAllComics);
                startActivity(intent);

            }
        }));
        return v;
    }


    private void bindAdapter(List<DataAllComics> dataAllComics) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcView.setLayoutManager(layoutManager);

        mAdapter = new FavoriteAdapter(dataAllComics,getContext());
        rcView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
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

                    bindAdapter(dataAllComicsList);

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
