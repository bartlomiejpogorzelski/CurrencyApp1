package com.example.bartek.currencyapp;

        import android.content.Context;
        import android.support.annotation.NonNull;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.TextView;

        import java.text.DecimalFormat;
        import java.util.ArrayList;

        import static com.example.bartek.currencyapp.MainActivity.currencyArrayList;

/**
 * Created by Bartek on 2016-11-15.
 */

public class Accounts extends ArrayAdapter<Account> {

        ArrayList<Account> accounts;
        LayoutInflater vi;
        int Resource;
        HolderView holder;
        Context context;

        public Accounts(Context context,int resource, ArrayList<Account> object) {

                super(context, resource, object);


                vi=(LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);





        }


        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {


                 View v = convertView;


                if (v == null){

                        holder= new HolderView();

                        v=vi.inflate(R.layout.row1, null);

                        holder.button1=(Button) v.findViewById(R.id.button);
                        holder.buy2=(TextView)v.findViewById(R.id.buy11);



                        v.setTag(holder);
                } else {
                        holder = (HolderView) v.getTag();
                }



                holder.button1.setText(currencyArrayList.get(position).getSymbol());
                holder.buy2.setText(String.valueOf(currencyArrayList.get(position).getBuy()));




                return v;




        }

        static class HolderView{
                public Button button1;
                public TextView buy2;





        }





}
