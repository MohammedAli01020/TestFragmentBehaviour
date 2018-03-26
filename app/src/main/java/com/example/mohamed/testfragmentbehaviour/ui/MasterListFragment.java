package com.example.mohamed.testfragmentbehaviour.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.mohamed.testfragmentbehaviour.R;
import com.example.mohamed.testfragmentbehaviour.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {

    private OnImageClickListener mCallbacks;

    public interface OnImageClickListener {
        void onImageSelected(int position);
    }

    public MasterListFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallbacks = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                " must implement OnImageClickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gridView =  rootView.findViewById(R.id.images_grid_view);

        MasterListAdapter adapter = new MasterListAdapter(AndroidImageAssets.getAll());

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCallbacks.onImageSelected(i);
            }
        });

        return rootView;
    }

}
