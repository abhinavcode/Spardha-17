package com.abc.spardha17.fragments.GameActivity;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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


public class TwoFragmentGame extends android.support.v4.app.Fragment {
    List<DataResults> resultdata = new ArrayList<>();
    RecyclerView recyclerView;
    GridLayoutManager gridlayoutManager;
    RecyclerAdapterResults adapter;
    String url ;
    SharedPreferences sharedpreferences;
    int position = 0;

    public TwoFragmentGame() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.updates_game, container, false);
        strings s=new strings();
        Bundle bundle = this.getArguments();

        if (bundle != null) {
            position = bundle.getInt("position", 0);
        }
        url=s.results[position];
        sharedpreferences = this.getActivity().getSharedPreferences("Result", Context.MODE_PRIVATE);

//        url="https://quarkbackend.com/getfile/eternaldivine100/basketball";
        recyclerView =
                    (RecyclerView) v.findViewById(R.id.recycler_view_res);

            getdatafromserver();

            gridlayoutManager = new GridLayoutManager(getActivity(), 1);
            recyclerView.setLayoutManager(gridlayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());

            adapter = new RecyclerAdapterResults(getActivity().getBaseContext(), resultdata);
            recyclerView.setAdapter(adapter);
            resultdata.clear();
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
        String tag_json_arry = "json_array_req";
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();

        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("responses" + position, response.toString());
                        editor.commit();
                        Log.d(AppController.TAG, response.toString());
                        System.out.println(response.toString());
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jresponse = response.getJSONObject(i);
                                DataResults data = new DataResults(jresponse.getString("eventname"), jresponse.getString("team1"),jresponse.getString("team2"),jresponse.getString("winner"));
                                resultdata.add(data);
                            }

                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        pDialog.hide();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String responses = sharedpreferences.getString("responses" + position, null);
                if (responses != null) {
                    try {
                        JSONArray response = new JSONArray(responses);
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject jresponse = response.getJSONObject(i);
                            DataResults data = new DataResults(jresponse.getString("eventname"), jresponse.getString("team1"), jresponse.getString("team2"), jresponse.getString("winner"));
                            resultdata.add(data);
                        }

                        adapter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Log.d(AppController.TAG, "Error: " + error.getMessage());
                pDialog.hide();
            }
        });
        AppController.getInstance().addToRequestQueue(req, tag_json_arry);

    }

}

