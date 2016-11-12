package com.example.bartek.currencyapp;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    static String TAG = "Main" ;

    ArrayList<Currency> currencyArrayList;
    CurrencyAdapter adapter;

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        fillCurrencyList();

    }


    private void fillCurrencyList() {

        currencyArrayList = new ArrayList<Currency>();


        new JSONAsyncTask().execute();

        adapter = new CurrencyAdapter(getApplicationContext(), R.layout.row, currencyArrayList);

        listView.setAdapter(adapter);


    }

    class JSONAsyncTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "Currency is downloading", Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {


                HttpGet get = new HttpGet("http://api.nbp.pl/api/exchangerates/tables/c?format=json");
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = httpclient.execute(get);

                int status = response.getStatusLine().getStatusCode();

                if (status == 200) {
                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);

                    try {
                        JSONArray apiData = new JSONArray(data);


                        JSONObject o = apiData.getJSONObject(0);

                        JSONArray jarray = o.getJSONArray("rates");



                        for (int i = 0; i < jarray.length(); i++) {

                            JSONObject c = jarray.getJSONObject(i);


                            Currency oneCurrency = new Currency();


                            oneCurrency.setSymbol(c.getString("code"));
                            oneCurrency.setBuy (c.getDouble("bid"));
                            oneCurrency.setSale(c.getDouble("ask"));



                            currencyArrayList.add(oneCurrency);


                        }

                    } catch (JSONException ignored) {
                        Log.e(TAG,ignored.getMessage());
                    }

                } else
                {
                    Log.e(TAG, "status error"+ String.valueOf(status) );
                }



            } catch (java.io.IOException e) {
                Log.e(TAG, e.getMessage());
            }
            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            adapter.notifyDataSetChanged();

        }
    }
}