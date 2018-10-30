package com.iitbhu.spardha.fragments.GameActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iitbhu.spardha.R;
import com.iitbhu.spardha.activity.OurTeamCard.DataContacts;

import java.util.List;

/**
 * Created by abhinav on 8/27/2017.
 */

public class RecyclerAdapterContact extends RecyclerView.Adapter<RecyclerAdapterContact.ViewHolder> {
        Context context;


private List<DataContacts> mDataset;
public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView designation;
    public TextView name;
    public ImageView contact;
    public CardView cardView;
    public ViewHolder(View v) {
        super(v);
        cardView=(CardView)v.findViewById(R.id.card_view_contact);
        name = (TextView) v.findViewById(R.id.namePlayer);
        contact=(ImageView)v.findViewById(R.id.callPlayer);
        designation=(TextView)v.findViewById(R.id.designation);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+mDataset.get(position).getContact()));
                v.getContext().startActivity(intent);
            }
        });

    }
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
    public RecyclerAdapterContact(List<DataContacts> myDataset) {
        mDataset = myDataset;
    }
    @Override
    public RecyclerAdapterContact.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_contact, parent, false);
//        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        v.setLayoutParams(lp);
        ViewHolder vh = new ViewHolder(v);
        return vh;


    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.name.setText(mDataset.get(position).getNameofperson());
        holder.designation.setText(mDataset.get(position).getDesignation());
    }
    @Override
    public int getItemCount() {
        if(mDataset!=null)
            return mDataset.size();
        else return 0;
    }

}
