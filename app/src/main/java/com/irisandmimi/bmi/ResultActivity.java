package com.irisandmimi.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Float bmi = getIntent().getFloatExtra(getString(R.string.extra_bmi),0);
        TextView result = (TextView)findViewById(R.id.text_result);
        result.setText("BMI : " + bmi);
    }
}
