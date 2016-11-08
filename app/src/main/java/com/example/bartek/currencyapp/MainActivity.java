package com.example.bartek.currencyapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Currency> currencyArrayList;
    CurrencyAdapter adapter;

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.list);

        fillCurrencyList();

    }


    private void fillCurrencyList() {

        currencyArrayList= new ArrayList<Currency>();

        Currency c = new Currency(5,5,"USD");
        currencyArrayList.add(c);

        c = new Currency(5,6, "EUR");

        currencyArrayList.add(c);

        currencyArrayList.add(new Currency(6, 7,"GBP" ));
        currencyArrayList.add(new Currency(8, 8,"CZK" ));
        currencyArrayList.add(new Currency(9, 9,"CAD" ));
        currencyArrayList.add(new Currency(10, 10,"NOK" ));

        adapter = new CurrencyAdapter(getApplicationContext(), R.layout.row, currencyArrayList);

        listView.setAdapter(adapter);



    }

}
