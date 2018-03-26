package com.example.mohamed.testfragmentbehaviour.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.mohamed.testfragmentbehaviour.R;
import com.example.mohamed.testfragmentbehaviour.data.AndroidImageAssets;

public class MasterListActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{
    private int mHeadIndex;
    private int mBodyIndex;
    private int mLegIndex;

    private boolean mTwoPane;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        if (findViewById(R.id.android_me_linear_layout) != null) {
            mTwoPane = true;
            Button nextButton = findViewById(R.id.next_button);
            nextButton.setVisibility(View.GONE);


            GridView gridView =  findViewById(R.id.images_grid_view);
            gridView.setNumColumns(2);

            if (savedInstanceState == null) {

                FragmentManager manager = getSupportFragmentManager();

                BodyFragment headFragment = new BodyFragment();
                headFragment.setmList(AndroidImageAssets.getHeads());
                manager.beginTransaction()
                        .add(R.id.head_container, headFragment)
                        .commit();

                BodyFragment bodyFragment = new BodyFragment();
                bodyFragment.setmList(AndroidImageAssets.getBodies());
                manager.beginTransaction()
                        .add(R.id.body_container, bodyFragment)
                        .commit();

                BodyFragment legFragment = new BodyFragment();
                legFragment.setmList(AndroidImageAssets.getLegs());
                manager.beginTransaction()
                        .add(R.id.leg_container, legFragment)
                        .commit();
            }

        } else {
            mTwoPane = false;
        }
    }

    @Override
    public void onImageSelected(int position) {

        int partPosition = position / 12;

        int listIndex =  position - (partPosition * 12);

        if (mTwoPane) {

            switch (partPosition) {
                case 0:
                    BodyFragment headFragment = new BodyFragment();
                    headFragment.setmList(AndroidImageAssets.getHeads());
                    headFragment.setmIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.head_container, headFragment)
                            .commit();
                    break;
                case 1:
                    BodyFragment bodyFragment = new BodyFragment();
                    bodyFragment.setmList(AndroidImageAssets.getBodies());
                    bodyFragment.setmIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container, bodyFragment)
                            .commit();
                    break;
                case 2:
                    BodyFragment legFragment = new BodyFragment();
                    legFragment.setmList(AndroidImageAssets.getLegs());
                    legFragment.setmIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.leg_container, legFragment)
                            .commit();
                    break;
                default:
                    break;
            }

        } else {

            switch (partPosition) {
                case 0:
                    mHeadIndex = listIndex;
                    break;
                case 1:
                    mBodyIndex = listIndex;
                    break;
                case 2:
                    mLegIndex = listIndex;
                    break;
                default:
                    break;
            }

            Bundle bundle = new Bundle();

            bundle.putInt("headIndex", mHeadIndex);
            bundle.putInt("bodyIndex", mBodyIndex);
            bundle.putInt("legIndex", mLegIndex);


            final Intent intent = new Intent(this, BodyActivity.class);
            intent.putExtras(bundle);

            Button nextButton = findViewById(R.id.next_button);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(intent);
                }
            });
        }

    }
}
