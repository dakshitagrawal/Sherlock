package com.example.shyam.sherlockapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shyam.sherlockapp.API.ApiClient;
import com.example.shyam.sherlockapp.API.ApiInterface;
import com.example.shyam.sherlockapp.Model.SeasonDetails;
import com.example.shyam.sherlockapp.Model.TV_Episodes;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shyam on 28-Dec-16.
 */

public class ContentAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    public String[] mSeasonNames;
    private static final String TAG = MainActivity.class.getSimpleName();
    private final static String API_KEY = "cdfb85bc7da2e244c14803436257575b";
    SeasonDetails season0;
    SeasonDetails season1;
    SeasonDetails season2;
    SeasonDetails season3;
    SeasonDetails season4;
    SeasonDetails[] seasons = new SeasonDetails[5];
    public Context context;

    public ContentAdapter(final Context context){
        this.context =context;

        ApiInterface apiServiceSeason0 = ApiClient.getClient().create(ApiInterface.class);
        Call<SeasonDetails> callSeason0 = apiServiceSeason0.getSeasonDetails(0, API_KEY);
        callSeason0.enqueue(new Callback<SeasonDetails>() {
            @Override
            public void onResponse(Call<SeasonDetails> call, Response<SeasonDetails> response) {
                season0 = response.body();
                seasons[4] =season0;
                if (season0!=null){
                    Toast.makeText(context,"Seasons Added",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,"Seasons Not Added",Toast.LENGTH_SHORT).show();
                }
                Log.d(TAG, "Episodes Received");
            }

            @Override
            public void onFailure(Call<SeasonDetails> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

        ApiInterface apiServiceSeason1 = ApiClient.getClient().create(ApiInterface.class);
        Call<SeasonDetails> callSeason1 = apiServiceSeason1.getSeasonDetails(1, API_KEY);
        callSeason1.enqueue(new Callback<SeasonDetails>() {
            @Override
            public void onResponse(Call<SeasonDetails> call, Response<SeasonDetails> response) {
                season1 = response.body();
                seasons[0] =season1;
                Log.d(TAG, "Episodes Received");
            }

            @Override
            public void onFailure(Call<SeasonDetails> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

        ApiInterface apiServiceSeason2 = ApiClient.getClient().create(ApiInterface.class);
        Call<SeasonDetails> callSeason2 = apiServiceSeason2.getSeasonDetails(2, API_KEY);
        callSeason2.enqueue(new Callback<SeasonDetails>() {
            @Override
            public void onResponse(Call<SeasonDetails> call, Response<SeasonDetails> response) {
                season2 = response.body();
                seasons[1] = season2;
                Log.d(TAG, "Episodes Received");
            }

            @Override
            public void onFailure(Call<SeasonDetails> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

        ApiInterface apiServiceSeason3 = ApiClient.getClient().create(ApiInterface.class);
        Call<SeasonDetails> callSeason3 = apiServiceSeason3.getSeasonDetails(3, API_KEY);
        callSeason3.enqueue(new Callback<SeasonDetails>() {
            @Override
            public void onResponse(Call<SeasonDetails> call, Response<SeasonDetails> response) {
                season3 = response.body();
                seasons[2] = season3;
                Log.d(TAG, "Episodes Received");
            }

            @Override
            public void onFailure(Call<SeasonDetails> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

        ApiInterface apiServiceSeason4 = ApiClient.getClient().create(ApiInterface.class);
        Call<SeasonDetails> callSeason4 = apiServiceSeason4.getSeasonDetails(4, API_KEY);
        callSeason4.enqueue(new Callback<SeasonDetails>() {
            @Override
            public void onResponse(Call<SeasonDetails> call, Response<SeasonDetails> response) {
                season4 = response.body();
                seasons[3] = season4;
                Log.d(TAG, "Episodes Received");
            }

            @Override
            public void onFailure(Call<SeasonDetails> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        switch (position){
            case 0:
                Picasso.with(context).load("http://image.tmdb.org/t/p/original//57o4MgHdSXP9SANGcDevuHqpT3G.jpg").into(holder.cardImage);
                break;
            case 1:
                Picasso.with(context).load("http://image.tmdb.org/t/p/original//8IGxkHKRjI3LCwapJ7ieYyWJRSH.jpg").into(holder.cardImage);
                break;
            case 2:
                Picasso.with(context).load("http://image.tmdb.org/t/p/original//sdv7HrQnhCFdqj3FPUUuVocI97b.jpg").into(holder.cardImage);
                break;
            case 3:
                Picasso.with(context).load("http://image.tmdb.org/t/p/original//5TCpr9kcMp5GodF9h30aE0cZwE8.jpg").into(holder.cardImage);
                break;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = holder.getAdapterPosition();
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                BottomSheetDialogFragment bottomSheetDialogFragment = new EpisodesListBottomSheet();
                Bundle args = new Bundle();

                String airDate = seasons[id].getAirDate();
                args.putString("SEASON_AIR_DATE", airDate);

                String posterPath = seasons[id].getPosterPath();
                args.putString("SEASON_POSTER_PATH", posterPath);

                List<TV_Episodes> episodes = seasons[id].getEpisodes();
                List<TV_Episodes> specialEpisodes = seasons[4].getEpisodes();

                String specialEpisodeAirDate = specialEpisodes.get(8).getAirdate();
                String episode1AirDate = episodes.get(0).getAirdate();
                String episode2AirDate = episodes.get(1).getAirdate();
                String episode3AirDate = episodes.get(2).getAirdate();

                double episode1RatingsDouble = episodes.get(0).getVoteAverage();
                double episode1RatingsDoubleRound = Math.round(episode1RatingsDouble*100.0)/100.0;
                String episode1RatingsString = Double.toString(episode1RatingsDoubleRound);
                double episode2RatingsDouble = episodes.get(1).getVoteAverage();
                double episode2RatingsDoubleRound = Math.round(episode2RatingsDouble*100.0)/100.0;
                String episode2RatingsString = Double.toString(episode2RatingsDoubleRound);
                double episode3RatingsDouble = episodes.get(2).getVoteAverage();
                double episode3RatingsDoubleRound = Math.round(episode3RatingsDouble*100.0)/100.0;
                String episode3RatingsString = Double.toString(episode3RatingsDoubleRound);
                double specialEpisodeRatingsDouble = specialEpisodes.get(8).getVoteAverage();
                double specialEpisodeRatingsDoubleRound = Math.round(specialEpisodeRatingsDouble*100.0)/100.0;
                String specialEpisodeRatingsString = Double.toString(specialEpisodeRatingsDoubleRound);

                String episode1Name = episodes.get(0).getName();
                String episode2Name = episodes.get(1).getName();
                String episode3Name = episodes.get(2).getName();
                String specialEpisodeName = specialEpisodes.get(8).getName();

                String episode1OverView = episodes.get(0).getOverview();
                String episode2OverView = episodes.get(1).getOverview();
                String episode3OverView = episodes.get(2).getOverview();
                String specialEpisodeOverview = specialEpisodes.get(8).getOverview();

                String episode1Still_Path = episodes.get(0).getStillPath();
                String episode1Poster = "http://image.tmdb.org/t/p/original/"+episode1Still_Path;
                String episode2Still_Path = episodes.get(1).getStillPath();
                String episode2Poster = "http://image.tmdb.org/t/p/original/"+episode2Still_Path;
                String episode3Still_Path = episodes.get(2).getStillPath();
                String episode3Poster = "http://image.tmdb.org/t/p/original/"+episode3Still_Path;
                String specialEpisodeStill_Path = specialEpisodes.get(8).getStillPath();
                String specialEpisodePoster = "http://image.tmdb.org/t/p/original/"+specialEpisodeStill_Path;

                String season1Quote = "“I am not a psychopath Anderson, I am a high-functioning sociopath. Do your research.”";
                String season1Speaker = "~ Sherlock";
                String season2Quote = "“Once you’ve ruled out the impossible, whatever remains, however improbable, must be the Truth.”";
                String season2Speaker = "~ Sherlock";
                String season3Quote = "\"You, being all mysterious with your cheekbones and turning your coat collar up so you look cool.\"";
                String season3Speaker = "~ John Watson";
                String season4Quote = "\"Now, let's talk about murder - sorry, did I say murder? I meant to say marriage.\"";
                String season4Speaker = "~ Sherlock";

                String[] seasonQuotes = new String[]{season1Quote, season2Quote, season3Quote, season4Quote};
                String[] seasonSpeakers = new String[]{season1Speaker, season2Speaker, season3Speaker, season4Speaker};
                String[] episode1 = new String[]{episode1Name,episode1AirDate,episode1RatingsString,episode1OverView,episode1Poster};
                String[] episode2 = new String[]{episode2Name,episode2AirDate,episode2RatingsString,episode2OverView,episode2Poster};
                String[] episode3 = new String[]{episode3Name,episode3AirDate,episode3RatingsString,episode3OverView,episode3Poster};
                String[] specialEpisode = new String[]{specialEpisodeName,specialEpisodeAirDate,specialEpisodeRatingsString,specialEpisodeOverview,specialEpisodePoster};

                args.putString("SEASON_QUOTE", seasonQuotes[id]);
                args.putString("SEASON_SPEAKER", seasonSpeakers[id]);
                args.putStringArray("EPISODE_1",episode1);
                args.putStringArray("EPISODE_2",episode2);
                args.putStringArray("EPISODE_3",episode3);
                args.putStringArray("SPECIAL_EPISODE",specialEpisode);
                args.putInt("HOLDER_POSITION", id);

                bottomSheetDialogFragment.setArguments(args);
                bottomSheetDialogFragment.show(activity.getSupportFragmentManager(),bottomSheetDialogFragment.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}

class ItemViewHolder extends RecyclerView.ViewHolder{

    ImageView cardImage;

    ItemViewHolder(View itemView){
        super(itemView);
        cardImage = (ImageView) itemView.findViewById(R.id.cardview_image);
    }
}
