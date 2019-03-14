package com.androidtutz.anushka.countriesapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidtutz.anushka.countriesapp.R;
import com.androidtutz.anushka.countriesapp.model.Result;

import java.util.ArrayList;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 5/30/2018.
 */
public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>{

private ArrayList<Result> countriesList;


        public CountryAdapter(ArrayList<Result> countriesList) {
            this.countriesList = countriesList;
        }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.row_country,parent,false);

        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {

         holder.countryNameTextView.setText(countriesList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return countriesList.size();
    }


    class CountryViewHolder extends RecyclerView.ViewHolder{

            TextView countryNameTextView;

            public CountryViewHolder(View itemView) {
                super(itemView);

                countryNameTextView=itemView.findViewById(R.id.tv_country_name);
            }
        }

}
