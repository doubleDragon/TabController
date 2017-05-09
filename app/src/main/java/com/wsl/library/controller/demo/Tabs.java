package com.wsl.library.controller.demo;

import android.support.v4.app.Fragment;

import com.wsl.library.controller.FragmentProvider;


public enum Tabs implements FragmentProvider {
    TAB_0,
    TAB_1,
    TAB_2,
    TAB_3;

    Tabs() {
    }

    @Override
    public String getTag() {
        return name();
    }

    @Override
    public Fragment getInstance() {
        return TabFragment.newInstance(name());
    }
}
