package com.tripint.intersightplus.activity;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.tripint.intersightplus.R;
import com.tripint.intersightplus.adapters.GuideAdapter;
import com.tripint.intersightplus.fragments.GuideFragment;
import com.tripint.intersightplus.utils.PackageUtils;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        //记录是否使用过
        SharedPreferences sp = getSharedPreferences("version",MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();

        //专门获取版本的工具类
        String packageVersion = PackageUtils.getPackageVersion(this);

        editor.putString("version",packageVersion);

        //记得写这句
        editor.commit();

        initView();
    }

    private void initView() {
        /**
         * 获取RadioGroup
         */

        final RadioGroup guide_tabBar = ((RadioGroup) findViewById(R.id.guide_tabBar));

        guide_tabBar.check(R.id.guideButtonOne);

        guide_tabBar.setClickable(false);

        ViewPager viewPager = ((ViewPager) findViewById(R.id.viewPager));

        ArrayList<Fragment> guideFragment = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            GuideFragment fragment = new GuideFragment();

            //Bundle传值，在Fragment中接受，来确定最后一页导航页是否显示“进去看看”
            Bundle bundle = new Bundle();

            bundle.putInt("id",i);

            fragment.setArguments(bundle);

            guideFragment.add(fragment);
        }

        viewPager.setAdapter(new GuideAdapter(getSupportFragmentManager(), guideFragment));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            //设置ViewPager的滑动监听
            @Override
            public void onPageSelected(int i) {
                int checkedId = R.id.guideButtonOne;
                switch (i) {
                    case 0:
                        checkedId = R.id.guideButtonOne;
                        break;
                    case 1:
                        checkedId = R.id.guideButtonTwo;
                        break;
                    case 2:
                        checkedId = R.id.guideButtonThree;
                        break;
                    case 3:
                        checkedId = R.id.guideButtonFour;
                        break;
                }
                guide_tabBar.check(checkedId);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }
}
