package com.example.shyam.sherlockapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shyam on 30-Dec-16.
 */

public class TV_Episodes {
    @SerializedName("air_date")
    private String airdate;
    @SerializedName("crew")
    private List<Crew> crew;
    @SerializedName("episode_number")
    private int episodeNumber;
    @SerializedName("guest_stars")
    private List<GuestStars> guestStars;
    @SerializedName("name")
    private String name;
    @SerializedName("overview")
    private String overview;
    @SerializedName("id")
    private int id;
    @SerializedName("production_code")
    private String productionCode;
    @SerializedName("season_number")
    private int seasonNumber;
    @SerializedName("still_path")
    private String stillPath;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("vote_count")
    private int voteCount;

    public TV_Episodes(String airdate, List<Crew> crew, int episodeNumber, List<GuestStars> guestStars, String name, String overview, int id, String productionCode, int seasonNumber, String stillPath, double voteAverage, int voteCount) {
        this.airdate = airdate;
        this.crew = crew;
        this.episodeNumber = episodeNumber;
        this.guestStars = guestStars;
        this.name = name;
        this.overview = overview;
        this.id = id;
        this.productionCode = productionCode;
        this.seasonNumber = seasonNumber;
        this.stillPath = stillPath;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public String getAirdate() {
        return airdate;
    }

    public List<Crew> getCrew() {
        return crew;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public List<GuestStars> getGuestStars() {
        return guestStars;
    }

    public String getName() {
        return name;
    }

    public String getOverview() {
        return overview;
    }

    public int getId() {
        return id;
    }

    public String getProductionCode() {
        return productionCode;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public String getStillPath() {
        return stillPath;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setAirdate(String airdate) {
        this.airdate = airdate;
    }

    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public void setGuestStars(List<GuestStars> guestStars) {
        this.guestStars = guestStars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductionCode(String productionCode) {
        this.productionCode = productionCode;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public void setStillPath(String stillPath) {
        this.stillPath = stillPath;
    }

    public void setVoteAverage(int voteAverage) {
        this.voteAverage = voteAverage;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
