package com.example.locationsearchviewwithretrofit.Service;

import com.example.locationsearchviewwithretrofit.Model.Country;

import io.reactivex.SingleObserver;
import retrofit2.http.GET;

public interface PatriotService {

    String END_POINT = "jpriebe/d62a45e29f24e843c974/raw/b1d3066d245e742018bce56e41788ac7afa60e29/us_state_capitals.json";

    @GET(END_POINT)
    SingleObserver<Country> getStates();
}
