package com.tpddns.flannery.bubeilibrary;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;

import com.orhanobut.logger.Logger;

/**
 * http://blog.csdn.net/u013015161/article/details/51495015
 * Created by flannery on 17-5-26.
 */

public class BuBeiLiearLayout extends LinearLayout implements BuBeiBaseView {
    public static final String TAG = BuBeiLiearLayout.class.getSimpleName();

    private void log(String text) {
        android.util.Log.d(TAG, text);
    }


    public BuBeiLiearLayout(Context context) {
        super(context);
        init(context);
    }

    public BuBeiLiearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BuBeiLiearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private FrameLayout frameLayout1;
    private FrameLayout frameLayout2;
    private int screenWidth;
    private int screenHeight;
    //
    // private GestureDetectorCompat mDetector;
    private Scroller mScroller;

    //最大的Menu的宽度, 这里是通过设置而得到的
    private int maxMenuHeight;
    // 就是为了计算移动出Menu
    private int firstPageMoveHeight;


    private void init(Context context) {
        mScroller = new Scroller(context);

        //mDetector = new GestureDetectorCompat(context, mOnGestureListener);
        //  mDetector.setOnDoubleTapListener(mOnDoubleTapListener);

        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        //LinearLayout container = new LinearLayout(context);
        final LinearLayout container = this;
        container.setOrientation(LinearLayout.VERTICAL);
        container.setLayoutParams(new LinearLayout.LayoutParams(screenWidth, screenHeight * 2));

        frameLayout1 = new FrameLayout(context);
        frameLayout1.setLayoutParams(new LayoutParams(screenWidth, screenHeight, Gravity.CENTER));
        //container.addView(frameLayout1);
        container.addView(frameLayout1, screenWidth, screenHeight);
        frameLayout2 = new FrameLayout(context);
        frameLayout2.setLayoutParams(new LayoutParams(screenWidth, screenHeight, Gravity.CENTER));
        container.addView(frameLayout2, screenWidth, screenHeight);
//
//        container.setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                log(" container.getX = " + container.getX() + ", containter.getY = " + container.getY() + " container.getTop = " + container.getTop() + " , container.getBottom = " + container.getBottom());
//                return false;
//            }
//        });
    }

//    private GestureDetector.OnDoubleTapListener mOnDoubleTapListener = new GestureDetector.OnDoubleTapListener() {
//        @Override
//        public boolean onSingleTapConfirmed(MotionEvent e) {
//            return false;
//        }
//
//        @Override
//        public boolean onDoubleTap(MotionEvent e) {
//            return false;
//        }
//
//        @Override
//        public boolean onDoubleTapEvent(MotionEvent e) {
//            return false;
//        }
//    };
//
//    private GestureDetector.OnGestureListener mOnGestureListener = new GestureDetector.OnGestureListener() {
//        @Override
//        public boolean onDown(MotionEvent e) {
//            return false;
//        }
//
//        @Override
//        public void onShowPress(MotionEvent e) {
//        }
//
//        @Override
//        public boolean onSingleTapUp(MotionEvent e) {
//            return false;
//        }
//
//        @Override
//        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//            scrollBy(0, (int) distanceY);
//            return false;
//        }
//
//        @Override
//        public void onLongPress(MotionEvent e) {
//        }
//
//        @Override
//        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//            return false;
//        }
//    };

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //log("getX = " + .getX() + " , getY = " + this.getY() + " , getTop = " + this.getTop());
        //log("onTouchEvent(MotionEvent ev)");
        float y = ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                log("onTouchEvent  ACTION_UP");
                break;
            case MotionEvent.ACTION_DOWN:
                //log("onTouchEvent -> ACTION_DOWN -> " + ev.getY());
                log("onTouchEvent  ACTION_DOWN");
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //log("onTouchEvent -> ACTION_MOVE -> " + ev.getY());
                //计算移动的距离


                float offY = y - lastY;
                log("onTouchEvent  ACTION_MOVE 0 offY = " + offY + " , getScrollY = " + getScrollY());
                if (getScrollY() <= 0 && offY > 0) {
                    offY = 0;
                }
                log("onTouchEvent  ACTION_MOVE offY = " + offY + " , getScrollY = " + getScrollY());
                scrollBy(0, (int) -offY);
                lastY = y;
                
                break;
        }
        //mDetector.onTouchEvent(ev);
        return true;//super.onTouchEvent(ev);
        //return true;
    }

    private float lastY;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //mDetector.onTouchEvent(ev);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                log("dispatchTouchEvent ACTION_UP");

                break;
            case MotionEvent.ACTION_DOWN:
                log("dispatchTouchEvent ACTION_DOWN");
                //lastY = ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                //int y = (int) (ev.getRawY() - lastY);
                log("dispatchTouchEvent ACTION_MOVE");
                //scrollBy(0, -y);
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        //log("onInterceptHoverEvent(MotionEvent event)");
        return super.onInterceptHoverEvent(event);
    }

    @Override
    public FrameLayout getFrameLayout1() {
        return frameLayout1;
    }

    @Override
    public FrameLayout getFrameLayout2() {
        return frameLayout2;
    }

    @Override
    public int getScreenWidth() {
        return screenWidth;
    }

    @Override
    public int getScreenHeight() {
        return screenHeight;
    }

    /**
     * 设置menu的的长度， 也就是第一页滑动的距离
     * 设置menu的的长度， 也就是第一页滑动的距离
     *
     * @param maxMenuHeight
     */
    @Override
    public void setMaxMenuHeight(int maxMenuHeight) {
        log("setMaxMenuHeight = " + maxMenuHeight);
        this.maxMenuHeight = maxMenuHeight;
    }

    @Override
    public void gotoPage2() {
        scrollTo(0, getScreenHeight());
    }

    @Override
    public void gotoMenuOpen() {
        if (maxMenuHeight > 0) {
            log("gotoMenuOpen = " + maxMenuHeight + " getHeight = " + getScreenHeight());
            //scrollTo(0, maxMenuHeight);
            scrollTo(0, maxMenuHeight);
        }
    }

    @Override
    public void gotoMenuClose() {
        if (maxMenuHeight > 0) {
            scrollBy(0, getScreenHeight() - firstPageMoveHeight);
        }
    }

    @Override
    public boolean isMenuOpen() {
        return false;
    }
}
