package com.example.capstone.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.capstone.GlobalApp;
import com.example.capstone.R;


import com.example.capstone.ReadComicActivity;
import com.example.capstone.dataClasses.Pizza;
import com.example.capstone.utils.MyRecycleItemClick;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import Pojos.DataAllComics;
import Pojos.HeaderAllComics;
import Pojos.LoginResponse;
import ratofit.RestService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ListFragment extends Fragment {

    RecyclerView rcView, rcViewRecent, rcRecommend;
    EditText etSearch;
    View v;
    List<Pizza> mList = new ArrayList<>();
    //DBHelper dbh;
    ListAdapter mAdapter;
    ListRecommendAdapter mAdapter2;

    Pizza pizzaData;

    private List<DataAllComics> dataAllComicsList;
    DataAllComics dataAllComics;

    public ListFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frament_list, container, false);

        rcView = v.findViewById(R.id.rv);
        rcViewRecent = v.findViewById(R.id.rvRecent);
        rcRecommend = v.findViewById(R.id.rvRecommend);

        etSearch = v.findViewById(R.id.etSearch);

        getActivity().setTitle(R.string.menu);


      /*  dbh = new DBHelper(getActivity());
        Cursor cursor1 = dbh.ListItems();
        if (cursor1.getCount() == 0) {
            Toast.makeText(getActivity(), "No Record Found", Toast.LENGTH_SHORT).show();
            return v;
        } else {
            cursor1.moveToFirst();
            do {

                Pizza pizza = new Pizza();
                pizza.setId(cursor1.getInt(0));
                pizza.setName(cursor1.getString(1));
                pizza.setQuantity(cursor1.getInt(2));
                pizza.setPrice(cursor1.getInt(3));
                pizza.setCalories(cursor1.getString(4));
                pizza.setPrepTime(cursor1.getString(5));
                pizza.setSize(cursor1.getString(6));
                pizza.setImage(cursor1.getInt(7));
                mList.add(pizza);

            } while (cursor1.moveToNext());
            cursor1.close();
            dbh.close();*/                 // else bracket is closed below


        Pizza pizza = new Pizza();
        /*pizza.setName("Superman");
        pizza.setImage(R.drawable.bg1);
        Pizza pizza2 = new Pizza();
        pizza.setName("Superman2");
        pizza.setImage(R.drawable.bg1);
        mList.add(pizza);
        mList.add(pizza2);*/

        String[] names = {"Joker R","Dragon Ball Z","Batman and Gotham","Hakuna","Rocky Maivia"};
        int[] ima = {R.drawable.ab3,R.drawable.ab2,R.drawable.ab4,R.drawable.ab8, R.drawable.ab};


        for (int i = 0; i < 5; i++) {
            pizza = new Pizza();
            pizza.setName(names[i]);
            pizza.setImage(ima[i]);
            mList.add(pizza);
        }

        //    bindAdapter();


            rcView.addOnItemTouchListener(new MyRecycleItemClick(getActivity(), new MyRecycleItemClick.OnItemClickListener(){
                @Override
                public void onItemClick(View view, int position) {

                    dataAllComics = dataAllComicsList.get(position);

                    Intent intent = new Intent(getActivity(), ReadComicActivity.class);
                   intent.putExtra("COMICDATA",dataAllComics);
                   startActivity(intent);

                }
            }));


        rcViewRecent.addOnItemTouchListener(new MyRecycleItemClick(getActivity(), new MyRecycleItemClick.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position) {

                dataAllComics = dataAllComicsList.get(position);

                Intent intent = new Intent(getActivity(), ReadComicActivity.class);
                intent.putExtra("COMICDATA",dataAllComics);
                startActivity(intent);

            }
        }));


        rcRecommend.addOnItemTouchListener(new MyRecycleItemClick(getActivity(), new MyRecycleItemClick.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position) {

                dataAllComics = dataAllComicsList.get(position);

                Intent intent = new Intent(getActivity(), ReadComicActivity.class);
                intent.putExtra("COMICDATA",dataAllComics);
                startActivity(intent);

            }
        }));


            etSearch.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    if(s.length() > 2 ){
                         //filter(s.toString());
                    } else {
                     //   bindAdapter();
                    }


                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });




getAllComics();


            return v;
      //  }   else bracket from above

    }


    private void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<Pizza> filteredlist = new ArrayList<>();

        // running a for loop to compare elements.
        for (Pizza item : mList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(getActivity(), "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            mAdapter.filterList(filteredlist);
        }
    }



    private void bindAdapter(List<DataAllComics> dataAllComics) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
        rcView.setLayoutManager( new GridLayoutManager(getActivity(), 3));

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
        rcViewRecent.setLayoutManager(layoutManager2);

        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
        rcRecommend.setLayoutManager(layoutManager3);


        mAdapter = new ListAdapter(dataAllComics,getContext());
        rcView.setAdapter(mAdapter);
        rcViewRecent.setAdapter(mAdapter);

        mAdapter2 = new ListRecommendAdapter(dataAllComics,getContext());
        rcRecommend.setAdapter(mAdapter2);

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
