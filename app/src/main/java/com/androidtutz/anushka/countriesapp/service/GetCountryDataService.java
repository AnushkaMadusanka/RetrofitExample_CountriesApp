package com.androidtutz.anushka.countriesapp.service;

import com.androidtutz.anushka.countriesapp.model.Info;

import retrofit2.http.GET;
import retrofit2.Call;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 5/30/2018.
 */
public interface GetCountryDataService {



      @GET("country/get/all")
      Call<Info> getResults();








}
