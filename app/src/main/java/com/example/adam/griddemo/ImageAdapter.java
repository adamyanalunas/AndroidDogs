package com.example.adam.griddemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.adam.griddemo.model.Dog;

import java.util.ArrayList;

/**
 * Created by adam on 11/6/15.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Dog> mDogs;

    public ImageAdapter(Context c, ArrayList<Dog> dogs) {
        mContext = c;
        mDogs = dogs;
    }

    public int getCount() {
        return mDogs.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // Initialize if not recycling
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(185, 185));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8,8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mDogs.get(position).getPictureID());
        return imageView;
    }
}
