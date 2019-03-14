package com.androidtutz.anushka.countriesapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.androidtutz.anushka.countriesapp.R;
import com.androidtutz.anushka.countriesapp.adapter.CountryAdapter;
import com.androidtutz.anushka.countriesapp.model.Info;
import com.androidtutz.anushka.countriesapp.model.Result;
import com.androidtutz.anushka.countriesapp.service.GetCountryDataService;
import com.androidtutz.anushka.countriesapp.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Result> results;
    private CountryAdapter countryAdapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCountries();
    }

    public Object getCountries() {

        GetCountryDataService getCountryDataService = RetrofitInstance.getService();
        Call<Info> call = getCountryDataService.getResults();

        call.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {

                Info info = response.body();

                if (info != null && info.getRestResponse() != null) {

                    results = (ArrayList<Result>) info.getRestResponse().getResult();

//                    for (Result r : results) {
//
//                        Log.i("testing123", "*********************************" + r.getName());
//
//                    }


                    viewData();


                }

            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {

            }
        });


        return results;
    }

    private void viewData() {

        recyclerView = (RecyclerView) findViewById(R.id.rv_countries_list);
        countryAdapter = new CountryAdapter(results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(countryAdapter);


    }
}
