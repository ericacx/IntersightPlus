package com.tripint.intersightplus.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import com.tripint.intersightplus.R;
import com.tripint.intersightplus.adapters.TabLayoutAdapter;
import com.tripint.intersightplus.fragments.HotTopicFragment;
import com.tripint.intersightplus.fragments.MyConcernedTopicFragment;

import java.util.LinkedList;
import java.util.List;

public class TopicActivity extends AppCompatActivity {

    private TabLayout topic_tabLayout;
    private ViewPager topic_viewPager;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        initView();
    }

    private void initView() {

        topic_tabLayout = ((TabLayout) findViewById(R.id.topic_tabLayout));
        topic_viewPager = ((ViewPager) findViewById(R.id.topic_viewPager));

        list = new LinkedList<>();
        list.add(new MyConcernedTopicFragment());
        list.add(new HotTopicFragment());

        TabLayout.Tab tab1 = topic_tabLayout.newTab();
        TabLayout.Tab tab2 = topic_tabLayout.newTab();

        tab1.setText("我关注的话题");
        tab2.setText("热门话题");

        topic_tabLayout.addTab(tab1);
        topic_tabLayout.addTab(tab2);

        topic_viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        topic_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(topic_tabLayout));
        topic_tabLayout.setOnTabSelectedListener(new TabLayoutAdapter());
    }
}
