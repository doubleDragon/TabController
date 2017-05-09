package com.wsl.library.controller.demo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.wsl.library.controller.FragmentProvider;
import com.wsl.library.controller.TabController;
import com.wsl.library.controller.listener.OnFragmentChangeListener;

public class TabControllerFragmentActivity extends AppCompatActivity
        implements OnFragmentChangeListener, View.OnClickListener{

    private static final String TAG = "TabControllerActivity";
    private static final String BUNDLE_BOTTOM_BAR = TabControllerFragmentActivity.class.getName() + ":BottomBar";

    private TabController tabController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab_controller);

        final TabControllerFragment tabControllerFragment =
                (TabControllerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        tabController = tabControllerFragment.getTabController();
        tabController.setChangeListener(this);
        tabController.switchTo(Tabs.TAB_0);


        findViewById(R.id.tab0).setOnClickListener(this);
        findViewById(R.id.tab1).setOnClickListener(this);
        findViewById(R.id.tab2).setOnClickListener(this);
        findViewById(R.id.tab3).setOnClickListener(this);
//        if (savedInstanceState != null) {
//            bottomBar.onRestoreInstanceState(savedInstanceState.getParcelable(BUNDLE_BOTTOM_BAR));
//        }
//
//        bottomBar.setOnTabSelectListener(new BottomBarListener(this), true);
    }

    @Override
    public void onFragmentShown(FragmentProvider fragmentType, Fragment shownFragment) {
        Log.d(TAG, "onFragmentShown: " + fragmentType.getTag());
    }

    @Override
    public void onFragmentAlreadyVisible(FragmentProvider fragmentType, Fragment visibleFragment) {
        Log.d(TAG, "onFragmentAlreadyVisible: " + fragmentType.getTag());
    }

    @Override
    public void onFragmentCreated(FragmentProvider fragmentType, Fragment addedFragment) {
        Log.d(TAG, "onFragmentCreated: " + fragmentType.getTag());
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
//        final Parcelable bottomBarParcelable = bottomBar.onSaveInstanceState();

//        outState.putParcelable(BUNDLE_BOTTOM_BAR, bottomBarParcelable);
    }

//    @Override
//    public void onStackSelected() {
//        tabController.switchTo(Tabs.TAB_1);
//    }
//
//    @Override
//    public void onViewPagerSelected() {
//        tabController.switchTo(Tabs.TAB_2);
//    }
//
//    @Override
//    public void onFlatSelected() {
//        tabController.switchTo(Tabs.TAB_3);
//    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab0:
                tabController.switchTo(Tabs.TAB_0);
                break;
            case R.id.tab1:
                tabController.switchTo(Tabs.TAB_1);
                break;
            case R.id.tab2:
                tabController.switchTo(Tabs.TAB_2);
                break;
            case R.id.tab3:
                tabController.switchTo(Tabs.TAB_3);
                break;
        }
    }
}
