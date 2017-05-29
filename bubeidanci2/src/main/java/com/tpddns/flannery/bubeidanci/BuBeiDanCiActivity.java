package com.tpddns.flannery.bubeidanci;


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
import com.tpddns.flannery.bubeilibrary.BuBeiBaseView;
import com.tpddns.flannery.bubeilibrary.BuBeiScrollView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuBeiDanCiActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = BuBeiDanCiActivity.class.getSimpleName();

    private TextView menu_text_1;
    private TextView menu_text_2;
    private TextView menu_text_3;
    private TextView menu_text_4;

    private ViewPager viewpager;

    public static final void startBuBeiDanCiActivity(Context ctx) {
        ctx.startActivity(new Intent(ctx, BuBeiDanCiActivity.class));
    }

    private View bubeiscrollview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        getSupportActionBar().hide();//隐藏掉整个ActionBar，包括下面的Tabs
        bubeiscrollview = findViewById(R.id.bubeiscrollview);
        View view1 = getLayoutInflater().inflate(R.layout.bubeidanci_1, null);
        View view2 = getLayoutInflater().inflate(R.layout.bubeidanci_2, null);


        initViewFirst(view1);
        initViewSecond(view2);

        ((BuBeiBaseView) bubeiscrollview).getFrameLayout1().addView(view1);
        ((BuBeiBaseView) bubeiscrollview).getFrameLayout2().addView(view2);

//        // bubeiscrollview.setVerticalFadingEdgeEnabled();
//        bubeiscrollview.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });

    }

    private void initViewFirst(View view) {

    }

    private void initViewSecond(View view2) {
        initNavigation(view2);
        initMenu(view2);
        initViewPager(view2);
    }

    private void initMenu(View view) {
        menu_text_1 = (TextView) view.findViewById(R.id.menu_text_1);
        menu_text_2 = (TextView) view.findViewById(R.id.menu_text_2);
        menu_text_3 = (TextView) view.findViewById(R.id.menu_text_3);
        menu_text_4 = (TextView) view.findViewById(R.id.menu_text_4);
    }


    private void initNavigation(View view) {
        View navigation_settings = view.findViewById(R.id.navigation_settings);
        View navigation_themes = view.findViewById(R.id.navigation_themes);
        View navigation_library = view.findViewById(R.id.navigation_library);
        View navigation_statistics = view.findViewById(R.id.navigation_statistics);
        navigation_settings.setOnClickListener(this);
        navigation_themes.setOnClickListener(this);
        navigation_library.setOnClickListener(this);
        navigation_statistics.setOnClickListener(this);
    }

    private void initViewPager(View view) {
        View bubeidanci_viewpager_demo = getLayoutInflater().inflate(R.layout.bubeidanci_viewpager_demo, null);
        View bubeidanci_viewpager_1 = getLayoutInflater().inflate(R.layout.bubeidanci_viewpager_1, null);
        View bubeidanci_viewpager_2 = getLayoutInflater().inflate(R.layout.bubeidanci_viewpager_2, null);
        View bubeidanci_viewpager_3 = getLayoutInflater().inflate(R.layout.bubeidanci_viewpager_3, null);
        View bubeidanci_viewpager_4 = getLayoutInflater().inflate(R.layout.bubeidanci_viewpager_4, null);
        initViewPager_demo(bubeidanci_viewpager_demo);
        initViewPager_1(bubeidanci_viewpager_1);
        initViewPager_2(bubeidanci_viewpager_2);
        initViewPager_3(bubeidanci_viewpager_3);
        initViewPager_4(bubeidanci_viewpager_4);

        final List<View> listViews = new ArrayList<>();
        listViews.add(bubeidanci_viewpager_demo);
        listViews.add(bubeidanci_viewpager_1);
        listViews.add(bubeidanci_viewpager_2);
        listViews.add(bubeidanci_viewpager_3);
        listViews.add(bubeidanci_viewpager_4);

        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
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


    private void initViewPager_demo(View view) {
//        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_demo);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        List<TypeInterface> list = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            list.add(new OneType("i " + i));
//        }
//
//
//        recyclerView.setAdapter(new MyAdapter(list, this));
    }

    private void initViewPager_1(View view) {

    }

    private void initViewPager_2(View view) {

    }

    private void initViewPager_3(View view) {

    }

    private void initViewPager_4(View view) {

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
        //Logger.t(TAG).d("onTouchEvent()");
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navigation_settings:
                setMenuTextWhite();
                menu_text_1.setTextColor(getResources().getColor(R.color.orange));
                viewpager.setCurrentItem(0);
                break;
            case R.id.navigation_themes:
                setMenuTextWhite();
                menu_text_2.setTextColor(getResources().getColor(R.color.orange));
                viewpager.setCurrentItem(1);
                break;
            case R.id.navigation_library:
                setMenuTextWhite();
                menu_text_3.setTextColor(getResources().getColor(R.color.orange));
                viewpager.setCurrentItem(2);
                break;
            case R.id.navigation_statistics:
                setMenuTextWhite();
                menu_text_4.setTextColor(getResources().getColor(R.color.orange));
                viewpager.setCurrentItem(3);
                break;
        }
    }
}
