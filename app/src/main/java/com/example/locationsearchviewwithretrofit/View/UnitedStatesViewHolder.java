package com.example.locationsearchviewwithretrofit.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.locationsearchviewwithretrofit.Model.OneState;
import com.example.locationsearchviewwithretrofit.R;


public class UnitedStatesViewHolder extends RecyclerView.ViewHolder {
    private TextView stateNameView;
    private TextView stateCapitalView;

    public UnitedStatesViewHolder(@NonNull View itemView) {
        super(itemView);
        stateNameView = itemView.findViewById(R.id.itemview_statename);
        stateCapitalView = itemView.findViewById(R.id.itemview_statecapital);
    }

    public void onBind(final OneState state) {
        stateNameView.setText(state.getStateName());
        stateCapitalView.setText(state.getStateCapital());
    }
}
