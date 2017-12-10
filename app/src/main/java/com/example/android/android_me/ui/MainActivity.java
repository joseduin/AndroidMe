package com.example.android.android_me.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;
import com.example.android.android_me.utils.FragmentUtil;

import java.util.List;

/**
 * Created by Jose on 10/12/2017.
 */

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImagenClickListener {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.android_me_linear_layout) != null) {
            Button nextButton = (Button) findViewById(R.id.nex_botton);
            nextButton.setVisibility(View.GONE);

            GridView gridView = (GridView) findViewById(R.id.images_grid_view);
            gridView.setColumnWidth(2);

            if (savedInstanceState == null) {
                setFragment(AndroidImageAssets.getHeads(), R.id.head_container, 0);
                setFragment(AndroidImageAssets.getBodies(), R.id.body_container, 0);
                setFragment(AndroidImageAssets.getLegs(), R.id.leg_container, 0);
            }
        }
        mTwoPane = findViewById(R.id.android_me_linear_layout) != null;
    }

    @Override
    public void onImageSelected(int position) {
        int bodyPartNumber = position / 12;
        int listIndex = position - 12 * bodyPartNumber;

        if (mTwoPane) {
            switch (bodyPartNumber) {
                case 0:
                    replaceFragment(AndroidImageAssets.getHeads(), R.id.head_container, listIndex);
                    break;
                case 1:
                    replaceFragment(AndroidImageAssets.getBodies(), R.id.body_container, listIndex);
                    break;
                case 2:
                    replaceFragment(AndroidImageAssets.getLegs(), R.id.leg_container, listIndex);
                    break;
            }

        } else {
            switch (bodyPartNumber) {
                case 0:
                    headIndex = listIndex;
                    break;
                case 1:
                    bodyIndex = listIndex;
                    break;
                case 2:
                    legIndex = listIndex;
                    break;
            }

            final Intent intent = new Intent(MainActivity.this, AndroidMeActivity.class);
            intent.putExtra("headIndex", headIndex);
            intent.putExtra("bodyIndex", bodyIndex);
            intent.putExtra("legIndex", legIndex);

            Button nextButton = (Button) findViewById(R.id.nex_botton);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(intent);
                }
            });
        }
    }

    private void setFragment(List<Integer> bodyParts, int view, int index) {
        BodyPartFragment fragment = fragment(bodyParts, index);

        FragmentUtil.add(getSupportFragmentManager(), view, fragment);
    }

    private void replaceFragment(List<Integer> bodyParts, int view, int index) {
        BodyPartFragment fragment = fragment(bodyParts, index);

        FragmentUtil.replace(getSupportFragmentManager(), view, fragment);
    }

    private BodyPartFragment fragment(List<Integer> bodyParts, int index) {
        BodyPartFragment fragment = new BodyPartFragment();
        fragment.setmImageIds(bodyParts);
        fragment.setmListIndex(index);
        return fragment;
    }

}
