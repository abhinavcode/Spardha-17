package com.abc.spardha17.activity.OurTeamCard;

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

;

/**
 * Created by abhinav on 8/12/2017.
 */
public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    Context context;


    private List<DataContacts> mDataset;
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public ImageView imageView;
        public TextView designation;
        public ImageView contact;
        public ImageView fb;

        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            imageView = (ImageView) v.findViewById(R.id.icon);
            designation=(TextView)v.findViewById(R.id.post);
            contact=(ImageView)v.findViewById(R.id.call);
            fb=(ImageView)v.findViewById(R.id.fb);


            contact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent intent=new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+mDataset.get(position).getContact()));
                    v.getContext().startActivity(intent);
                }
            });

            fb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    Intent fbop=getFBIntent(itemView.getContext(),mDataset.get(position).getFb());
                    v.getContext().startActivity(fbop);
                }
            });
        }
    }

    public Intent getFBIntent(Context context, String facebookId) {

//        try {
//            // Check if FB app is even installed
//            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
//
//            String facebookScheme = "fb://profile/" + facebookId;
//            return new Intent(Intent.ACTION_VIEW, Uri.parse(facebookScheme));
//        }
//        catch(Exception e) {

            // Cache and Open a url in browser
            String facebookProfileUri = "https://www.facebook.com/" + facebookId;
            return new Intent(Intent.ACTION_VIEW, Uri.parse(facebookProfileUri));
//        }

    }


    public void add(int position, DataContacts item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }
    public void remove(DataContacts item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }
    public adapter(List<DataContacts> myDataset) {
        mDataset = myDataset;
    }
    @Override
    public adapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_team, parent, false);
//        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        v.setLayoutParams(lp);
        ViewHolder vh = new ViewHolder(v);
        return vh;


    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.name.setText(mDataset.get(position).getNameofperson());
        holder.designation.setText(mDataset.get(position).getDesignation());
        Glide.with(holder.imageView.getContext()).load(mDataset.get(position).getImageURL()).into(holder.imageView);

    }
    @Override
    public int getItemCount() {
        if(mDataset!=null)
            return mDataset.size();
        else return 0;
    }



}