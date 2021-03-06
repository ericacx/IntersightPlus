package com.tripint.intersightplus.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tripint.intersightplus.MainActivity;
import com.tripint.intersightplus.R;
import com.tripint.intersightplus.utils.PackageUtils;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        SharedPreferences sp = getSharedPreferences("version",MODE_PRIVATE);

        //相当于旧版本
        final String version = sp.getString("version", null);

        //相当于新版本
        final String newVersion = PackageUtils.getPackageVersion(this);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //说明登录过，不需要进入导航页，直接进入主界面
                //当新版本与旧版本一致时直接跳转进入主界面
                if(newVersion.equals(version)){

                    Intent intent = new Intent(WelcomeActivity.this,TopicActivity.class);

                    startActivity(intent);

                    finish();

                }else {//需要进入导航页
                    Intent intent = new Intent(WelcomeActivity.this,GuideActivity.class);

                    startActivity(intent);

                    finish();
                }
            }
        });
        thread.start();
    }
}
