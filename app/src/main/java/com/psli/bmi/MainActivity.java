package com.psli.bmi;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edWeight, edHeight;
    private Button bInfo;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "onCreate");
        setContentView(R.layout.activity_main);
        //getResources().getString(R.string.app_name);
        findView();
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

    public void findView() {
        this.edWeight = (EditText) findViewById(R.id.ed_weight);
        this.edHeight = (EditText) findViewById(R.id.ed_height);
        this.bInfo = (Button) findViewById(R.id.b_info);
        this.intent = new Intent(this, ResultActivity.class);
    }

    public void bmi(View view) {
        //System.out.println("Cat");
        //Log.d("MainActivity", "testing bmi method");
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
            intent.putExtra("EX_BMI", bmi);
            startActivity(intent);
            /*if(bmi < 20) {
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
            }*/
            //Log.d("BMI", String.valueOf(bmi));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onRestart");
    }
}
