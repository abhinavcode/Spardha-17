package com.abc.spardha17.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.abc.spardha17.R;
import com.abc.spardha17.activity.OurTeamCard.DataContacts;
import com.abc.spardha17.activity.OurTeamCard.JSONParseteam;
import com.abc.spardha17.activity.OurTeamCard.adapter;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

public class ourTeam extends AppCompatActivity {
    public static final String JSON_URL = "https://quarkbackend.com/getfile/eternaldivine100/team";
    List<DataContacts> mDataset;
    SharedPreferences sharedpreferences;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_team);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_team);

        GridLayoutManager gridlayoutManager = new GridLayoutManager(getBaseContext(), 1);
        mRecyclerView.setLayoutManager(gridlayoutManager);
        sharedpreferences = getSharedPreferences("dataourTeam", Context.MODE_PRIVATE);

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

                        SharedPreferences.Editor editor = sharedpreferences.edit();

                        editor.putString("response", response);
                        editor.commit();
                        JSONParseteam pj = new JSONParseteam();
                        pj.parseJSONteam(response);
                        mDataset = pj.getData();
                        mAdapter = new adapter(mDataset);
                        mRecyclerView.setAdapter(mAdapter);
                        pDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(ourTeam.this,"No Internet connection",Toast.LENGTH_LONG).show();
                        String response = sharedpreferences.getString("response", null);
                        if (response != null) {
                            JSONParseteam pj = new JSONParseteam();
                            pj.parseJSONteam(response);
                            mDataset = pj.getData();
                            mAdapter = new adapter(mDataset);
                            mRecyclerView.setAdapter(mAdapter);
                        }
                        pDialog.dismiss();

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}
