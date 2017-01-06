package com.example.shyam.sherlockapp.Model;

/**
 * Created by shyam on 30-Dec-16.
 */

public class Crew {
    private int id;
    private String credit_id;
    private String name;
    private String department;
    private String job;
    private String profilePath;

    public Crew(int id, String credit_id, String name, String department, String job, String profilePath) {
        this.id = id;
        this.credit_id = credit_id;
        this.name = name;
        this.department = department;
        this.job = job;
        this.profilePath = profilePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }
}
