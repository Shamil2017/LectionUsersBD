package com.example.lectionusersbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnRegistration, btnIdentification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegistration = findViewById(R.id.btnRegistration);
        btnIdentification = findViewById(R.id.btnIdentification);
    }

    public void ClickRead(View view) {

    }

    public void onClick(View view) {
        if (view == btnRegistration)
        {
            //Intent go = new Intent(this, RegistationActivity.class );
            //startActivity(go);
        }
        if (view == btnIdentification)
        {
            //Intent go = new Intent(this, LoginActivity.class  );
            //startActivity(go);
        }
    }
}