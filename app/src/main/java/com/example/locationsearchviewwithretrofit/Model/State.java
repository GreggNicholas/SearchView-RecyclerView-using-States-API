package com.example.locationsearchviewwithretrofit.Model;

import com.google.gson.annotations.SerializedName;

public class State {

    private String name;
    private String capital;
    private String lat;
    @SerializedName("long")
    private String longitude;

    public State(String name, String capital, String lat, String longitude) {
        this.name = name;
        this.capital = capital;
        this.lat = lat;
        this.longitude = longitude;
    }

    public String getStateName() {
        return name;
    }

    public String getStateCapital() {
        return capital;
    }

    public String getStateLat() {
        return lat;
    }

    public String getStateLongitude() {
        return longitude;
    }
}
