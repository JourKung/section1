package com.example.benzdev.section1;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by BenZDeV on 3/20/2017.
 */

public class CustomViewGroup extends FrameLayout {

    private Button btnCustomViewGroupHello;
    public CustomViewGroup(@NonNull Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
    }

    @TargetApi(21)
    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
    }


    private void initInflate() {
        // Inflate Layout Here

        inflate(getContext(), R.layout.sample_layout, this);


    }

    private void initInstances() {

        btnCustomViewGroupHello = (Button) findViewById(R.id.btnCustomViewGroupHello);

    }

    public void setButtonText(String text){

        btnCustomViewGroupHello.setText(text);

    }

}
