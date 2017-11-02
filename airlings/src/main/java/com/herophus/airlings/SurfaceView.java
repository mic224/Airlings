package com.herophus.airlings;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.support.v4.view.GestureDetectorCompat;
import android.view.MotionEvent;

public class SurfaceView extends GLSurfaceView {

    private final GLRenderer renderer;

    private GestureDetectorCompat GestDetector;

    public SurfaceView(Context context, GLRenderer rend) {
        super(context);

        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2);

        // Set the Renderer for drawing on the GLSurfaceView
        renderer = rend;
        setRenderer(renderer);

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

        // Gesture Detection
        GestDetector = new GestureDetectorCompat(context, new GestureListener(renderer));
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        renderer.onPause();
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        renderer.onResume();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        GestDetector.onTouchEvent(event);
        return true;
    }
}