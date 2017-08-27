package com.abc.spardha17.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.abc.spardha17.R;
import com.abc.spardha17.activity.Informalbackend.JSONParseinformal;
import com.abc.spardha17.activity.Informalbackend.adapter;
import com.abc.spardha17.activity.Informalbackend.informalcontainer;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

public class Informals extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List<informalcontainer> mDataset;
    public static final String JSON_URL = "https://quarkbackend.com/getfile/eternaldivine100/informals";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informals);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_informals);

        GridLayoutManager gridlayoutManager = new GridLayoutManager(getBaseContext(),1);
        mRecyclerView.setLayoutManager(gridlayoutManager);

        sendRequest();

    }


    private void sendRequest(){
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONParseinformal pj = new JSONParseinformal();
                        pj.parseJSONInformal(response);
                        mDataset = pj.getItems();
                        mAdapter=new adapter(mDataset);
                        mRecyclerView.setAdapter(mAdapter);

                        pDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Informals.this,"No Internet connection",Toast.LENGTH_LONG).show();
                        pDialog.dismiss();

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}
