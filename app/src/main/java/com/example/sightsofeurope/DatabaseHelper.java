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

        db.execSQL("INSERT INTO country VALUES(1, 'Austria', 'flag_at', 'cover_at', 'Vienna', '83.858 km2', '8,993,549', 'German', 'Christian', 'Euro', 'Osterreich')");
        db.execSQL("INSERT INTO country VALUES(2, 'Belgium', 'flag_be', 'cover_be', 'Brussels', '30.510 km2', '11.573,754', 'Dutch, French, German', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(3, 'Czech Republic', 'flag_cz', 'cover_cz', 'Prague', '78.866 km2', '10,703,353', 'Czech', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(4, 'France', 'flag_fr', 'cover_fr', 'Paris', '551.695 km2', '65,213,401', 'French', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(5, 'Germany', 'flag_de', 'cover_de', 'Berlin', '357.386 km2', '83,753,511', 'German', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(6, 'Great Britain', 'flag_uk', 'cover_uk', 'London', '242.495 km2', '66,595,844', 'English', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(7, 'Greece', 'flag_gr', 'cover_gr', 'Athens', '131.940 km2', '10,444,289', 'Greek', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(8, 'Hungary', 'flag_hu', 'cover_hu', 'Budapest', '93.030 km2', '9,671,013', 'Hungarian', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(9, 'Italy', 'flag_it', 'cover_it', 'Rome', '301.338 km2', '60,503,793', 'Italian', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(10, 'Ireland', 'flag_ie', 'cover_ie', 'Dublin', '70.273 km2', '4,921,183', 'Irish, English', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(11, 'Netherlands', 'flag_nl', 'cover_nl', 'Amsterdam', '41.543 km2', '17,118,616', 'Dutch', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(12, 'Norway', 'flag_no', 'cover_no', 'Oslo', '385.178 km2', '5,403,544', 'Norwegian', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(13, 'Portugal', 'flag_pt', 'cover_pt', 'Lisbon', '91.568 km2', '10,208,226', 'Portuguese', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(14, 'Spain', 'flag_es', 'cover_es', 'Madrid', '498.511 km2', '46,763,147', 'Spanish', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(15, 'Switzerland', 'flag_ch', 'cover_ch', 'Bern', '41.285 km2', '8,627,337', 'German, French, Italian, Romansh', 'Christian', 'Euro', 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(16, 'Turkey', 'flag_tr', 'cover_tr', 'Ankara', '783.562 km2', '84,090,239', 'Turkish', 'Christian', 'Euro', 'Belgie')");
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

    public Country findCountryById(int id){

        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT * FROM country WHERE id = " + id + " ;";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();


        Country newsArticle = new Country(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10));

        cursor.close();
        db.close();

        return newsArticle;
    }
}
