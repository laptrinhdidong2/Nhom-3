package com.example.ngocdiem.styleapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class StyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);

        final Button customButton = findViewById(R.id.custom_button);
        Switch switchEnableButton = findViewById((R.id.switch_enable_button));

        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StyleActivity.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });
        switchEnableButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    customButton.setEnabled(true);

                }
                else
                {
                    customButton.setEnabled(false);
                }
            }
        });
    }

}
