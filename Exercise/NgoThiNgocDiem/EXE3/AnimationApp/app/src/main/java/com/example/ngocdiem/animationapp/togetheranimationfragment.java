package com.example.ngocdiem.animationapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ngocdiem.animationapp.R;

/**
 * Created by abhiandroid
 */

public class togetheranimationfragment extends Fragment implements Animation.AnimationListener{ @Nullable
ImageView imageView;
    Button btnStart;
    View view;
    Animation animTogether;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_togetheranimation, container, false);
        imageView = (ImageView) view.findViewById(R.id.imgtogether);
        btnStart = (Button)view.findViewById(R.id.btntogether);
        animTogether = AnimationUtils.loadAnimation(getContext(),
                R.anim.together );
        animTogether.setAnimationListener(this);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView.startAnimation(animTogether);
            }
        });
        return view;

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
