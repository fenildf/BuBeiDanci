package com.tpddns.flannery.bubeilibrary;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.orhanobut.logger.Logger;

/**
 * Created by flannery on 2017/5/28.
 */

public class BuBeiViewPager extends ViewPager {
    private String TAG = BuBeiViewPager.class.getSimpleName();

    public BuBeiViewPager(Context context) {
        super(context);
        init();
    }

    public BuBeiViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
//        setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Logger.t(TAG).d("onTouch " + event.getY());
//                return false;
//            }
//        });
    }

}
