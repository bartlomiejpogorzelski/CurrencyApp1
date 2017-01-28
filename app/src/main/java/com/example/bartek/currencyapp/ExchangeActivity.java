package com.example.bartek.currencyapp;

import android.content.Intent;
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
    double a;
    double b;
    double d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);


        textAmount=(TextView)findViewById(R.id.textAmount1);

        textForeign=(TextView)findViewById(R.id.textForeign);

        editText=(EditText) findViewById(R.id.EditSum);
        buyButton=(Button)findViewById(R.id.BuyButton);


        textForeign.setText(String.valueOf(MainActivity.currencyArrayList.get(0).getBuy()));




    }

    public void BtnBUY(View view) {
       upDateTextView();



//        Intent anotherIntent5= new Intent(getApplicationContext(), ExchangeActivity.class);
//        startActivity(anotherIntent5);

    }

    private void upDateTextView() {
        a =Double.valueOf((textForeign.getText()).toString());
        b= Double.parseDouble(String.valueOf(editText.getText())); //editText.getText
        d = Double.parseDouble(String.valueOf(textAmount.getText()));

        double result= a * b;

        double z = d - result;

        textAmount.setText(String.valueOf(z));
    }


}


