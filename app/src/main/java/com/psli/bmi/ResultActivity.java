package com.psli.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView txt_bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        float bmi = getIntent().getFloatExtra("EX_BMI", 0);

        findViews();
        txt_bmi.setText(getString(R.string.msg) + bmi);
    }

    private void findViews() {
        txt_bmi = (TextView) findViewById(R.id.bmi_msg);
    }


}