package com.abc.spardha17.activity.Informalbackend;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abc.spardha17.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by abhinav on 8/23/2017.
 */

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    Context context;


    private List<informalcontainer> mDataset;
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text;
        public ImageView imageView;
        public ViewHolder(View v) {
            super(v);
            text = (TextView) v.findViewById(R.id.textinformal);
            imageView = (ImageView) v.findViewById(R.id.imginformal);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    System.out.println("position "+position);

                    System.out.println("link "+mDataset.get(position).getHyperlinkimg());
                    String url = mDataset.get(position).getHyperlinkimg();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    System.out.println("url "+url);
                    v.getContext().startActivity(i);
                }
            });

//            text.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = getAdapterPosition();
//                    System.out.println("position "+position);
//
//                    System.out.println("link "+mDataset.get(position).getHyperlinkimg());
////                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mDataset.get(position).getHyperlinkimg()));
////                    imageView.getContext().startActivity(browserIntent);
//                }
//            });
        }
    }
    public void add(int position, informalcontainer item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }
    public void remove(informalcontainer item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }
    public adapter(List<informalcontainer> myDataset) {
        mDataset = myDataset;
    }
    @Override
    public adapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_informals, parent, false);
//        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        v.setLayoutParams(lp);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.text.setText(mDataset.get(position).getEventname());
        System.out.println("img url "+mDataset.get(position).getUrlimg());
        Glide.with(holder.imageView.getContext()).load(mDataset.get(position).getUrlimg()).into(holder.imageView);


    }
    @Override
    public int getItemCount() {
        if(mDataset!=null)
            return mDataset.size();
        else return 0;
    }



}
