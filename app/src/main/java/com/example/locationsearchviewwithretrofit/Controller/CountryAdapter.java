package com.example.locationsearchviewwithretrofit.Controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.locationsearchviewwithretrofit.Model.Country;
import com.example.locationsearchviewwithretrofit.R;
import com.example.locationsearchviewwithretrofit.View.CountryViewHolder;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    private List<Country> getListOfState;


    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.state_itemview, viewGroup, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder countryViewHolder, int position) {
        //  countryViewHolder.onBind();
    }


    @Override
    public int getItemCount() {
        return 0;
    }
}
