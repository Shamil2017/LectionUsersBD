package com.example.lectionusersbd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {
    private static final String DB_NAME = "users.db"; // Имя базы данных
    private static final int DB_VERSION = 1; // Версия базы данных
    public  static final String tableName = "user";
    public static final String login = "login";
    public static final String passw = "password";
    public static final String email = "email";
    public static final String phone = "phone";

    public HelperDB(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    public HelperDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ tableName+" ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + login+" TEXT, "
                + passw+" TEXT, "
                + email+" TEXT, "
                + phone+" TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String SQL_Delete = "drop table if exists "+tableName;
        sqLiteDatabase.execSQL(SQL_Delete);
        onCreate(sqLiteDatabase);
    }
}
