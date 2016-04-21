package com.tripint.intersightplus.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tripint.intersightplus.MainActivity;
import com.tripint.intersightplus.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuideFragment extends Fragment {

    public GuideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_guide, container, false);

        initView(ret);

        return ret;
    }

    private void initView(View ret) {
        //创建一个集合的对象放置图片
        List<Integer> images = new ArrayList<>();

        // 把图片添加到集合images中
        images.add(R.mipmap.p1);
        images.add(R.mipmap.p2);
        images.add(R.mipmap.p3);
        images.add(R.mipmap.p4);

        //获取来自activity中传递过来的值
        Bundle arguments = getArguments();

        int id = arguments.getInt("id");

        //获得界面控件对象
        ImageView imageView = ((ImageView) ret.findViewById(R.id.guide_imageView));

        TextView goToSee = ((TextView) ret.findViewById(R.id.goToSee));


        switch (id){
            case 0:
                imageView.setImageResource(images.get(id));
                break;
            case 1:
                imageView.setImageResource(images.get(id));
                break;
            case 2:
                imageView.setImageResource(images.get(id));
                break;
            case 3://最后一页，显示“进去看看”
                imageView.setImageResource(images.get(id));
                goToSee.setVisibility(View.VISIBLE);
                goToSee.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), MainActivity.class);

                        startActivity(intent);

                        getActivity().finish();
                    }
                });
                break;
        }
    }


}
