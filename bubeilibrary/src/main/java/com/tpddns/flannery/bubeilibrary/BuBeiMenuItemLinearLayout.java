package com.tpddns.flannery.bubeilibrary;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by flannery on 17-5-31.
 */

public class BuBeiMenuItemLinearLayout extends LinearLayout {
    private String TAG = BuBeiMenuItemLinearLayout.class.getSimpleName();

    private OnClickListener mOnClickListener;

    private void log(String text) {
        android.util.Log.d(TAG, text);
    }

    public BuBeiMenuItemLinearLayout(Context context) {
        super(context);
    }

    public BuBeiMenuItemLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BuBeiMenuItemLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        log("onInterceptTouchEvent(MotionEvent ev)");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                log("onTouchEvent(MotionEvent event) ACTION_UP");
                break;
            case MotionEvent.ACTION_DOWN:
                log("onTouchEvent(MotionEvent event) ACTION_DOWN");
                if (mOnClickListener != null) {
                    mOnClickListener.onClick(this);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                log("onTouchEvent(MotionEvent event) ACTION_MOVE");
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        log("dispatchTouchEvent(MotionEvent ev)");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        mOnClickListener = l;
        //super.setOnClickListener(l);
    }
}
