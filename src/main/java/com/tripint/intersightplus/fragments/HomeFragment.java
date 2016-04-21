package com.tripint.intersightplus.fragments;


import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tripint.intersightplus.R;
import com.tripint.intersightplus.adapters.TabLayoutAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //初始化控件
        initView(view);

        return view;
    }

    private void initView(View view) {
        tabLayout = ((TabLayout) view.findViewById(R.id.tabLayout));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager = ((ViewPager) view.findViewById(R.id.viewPager));

        fragmentList = new LinkedList<>();
        fragmentList.add(new AllFragment());
        fragmentList.add(new InternetFragment());
        fragmentList.add(new FinancialFragment());
        fragmentList.add(new SourceFragment());
        fragmentList.add(new TechFragment());
        fragmentList.add(new EnvironmentFragment());
        fragmentList.add(new ArchitectureFragment());

        TabLayout.Tab tab1 = tabLayout.newTab();
        TabLayout.Tab tab2 = tabLayout.newTab();
        TabLayout.Tab tab3 = tabLayout.newTab();
        TabLayout.Tab tab4 = tabLayout.newTab();
        TabLayout.Tab tab5 = tabLayout.newTab();
        TabLayout.Tab tab6 = tabLayout.newTab();
        TabLayout.Tab tab7 = tabLayout.newTab();

        tab1.setText("全部");
        tab2.setText("互联网");
        tab3.setText("金融");
        tab4.setText("能源");
        tab5.setText("科技");
        tab6.setText("环保");
        tab7.setText("建筑");

        tabLayout.addTab(tab1);
        tabLayout.addTab(tab2);
        tabLayout.addTab(tab3);
        tabLayout.addTab(tab4);
        tabLayout.addTab(tab5);
        tabLayout.addTab(tab6);
        tabLayout.addTab(tab7);

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayoutAdapter());
    }

}
