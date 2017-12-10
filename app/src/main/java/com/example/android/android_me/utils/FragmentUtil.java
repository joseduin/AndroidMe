package com.example.android.android_me.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by Jose on 10/12/2017.
 */

public class FragmentUtil {

    public static int add(FragmentManager fragmentManager, int view, Fragment fragment) {
        return fragmentManager.beginTransaction().add(view, fragment).commit();
    }

    public static int add(FragmentManager fragmentManager, Fragment fragment, String tag) {
        return fragmentManager.beginTransaction().add(fragment, tag).commit();
    }

    public static int add(FragmentManager fragmentManager, int view, Fragment fragment, String tag) {
        return fragmentManager.beginTransaction().add(view, fragment, tag).commit();
    }

    public static int replace(FragmentManager fragmentManager, int view, Fragment fragment) {
        return fragmentManager.beginTransaction().replace(view, fragment).commit();
    }

    public static int replace(FragmentManager fragmentManager, int view, Fragment fragment, String tag) {
        return fragmentManager.beginTransaction().replace(view, fragment, tag).commit();
    }
}
