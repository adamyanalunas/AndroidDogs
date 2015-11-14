package com.example.adam.griddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.adam.griddemo.model.Dog;

import java.util.ArrayList;

public class GridHome extends AppCompatActivity {

    private static final String LOG_TAG = "GridActivity";
    private ArrayList<Dog> mDogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_home);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        mDogs = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            mDogs.add(new Dog());
        }

        gridView.setAdapter(new ImageAdapter(this, mDogs));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDog(mDogs.get(position));
            }
        });
    }

    public void showDog(Dog dog) {
        Intent intent = new Intent(this, ZoomedDog.class);

        Bundle extras = new Bundle();

        extras.putInt(ZoomedDog.IMAGE_BUNDLE_ID, dog.getPictureID());
        extras.putString(ZoomedDog.NAME_BUNDLE_ID, dog.getName());
        intent.putExtras(extras);

        startActivity(intent);
    }

}
