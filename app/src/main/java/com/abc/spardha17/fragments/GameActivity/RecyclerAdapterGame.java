package com.abc.spardha17.fragments.GameActivity;

/**
 * Created by abhinav on 5/14/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abc.spardha17.R;

public class RecyclerAdapterGame extends RecyclerView.Adapter<RecyclerAdapterGame.ViewHolder> {

    private String[] titles = {"Athletics",
            "Badminton",
            "Basketball",
            "Boxing",
            "Carrom",
            "Chess",
            "Cricket",
            "Football",
            "Handball",
            "Hockey",
            "Kabaddi",
            "Lawn Tennis",
            "Squash",
            "Table Tennis",
            "Taekwando",
            "Volleyball",
            "Weightlifting"
    };

    private String[] colors = {"#2E86C1",
            "#2ECC71",
            "#F4D03F",
            "#e2361f",
            "#2E86C1",
            "#2ECC71",
            "#F4D03F",
            "#e2361f",
            "#2E86C1",
            "#2ECC71",
            "#F4D03F",
            "#e2361f",
            "#2E86C1",
            "#2ECC71",
            "#F4D03F",
            "#e2361f",
            "#2E86C1"
    };

    private int[] images = {R.drawable.wl,
            R.drawable.hy,
            R.drawable.tt,
            R.drawable.tt,
            R.drawable.wl,
            R.drawable.hy,
            R.drawable.tt,
            R.drawable.tt,
            R.drawable.wl,
            R.drawable.hy,
            R.drawable.tt,
            R.drawable.tt,
            R.drawable.wl,
            R.drawable.wl,
            R.drawable.hy,
            R.drawable.tt,
            R.drawable.tt,
    };

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.update_game_card, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.eventName.setText(titles[i]);
//        viewHolder.itemImage.setImageResource(images[i]);
//    viewHolder.itemTitle.setTextColor(Color.parseColor(colors[i]));
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            viewHolder.itemImage.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colors[i])));
//        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

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
//                    Intent intent = new Intent(itemView.getContext(), Game.class);
                    // create the transition animation - the images in the layouts
                    // of both activities are defined with android:transitionName="robot"
//                    ActivityOptions options = ActivityOptions
//                            .makeSceneTransitionAnimation((Activity) itemView.getContext(), itemView, "game");
                    // start the new activity
                    System.out.println("posotion before " + position);
//                    Toast.makeText(itemView.getContext(), "made upto here "+position , Toast.LENGTH_LONG).show();

//                    Bundle b=options.toBundle();
//                    b.putInt("position",position);
//                    intent.putExtras(b);
//                    itemView.getContext().startActivity(intent,b);

                    //PREDEIFINED
//                    Snackbar.make(v, "Click detected on item " + position,
//                            Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();

                }
            });
        }
    }
}