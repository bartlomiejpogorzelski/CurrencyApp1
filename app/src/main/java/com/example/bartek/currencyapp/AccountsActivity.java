package com.example.bartek.currencyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AccountsActivity extends AppCompatActivity {

    public static Account mainAccount= new Account(13000.0, new Currency(1,1,"PLN"));
    public static ArrayList<Account> accountsList = new ArrayList<Account>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accounts_activity);

        ListView listInAccountsActivity = (ListView) findViewById(R.id.listB);
        TextView textView= (TextView) findViewById(R.id.textAmount);
        textView.setText(String.valueOf(mainAccount.getAmount()+"  zł"));

        AccountsAdapter accountsAdapter = new AccountsAdapter(getApplicationContext(), R.layout.row1, accountsList);
        for (int i = 0; i < MainActivity.currencyArrayList.size() ; i++)        {
            accountsList.add(new Account(0.0, MainActivity.currencyArrayList.get(i)));
        }
        listInAccountsActivity.setAdapter(accountsAdapter);
        accountsAdapter.notifyDataSetChanged();
    }
    public void btnAllCurrencies(View view) {
        Intent anotherIntent= new Intent(getApplicationContext(), ExchangeActivity.class);
        startActivity(anotherIntent);
    }
}
