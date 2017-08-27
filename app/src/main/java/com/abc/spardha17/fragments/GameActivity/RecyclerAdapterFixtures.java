package com.abc.spardha17.fragments.GameActivity;

/**
 * Created by abhinav on 5/14/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abc.spardha17.R;
import com.abc.spardha17.fragments.Strings.strings;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterFixtures extends RecyclerView.Adapter<RecyclerAdapterFixtures.ViewHolder> {
    private List<DataFixtures> t = new ArrayList<DataFixtures>();
    private Context context;
    strings item=new strings();
    private String[] titles = item.titles;
    private int[] images = item.icons;


    public RecyclerAdapterFixtures(Context baseContext, List<DataFixtures> datalist) {
        context = baseContext;
        t = datalist;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        data();
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.update_game_card, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
//        data();
        viewHolder.eventName.setText(t.get(i).getEventName());
        viewHolder.location.setText(t.get(i).getLocation());
        viewHolder.dateTime.setText(t.get(i).getDatetime());
        viewHolder.team1.setText(t.get(i).getTeam1());
        viewHolder.team2.setText(t.get(i).getTeam2());
    }

    @Override
    public int getItemCount() {
//        data();
        return t.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public int currentItem;
        public TextView eventName;
        public TextView location;
        public TextView dateTime;
        public TextView team1;
        public TextView team2;

        public ViewHolder(final View itemView) {
            super(itemView);
            eventName = (TextView) itemView.findViewById(R.id.eventname);
            location = (TextView) itemView.findViewById(R.id.location);
            dateTime = (TextView) itemView.findViewById(R.id.datetime);
            team1 = (TextView) itemView.findViewById(R.id.team1);
            team2 = (TextView) itemView.findViewById(R.id.team2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
//                    System.out.println("posotion before " + position);


                }
            });
        }
    }

}