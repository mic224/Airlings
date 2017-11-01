package com.herophus.airlings;

import android.view.GestureDetector;
import android.view.MotionEvent;

class GestureListener extends GestureDetector.SimpleOnGestureListener {

    GLRenderer renderer;

    public GestureListener(GLRenderer r) {
        renderer = r;
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
                            float distanceY) {
//        renderer.scroll(distanceX, distanceY);
        return true;
    }

    @Override
    public boolean onDown(MotionEvent event) {

        return false;
    }

}
