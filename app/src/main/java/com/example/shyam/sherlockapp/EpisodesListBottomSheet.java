package com.example.shyam.sherlockapp;


import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class EpisodesListBottomSheet extends BottomSheetDialogFragment {
    int holderPosition;
    String airDate;
    String posterPath;
    String seasonQuote;
    String seasonSpeaker;
    String[] episode1;
    String[] episode2;
    String[] episode3;
    String[] specialEpisode;
    String[] episodeName;
    String baseURL = "http://image.tmdb.org/t/p/original/";
    public BottomSheetBehavior mBehavior;

    public EpisodesListBottomSheet(){
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog =  super.onCreateDialog(savedInstanceState);
        holderPosition = getArguments().getInt("HOLDER_POSITION");
        airDate = getArguments().getString("SEASON_AIR_DATE");
        posterPath = getArguments().getString("SEASON_POSTER_PATH");
        seasonQuote = getArguments().getString("SEASON_QUOTE");
        seasonSpeaker = getArguments().getString("SEASON_SPEAKER");
        episode1 = getArguments().getStringArray("EPISODE_1");
        episode2 = getArguments().getStringArray("EPISODE_2");
        episode3 = getArguments().getStringArray("EPISODE_3");
        specialEpisode = getArguments().getStringArray("SPECIAL_EPISODE");
        return dialog;
    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        final View contentView = View.inflate(getContext(),R.layout.fragment_episodes_list_bottom_sheet,null);
        dialog.setContentView(contentView);

        mBehavior = BottomSheetBehavior.from((View) contentView.getParent());

        String posterURL = baseURL+posterPath;
        ImageView imageView = (ImageView) contentView.findViewById(R.id.bottomImageView);
        Picasso.with(getContext()).load(posterURL).fit().centerCrop().into(imageView);
        TextView bottomQuote = (TextView) contentView.findViewById(R.id.bottomQuote);
        bottomQuote.setText(seasonQuote);
        TextView bottomSpeaker = (TextView) contentView.findViewById(R.id.bottomSpeaker);
        bottomSpeaker.setText(seasonSpeaker);
        TextView bottomAirDate = (TextView) contentView.findViewById(R.id.bottomAirDate);
        bottomAirDate.setText(airDate);
        ListView listView = (ListView) contentView.findViewById(R.id.bottomListView);
        ArrayAdapter<String> adapter;
        if(holderPosition == 3){
            episodeName = new String[]{"0. " + specialEpisode[0],"1. " + episode1[0], "2. " + episode2[0], "3. " + episode3[0]};
        }else {
            episodeName = new String[]{"1. " + episode1[0], "2. " + episode2[0], "3. " + episode3[0]};
        }
        adapter = new ArrayAdapter<String>(contentView.getContext(), R.layout.list_view_item, android.R.id.text1, episodeName);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle args = new Bundle();
                if(holderPosition == 3){
                    switch (position){
                        case 0:
                            args.putStringArray("EPISODE_INFORMATION", specialEpisode);
                            break;
                        case 1:
                            args.putStringArray("EPISODE_INFORMATION", episode1);
                            break;
                        case 2:
                            args.putStringArray("EPISODE_INFORMATION", episode2);
                            break;
                        case 3:
                            args.putStringArray("EPISODE_INFORMATION", episode3);
                            break;
                    }
                }else{
                    switch (position){
                        case 0:
                            args.putStringArray("EPISODE_INFORMATION", episode1);
                            break;
                        case 1:
                            args.putStringArray("EPISODE_INFORMATION", episode2);
                            break;
                        case 2:
                            args.putStringArray("EPISODE_INFORMATION", episode3);
                            break;
                    }
                }
                EpisodeDescription episodeDescription = new EpisodeDescription();
                episodeDescription.setArguments(args);
                AppCompatActivity activity = (AppCompatActivity) contentView.getContext();
                FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_view,episodeDescription).addToBackStack(null).commit();
                mBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }
}
