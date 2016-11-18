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


    public static final String KEY= "key";

    CurrencyAdapter.HolderView holder= new CurrencyAdapter.HolderView();

    TextView textView;
    ListView listb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        textView= (TextView) findViewById(R.id.textAmount);
        listb= (ListView) findViewById(R.id.listB);






       // CurrencyAdapter adapter = new CurrencyAdapter(getApplicationContext(), R.layout.row, MainActivity.currencyArrayList);

      //  listb.setAdapter(adapter);




        ArrayList<Account> accountsList = new ArrayList<Account>();
        Accounts aa = new Accounts(getApplicationContext(), R.layout.row1, accountsList);
       // int n= 100;

       //for (int i=0; i<n; i++) {
       // accountsList.add(new Account(1000.0, MainActivity.currencyArrayList.get(i)));

        accountsList.add(new Account(1000.0, MainActivity.currencyArrayList.get(0)));
        accountsList.add(new Account(1000.0, MainActivity.currencyArrayList.get(1)));
        accountsList.add(new Account(1000.0, MainActivity.currencyArrayList.get(2)));
        accountsList.add(new Account(1000.0, MainActivity.currencyArrayList.get(3)));
        accountsList.add(new Account(1000.0, MainActivity.currencyArrayList.get(4)));
        accountsList.add(new Account(1000.0, MainActivity.currencyArrayList.get(5)));
        accountsList.add(new Account(1000.0, MainActivity.currencyArrayList.get(6)));
        accountsList.add(new Account(1000.0, MainActivity.currencyArrayList.get(7)));
        accountsList.add(new Account(1000.0, MainActivity.currencyArrayList.get(8)));
        accountsList.add(new Account(1000.0, MainActivity.currencyArrayList.get(9)));
      // if( i...n) break ;

    // }



        listb.setAdapter(aa);
        aa.notifyDataSetChanged();
            //CurrencyAdapter.HolderView.class.getClass();


    }






    public void btnUSD(View view) {



    }
}
