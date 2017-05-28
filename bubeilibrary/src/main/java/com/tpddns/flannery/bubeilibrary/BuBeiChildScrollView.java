package com.tpddns.flannery.bubeilibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

import com.orhanobut.logger.Logger;

/**
 * Created by flannery on 2017/5/28.
 */

public class BuBeiChildScrollView extends ScrollView {
    private String TAG = BuBeiChildScrollView.class.getSimpleName();

    
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
}
