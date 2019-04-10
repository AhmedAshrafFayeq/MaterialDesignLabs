package com.example.layouts_materialdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GridActivity extends AppCompatActivity {

    TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        t1=findViewById(R.id.gridID1);
        t2=findViewById(R.id.gridID2);
        t3=findViewById(R.id.gridID3);
    }
}
