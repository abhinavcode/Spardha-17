package com.abc.spardha17.fragments.GameActivity;

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

/**
 * Created by abhinav on 8/24/2017.
 */

public class RecyclerAdapterResults extends RecyclerView.Adapter<RecyclerAdapterResults.ViewHolder> {
    private List<DataResults> t = new ArrayList<>();
    private Context context;
    strings item=new strings();
    private String[] titles = item.titles;
    private int[] images = item.icons;


public RecyclerAdapterResults(Context baseContext, List<DataResults> datalist) {
        context = baseContext;
        t = datalist;
}



@Override
public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        data();
        View v = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.results_card, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
        }

@Override
public void onBindViewHolder(ViewHolder viewHolder, int i) {
//        data();
        viewHolder.eventName.setText(t.get(i).getEventName());
        viewHolder.team1.setText(t.get(i).getTeam1());
        viewHolder.team2.setText(t.get(i).getTeam2());
       viewHolder.winner.setText(t.get(i).getWinner());
        }

@Override
public int getItemCount() {
//        data();
        return t.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder {
    public int currentItem;
    public TextView eventName;
    public TextView team1;
    public TextView team2;
    public TextView winner;
    public ViewHolder(final View itemView) {
        super(itemView);
        eventName = (TextView) itemView.findViewById(R.id.eventnameres);
        team1 = (TextView) itemView.findViewById(R.id.team1res);
        team2 = (TextView) itemView.findViewById(R.id.team2res);
        winner=(TextView)itemView.findViewById(R.id.winnerres);
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