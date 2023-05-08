package com.example.capstone.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.capstone.R;
import com.example.capstone.dataClasses.Pizza;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import Pojos.DataAllComics;
import de.hdodenhof.circleimageview.CircleImageView;

public class ChapterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DataAllComics> mList;
    private List<String> namesList;
    private String image;
    public ChapterAdapter(List<DataAllComics> list, String Image ,List<String> chapterTitles, Context context){
        super();
        mList = list;
        namesList = chapterTitles;
        image = Image;
        context = context;
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<Pizza> filterllist) {
        // below line is to add our filtered
        // list in our course array list.
        //mList = filterllist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chapters,parent,false);
        ViewHolder viewHolder1 = new ViewHolder(v);
        return viewHolder1;

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

//        DataAllComics data = mList.get(position);
        String name = namesList.get(position);



        Currency cur = Currency.getInstance("USD");
        // Get and print the symbol of the currency
        String symbol = cur.getSymbol();
        ((ViewHolder) holder).name.setText(name);
       // ((ViewHolder) holder).size.setText("SIZE " + String.valueOf(pizza.getSize()));
      //  ((ViewHolder) holder).imageView.setImageResource(data.getCoverImage());

        Glide.with(((ViewHolder) holder).circleImageView).load(image).into(((ViewHolder) holder).circleImageView);
    }

    @Override
    public int getItemCount() {
        return namesList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
       // public ImageView imageView;
        public CircleImageView circleImageView;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tvChapter);
            circleImageView = itemView.findViewById(R.id.imgComic);
        }
    }
}