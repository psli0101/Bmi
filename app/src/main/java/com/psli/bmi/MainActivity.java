package com.psli.bmi;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getResources().getString(R.string.app_name);
        Button bInfo = (Button) findViewById(R.id.b_info);
        bInfo.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.b_info)
                            .setMessage(R.string.formula)
                            .setPositiveButton(R.string.ok, null)
                            .show();
                }
            }
        );
    }

    public void bmi(View view) {
        //System.out.println("Cat");
        //Log.d("MainActivity", "testing bmi method");
        EditText edWeight = (EditText) findViewById(R.id.ed_weight);
        EditText edHeight = (EditText) findViewById(R.id.ed_height);
        float w = Float.parseFloat(edWeight.getText().toString());
        float h = Float.parseFloat(edHeight.getText().toString());
        if ( h > 3.0 ) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.bmi_title)
                    .setMessage("身高單位應為公尺")
                    .setPositiveButton(R.string.ok, null)
                    .show();
        } else {
            float bmi = w / (h * h);
            if(bmi < 20) {
                new AlertDialog.Builder(this)
                        .setTitle(R.string.bmi_title)
                        .setMessage(getString(R.string.msg)+bmi+", 請多吃點")
                        .setPositiveButton(R.string.ok, null)
                        .setNeutralButton(R.string.cancel, null)
                        .setNegativeButton(R.string.test, null)
                        .show();
            } else {
                new AlertDialog.Builder(this)
                        .setTitle(R.string.bmi_title)
                        .setMessage(getString(R.string.msg)+bmi)
                        .setPositiveButton(R.string.ok, null)
                        .setNeutralButton(R.string.cancel, null)
                        .setNegativeButton(R.string.test, null)
                        .show();
            }
            //Log.d("BMI", String.valueOf(bmi));
        }
    }
}
