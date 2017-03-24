package com.example.benzdev.section1;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by BenZDeV on 3/17/2017.
 */

public class CustomView extends View {

    private  boolean isBlue = false;
    private  boolean isDown = false;
    private GestureDetector gestureDetector;


    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        initWithAttrs(attrs, 0 ,0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initWithAttrs(attrs, defStyleAttr,0);
    }

    @TargetApi(21)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void init() {

            gestureDetector = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() {
                @Override
                public boolean onDown(MotionEvent motionEvent) {
                    // Decide : Care or not care?

                    return false;
                }

                @Override
                public void onShowPress(MotionEvent motionEvent) {
                    // Do whatever you want
                    getParent().requestDisallowInterceptTouchEvent(true);

                }

                @Override
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return false;
                }

                @Override
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                    return false;
                }

                @Override
                public void onLongPress(MotionEvent motionEvent) {

                }

                @Override
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

                    isBlue = !isBlue;
                    invalidate();
                    return false;
                }
            });
        // Enable Click Mode
        setClickable(true);

        //After this call , if it's not clickable , it will be clickable
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


    private  void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes){

        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs,R.styleable.CustomView,defStyleAttr,defStyleRes);
        try {
                isBlue= a.getBoolean(R.styleable.CustomView_isBlue, false);
        }finally {
            a.recycle();
        }




    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();

        if(isBlue)
            p.setColor(0xFF0000FF);  // in Java : AARRGGBB //blue
        else
            p.setColor(0xFFFF0000);  // in Java : AARRGGBB //red

        canvas.drawLine(0,0,getMeasuredWidth(),getMeasuredHeight(),p);
        if(isDown){
            p.setColor(0xFF00FF00);

            //covert dp to px
            float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,5,getContext().getResources().getDisplayMetrics());

            p.setStrokeWidth(px);

            // Draw Line
            canvas.drawLine(0,getMeasuredHeight(),getMeasuredWidth(),0,p);

        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Pass event to GestureDectector
        gestureDetector.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                isDown = true;
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                isDown = false;
                invalidate();
                return true;
            case MotionEvent.ACTION_CANCEL:
                isDown = false;
                invalidate();
                //stop work
                return true;





        }
        return super.onTouchEvent(event);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();


    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
    }
}



