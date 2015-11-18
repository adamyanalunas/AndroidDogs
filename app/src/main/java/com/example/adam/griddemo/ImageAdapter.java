package com.example.adam.griddemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adam.griddemo.model.Dog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by adam on 11/6/15.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Dog> mDogs;
    private final LayoutInflater mInflater;


    public ImageAdapter(Context c, ArrayList<Dog> dogs) {
        mInflater = LayoutInflater.from(c);
        mContext = c;
        mDogs = dogs;
    }

    public int getCount() {
        return mDogs.size();
    }

    public Dog getItem(int position) {
        return mDogs.get(position);
    }

    public long getItemId(int position) {
        return mDogs.get(position).getPictureID();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ImageView picture;
        TextView name;

        if (convertView == null) {
            v = mInflater.inflate(R.layout.grid_item, parent, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView) v.getTag(R.id.picture);
        name = (TextView) v.getTag(R.id.text);

        Dog dog = getItem(position);
        Picasso.with(mContext)
                .load(dog.getPictureID())
                .resize(350, 350)
                .centerCrop()
                .into(picture);
        name.setText(dog.getName());

        return v;
    }

    private int dpToPx(int dp)
    {
        float density = mContext.getResources().getDisplayMetrics().density;
        return Math.round((float)dp * density);
    }
}
