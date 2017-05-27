package com.flannery.bubeidanci;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuBeiDanCiActivity extends AppCompatActivity {
    private static final String TAG = BuBeiDanCiActivity.class.getSimpleName();

    private TextView menu_text_1;
    private TextView menu_text_2;
    private TextView menu_text_3;
    private TextView menu_text_4;


    public static final void startBuBeiDanCiActivity(Context ctx) {
        ctx.startActivity(new Intent(ctx, BuBeiDanCiActivity.class));
    }

    private BuBeiScrollView bubeiscrollview;

    /**
     * 关闭Android导航栏，实现全屏
     */
    private void closeBar() {
        try {
            String command;
            command = "LD_LIBRARY_PATH=/vendor/lib:/system/lib service call activity 42 s16 com.android.systemui";
            ArrayList<String> envlist = new ArrayList<String>();
            Map<String, String> env = System.getenv();
            for (String envName : env.keySet()) {
                envlist.add(envName + "=" + env.get(envName));
            }
            String[] envp = envlist.toArray(new String[0]);
            Process proc = Runtime.getRuntime().exec(
                    new String[]{"su", "-c", command}, envp);
            proc.waitFor();
        } catch (Exception ex) {
            // Toast.makeText(getApplicationContext(), ex.getMessage(),
            // Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        getSupportActionBar().hide();//隐藏掉整个ActionBar，包括下面的Tabs
        bubeiscrollview = (BuBeiScrollView) findViewById(R.id.bubeiscrollview);
        View view1 = getLayoutInflater().inflate(R.layout.bubeidanci_1, null);
        View view2 = getLayoutInflater().inflate(R.layout.bubeidanci_2, null);
        initMenu(view2);


        bubeiscrollview.getFrameLayout1().addView(view1);
        bubeiscrollview.getFrameLayout2().addView(view2);

//        // bubeiscrollview.setVerticalFadingEdgeEnabled();
//        bubeiscrollview.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });
        initViewPager();
    }

    private void initMenu(View view) {
        menu_text_1 = (TextView) view.findViewById(R.id.menu_text_1);
        menu_text_2 = (TextView) view.findViewById(R.id.menu_text_2);
        menu_text_3 = (TextView) view.findViewById(R.id.menu_text_3);
        menu_text_4 = (TextView) view.findViewById(R.id.menu_text_4);
    }

    private void initViewPager() {
        View bubeidanci_viewpager_1 = getLayoutInflater().inflate(R.layout.bubeidanci_viewpager_1, null);
        View bubeidanci_viewpager_2 = getLayoutInflater().inflate(R.layout.bubeidanci_viewpager_2, null);
        View bubeidanci_viewpager_3 = getLayoutInflater().inflate(R.layout.bubeidanci_viewpager_3, null);
        View bubeidanci_viewpager_4 = getLayoutInflater().inflate(R.layout.bubeidanci_viewpager_4, null);
        final List<View> listViews = new ArrayList<>();
        listViews.add(bubeidanci_viewpager_1);
        listViews.add(bubeidanci_viewpager_2);
        listViews.add(bubeidanci_viewpager_3);
        listViews.add(bubeidanci_viewpager_4);

        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        viewpager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return listViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(listViews.get(position));
                return listViews.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(listViews.get(position));
            }
        });
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setMenuTextWhite();
                setMenuTextColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void setMenuTextWhite() {
        menu_text_1.setTextColor(Color.WHITE);
        menu_text_2.setTextColor(Color.WHITE);
        menu_text_3.setTextColor(Color.WHITE);
        menu_text_4.setTextColor(Color.WHITE);
    }

    private void setMenuTextColor(int index) {
        Logger.t(TAG).d("index = " + index);
        switch (index) {
            case 0:
                menu_text_1.setTextColor(getResources().getColor(R.color.orange));
                break;
            case 1:
                menu_text_2.setTextColor(getResources().getColor(R.color.orange));
                break;
            case 2:
                menu_text_3.setTextColor(getResources().getColor(R.color.orange));
                break;
            case 3:
                menu_text_4.setTextColor(getResources().getColor(R.color.orange));
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logger.t(TAG).d("onTouchEvent()");
        return super.onTouchEvent(event);
    }

    public void clickAdd(View view) {
        Logger.t(TAG).d("clickAdd()");
        bubeiscrollview.scrollBy(0, 200);

    }

    public void clickSub(View view) {
        bubeiscrollview.scrollTo(400, 400);
        Logger.t(TAG).d("clickSub()");
    }
}
