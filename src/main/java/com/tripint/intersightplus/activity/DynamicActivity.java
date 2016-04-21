package com.tripint.intersightplus.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tripint.intersightplus.R;
import com.tripint.intersightplus.adapters.TabLayoutAdapter;
import com.tripint.intersightplus.fragments.MessageFragment;
import com.tripint.intersightplus.fragments.NewFragment;

import java.util.LinkedList;
import java.util.List;

public class DynamicActivity extends AppCompatActivity {

    private TabLayout dynamic_tabLayout;
    private ViewPager dynamic_viewPager;
    private List<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        initView();
    }

    private void initView() {
        dynamic_tabLayout = ((TabLayout) findViewById(R.id.dynamic_tabLayout));
        dynamic_viewPager = ((ViewPager) findViewById(R.id.dynamic_viewPager));

        list = new LinkedList<>();
        list.add(new NewFragment());
        list.add(new MessageFragment());

        TabLayout.Tab tab1 = dynamic_tabLayout.newTab();
        TabLayout.Tab tab2 = dynamic_tabLayout.newTab();

        tab1.setText("最新动态");
        tab2.setText("消息通知");

        dynamic_tabLayout.addTab(tab1);
        dynamic_tabLayout.addTab(tab2);

        dynamic_viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        dynamic_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(dynamic_tabLayout));
        dynamic_tabLayout.setOnTabSelectedListener(new TabLayoutAdapter());
    }
}
