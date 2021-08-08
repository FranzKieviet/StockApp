package com.example.stockapp;

import com.parse.ParseClassName;
import  com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("StockProfile")
public class Stock extends ParseObject{

    public static final String KEY_BUYPRICE = "buyPrice";
    public static final String KEY_TICKER = "ticker";
    public static final String KEY_USER = "user";
    public static final String KEY_COUNT = "count";

    public double getBuyPrice(){
        return getDouble(KEY_BUYPRICE);
    }

    public void setBuyPrice(float price){
        put(KEY_BUYPRICE, price);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user){
        put(KEY_USER, user);
    }

    public String getTicker(){
        return getString(KEY_TICKER);
    }

    public void setTicker(String ticker){
        put(KEY_TICKER, ticker);
    }

    public String getCount(){
        return getString(KEY_COUNT);
    }

    public void setCount(String count){
        put(KEY_COUNT, count);
    }


}
