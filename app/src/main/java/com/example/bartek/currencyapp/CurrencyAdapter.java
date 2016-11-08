package com.example.bartek.currencyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartek on 2016-11-07.
 */
public class CurrencyAdapter extends ArrayAdapter<Currency> {

    ArrayList<Currency> currencyArrayList;
    LayoutInflater vi;
    int Resource;
    HolderView holder;

    public CurrencyAdapter(Context context, int resource, ArrayList<Currency> objects) {
        super(context, resource, objects);
        
        vi=(LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Resource=resource;
        currencyArrayList=objects;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;


        if (v == null){

            holder= new HolderView();

            v=vi.inflate(Resource, null);



            holder.symbol1=(TextView)v.findViewById(R.id.symbol);
            holder.buy2=(TextView)v.findViewById(R.id.buy);
            holder.sale3=(TextView)v.findViewById(R.id.sale);


            v.setTag(holder);
        } else {
            holder = (HolderView) v.getTag();
        }



        holder.symbol1.setText(currencyArrayList.get(position).getSymbol());
        holder.buy2.setText(String.valueOf(currencyArrayList.get(position).getBuy()));
        holder.sale3.setText(String.valueOf(currencyArrayList.get(position).getSale()));

        return v;




    }

        static class HolderView{
            public TextView symbol1;
            public TextView buy2;
            public TextView sale3;

    }


}
