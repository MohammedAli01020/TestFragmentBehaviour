package com.example.mohamed.testfragmentbehaviour.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mohamed.testfragmentbehaviour.R;

import java.util.ArrayList;
import java.util.List;


public class BodyFragment extends Fragment {

    private List<Integer> mList;
    private int mIndex;

    private static final String IMAGES_LIST = "images_list";
    private static final String IMAGES_INDEX = "images_index";


    public BodyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            mList = savedInstanceState.getIntegerArrayList(IMAGES_LIST);
            mIndex = savedInstanceState.getInt(IMAGES_INDEX);
        }
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_body, container, false);
        final ImageView imageView = rootView.findViewById(R.id.image_view);

        if (mList != null) {
            imageView.setImageResource(mList.get(mIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mIndex < mList.size() - 1) {
                        mIndex ++;
                    } else {
                        mIndex = 0;
                    }

                    imageView.setImageResource(mList.get(mIndex));
                }
            });
        }


        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(IMAGES_LIST, (ArrayList<Integer>) mList);
        outState.putInt(IMAGES_INDEX, mIndex);

        super.onSaveInstanceState(outState);
    }

    public void setmList(List<Integer> mList) {
        this.mList = mList;
    }

    public void setmIndex(int mIndex) {
        this.mIndex = mIndex;
    }

}
