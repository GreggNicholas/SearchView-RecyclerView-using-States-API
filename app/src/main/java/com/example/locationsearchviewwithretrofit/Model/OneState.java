package com.example.locationsearchviewwithretrofit.Model;

public class OneState {

    private String name;
    private String capital;

    public OneState(String name, String capital) {
        this.name = name;
        this.capital = capital;

    }

    public String getStateName() {
        return name;
    }

    public String getStateCapital() {
        return capital;
    }
}
