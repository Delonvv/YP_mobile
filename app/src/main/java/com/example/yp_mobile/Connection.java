package com.example.yp_mobile;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Connection extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "database";
    private static final int DATABASE_VERSION = 1;

    public Connection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Connection(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE tableyp ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name" + " TEXT,"
                + "price" + " TEXT,"
                + "img" + " TEXT"
                + ")";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tableyp");
        onCreate(db);
    }
    public void clearTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("tableyp ", null, null);
        db.close();
    }
}