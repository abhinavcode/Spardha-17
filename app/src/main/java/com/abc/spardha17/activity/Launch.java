package com.abc.spardha17.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.abc.spardha17.R;
import com.abc.spardha17.activity.Launchbackend.JSONParse;
import com.abc.spardha17.activity.Launchbackend.movie;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import java.util.List;

public class Launch extends AppCompatActivity {
//    List<DataFixtures> resultdata = new ArrayList<>();
//    RecyclerView recyclerView;
//    GridLayoutManager gridlayoutManager;
//    RecyclerAdapterFixtures adapter;
//    private RecyclerView mRecyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager mLayoutManager;
    public TextView text1;
    public TextView content1;
    public ImageView icon1;
    List<movie> mDataset;
    public static final String JSON_URL = "https://quarkbackend.com/getfile/eternaldivine100/launch";

//    private FloatingActionButton events;
//    private FloatingActionButton ourTeam;
//    private FloatingActionButton maps;
//
//    private FloatingActionMenu menu;
    LinearLayout events,informals,about,ourTeam,gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        icon1=(ImageView)findViewById(R.id.icon1);
        content1=(TextView)findViewById(R.id.content1);
        text1=(TextView)findViewById(R.id.text1);
        events=(LinearLayout)findViewById(R.id.llevents);
        informals=(LinearLayout)findViewById(R.id.llinformals);
        about=(LinearLayout)findViewById(R.id.llabout);
        ourTeam=(LinearLayout)findViewById(R.id.llourteam);
        gallery=(LinearLayout)findViewById(R.id.llgallery);
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Launch.this,MainActivity.class));
            }
        });
        ourTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Launch.this,ourTeam.class));

            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Launch.this,AboutUs.class));
            }
        });
        informals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Launch.this,Informals.class));
            }
        });
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Launch.this,Gallery.class));
            }
        });

//        menu= (FloatingActionMenu) findViewById(R.id.menu_down);
//        events=(FloatingActionButton)findViewById(R.id.events);
//        maps=(FloatingActionButton)findViewById(R.id.maps);
//        ourTeam=(FloatingActionButton)findViewById(R.id.ourteam);
//        menu.setClosedOnTouchOutside(true);

//        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

//        GridLayoutManager gridlayoutManager = new GridLayoutManager(getBaseContext(),1);
//        mRecyclerView.setLayoutManager(gridlayoutManager);

        sendRequest();

//        menu.hideMenuButton(false);
//        menu.toggle(true);

//        events.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Launch.this,MainActivity.class));
//            }
//        });
//        maps.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //TODO make maps
//            }
//        });
//
//        ourTeam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Launch.this,ourTeam.class));
//            }
//        });
}
//    @Override
//    public void onBackPressed() {
//        if (this.menu.isOpened()) {
//            this.menu.close(true);
//        } else {
//            super.onBackPressed();
//        }
//    }
//

    private void sendRequest(){
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONParse pj = new JSONParse();
                        pj.parseJSON(response);
                        mDataset = pj.getMovies();
//                        mAdapter = new myadapter(mDataset);
//                        mRecyclerView.setAdapter(mAdapter);
//                        mDataset.get(0).
                        System.out.println("hey"+mDataset.get(0).getName());
                        text1.setText(mDataset.get(0).getName());
                        content1.setText(mDataset.get(0).getContent());
                        System.out.println("hey hey "+mDataset.get(0).getUrl());
                        Glide.with(icon1.getContext()).load(mDataset.get(0).getUrl()).into(icon1);

                        pDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Launch.this,"No Internet connection",Toast.LENGTH_LONG).show();
                        pDialog.dismiss();

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}
