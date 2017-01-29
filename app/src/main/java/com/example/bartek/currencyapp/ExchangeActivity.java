package com.example.bartek.currencyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExchangeActivity extends AppCompatActivity {



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

        textAmount.setText(AccountsActivity.mainAccount.getAmount().toString()); //it can be String.valueof()

        textForeign.setText(String.valueOf(MainActivity.currencyArrayList.get(0).getBuy()));




    }

    public void BtnBUY(View view) {
       upDateTextView();



//        Intent anotherIntent5= new Intent(getApplicationContext(), ExchangeActivity.class);
//        startActivity(anotherIntent5);

    }

    private void upDateTextView() {
        foreignCurs=Double.valueOf((textForeign.getText()).toString());
        buyAmount = Double.parseDouble(String.valueOf(editText.getText())); //editText.getText
        plnAmount = Double.parseDouble(String.valueOf(textAmount.getText()));

        double result=  foreignCurs * buyAmount;

        double newPlnAmount = plnAmount - result;

        textAmount.setText(String.valueOf(newPlnAmount));
    }


}


