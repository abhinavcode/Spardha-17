package com.abc.spardha17.fragments.GameActivity;

/**
 * Created by abhinav on 8/24/2017.
 */

public class DataResults {
    private String eventName = "";
    private String team1 = "";
    private String team2 = "";
    private String winner = "";

    public DataResults(String eventName, String team1, String team2, String winner) {
        this.eventName = eventName;
        this.team1 = team1;
        this.team2 = team2;
        this.winner = winner;
    }

    public String getEventName() {

        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
