package com.iitbhu.spardha.fragments.GameActivity;

/**
 * Created by abhinav on 6/25/2017.
 */

public class DataFixtures {
    private String eventName = "";
    private String location = "";
    private String datetime = "";
    private String team1 = "";
    private String team2 = "";


    private String time="";
    public DataFixtures(String eventName, String location, String datetime,String time, String team1, String team2) {
        this.eventName = eventName;
        this.location = location;
        this.datetime = datetime;
        this.team1 = team1;
        this.team2 = team2;
        this.time=time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }
}
