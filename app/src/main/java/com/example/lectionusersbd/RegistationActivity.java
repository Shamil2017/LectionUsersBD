package com.example.lectionusersbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistationActivity extends AppCompatActivity {
    EditText edLogin, edPassword, edMail, edPhone;
    User user;
    Button btnReg;

    SQLiteDatabase sqDb;
    HelperDB myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation);
        btnReg = findViewById(R.id.btnReg);
        edLogin = findViewById(R.id.edLogin);
        edPassword = findViewById(R.id.edPassword);
        edMail = findViewById(R.id.edMail);
        edPhone = findViewById(R.id.edPhone);

        myDb = new HelperDB(this);
        sqDb = myDb.getWritableDatabase();
        sqDb.close();
    }

    public void onClickReg(View view) {
        String strLogin = edLogin.getText().toString().trim();
        String strPassword = edPassword.getText().toString().trim();
        String strEmail = edMail.getText().toString().trim();
        String strPhone = edPhone.getText().toString().trim();
        edLogin.setText("");
        edPassword.setText("");
        edPhone.setText("");
        edMail.setText("");
        user = new User(strLogin,strPassword,strEmail,strPhone);
        if (isEmptyDB()) {
            goRegistr();
            return;
        }
        if (isFoundUser(strLogin, strPassword))
        {
            Toast.makeText(this, "Пользователь с такими данными зарегистрирован!", Toast.LENGTH_SHORT).show();
            return;
        }
        goRegistr();
    }

    private boolean isEmptyDB() {
        sqDb = myDb.getWritableDatabase();
        Cursor c = sqDb.query(HelperDB.tableName, null,null, null, null, null, null);
        int count = c.getCount();
        c.close();
        return (count==0);
    }

    private void goRegistr() {
        ContentValues cv = new ContentValues();
        cv.put(HelperDB.login, this.user.getLogin());
        cv.put(HelperDB.passw, this.user.getPassword());
        cv.put(HelperDB.email, this.user.getEmail());
        cv.put(HelperDB.phone, this.user.getPhone());
        sqDb = myDb.getWritableDatabase();
        sqDb.insert(HelperDB.tableName, null, cv);
        sqDb.close();
    }

    private boolean isFoundUser(String strLogin, String strPassword) {
        boolean flag = false;
        sqDb = myDb.getWritableDatabase();
        Cursor c = sqDb.query(HelperDB.tableName, null,null, null, null, null, null);
        int col1 = c.getColumnIndex(HelperDB.login);
        int col2 = c.getColumnIndex(HelperDB.passw);
        c.moveToFirst();
        while (!c.isAfterLast())
        {
            String t1 = c.getString(col1);
            String t2 = c.getString(col2);
            if (strLogin.equals(t1) && strPassword.equals(t2))
            {
                flag = true;
                break;
            }
            c.moveToNext();
        }
        c.close();
        sqDb.close();
        return flag;

    }
}