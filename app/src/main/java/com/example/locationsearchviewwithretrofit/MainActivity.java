package com.example.locationsearchviewwithretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.example.locationsearchviewwithretrofit.Controller.CountryAdapter;
import com.example.locationsearchviewwithretrofit.Model.Country;
import com.example.locationsearchviewwithretrofit.Model.State;
import com.example.locationsearchviewwithretrofit.Service.PatriotService;
import com.example.locationsearchviewwithretrofit.Service.RetrofitSingleton;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private final CompositeDisposable disposable = new CompositeDisposable();
    private SearchView searchView;
    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.main_searchview);
        recyclerView = findViewById(R.id.main_recyclerview);
//        disposable.add(
//                Retrofit retrofit = RetrofitSingleton.getInstance();
//        retrofit.create(PatriotService.class)
//                .getCountryResponse()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<Country>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(Country country) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//                });


        countryAdapter = new CountryAdapter();
        recyclerView.setAdapter(countryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
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

    @Override
    protected void onStop() {
        super.onStop();
        disposable.clear();
    }
}
