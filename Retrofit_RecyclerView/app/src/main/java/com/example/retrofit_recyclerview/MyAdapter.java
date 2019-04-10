package com.example.retrofit_recyclerview;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofit_recyclerview.Model.WorldPopulation;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<WorldPopulation> myList;
    Context applicationContext;

    public MyAdapter(Context applicationContext, int listID, List<WorldPopulation> myList) {
        this.myList = myList;
        this.applicationContext = applicationContext;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {

//        String pop = myList.get(i).getPopulation();
//        String country = myList.get(i).getCountry();
//        int rank = myList.get(i).getRank();
//        String flag = myList.get(i).getFlag();


        WorldPopulation worldPopulation=myList.get(i);


        myViewHolder.pop.setText(worldPopulation.getPopulation());
        myViewHolder.country.setText(worldPopulation.getCountry());
        myViewHolder.rank.setText(String.valueOf(worldPopulation.getRank()));

        Glide.with(applicationContext)
                .load(worldPopulation.getFlag())
                .override(50,50)
                .into(myViewHolder.myImg);

    }


    @Override
    public int getItemCount() {

        return myList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public ImageView myImg;
        public TextView rank, pop, country;

        public MyViewHolder(View itemView) {
            super(itemView);

            myImg = itemView.findViewById(R.id.imgID);
            rank = itemView.findViewById(R.id.rankID);
            pop = itemView.findViewById(R.id.populationID);
            country = itemView.findViewById(R.id.countryID);
        }
    }
}
