package com.example.shyam.sherlockapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class EpisodeDescription extends Fragment {
    String[] episodeDetails;

    public EpisodeDescription() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_episode_description, container, false);
        episodeDetails = getArguments().getStringArray("EPISODE_INFORMATION");

        ImageView imageView = (ImageView) v.findViewById(R.id.episodeDescriptionImage);
        Picasso.with(getContext()).load(episodeDetails[4]).fit().centerCrop().into(imageView);

        TextView episodeDescriptionName = (TextView) v.findViewById(R.id.episodeDescriptionName);
        episodeDescriptionName.setText(episodeDetails[0]);

        TextView episodeDescriptionAirDate = (TextView) v.findViewById(R.id.episodeDescriptionAirDate);
        episodeDescriptionAirDate.setText(episodeDetails[1]);

        Float ratingValue = Float.valueOf(episodeDetails[2]);
        RatingBar ratingBar = (RatingBar) v.findViewById(R.id.episodeDescriptionRatingStars);
        ratingBar.setRating(ratingValue/2.0f);

        TextView episodeDescriptionRatings = (TextView) v.findViewById(R.id.episodeDescriptionRatings);
        episodeDescriptionRatings.setText(episodeDetails[2]);

        TextView episodeDescriptionOverview = (TextView) v.findViewById(R.id.episodeDescriptionOverview);
        episodeDescriptionOverview.setText(episodeDetails[3]);

        return v;
    }

}
