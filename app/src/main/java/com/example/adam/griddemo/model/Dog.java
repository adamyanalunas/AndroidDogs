package com.example.adam.griddemo.model;

import com.example.adam.griddemo.R;

import java.util.Random;

/**
 * Created by adam on 11/13/15.
 */
public class Dog {
    private int mPictureID;
    private String mName;

    public Dog() {
        mPictureID = randomThumbID();
        mName = randomName();
    }

    public String getName() { return mName; }
    public int getPictureID() { return mPictureID; }

    public String randomName() {
        Random r = new Random();
        return  mNames[r.nextInt(mNames.length)];
    }

    public Integer randomThumbID() {
        Random r = new Random();
        return mThumbIds[r.nextInt(mThumbIds.length)];
    }

    private String[] mNames = {
            "Rocky", "Han", "Luke", "Arin", "Danny",
            "Pete", "Brian", "Ben", "Sage", "Jess",
            "Megan", "Lucy", "Suzette", "Trisha",
            "Hank", "Henk", "Lorde", "Devin", "Tosin"
    };

    private int[] mThumbIds = {
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };
}
