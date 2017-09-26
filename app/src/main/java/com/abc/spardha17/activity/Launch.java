package com.abc.spardha17.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.abc.spardha17.R;
import com.abc.spardha17.activity.Launchbackend.JSONParse;
import com.abc.spardha17.activity.Launchbackend.movie;
import com.abc.spardha17.activity.Launchbackend.myadapter;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.util.List;

public class Launch extends AppCompatActivity {
    public static final String JSON_URL = "https://quarkbackend.com/getfile/eternaldivine100/launch";
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
    SharedPreferences sharedpreferences;

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
        ActionBar actionBar=getSupportActionBar();
//        toolbar.setBackground();
        actionBar.hide();
//        getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        getWindow().setStatusBarColor(Color.WHITE);
        sharedpreferences = getSharedPreferences("Launch", Context.MODE_PRIVATE);

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
        String response = sharedpreferences.getString("response", null);
        if (response != null) {
            JSONParse pj = new JSONParse();
            pj.parseJSON(response);
            mDataset = pj.getMovies();
            loadData();
        }
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

                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("response", response);
                        editor.commit();
                        JSONParse pj = new JSONParse();
                        pj.parseJSON(response);
                        mDataset = pj.getMovies();
//                        mAdapter = new myadapter(mDataset);
//                        mRecyclerView.setAdapter(mAdapter);
//                        mDataset.get(0).
                        loadData();
                        pDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(Launch.this,"No Internet connection",Toast.LENGTH_LONG).show();

                        pDialog.dismiss();

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    public void loadData() {

        System.out.println("hey" + mDataset.get(0).getName());
        text1.setText(mDataset.get(0).getName());
        content1.setText(mDataset.get(0).getContent());
        System.out.println("hey hey " + mDataset.get(0).getUrl());
        Glide.with(icon1.getContext()).load(mDataset.get(0).getUrl())
                .transform(new CircleTransform(getBaseContext()))
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(icon1);

    }

    public class CircleTransform extends BitmapTransformation {
        public CircleTransform(Context context) {
            super(context);
        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return circleCrop(pool, toTransform);
        }

        private Bitmap circleCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;

            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            // TODO this could be acquired from the pool too
            Bitmap squared = Bitmap.createBitmap(source, x, x, size, size);

            Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }

            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);
            return result;
        }

        @Override
        public String getId() {
            return getClass().getName();
        }
    }
}
