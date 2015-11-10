package com.example.adam.griddemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by adam on 11/9/15.
 */
public class ZoomedDog extends Activity {

    public static final String IMAGE_BUNDLE_ID = "IMAGE_BUNDLE_ID";
    public static final String NAME_BUNDLE_ID = "NAME_BUNDLE_ID ";

    private ImageView mDogImageView;
    private TextView mDogNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dog_image_view);
        Bundle extras = getIntent().getExtras();

        mDogImageView = (ImageView) findViewById(R.id.dog_image_view);
        Bitmap bitmap = extras.getParcelable(IMAGE_BUNDLE_ID);
        mDogImageView.setImageBitmap(bitmap);

        mDogNameText = (TextView) findViewById(R.id.dog_image_text);
        String name = extras.getString(NAME_BUNDLE_ID);
        mDogNameText.setText(name);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mDogNameText = null;
        mDogImageView = null;
    }
}
