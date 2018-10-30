package com.iitbhu.spardha.fragments.GameActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iitbhu.spardha.R;
import com.iitbhu.spardha.app.AppController;
import com.iitbhu.spardha.fragments.Strings.strings;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class OneFragmentGame extends Fragment {
    List<DataFixtures> resultdata = new ArrayList<>();
    RecyclerView recyclerView;
    GridLayoutManager gridlayoutManager;
    RecyclerAdapterFixtures adapter;
    String url;
    int position = 0;
    SharedPreferences sharedpreferences;

    public OneFragmentGame() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_game_fixture, container, false);
        strings s=new strings();
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            position = bundle.getInt("position", 0);
        }
        url=s.fixtures[position];
//        url="https://quarkbackend.com/getfile/eternaldivine100/basketballfix";
        recyclerView =
                (RecyclerView) v.findViewById(R.id.recycler_view_fixture);
        sharedpreferences = this.getActivity().getSharedPreferences("Fixture", Context.MODE_PRIVATE);


        gridlayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(gridlayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new RecyclerAdapterFixtures(getActivity().getBaseContext(), resultdata);
        recyclerView.setAdapter(adapter);
        resultdata.clear();
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

        String responses = sharedpreferences.getString("response" + position, null);
        if (responses != null) {
            try {
                JSONArray response = new JSONArray(responses);
                for (int i = 0; i < response.length(); i++) {
                    JSONObject jresponse = response.getJSONObject(i);
                    DataFixtures data = new DataFixtures(jresponse.getString("eventname"), jresponse.getString("location"), jresponse.getString("date"), jresponse.getString("time"), jresponse.getString("team1"), jresponse.getString("team2"));
                    resultdata.add(data);
                }

                adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Log.d(AppController.TAG, "Error");

    }

}