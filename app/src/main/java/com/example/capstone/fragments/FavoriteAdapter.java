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

import java.util.Currency;
import java.util.List;

import Pojos.DataAllComics;

public class FavoriteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<DataAllComics> mList;
    public FavoriteAdapter(List<DataAllComics> list, Context context){
        super();
        mList = list;
        context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite,parent,false);
        FavoriteAdapter.ViewHolder viewHolder1 = new FavoriteAdapter.ViewHolder(v);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DataAllComics data = mList.get(position);


        ((FavoriteAdapter.ViewHolder) holder).name.setText( String.valueOf(data.getComicTitle()));
       ((FavoriteAdapter.ViewHolder) holder).tvAuthor.setText( String.valueOf(data.getAuthor()));
        Glide.with(((FavoriteAdapter.ViewHolder) holder).imageView).load(data.getThumbnailImage()).into(((FavoriteAdapter.ViewHolder) holder).imageView);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
                public TextView tvAuthor;
        public ImageView imageView;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tvTitle);
            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
            imageView = itemView.findViewById(R.id.imgComicImage);
        }
    }
}
