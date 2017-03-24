package com.example.benzdev.section1;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    int x, y, z;
    Button btnCopy, btnCalculate;
    TextView tv1, tvResult;
    EditText editTextHello, editText1, editText2;
    RadioButton rbPlus, rbMinus, rbMultiply, rbDivide;
    RadioGroup rgOperater;
    private CustomViewGroup viewGroup1, viewGroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;  //Screen Width
        int height = size.y; //Screen Height

        Toast.makeText(this, "Width : " + width + ", Height : " + height, Toast.LENGTH_SHORT).show();

    }

    private void initInstances() {
        tv1 = (TextView) findViewById(R.id.tvHello);
        tv1.setMovementMethod(LinkMovementMethod.getInstance());
        tv1.setText(Html.fromHtml("<b>He<u>ll</u>o</b> <i>world</i> <a href=\"http://nuuneoi.com\">http://nuuneoi.com>/a>"));

        editTextHello = (EditText) findViewById(R.id.editTextHello);
        editTextHello.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    //Copy text in EditText to TextView
                    tv1.setText(editTextHello.getText());
                    return true;
                }


                return false;
            }
        });

        btnCopy = (Button) findViewById(R.id.btnCopy);
        btnCopy.setOnClickListener(this);


        ////////////////////////////////
        //// Start Here
        ///////////////////////////////

        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        tvResult = (TextView) findViewById(R.id.tvResult);

        //ไม่นิยมทำเพราะประกาศตัวแปรเยอะ
        /*
        rbPlus = (RadioButton) findViewById(R.id.rbPlus);
        rbMinus = (RadioButton) findViewById(R.id.rbMinus);
        rbMultiply = (RadioButton) findViewById(R.id.rbMultiply);
        rbDivide = (RadioButton) findViewById(R.id.rbDevide); */

        rgOperater = (RadioGroup) findViewById(R.id.rbOperator);
        btnCalculate.setOnClickListener(this);


        viewGroup1 = (CustomViewGroup) findViewById(R.id.viewGroup1);
        viewGroup2 = (CustomViewGroup) findViewById(R.id.viewGroup2);

        viewGroup1.setButtonText("Hello");
        viewGroup2.setButtonText("World");


    }


    @Override
    public void onClick(View view) {
        if (view == btnCalculate) {
            int val1 = 0;
            int val2 = 0;

            try {
                val1 = Integer.parseInt(editText1.getText().toString());

            } catch (NumberFormatException e) {

            }

            try {
                val2 = Integer.parseInt(editText2.getText().toString());

            } catch (NumberFormatException e) {

            }
            int sum = 0;

            /*
            if(rbPlus.isChecked()) {
                int sum = val1 + val2;
                tvResult.setText("=" + sum + "");
            }
            if(rbMinus.isChecked()){
                int sum = val1 - val2;
                tvResult.setText("=" + sum + "");
            }
            if(rbMultiply.isChecked()){
                int sum = val1 * val2;
                tvResult.setText("=" + sum + "");

            }
            if(rbDivide.isChecked()){
                int sum = val1 / val2;
                tvResult.setText("=" + sum + "");
            }*/
            switch (rgOperater.getCheckedRadioButtonId()) {
                case R.id.rbPlus:
                    sum = val1 + val2;

                    break;
                case R.id.rbMinus:
                    sum = val1 - val2;
                    break;
                case R.id.rbMultiply:
                    sum = val1 * val2;
                    break;
                case R.id.rbDivide:
                    sum = val1 / val2;
                    break;
            }
            tvResult.setText(" = " + sum + "");

            Log.d("Calculation", "Result = " + sum);
            Toast.makeText(MainActivity.this, "Resulut :" + sum, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("result", sum);

            Coordinate c1 = new Coordinate();
            c1.x = 5;
            c1.y = 10;
            c1.z = 20;
            Bundle bundle = new Bundle();
            bundle.putInt("x", c1.x);
            bundle.putInt("y", c1.y);
            bundle.putInt("z", c1.z);
            intent.putExtra("cBundle" , bundle);

            //Serializable Lab
            CoordinateSerializable c2 = new CoordinateSerializable();
            c2.x = 5;
            c2.y = 10;
            c2.z = 20;
            intent.putExtra("cSerializable",c2);


            //Parcelable
            CoordinateParcelable c3 =new CoordinateParcelable();
            c3.x = 5;
            c3.y = 10;
            c3.z = 20;
            intent.putExtra("cParcelable", c3);


            //startActivity(intent);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //getMenuInflater() คิอคนที่ทำหน้าที่ inflate ให้
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    //โยนเมนูที่ถูกเลือกเข้ามาในฟังก์ชั่นนี้
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_setting) {
            //Do What you want
            Toast.makeText(MainActivity.this, "Setting", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save thing(s) here


        //outState.putString("text", tvResult.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore thing(s) here

       // tvResult.setText(savedInstanceState.getString("text"));
    }
}
