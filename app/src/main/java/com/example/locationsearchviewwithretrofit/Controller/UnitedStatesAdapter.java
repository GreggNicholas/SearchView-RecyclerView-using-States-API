package com.example.locationsearchviewwithretrofit.Controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.locationsearchviewwithretrofit.Model.State;
import com.example.locationsearchviewwithretrofit.R;
import com.example.locationsearchviewwithretrofit.View.UnitedStatesViewHolder;

import java.util.List;

public class UnitedStatesAdapter extends RecyclerView.Adapter<UnitedStatesViewHolder> {
    private List<State> getListOfState;

    @NonNull
    @Override
    public UnitedStatesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.state_itemview, viewGroup, false);
        return new UnitedStatesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnitedStatesViewHolder unitedStatesViewHolder, int position) {
        unitedStatesViewHolder.onBind(getListOfState.get(position));
    }

    @Override
    public int getItemCount() {
        return getListOfState.size();
    }

    public void setData(List<State> stateListQuery) {
        getListOfState = stateListQuery;
        notifyDataSetChanged();
    }
}
