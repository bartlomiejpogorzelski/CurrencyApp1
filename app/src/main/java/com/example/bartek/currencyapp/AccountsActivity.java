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

    CurrencyAdapter.HolderView holder= new CurrencyAdapter.HolderView();

    Button buttonSmall;
    TextView textView;
    ListView listb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accounts_activity);

        textView= (TextView) findViewById(R.id.textAmount);
        listb= (ListView) findViewById(R.id.listB);

        textView.setText(String.valueOf(mainAccount.getAmount()+"  zł"));

        ArrayList<Account> accountsList = new ArrayList<Account>();
        AccountsAdapter aa = new AccountsAdapter(getApplicationContext(), R.layout.row1, accountsList);

        for (int i = 0; i < MainActivity.currencyArrayList.size() ; i++) {
            accountsList.add(new Account(1000.0, MainActivity.currencyArrayList.get(i)));
        }

        listb.setAdapter(aa);
        aa.notifyDataSetChanged();
//        listb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(), "dziala", Toast.LENGTH_SHORT).show();
//                Intent anotherIntent= new Intent(getApplicationContext(), ExchangeActivity.class);
//
//               startActivity(anotherIntent);
//            }
//        });

//        buttonSmall= (Button) findViewById(R.id.buttonSmall);
//
//        buttonSmall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "kkk" , Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public void btnAllCurrencies(View view) {
        Intent anotherIntent= new Intent(getApplicationContext(), ExchangeActivity.class);
        startActivity(anotherIntent);

    }

//      public void BtnSmall(View view) {
//
//         Intent anotherIntent1= new Intent(getApplicationContext(), ExchangeActivity.class);
//                  startActivity(anotherIntent1);
//       }

}
