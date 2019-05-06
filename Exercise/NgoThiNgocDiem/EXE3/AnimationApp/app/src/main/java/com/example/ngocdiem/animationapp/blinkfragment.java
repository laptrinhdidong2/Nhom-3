package com.example.ngocdiem.animationapp;

import android.app.Activity;
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
import android.widget.TextView;
import android.widget.Toast;
import com.example.ngocdiem.animationapp.R;
import static com.example.ngocdiem.animationapp.R.drawable.animation;

/**
 * Created by abhiandroid
 */

public class blinkfragment extends Fragment implements Animation.AnimationListener {
    ImageView imageView;
    Button btnStart;
    View view;
    Animation animBlink;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_blink, container, false);
        imageView = (ImageView) view.findViewById(R.id.imageblink);
        btnStart = (Button)view.findViewById(R.id.btnStart);
        animBlink = AnimationUtils.loadAnimation(getContext(),
                R.anim.blink);
        animBlink.setAnimationListener(this);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
                imageView.startAnimation(animBlink);
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