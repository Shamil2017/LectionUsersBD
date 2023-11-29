package com.example.lectionusersbd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistationActivity extends AppCompatActivity {
    EditText edLogin, edPassword, edMail, edPhone;
    User user;
    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation);
    }

    public void onClick(View view) {
        String strLogin = edLogin.getText().toString().trim();
        String strPassword = edPassword.getText().toString().trim();
        String strEmail = edMail.getText().toString().trim();
        String strPhone = edPhone.getText().toString().trim();
        edLogin.setText("");
        edPassword.setText("");
        edPhone.setText("");
        edMail.setText("");
        user = new User(strLogin,strPassword,strEmail,strPhone);
     //   if (isEmptyDB()) {
     //       goRegistr();
     //       return;
     //   }
     //   if (isFoundUser(strLogin, strPassword))
     //   {
     //       Toast.makeText(this, "Пользователь с такими данными зарегистрирован!", Toast.LENGTH_SHORT).show();
     //       return;
     //   }
        goRegistr();
    }

    private void goRegistr() {
    }
}