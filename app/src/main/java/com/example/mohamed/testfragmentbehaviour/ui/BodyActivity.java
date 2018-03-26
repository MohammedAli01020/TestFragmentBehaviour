package com.example.mohamed.testfragmentbehaviour.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mohamed.testfragmentbehaviour.R;
import com.example.mohamed.testfragmentbehaviour.data.AndroidImageAssets;


public class BodyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            FragmentManager manager = getSupportFragmentManager();

            BodyFragment headFragment = new BodyFragment();
            headFragment.setmList(AndroidImageAssets.getHeads());
            int headIndex = getIntent().getIntExtra("headIndex", 0);
            headFragment.setmIndex(headIndex);
            manager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();

            BodyFragment bodyFragment = new BodyFragment();
            bodyFragment.setmList(AndroidImageAssets.getBodies());
            int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
            bodyFragment.setmIndex(bodyIndex);
            manager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();

            BodyFragment legFragment = new BodyFragment();
            legFragment.setmList(AndroidImageAssets.getLegs());
            int legIndex = getIntent().getIntExtra("legIndex", 0);
            legFragment.setmIndex(legIndex);
            manager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }

    }
}
