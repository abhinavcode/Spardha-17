package com.abc.spardha17.fragments;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abc.spardha17.R;

public class TwoFragment extends android.support.v4.app.Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    public TwoFragment() {
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
        View v=inflater.inflate(R.layout.fragment_two, container, false);
        recyclerView =
                (RecyclerView) v.findViewById(R.id.recycler_view);

//        layoutManager = new GridLayoutManager(getContext(),Gri,false);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
        return v;

    }

}
