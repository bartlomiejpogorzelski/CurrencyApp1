package com.example.bartek.currencyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityB extends AppCompatActivity {




    CurrencyAdapter.HolderView holder= new CurrencyAdapter.HolderView();

    TextView textView;
    ListView listb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);



        textView= (TextView) findViewById(R.id.textAmount);
        listb= (ListView) findViewById(R.id.listB);



        textView.setText(String.valueOf(12000.00+" zł"));


       // CurrencyAdapter adapter = new CurrencyAdapter(getApplicationContext(), R.layout.row, MainActivity.currencyArrayList);

      //  listb.setAdapter(adapter);




        ArrayList<Account> accountsList = new ArrayList<Account>();
        Accounts aa = new Accounts(getApplicationContext(), R.layout.row1, accountsList);

        for (int i = 0; i < MainActivity.currencyArrayList.size() ; i++) {
            accountsList.add(new Account(1000.0, MainActivity.currencyArrayList.get(i)));
        }



        listb.setAdapter(aa);
        aa.notifyDataSetChanged();
            //CurrencyAdapter.HolderView.class.getClass();


    }






    public void btnAllCurrencies(View view) {
    finish();


    }

    public void BtnSmall(View view) {
    //textView*=

    }
}
