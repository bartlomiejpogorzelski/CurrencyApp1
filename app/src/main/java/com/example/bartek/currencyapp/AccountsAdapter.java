package com.example.bartek.currencyapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static android.R.attr.button;
import static android.R.attr.resource;
import static com.example.bartek.currencyapp.AccountsActivity.accountsList;

import static com.example.bartek.currencyapp.MainActivity.currencyArrayList;
import static com.example.bartek.currencyapp.R.layout.row1;

/**
 * Created by Bartek on 2016-11-15.
 */

public class AccountsAdapter extends ArrayAdapter<Account> {

    LayoutInflater vi;
    private Context context;

    public AccountsAdapter(Context context, int resource, ArrayList<Account> object) {
        super(context, resource, object);
        vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context=context;
    }
    @NonNull
    @Override
    public View getView(final int position, final View convertView, @NonNull final ViewGroup parent) {
        HolderView holder;
        View v = convertView;
        if (v == null) {
            holder = new HolderView();
            v = vi.inflate(row1, null);
            holder.button1 = (Button) v.findViewById(R.id.buttonSmall);
            holder.buy2 = (TextView) v.findViewById(R.id.buy11);
            holder.otherAmount = (TextView)v.findViewById(R.id.amountOtherCurrency);
            v.setTag(holder);
        } else {
            holder = (HolderView) v.getTag();
        }
        holder.button1.setText(currencyArrayList.get(position).getSymbol());
        holder.buy2.setText(String.valueOf(currencyArrayList.get(position).getBuy()));
        holder.otherAmount.setText(String.valueOf(accountsList.get(position).getAmount()));

        holder.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent exchangeIntent= new Intent(context, ExchangeActivity.class);
                exchangeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(exchangeIntent);
                Toast.makeText(context, "działa", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
    static class HolderView {
        public Button button1;
        public TextView buy2;
        public TextView otherAmount;
    }

}
