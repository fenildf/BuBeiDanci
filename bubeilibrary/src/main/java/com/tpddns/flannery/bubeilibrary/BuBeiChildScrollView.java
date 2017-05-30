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

    private void log(String text) {
        android.util.Log.d(TAG, text);
    }

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
        //getParent().requestDisallowInterceptTouchEvent(true);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        log("onInterceptTouchEvent(MotionEvent ev)");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        log("dispatchTouchEvent(MotionEvent ev)");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        log("onTouchEvent(MotionEvent ev)");
        return super.onTouchEvent(ev);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        log("l -> " + l + " , t -> " + t + " , oldl -> " + oldl + ", oldt-> " + oldt);
    }
}

