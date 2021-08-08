package com.example.stockapp;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stockapp.Stock;
import com.example.stockapp.StockAdapter;
import com.example.stockapp.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.nio.channels.ClosedByInterruptException;
import java.util.ArrayList;
import java.util.List;


public class StockFragment extends Fragment {

    public static final String TAG = "StockFragment";
    private RecyclerView rvStocks;
    protected StockAdapter adapter;
    protected List<Stock> stockProfile;

    public StockFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stock, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvStocks= view.findViewById(R.id.rvStocks);

        stockProfile= new ArrayList<>();
        adapter = new StockAdapter(getContext(), stockProfile);

        rvStocks.setAdapter(adapter);
        rvStocks.setLayoutManager(new LinearLayoutManager(getContext()));
        queryStocks();

    }
    protected void queryStocks(){
        ParseQuery<Stock> query = ParseQuery.getQuery(Stock.class);
        query.include(Stock.KEY_USER);
        query.setLimit(20);
        query.findInBackground(new FindCallback<Stock>() {
            @Override
            public void done(List<Stock> stocks, ParseException e) {
                if (e!= null){
                    Log.e(TAG, "Issue with getting posts", e);
                    return;
                }
                for(Stock stock : stocks){
                    Log.i(TAG, "Stock Ticker:" +stock.getTicker());
                }
                stockProfile.addAll(stocks);
                adapter.notifyDataSetChanged();
            }

        });
    }

}