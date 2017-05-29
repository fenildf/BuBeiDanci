package com.tpddns.flannery.bubeilibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

import com.orhanobut.logger.Logger;

/**
 * http://www.cnblogs.com/shortboy/archive/2013/04/08/3008706.html
 * 还是用ListView吧， 先把界面实现出来
 * Created by flannery on 2017/5/28.
 */

public class BuBeiChildScrollView extends ScrollView {
    private String TAG = BuBeiChildScrollView.class.getSimpleName();

    public ScrollView parentScrollView;
    private int lastScrollDelta = 0;
    int mTop = 0;

    public BuBeiChildScrollView(Context context) {
        super(context);
        init();
    }

    public BuBeiChildScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BuBeiChildScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        Logger.t(TAG).d("ev -> " + getScrollY());
        return super.onTouchEvent(ev);
    }
}

