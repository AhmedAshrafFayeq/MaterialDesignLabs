package com.example.layouts_materialdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LinearActivity extends AppCompatActivity {

    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        t1=findViewById(R.id.lineartxt1ID);
        t2=findViewById(R.id.lineartxt2ID);
    }
}
