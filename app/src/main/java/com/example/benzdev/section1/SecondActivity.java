package com.example.benzdev.section1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    int sum = 0;
    private TextView tvResultSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        sum = intent.getIntExtra("result", 0);


        Bundle bundle = intent.getBundleExtra("cBundle");
        int x = bundle.getInt("x");
        int y = bundle.getInt("y");
        int z = bundle.getInt("z");


        CoordinateSerializable c2 = (CoordinateSerializable) intent.getSerializableExtra("cSerializable");
        int x2 = c2.x;
        int y2 = c2.y;
        int z2 = c2.z;

        CoordinateParcelable c3 = (CoordinateParcelable) intent.getParcelableExtra("cParcelable");
        int x3 = c3.x;
        int y3 = c3.y;
        int z3 = c3.z;



        initInstances();
    }

    private void initInstances() {

        tvResultSecond = (TextView) findViewById(R.id.tvResultSecond);
        tvResultSecond.setText("Result = " + sum);


    }
}
