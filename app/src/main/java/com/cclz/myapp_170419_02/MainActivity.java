package com.cclz.myapp_170419_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
        StringRequest request=new StringRequest("http://rate.bot.com.tw/xrt?Lang=zh-TW", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("NET", response);
                int loc = response.indexOf("美金 (USD)");
                int loc2 = response.indexOf("30.06");
                Log.d("NET", "loc: " + loc);
                Log.d("NET", "loc2: " + loc2);
                String dollar=response.substring(loc + 368, loc + 368 +6);

                Log.d("NET", "dollar: " + dollar);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);
        queue.start();
    }
}
