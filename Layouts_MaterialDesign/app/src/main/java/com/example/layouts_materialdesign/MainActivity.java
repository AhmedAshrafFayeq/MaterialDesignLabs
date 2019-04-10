package com.example.layouts_materialdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button frame,linear,grid,relative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frame=findViewById(R.id.frameID);
        linear=findViewById(R.id.LinearID);
        grid=findViewById(R.id.gridID);
        relative=findViewById(R.id.relativeID);


        frame.setOnClickListener((e)->{
            Intent intent=new Intent(MainActivity.this, FrameAcivity.class);
            startActivity(intent);
        });

        linear.setOnClickListener((e)->{
            Intent intent=new Intent(MainActivity.this, LinearActivity.class);
            startActivity(intent);
        });
        grid.setOnClickListener((e)->{
            Intent intent=new Intent(MainActivity.this, GridActivity.class);
            startActivity(intent);
        });
        relative.setOnClickListener((e)->{
            Intent intent=new Intent(MainActivity.this, RelativeActivity.class);
            startActivity(intent);
        });

    }
}
