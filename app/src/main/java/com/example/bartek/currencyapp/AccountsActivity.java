package com.example.bartek.currencyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AccountsActivity extends AppCompatActivity {



    public static Account mainAccount= new Account(13000.0, new Currency(1,1,"PLN"));

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







        ArrayList<Account> accountsList = new ArrayList<Account>();
        AccountsAdapter aa = new AccountsAdapter(getApplicationContext(), R.layout.row1, accountsList);

        for (int i = 0; i < MainActivity.currencyArrayList.size() ; i++) {
            accountsList.add(new Account(1000.0, MainActivity.currencyArrayList.get(i)));
        }

        listb.setAdapter(aa);
        aa.notifyDataSetChanged();


    }






    public void btnAllCurrencies(View view) {
    finish();


    }

    public void BtnSmall(View view) {
        Intent intent= new Intent(this, ExchangeActivity.class);

        startActivity(intent);

    }
}
