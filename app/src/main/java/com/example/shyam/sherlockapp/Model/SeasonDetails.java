package com.example.shyam.sherlockapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shyam on 30-Dec-16.
 */

public class SeasonDetails {
    @SerializedName("_id")
    private String _id;
    @SerializedName("air_date")
    private String airDate;
    @SerializedName("episodes")
    private List<TV_Episodes> episodes;
    @SerializedName("name")
    private String name;
    @SerializedName("overview")
    private String overview;
    @SerializedName("id")
    private int id;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("season_number")
    private int seasonNumber;

    public SeasonDetails(String _id, String airDate, List<TV_Episodes> episodes, String name, String overview, int id, String posterPath, int seasonNumber) {
        this._id = _id;
        this.airDate = airDate;
        this.episodes = episodes;
        this.name = name;
        this.overview = overview;
        this.id = id;
        this.posterPath = posterPath;
        this.seasonNumber = seasonNumber;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public List<TV_Episodes> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<TV_Episodes> episodes) {
        this.episodes = episodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
}
