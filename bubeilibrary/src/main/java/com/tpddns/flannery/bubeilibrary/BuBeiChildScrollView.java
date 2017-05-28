package com.tpddns.flannery.bubeilibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

import com.orhanobut.logger.Logger;

/**
 * @deprecated http://www.cnblogs.com/shortboy/archive/2013/04/08/3008706.html
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
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Logger.t(TAG).d("onTouch event -> " + event.getY());
                return false;
            }
        });
    }


    public void resume() {
        overScrollBy(0, -lastScrollDelta, 0, getScrollY(), 0, getScrollRange(), 0, 0, true);
        lastScrollDelta = 0;
    }


    /**
     * 将targetView滚到最顶端
     */
    public void scrollTo(View targetView) {

        int oldScrollY = getScrollY();
        int top = targetView.getTop() - mTop;
        int delatY = top - oldScrollY;
        lastScrollDelta = delatY;
        overScrollBy(0, delatY, 0, getScrollY(), 0, getScrollRange(), 0, 0, true);
    }

    private int getScrollRange() {
        int scrollRange = 0;
        if (getChildCount() > 0) {
            View child = getChildAt(0);
            scrollRange = Math.max(0, child.getHeight() - (getHeight()));
        }
        return scrollRange;
    }

    int currentY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        if (parentScrollView == null) {
//            return super.onInterceptTouchEvent(ev);
//        } else {
//            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//                // 将父scrollview的滚动事件拦截
//                currentY = (int) ev.getY();
//                setParentScrollAble(false);
//                return super.onInterceptTouchEvent(ev);
//            } else if (ev.getAction() == MotionEvent.ACTION_UP) {
//                // 把滚动事件恢复给父Scrollview
//                setParentScrollAble(true);
//            } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
//            }
//        }
        return super.onInterceptTouchEvent(ev);

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
//        View child = getChildAt(0);
//        if (parentScrollView != null) {
//            if (ev.getAction() == MotionEvent.ACTION_MOVE) {
//                int height = child.getMeasuredHeight();
//                height = height - getMeasuredHeight();
//
//                // System.out.println("height=" + height);
//                int scrollY = getScrollY();
//                // System.out.println("scrollY" + scrollY);
//                int y = (int) ev.getY();
//
//                // 手指向下滑动
//                if (currentY < y) {
//                    if (scrollY <= 0) {
//                        // 如果向下滑动到头，就把滚动交给父Scrollview
//                        setParentScrollAble(true);
//                        return false;
//                    } else {
//                        setParentScrollAble(false);
//
//                    }
//                } else if (currentY > y) {
//                    if (scrollY >= height) {
//                        // 如果向上滑动到头，就把滚动交给父Scrollview
//                        setParentScrollAble(true);
//                        return false;
//                    } else {
//                        setParentScrollAble(false);
//
//                    }
//
//                }
//                currentY = y;
//            }
        return super.onTouchEvent(ev);


    }


    /**
     * 是否把滚动事件交给父scrollview
     */
    private void setParentScrollAble(boolean flag) {
        parentScrollView.requestDisallowInterceptTouchEvent(!flag);
    }
}

