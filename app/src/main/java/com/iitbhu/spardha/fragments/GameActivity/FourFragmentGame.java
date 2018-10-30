package com.iitbhu.spardha.fragments.GameActivity;

/**
 * Created by abhinav on 6/23/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iitbhu.spardha.R;
import com.iitbhu.spardha.fragments.Strings.strings;

public class FourFragmentGame extends Fragment {
    String halloffame;
    public FourFragmentGame() {
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
        View v = inflater.inflate(R.layout.fragment_hall_of_fame, container, false);
//        Button b = (Button) v.findViewById(R.id.test);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), Game.class));
//            }
//        });
        strings s=new strings();
        Bundle bundle = this.getArguments();
        int position=0;
        if (bundle != null) {
            position = bundle.getInt("position", 0);
        }
        halloffame=s.halloffame[position];
        System.out.println("hello"+halloffame);
        TextView hallOfFame=(TextView)v.findViewById(R.id.halloffame);
        hallOfFame.setText(halloffame);
        return v;
    }
}
