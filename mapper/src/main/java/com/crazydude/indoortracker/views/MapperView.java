package com.crazydude.indoortracker.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

/**
 * Created by Crazy on 25.10.2016.
 */

public class MapperView extends View {

    private GestureDetectorCompat mGestureDetector;
    private ScaleGestureDetector mScaleGestureDetector;
    private Matrix mCameraMatrix;
    private Paint mDrawPaint;

    public MapperView(Context context) {
        super(context);
        init();
    }

    public MapperView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MapperView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MapperView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.setMatrix(mCameraMatrix);
        canvas.drawLine(0, 0, 400, 400, mDrawPaint);
    }

    private void init() {
        mGestureDetector = new GestureDetectorCompat(getContext(), new GestureDetectorListener());
        mScaleGestureDetector = new android.view.ScaleGestureDetector(getContext(), new ScaleGestureDetectorListener());
        mCameraMatrix = new Matrix();
        mDrawPaint = new Paint();
        mDrawPaint.setARGB(255, 255, 0, 0);
        mDrawPaint.setStrokeWidth(25);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mGestureDetector.onTouchEvent(event) | mScaleGestureDetector.onTouchEvent(event)) {
            return true;
        }

        return super.onTouchEvent(event);
    }

    private class GestureDetectorListener extends android.view.GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            mCameraMatrix.postTranslate(-distanceX, -distanceY);
            MapperView.this.invalidate();
            return true;
        }
    }

    private class ScaleGestureDetectorListener extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(android.view.ScaleGestureDetector detector) {
//            mCameraMatrix.postScale(detector.getCurrentSpanX(), detector.getCurrentSpanY());
            return true;
        }
    }
}