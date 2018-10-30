package com.iitbhu.spardha.fragments.GameActivity;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iitbhu.spardha.R;
import com.iitbhu.spardha.activity.OurTeamCard.DataContacts;
import com.iitbhu.spardha.activity.OurTeamCard.JSONParseteam;
import com.iitbhu.spardha.fragments.Strings.strings;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragmentGame extends Fragment {

    List<DataContacts> mDataset;
//    public static final String JSON_URL = "https://quarkbackend.com/getfile/eternaldivine100/team";
    String url;
    SharedPreferences sharedpreferences;
    int position = 0;
    private RecyclerView mRecyclerView;
    private RecyclerAdapterContact mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ThreeFragmentGame() {
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
        View v= inflater.inflate(R.layout.fragment_three, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_contact);

        GridLayoutManager gridlayoutManager = new GridLayoutManager(getActivity().getBaseContext(),1);
        mRecyclerView.setLayoutManager(gridlayoutManager);
        strings s=new strings();
        Bundle bundle = this.getArguments();
        sharedpreferences = this.getActivity().getSharedPreferences("Contact", Context.MODE_PRIVATE);

        if (bundle != null) {
            position = bundle.getInt("position", 0);
        }
        url=s.contact[position];
        sendRequest();
        return v;
    }
    private void sendRequest(){
        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();
        String response = sharedpreferences.getString("responsec" + position, null);
        if (response != null) {
            JSONParseteam pj = new JSONParseteam();
            pj.parseJSONteam(response);
            mDataset = pj.getData();
            mAdapter = new RecyclerAdapterContact(mDataset);
            mRecyclerView.setAdapter(mAdapter);

        }
        pDialog.dismiss();


    }


}
