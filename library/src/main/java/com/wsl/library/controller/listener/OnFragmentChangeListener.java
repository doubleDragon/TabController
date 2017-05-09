package com.wsl.library.controller.listener;

import android.support.v4.app.Fragment;

import com.wsl.library.controller.FragmentProvider;


/**
 * Pass this listener to
 * {@link com.wsl.library.controller.TabController#setChangeListener(OnFragmentChangeListener)}
 * to be notified for one of it's events.
 */
public interface OnFragmentChangeListener {

    /**
     * Called when one of your fragments has been shown.
     *
     * @param provider Your shown fragment's provider.
     * @param shownFragment The fragment that has been shown.
     */
    void onFragmentShown(FragmentProvider provider, Fragment shownFragment);

    /**
     * Called on attempt to show an already visible fragment.
     *
     * @param provider Your visible fragment's provider.
     * @param visibleFragment The fragment that is already visible.
     */
    void onFragmentAlreadyVisible(FragmentProvider provider, Fragment visibleFragment);

    /**
     * Called when the fragment you want to show has been created by the
     * {@link com.wsl.library.controller.TabController}.
     *
     * @param provider Your created fragment's provider.
     * @param createdFragment Your created fragment.
     */
    void onFragmentCreated(FragmentProvider provider, Fragment createdFragment);
}
