package com.example.sightsofeurope;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "registeruser";
    //public static final String COL_1 = "ID";
    public static final String COL_2 = "username";
    public static final String COL_3 = "password";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE registeruser (username TEXT PRIMARY KEY, password TEXT)");
        db.execSQL("CREATE TABLE country (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, flag TEXT, cover TEXT, capital TEXT, area TEXT, population TEXT, language TEXT, religion TEXT, currency TEXT, content TEXT)");

        db.execSQL("INSERT INTO country VALUES(1, 'Austria', 'cover_at', 'cover_at', 'Vienna', '24', '24', 'German', 'Christian', 'Euro', 'Osterreich')");
        db.execSQL("INSERT INTO country VALUES(2, 'Belgium', 'cover_be', 'cover_be', 'Brussels', '24', '24', 'German', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(3, 'Czech Republic', 'cover_cz', 'cover_cz', 'Brussels', '24', '24', 'German', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(4, 'France', 'cover_fr', 'cover_fr', 'Brussels', '24', '24', 'German', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(5, 'Germany', 'cover_de', 'cover_de', 'Brussels', '24', '24', 'German', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(6, 'Greece', 'cover_gr', 'cover_gr', 'Brussels', '24', '24', 'German', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(7, 'Hungary', 'cover_hu', 'cover_hu', 'Brussels', '24', '24', 'German', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(8, 'Italy', 'cover_it', 'cover_it', 'Brussels', '24', '24', 'German', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(9, 'Ireland', 'cover_ie', 'cover_ie', 'Brussels', '24', '24', 'German', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(10, 'Norway', 'cover_no', 'cover_no', 'Brussels', '24', '24', 'German', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(11, 'Portugal', 'cover_pt', 'cover_pt', 'Brussels', '24', '24', 'German', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(12, 'Spain', 'cover_es', 'cover_es', 'Brussels', '24', '24', 'German', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(13, 'Turkey', 'cover_tr', 'cover_tr', 'Brussels', '24', '24', 'German', 'Christian', 'Euro', 'Belgie')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addUser(String user, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user);
        contentValues.put("password", password);
        long res = db.insert("registeruser", null, contentValues);
        db.close();
        return res;
    }

    public boolean checkUser(String username, String password){
        String[] columns = { COL_2 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = { username, password };
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return true;
        else
            return false;
    }

    // DATABASE - NEW
    public ArrayList<Country> getCountries(){
        ArrayList<Country> countries = new ArrayList<Country>();
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT * FROM country ORDER BY id ASC;";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        for(int i=0; i<cursor.getCount(); i++){
            Country country = new Country(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                    cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10));
            countries.add(country);
            cursor.moveToNext();
        }

        cursor.close();
        db.close();
        return countries;
    }
}
