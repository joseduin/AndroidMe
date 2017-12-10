package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by Jose on 10/12/2017.
 */

public class MasterListFragment extends Fragment {

    private OnImagenClickListener mCallback;
    public interface OnImagenClickListener {
        void onImageSelected(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnImagenClickListener) context;
        } catch (ClassCastException e) { }
    }

    public MasterListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.images_grid_view);

        MasterListAdapter adapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCallback.onImageSelected(position);
            }
        });

        return rootView;
    }
}
