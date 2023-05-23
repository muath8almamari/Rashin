package com.example.menu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHelperList extends SQLiteOpenHelper {

    private static final String db_name = "rashin.db";
    private static final String table_name = "my_rashin";
    private static final String col_ID = "_id";
    private static final String object_name = "object_name";
    private static final String object_price = "object_price";
    private static final String object_quantity = "object_quantity";
    private static final String object_finish = "object_finish";
    private Context context;

    public DbHelperList(@Nullable Context context) {
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + table_name + " (" + col_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + object_name + " TEXT, " + object_price + " DOUBLE, " + object_quantity + " INTEGER, " + object_finish + " BOOLEAN " + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);
    }

    long addBook(String objName, String objPrice, int objQuantity, boolean objFinish) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(object_name, objName);
        cv.put(object_price, objPrice);
        cv.put(object_quantity, objQuantity);
        cv.put(object_finish, objFinish);
        return db.insert(table_name, null, cv);
    }

    Cursor readAllData() {
        String query = "SELECT * FROM " + table_name;
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(query, null);
    }

    void updateData(String row,String name,String price,String quantity ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(object_name,name);
        cv.put(object_price,price);
        cv.put(object_quantity,quantity);
        long result =db.update(table_name,cv,"_id=?",new String[]{row});


    }
}
