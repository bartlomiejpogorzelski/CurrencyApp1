package com.example.bartek.currencyapp;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.bartek.currencyapp.AccountsActivity.mainAccount;

public class ExchangeActivity extends AppCompatActivity  {


    TextView textAmount;
    TextView textForeign;
    EditText editText;
    Button buyButton;
    double foreignCurs;
    double buyAmount;
    double plnAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);


        textAmount=(TextView)findViewById(R.id.textAmount1);

        textForeign=(TextView)findViewById(R.id.textForeign);

        editText=(EditText) findViewById(R.id.EditSum);
        buyButton=(Button)findViewById(R.id.BuyButton);

        textAmount.setText(mainAccount.getAmount().toString()); //it can be String.valueof()

        textForeign.setText(String.valueOf(MainActivity.currencyArrayList.get(0).getBuy()));

        addSpinnerList();

    }

    private void addSpinnerList() {
         Spinner spinner = (Spinner) findViewById(R.id.spinner);

        String[] array_spinner;
        ArrayList list1= new ArrayList();

        for (int y=0; y < MainActivity.currencyArrayList.size() ; y++)
        {
            array_spinner= new String[MainActivity.currencyArrayList.size()];
            array_spinner[y]=String.valueOf(MainActivity.currencyArrayList.get(y).getSymbol());

            list1.add(array_spinner);
        }

         ArrayAdapter spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list1);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);
    }


    public void BtnBUY(View view) {
       upDateTextView();

        Intent anotherIntent5= new Intent(getApplicationContext(), AccountsActivity.class);
        startActivity(anotherIntent5);

    }

    private void upDateTextView() {
        foreignCurs=Double.valueOf((textForeign.getText()).toString());
        buyAmount = Double.parseDouble(String.valueOf(editText.getText())); //editText.getText
        plnAmount = Double.parseDouble(String.valueOf(textAmount.getText()));

        double result=  foreignCurs * buyAmount;
        double newPlnAmount = plnAmount - result;
        if (result > plnAmount)
        {
            Toast.makeText(this,"You don't have enough money",Toast.LENGTH_SHORT).show();
        }
            else
            mainAccount.setAmount(newPlnAmount);
            textAmount.setText(String.valueOf(mainAccount.getAmount()));

    }


}



