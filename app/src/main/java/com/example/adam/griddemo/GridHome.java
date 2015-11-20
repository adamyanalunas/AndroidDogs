package com.example.adam.griddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.example.adam.griddemo.model.Dog;

import java.util.ArrayList;

public class GridHome extends AppCompatActivity implements AbsListView.OnScrollListener {

    private static final String LOG_TAG = "GridActivity";

    private ImageAdapter mAdapter;
    private ArrayList<Dog> mDogs;
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_home);

        mGridView = (GridView) findViewById(R.id.gridView);

        mDogs = conjureDogs();

        mAdapter = new ImageAdapter(this, mDogs);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnScrollListener(this);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dog dog = mDogs.get(position);
                dog.setSeen(true);
                showDog(dog);
                mAdapter.notifyDataSetChanged();
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

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE) {
            for(int i = mGridView.getFirstVisiblePosition(); i <= mGridView.getLastVisiblePosition(); i++) {
                Dog dog = (Dog) mGridView.getItemAtPosition(i);
                String hasSeen = dog.getSeen() ? "Seen" : "Unseen";
                System.out.println(i + " = " + hasSeen);
            }
            System.out.println("---");
        }
    }

    private ArrayList<Dog> conjureDogs() {
        ArrayList<Dog> dogs = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            dogs.add(new Dog());
        }

        return dogs;
    }
}
