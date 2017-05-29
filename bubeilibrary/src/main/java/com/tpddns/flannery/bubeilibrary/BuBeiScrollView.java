package com.tpddns.flannery.bubeilibrary;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
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

    private GestureDetectorCompat mDetector;


    private int maxMenuHeight;


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
    private int lastY;


    private void init(Context context) {


        mDetector = new GestureDetectorCompat(context, mOnGestureListener);
        mDetector.setOnDoubleTapListener(mOnDoubleTapListener);

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

        initChildScrollView();
    }

    private void initChildScrollView() {
        this.requestDisallowInterceptTouchEvent(true);
    }

    private GestureDetector.OnDoubleTapListener mOnDoubleTapListener = new GestureDetector.OnDoubleTapListener() {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            return false;
        }
    };

    private GestureDetector.OnGestureListener mOnGestureListener = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            scrollBy(0, (int) distanceY);
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    };

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        //mDetector.onTouchEvent(ev);
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

    /**
     * 设置menu的的长度， 也就是第一页滑动的距离
     *
     * @param maxMenuHeight
     */
    public void setMaxMenuHeight(int maxMenuHeight) {
        this.maxMenuHeight = maxMenuHeight;
    }
}
