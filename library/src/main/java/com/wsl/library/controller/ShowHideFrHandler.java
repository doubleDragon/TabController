package com.wsl.library.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * An implementation of {@link ShowHideHandler} that uses {@link FragmentTransaction#show(Fragment)}
 * and {@link FragmentTransaction#hide(Fragment)} to show/hide fragments.
 */
public class ShowHideFrHandler implements ShowHideHandler {
    @Override
    public FragmentTransaction show(FragmentTransaction transaction, Fragment fragment) {

        return transaction.show(fragment);
    }

    @Override
    public FragmentTransaction hide(FragmentTransaction transaction, Fragment fragment) {
        return transaction.hide(fragment);
    }

    @Override
    public void save(Bundle saveControllerState, Fragment fragment) {
        boolean visible = isVisible(fragment);
        saveControllerState.putBoolean(fragment.getTag(), visible);
    }

    @Override
    public void restore(@Nullable Bundle savedControllerState, FragmentTransaction transaction, Fragment fragment) {
        if (savedControllerState != null) {
            boolean visible = savedControllerState.getBoolean(fragment.getTag());
            if (visible) {
                show(transaction, fragment);
            } else {
                hide(transaction, fragment);
            }
        }
    }

    @Override
    public boolean isVisible(Fragment fragment) {
        return !fragment.isHidden();
    }
}
