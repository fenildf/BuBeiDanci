package com.tpddns.flannery.bubeilibrary;

import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by flannery on 2017/5/28.
 */

public interface BuBeiBaseView {
    FrameLayout getFrameLayout1();

    FrameLayout getFrameLayout2();

    int getScreenWidth();

    int getScreenHeight();

    void setMaxMenuHeight(int maxMenuHeight);
}
