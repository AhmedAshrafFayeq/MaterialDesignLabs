package com.example.layouts_materialdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RelativeActivity extends AppCompatActivity {

    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        t1=findViewById(R.id.relativeTxt1ID);
        t2=findViewById(R.id.relativeTxt2ID);
    }
}
