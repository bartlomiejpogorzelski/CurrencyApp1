package com.example.bartek.currencyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.bartek.currencyapp.MainActivity.currencyArrayList;

public class ExchangeActivity extends AppCompatActivity {



    TextView textAmount;
    TextView textForeign;
    EditText editText;
    Button buyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);


        textAmount=(TextView)findViewById(R.id.textAmount1);

        textForeign=(TextView)findViewById(R.id.textForeign);

        editText=(EditText) findViewById(R.id.EditSum);
        buyButton=(Button)findViewById(R.id.BuyButton);

        textAmount.setText(String.valueOf(AccountsActivity.mainAccount.getAmount()));

        textForeign.setText(String.valueOf(MainActivity.currencyArrayList.get(0).getBuy()));



    }

    public void BtnBUY(View view) {


    }
}
