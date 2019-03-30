package com.dev.orangeapp.VideoClub;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class VideoClubViewPager extends ViewPager {
    public VideoClubViewPager(Context context) {
        super(context);
        init();
    }

    public VideoClubViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setPageTransformer(true, new VerticalPageTransformer());
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private class VerticalPageTransformer implements ViewPager.PageTransformer {

        @Override
        public void transformPage(View view, float position) {

            if (position < -1) {
                view.setAlpha(0);
            } else if (position <= 1) {
                view.setAlpha(1);

                view.setTranslationX(view.getWidth() * -position);

                float yPosition = position * view.getHeight();
                view.setTranslationY(yPosition);
            } else {
                view.setAlpha(0);
            }
        }
    }

    private MotionEvent swapXY(MotionEvent ev) {
        float width = getWidth();
        float height = getHeight();

        float newX = (ev.getY() / height) * width;
        float newY = (ev.getX() / width) * height;

        ev.setLocation(newX, newY);

        return ev;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = super.onInterceptTouchEvent(swapXY(ev));
        swapXY(ev);
        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapXY(ev));
    }
public  class ViewPagerTransform implements ViewPager.PageTransformer{

        private static final float MIN_SCALE=0.65f;

    @Override
    public void transformPage(@NonNull View page, float position) {
        if(position <=-1){
            page.setAlpha(0);
        }else if (position<=0){
            page.setAlpha(1);
            page.setTranslationX(page.getWidth() * -position);
            page.setTranslationY(page.getHeight() * position);

            page.setScaleX(1);
            page.setScaleY(1);

        }else if(position <=1){
            page.setAlpha(1-position);
            page.setTranslationY(page.getWidth()* - position);
            page.setTranslationY(0);
             float scaleFactor = MIN_SCALE + (1 -MIN_SCALE)*(1-Math.abs(position));
             page.setScaleY(scaleFactor);
             page.setScaleY(scaleFactor);
        }else if(position>1){
            page.setAlpha(0);

        }

    }
}
}
