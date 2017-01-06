package com.example.shyam.sherlockapp.API;



import com.example.shyam.sherlockapp.Model.SeasonDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by shyam on 30-Dec-16.
 */

public interface ApiInterface {
    @GET("tv/19885/season/{id}")
    Call<SeasonDetails> getSeasonDetails(@Path("id") int id, @Query("api_key") String apikey);

}
