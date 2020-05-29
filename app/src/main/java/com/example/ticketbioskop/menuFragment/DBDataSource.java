package com.example.ticketbioskop.menuFragment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.ticketbioskop.Saldo;

class DBDataSource {
    private SQLiteDatabase database;

    private DBHelper dbHelper;

    private String[] allColumns = { DBHelper.COLUMN_ID,
            DBHelper.COLUMN_NAME, DBHelper.COLUMN_SALDO};

    public DBDataSource(Context context)
    {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public Saldo createBarang(String nama, String saldo) {

        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_NAME, nama);
        values.put(DBHelper.COLUMN_SALDO, saldo);


        long insertId = database.insert(DBHelper.TABLE_NAME, null,
                values);


        Cursor cursor = database.query(DBHelper.TABLE_NAME,
                allColumns, DBHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);


        cursor.moveToFirst();


        Saldo newSaldo = cursorToSaldo(cursor);


        cursor.close();


        return newSaldo;
    }

    private Saldo cursorToSaldo(Cursor cursor)
    {

        Saldo saldo = new Saldo();

        Log.v("info", "The getLONG "+cursor.getLong(0));
        Log.v("info", "The setLatLng "+cursor.getString(1)+","+cursor.getString(2));


        saldo.setId(cursor.getLong(0));
        saldo.setNama(cursor.getString(1));
        saldo.setSaldo(cursor.getInt(2));


        return saldo;
    }

    public void close() {
        dbHelper.close();
    }

}
