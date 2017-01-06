package com.example.shyam.sherlockapp.Model;

import android.renderscript.Sampler;

/**
 * Created by shyam on 30-Dec-16.
 */

public class GuestStars {
    private int id;
    private String name;
    private String creditId;
    private String character;
    private int order;
    private Sampler.Value profilePath;

    public GuestStars(int id, String name, String creditId, String character, int order, Sampler.Value profilePath) {
        this.id = id;
        this.name = name;
        this.creditId = creditId;
        this.character = character;
        this.order = order;
        this.profilePath = profilePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Sampler.Value getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(Sampler.Value profilePath) {
        this.profilePath = profilePath;
    }
}
