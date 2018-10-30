package com.iitbhu.spardha.fragments.GameActivity;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iitbhu.spardha.R;
import com.iitbhu.spardha.app.AppController;
import com.iitbhu.spardha.fragments.Strings.strings;


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

