package com.example.bartek.currencyapp;

import android.content.Intent;
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
import java.util.Arrays;
import java.util.List;

import static com.example.bartek.currencyapp.AccountsActivity.accountsList;
import static com.example.bartek.currencyapp.AccountsActivity.mainAccount;

public class ExchangeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView textAmount;
    TextView textForeign;
    EditText editText;
    Button buyButton;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);

        textAmount = (TextView)findViewById(R.id.textAmount1);
        textForeign = (TextView)findViewById(R.id.textForeign);
        editText = (EditText) findViewById(R.id.EditSum);
        buyButton = (Button)findViewById(R.id.BuyButton);
        textAmount.setText(mainAccount.getAmount().toString()); //it can be String.valueof()
        textForeign.setText(String.valueOf("Course of currency "));
        addSpinnerList();
    }
    private void addSpinnerList() {
        spinner = (Spinner) findViewById(R.id.spinner);
        String[] array_spinner;
        ArrayList<String> list1= new ArrayList();
        for (int y = 0; y < MainActivity.currencyArrayList.size() ; y++)
        {
            array_spinner = new String[MainActivity.currencyArrayList.size()];
            array_spinner[y] = String.valueOf(MainActivity.currencyArrayList.get(y).getSymbol());
            for (String s : array_spinner)
            {
                if (s != null && s.length() >0)
                if (s != null && s.length() > 0)
                {
                    list1.add(s);
                }
            }
        }
        ArrayAdapter spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//spinner wiekszy na cały ekran
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);
    }
    public void BtnBUY(View view) {
        upDateTextView();
        Intent anotherIntent5= new Intent(getApplicationContext(), AccountsActivity.class);
        startActivity(anotherIntent5);
   }
    //edittext nazwe zmienic na currencyAmount
    private void upDateTextView() {
        double foreignCurs = Double.valueOf((textForeign.getText()).toString());
        double plnAmount = Double.parseDouble(String.valueOf(textAmount.getText()));
        double buyAmount = Double.parseDouble(String.valueOf(editText.getText())); //editText.getText
        double result =  foreignCurs * buyAmount;
        double newPlnAmount = plnAmount - result;
        if (result > plnAmount)
        {
            Toast.makeText(this,"You don't have enough money",Toast.LENGTH_SHORT).show();
        }
        else
        {
            mainAccount.setAmount(newPlnAmount);
            textAmount.setText(String.valueOf(mainAccount.getAmount()));
            for (int i = 0; i < accountsList.size(); i++) {
                Account account = accountsList.get(i);
                if(account.getCurrency().getSymbol().equals(spinner.getSelectedItem().toString())) {
                //dzieki temu kupując jedna walutę kilka razy, wartość się dodaje, a nie nowa zastępuje starą.
                    account.updateAmount(buyAmount);
                }
            }
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        Toast.makeText(parent.getContext(), "You chose this currency: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
        textForeign.setText(String.valueOf(MainActivity.currencyArrayList.get(position).getBuy()));
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}



