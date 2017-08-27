package com.abc.spardha17.fragments.GameActivity;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abc.spardha17.R;
import com.abc.spardha17.activity.OurTeamCard.DataContacts;
import com.abc.spardha17.activity.OurTeamCard.JSONParseteam;
import com.abc.spardha17.fragments.Strings.strings;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragmentGame extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerAdapterContact mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List<DataContacts> mDataset;
//    public static final String JSON_URL = "https://quarkbackend.com/getfile/eternaldivine100/team";
    String url;
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
        int position=0;
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

        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONParseteam pj = new JSONParseteam();
                        pj.parseJSONteam(response);
                        mDataset = pj.getData();
                        mAdapter = new RecyclerAdapterContact(mDataset);
                        mRecyclerView.setAdapter(mAdapter);
                        pDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getActivity(),"No Internet connection",Toast.LENGTH_LONG).show();
                        pDialog.dismiss();

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);

    }


}
