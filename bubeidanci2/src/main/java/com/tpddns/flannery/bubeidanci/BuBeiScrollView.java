package com.tpddns.flannery.bubeidanci;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.orhanobut.logger.Logger;

/**
 * Created by flannery on 17-5-26.
 */

public class BuBeiScrollView extends ScrollView {
    public static final String TAG = "BuBeiScrollView";

    public BuBeiScrollView(Context context) {
        super(context);
        init(context);
    }

    public BuBeiScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BuBeiScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private FrameLayout frameLayout1;
    private FrameLayout frameLayout2;
    private int screenWidth;
    private int screenHeight;


    private void init(Context context) {

        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        LinearLayout container = new LinearLayout(context);
        container.setOrientation(LinearLayout.VERTICAL);

        frameLayout1 = new FrameLayout(context);
        frameLayout1.setLayoutParams(new LayoutParams(screenWidth, screenHeight, Gravity.CENTER));
        container.addView(frameLayout1);
        frameLayout2 = new FrameLayout(context);
        frameLayout2.setLayoutParams(new LayoutParams(screenWidth, screenHeight, Gravity.CENTER));
        container.addView(frameLayout2);

        this.addView(container);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Logger.t(TAG).d("onInterceptTouchEvent() " + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //Logger.t(TAG).d("onTouchEvent() " + ev.getAction());
        return super.onTouchEvent(ev);
        //return true;
    }

    public FrameLayout getFrameLayout1() {
        return frameLayout1;
    }

    public FrameLayout getFrameLayout2() {
        return frameLayout2;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}
