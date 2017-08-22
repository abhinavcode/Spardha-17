package com.abc.spardha17.activity;

import android.content.Context;
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
 * Created by abhinav on 8/12/2017.
 */
public class myadapter extends RecyclerView.Adapter<myadapter.ViewHolder> {
    Context context;


    private List<movie> mDataset;
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text;
        public ImageView imageView;
        public TextView content;

        public ViewHolder(View v) {
            super(v);
            text = (TextView) v.findViewById(R.id.text);
            imageView = (ImageView) v.findViewById(R.id.icon);
            content=(TextView)v.findViewById(R.id.content);

        }
    }
    public void add(int position, movie item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }
    public void remove(movie item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }
    public myadapter(List<movie> myDataset) {
        mDataset = myDataset;
    }
    @Override
    public myadapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card, parent, false);
//        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        v.setLayoutParams(lp);
        ViewHolder vh = new ViewHolder(v);
        return vh;


    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.text.setText(mDataset.get(position).getName());
        holder.content.setText(mDataset.get(position).getContent());





        Glide.with(holder.imageView.getContext()).load(mDataset.get(position).getUrl()).into(holder.imageView);


    }
    @Override
    public int getItemCount() {
        if(mDataset!=null)
        return mDataset.size();
        else return 0;
    }



}