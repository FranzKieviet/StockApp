package com.example.stockapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import  androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.ViewHolder>{

    private Context context;
    private List<Stock> stockProfile;

    public StockAdapter(Context context, List<Stock> stockProfile){
        this.context=context;
        this.stockProfile=stockProfile;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_stock, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Stock stock = stockProfile.get(position);
        holder.bind(stock);
    }

    @Override
    public int getItemCount() {
        return stockProfile.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTicker;
        private TextView tvBuyPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTicker=itemView.findViewById(R.id.tvTicker);
            tvBuyPrice=itemView.findViewById(R.id.tvBuyPrice);
        }

        public void bind(Stock stock) {
            tvTicker.setText(stock.getTicker());
            tvBuyPrice.setText("$ "+stock.getBuyPrice());

        }
    }

}
