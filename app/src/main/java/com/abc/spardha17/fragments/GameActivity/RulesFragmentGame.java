package com.abc.spardha17.fragments.GameActivity;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abc.spardha17.R;
import com.abc.spardha17.app.AppController;
import com.abc.spardha17.fragments.Strings.strings;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class RulesFragmentGame extends android.support.v4.app.Fragment {
    SharedPreferences sharedpreferences;
    int position = 0;
    TextView rules;
    public RulesFragmentGame() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rules, container, false);
        strings s=new strings();
        Bundle bundle = this.getArguments();

        if (bundle != null) {
            position = bundle.getInt("position", 0);
        }
        rules= (TextView) v.findViewById(R.id.rule);
        sharedpreferences = this.getActivity().getSharedPreferences("Rules", Context.MODE_PRIVATE);

//        url="https://quarkbackend.com/getfile/eternaldivine100/basketball";

        getdatafromserver();

//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                //        if(gridlayoutManager.findLastCompletelyVisibleItemPosition())
//
//                super.onScrolled(recyclerView, dx, dy);
//            }
//        });
//


        return v;

    }

    private void getdatafromserver() {

        String responses = sharedpreferences.getString("responser" + position, null);
        if (responses != null) {
                String response = (responses);
                rules.setText(Html.fromHtml(response));
        }
        Log.d(AppController.TAG, "Error: " );
    }

}

