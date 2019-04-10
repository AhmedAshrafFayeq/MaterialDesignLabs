package com.example.registrationform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    RadioGroup radioGroup;
    RadioButton male,female;
    CheckBox ch1,ch2,ch3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.userNametxtID);
        password=findViewById(R.id.passwordtxtID);

        radioGroup=findViewById(R.id.radioID);
        male=findViewById(R.id.maleID);
        female=findViewById(R.id.femaleID);

        ch1=findViewById(R.id.checkID1);
        ch2=findViewById(R.id.checkID2);
        ch3=findViewById(R.id.checkID3);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "male", Toast.LENGTH_SHORT).show();
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "female", Toast.LENGTH_SHORT).show();
            }
        });

    }
}