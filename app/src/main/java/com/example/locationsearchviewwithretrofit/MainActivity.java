package com.example.locationsearchviewwithretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;

import com.example.locationsearchviewwithretrofit.Controller.CountryAdapter;
import com.example.locationsearchviewwithretrofit.Model.UnitedStates;
import com.example.locationsearchviewwithretrofit.Model.State;
import com.example.locationsearchviewwithretrofit.Service.PatriotService;
import com.example.locationsearchviewwithretrofit.Service.RetrofitSingleton;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private static final String TAG = "Main Activity";

    private SearchView searchView;
    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;
    private Retrofit retrofit;
    private List<State> stateList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.main_searchview);
        recyclerView = findViewById(R.id.main_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        retrofit = RetrofitSingleton.getInstance()
                .create(PatriotService.class)
                .getStates()
                .enqueue(new Callback<UnitedStates>() {
                    @Override
                    public void onResponse(Call<UnitedStates> call, Response<UnitedStates> response) {
                        Log.d(TAG, "onResponse: " + response.body().getStateList().get(0).getStateCapital());
                        stateList.addAll(response.body().getStateList());
                        countryAdapter = new CountryAdapter(stateList);
                        recyclerView.setAdapter(countryAdapter);
                    }

                    @Override
                    public void onFailure(Call<UnitedStates> call, Throwable t) {
                        Log.e(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        List<State> stateListQuery = new LinkedList<>();
        for (State state : stateListQuery) {
            if (state.getStateCapital().toLowerCase().startsWith(s.toLowerCase())) {
                stateListQuery.add(state);
            }
        }
        countryAdapter.setData(stateListQuery);
        return false;
    }
}
