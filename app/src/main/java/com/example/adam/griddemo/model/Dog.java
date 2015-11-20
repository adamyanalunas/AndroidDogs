package com.example.adam.griddemo.model;

import com.example.adam.griddemo.R;

import java.util.Random;

/**
 * Created by adam on 11/13/15.
 */
public class Dog {
    private String mName;
    private int mPictureID;
    private Boolean mSeen = false;

    public Dog() {
        mPictureID = randomThumbID();
        mName = randomName();
    }

    public String getName() { return mName; }
    public int getPictureID() { return mPictureID; }

    public Boolean getSeen() { return mSeen; }
    public void setSeen(Boolean hasSeen) { mSeen = hasSeen; }

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
            R.drawable.dog_1, R.drawable.dog_2,
            R.drawable.dog_3, R.drawable.dog_4,
            R.drawable.dog_5, R.drawable.dog_6,
            R.drawable.dog_7, R.drawable.dog_8,
            R.drawable.dog_9, R.drawable.dog_10,
            R.drawable.dog_11, R.drawable.dog_12,
            R.drawable.dog_13, R.drawable.dog_14
    };
}
