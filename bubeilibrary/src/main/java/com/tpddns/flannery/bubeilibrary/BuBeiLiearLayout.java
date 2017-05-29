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

    private GestureDetectorCompat mDetector;
    private Scroller mScroller;


    private int maxMenuHeight;


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
    private int lastY;


    private void init(Context context) {
        mScroller = new Scroller(context);

        mDetector = new GestureDetectorCompat(context, mOnGestureListener);
        mDetector.setOnDoubleTapListener(mOnDoubleTapListener);

        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        //LinearLayout container = new LinearLayout(context);
        LinearLayout container = this;
        container.setOrientation(LinearLayout.VERTICAL);
        container.setLayoutParams(new LinearLayout.LayoutParams(screenWidth, screenHeight * 2));

        frameLayout1 = new FrameLayout(context);
        frameLayout1.setLayoutParams(new LayoutParams(screenWidth, screenHeight, Gravity.CENTER));
        //container.addView(frameLayout1);
        container.addView(frameLayout1, screenWidth, screenHeight);
        frameLayout2 = new FrameLayout(context);
        frameLayout2.setLayoutParams(new LayoutParams(screenWidth, screenHeight, Gravity.CENTER));
        container.addView(frameLayout2, screenWidth, screenHeight);

//        setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return mDetector.onTouchEvent(event);
//            }
//        });

        //this.addView(container);
//        setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Logger.t(TAG).d("onTouch - " + event.getY());
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        //Logger.t(TAG).d("ACTION_DOWN");
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        //Logger.t(TAG).d("ACTION_MOVE");
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        //Logger.t(TAG).d("ACTION_UP");
//                        break;
//                }
//
//
//                //scrollBy(0, 20);
        // mDetector.onTouchEvent(event);
//                return true;
//            }
//        });
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
            Logger.t(TAG).d("onScroll()");
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
        Logger.t(TAG).d("onTouchEvent(MotionEvent ev)");
//        Logger.t(TAG).d("onTouchEvent(MotionEvent ev) ");
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                Logger.t(TAG).d("ACTION_DOWN");
//                break;
//            case MotionEvent.ACTION_MOVE:
//                Logger.t(TAG).d("ACTION_MOVE");
//                break;
//            case MotionEvent.ACTION_UP:
//                Logger.t(TAG).d("ACTION_UP");
//                break;
//        }
//
//
//        //scrollBy(0, 20);
        //mDetector.onTouchEvent(ev);
        return super.onTouchEvent(ev);
        //return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Logger.t(TAG).d("dispatchTouchEvent(MotionEvent ev)");
        mDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        Logger.t(TAG).d("onInterceptHoverEvent(MotionEvent event)");
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
     *
     * @param maxMenuHeight
     */
    @Override
    public void setMaxMenuHeight(int maxMenuHeight) {
        this.maxMenuHeight = maxMenuHeight;
    }
}
