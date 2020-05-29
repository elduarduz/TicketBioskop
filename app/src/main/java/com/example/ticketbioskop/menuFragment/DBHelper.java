package com.example.ticketbioskop.menuFragment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBHelper {
    public static final String TABLE_NAME = "data_privasi";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "nama";
    public static final String COLUMN_SALDO = "saldo";
    private static final String db_name ="privasi.db";
    private static final int db_version=1;

    private static final String db_create = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_NAME+ " varchar(50) not null, "
            + COLUMN_SALDO+ " integer(50) not null);";

    public DBHelper(Context context){
        super();
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_create);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(),"Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }


    public SQLiteDatabase getWritableDatabase() {
        return writableDatabase();
    }

    private SQLiteDatabase writableDatabase() {
        return  writableDatabase();
    }

    public void close() {
    }
}
