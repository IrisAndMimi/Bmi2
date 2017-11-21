package com.irisandmimi.bmi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class bmi extends AppCompatActivity {
    String s = new String("abc");
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new AlertDialog.Builder(bmi.this)
                    .setTitle(R.string.Help)
                    .setMessage(R.string.Info)
                    .setPositiveButton(R.string.OK,null)
                    .show();
        }
    };
    private EditText edWeight;
    private EditText edHeight;
    private Button bHelp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        findViews();
        bHelp.setOnClickListener(listener);
//        bHelp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new AlertDialog.Builder(bmi.this)
//                        .setTitle("說明")
//                        .setPositiveButton("OK",null)
//                        .show();
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart");
    }

    private void findViews() {
        edWeight = (EditText) findViewById(R.id.ed_weight);
        edHeight = (EditText) findViewById(R.id.ed_height);
        bHelp = (Button)findViewById(R.id.b_help);
    }

    public void bmi(View view){
//        System.out.println("What???");
        Log.d("MainActivity","testing bmi method");

        float weight = Float.parseFloat(edWeight.getText().toString());
        float height = Float.parseFloat(edHeight.getText().toString());
        float bmi = weight / (height * height);

        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra(getString(R.string.extra_bmi),bmi);
        startActivity(intent);

        if (bmi<20 && height<3){
            new AlertDialog.Builder(this)
                    .setMessage(getString(R.string.UrBmi_is)+ bmi+getString(R.string.Dot)+" 請多吃點")
                    .setTitle(R.string.Result_Title)
                    .setPositiveButton(R.string.OK,null)
                    .show();
        }
        if (height>3){
            new AlertDialog.Builder(this)
                    .setMessage("身高單位應為公尺")
                    .setTitle(R.string.Result_Title)
                    .setPositiveButton(R.string.OK,null)
                    .show();
        }

      /*  Log.d("MainActivity",getString(R.string.UrBmi_is)+ bmi);
        Toast.makeText(this,"Your bmi is "+ bmi, Toast.LENGTH_LONG).show();*/
    }
}
