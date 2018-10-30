package com.iitbhu.spardha.activity.Launchbackend;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iitbhu.spardha.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.util.List;

/**
 * Created by abhinav on 8/12/2017.
 */
public class myadapter extends RecyclerView.Adapter<myadapter.ViewHolder> {
    Context context;


    private List<movie> mDataset;

    public myadapter(List<movie> myDataset) {
        mDataset = myDataset;
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

        System.out.println("lets see "+mDataset.get(position).getName());
        System.out.println("ktb " +
                "");
        holder.text.setText(mDataset.get(position).getName());
//        holder.content.setText(mDataset.get(position).getContent());

        System.out.println("lets see "+mDataset.get(position).getUrl());
        Glide.with(holder.imageView.getContext()).load(mDataset.get(position).getUrl())
                .transform(new CircleTransform(holder.imageView.getContext()))
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        if(mDataset!=null)
        return mDataset.size();
        else return 0;
    }

    public static class CircleTransform extends BitmapTransformation {
        public CircleTransform(Context context) {
            super(context);
        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return circleCrop(pool, toTransform);
        }

        private Bitmap circleCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;

            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            // TODO this could be acquired from the pool too
            Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);

            Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }

            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);
            return result;
        }

        @Override
        public String getId() {
            return getClass().getName();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text;
        public ImageView imageView;
        public TextView content;
        public LinearLayout textHead;

        public ViewHolder(View v) {
            super(v);
            text = (TextView) v.findViewById(R.id.text);
            imageView = (ImageView) v.findViewById(R.id.icon);
//            content=(TextView)v.findViewById(R.id.content);
//            textHead=(LinearLayout)v.findViewById(R.id.textHead);
            int width = v.getContext().getResources().getDisplayMetrics().widthPixels;
            int height = v.getContext().getResources().getDisplayMetrics().heightPixels;
            android.view.ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();

            layoutParams.width = width;
            layoutParams.height = height / 2;
            imageView.setLayoutParams(layoutParams);

//            layoutParams.height = height/2-60;
//            textHead.setLayoutParams(layoutParams);
        }
    }



}