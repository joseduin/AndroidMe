/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;
import com.example.android.android_me.utils.FragmentUtil;

import java.util.List;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {

            setFragment(AndroidImageAssets.getHeads(), R.id.head_container, "headIndex");
            setFragment(AndroidImageAssets.getBodies(), R.id.body_container, "bodyIndex");
            setFragment(AndroidImageAssets.getLegs(), R.id.leg_container, "legIndex");
        }
    }

    private void setFragment(List<Integer> bodyParts, int view, String bundlePart) {
        BodyPartFragment fragment = new BodyPartFragment();
        fragment.setmImageIds(bodyParts);
        int index = getIntent().getIntExtra(bundlePart, 0);
        fragment.setmListIndex(index);

        FragmentUtil.add(getSupportFragmentManager(), view, fragment);
    }
}
