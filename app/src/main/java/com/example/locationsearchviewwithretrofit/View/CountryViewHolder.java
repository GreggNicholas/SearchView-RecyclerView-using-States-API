package com.example.locationsearchviewwithretrofit.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.locationsearchviewwithretrofit.Model.State;
import com.example.locationsearchviewwithretrofit.R;


public class CountryViewHolder extends RecyclerView.ViewHolder {
    private TextView stateNameView;
    private TextView stateCapitalView;

    public CountryViewHolder(@NonNull View itemView) {
        super(itemView);
        stateNameView = stateNameView.findViewById(R.id.itemview_statename);
        stateCapitalView = itemView.findViewById(R.id.itemview_statecapital);
    }

    public void onBind(final State state) {
        stateNameView.setText(state.getStateName());
        stateCapitalView.setText(state.getStateCapital());
    }
}
