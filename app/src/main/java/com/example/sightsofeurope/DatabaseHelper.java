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
        db.execSQL("CREATE TABLE country (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, flag TEXT, cover TEXT, capital TEXT, area TEXT, population TEXT, language TEXT, religion TEXT, currency TEXT, bottomBoundary REAL, leftBoundary REAL, topBoundary REAL, rightBoundary REAL, content TEXT)");

        db.execSQL("INSERT INTO country VALUES(1, 'Austria', 'flag_at', 'cover_at', 'Vienna', '83.858 km2', '8,984,550', 'German', 'Christian', 'Euro', 45.669698, 8.707491, 49.205013, 17.815156, 'Osterreich')");
        db.execSQL("INSERT INTO country VALUES(2, 'Belgium', 'flag_be', 'cover_be', 'Brussels', '30.510 km2', '11,573,754', 'Dutch, French, German', 'Christian', 'Euro', 49.424999, 2.004660, 51.587054, 6.673849, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(3, 'Czech Republic', 'flag_cz', 'cover_cz', 'Prague', '78.866 km2', '10,703,353', 'Czech', 'Christian', 'Euro', 47.909861, 11.089481, 51.721038, 19.812625, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(4, 'Denmark', 'flag_dk', 'cover_dk', 'Copenhagen', '42.933 km2', '5,783,550', 'Danish', 'Christian', 'Euro', 54.338983, 6.663153, 58.045945, 15.375311, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(5, 'France', 'flag_fr', 'cover_fr', 'Paris', '551.695 km2', '65,213,401', 'French', 'Christian', 'Euro', 40.353693, -6.229124, 51.841574, 10.557984, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(6, 'Germany', 'flag_de', 'cover_de', 'Berlin', '357.386 km2', '83,753,511', 'German', 'Christian', 'Euro', 47.092716, 4.889749, 55.059622, 16.337502, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(7, 'Great Britain', 'flag_uk', 'cover_uk', 'London', '242.495 km2', '66,595,844', 'English', 'Christian', 'Euro', 47.965369, -15.128226, 61.693319, 5.306344, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(8, 'Greece', 'flag_gr', 'cover_gr', 'Athens', '131.940 km2', '10,444,289', 'Greek', 'Christian', 'Euro', 34.174543, 18.208311, 42.207362, 29.743956, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(9, 'Hungary', 'flag_hu', 'cover_hu', 'Budapest', '93.030 km2', '9,671,013', 'Hungarian', 'Christian', 'Euro', 45.408057, 15.635626, 49.046837, 23.402959, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(10, 'Iceland', 'flag_is', 'cover_is', 'Reykjavik', '103.000 km2', '362,860', 'Icelandic', 'Christian', 'Euro', 62.768930, -26.234839, 67.181993, -11.403296, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(11, 'Italy', 'flag_it', 'cover_it', 'Rome', '301.338 km2', '60,503,793', 'Italian', 'Christian', 'Euro', 35.738650, 5.164633, 47.451259, 18.787680, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(12, 'Ireland', 'flag_ie', 'cover_ie', 'Dublin', '70.273 km2', '4,921,183', 'Irish, English', 'Christian', 'Euro', 51.290573, -11.806033, 55.442538, -4.620975, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(13, 'Netherlands', 'flag_nl', 'cover_nl', 'Amsterdam', '41.543 km2', '17,118,616', 'Dutch', 'Christian', 'Euro', 50.489958, 2.465151, 53.908490, 8.342836, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(14, 'Norway', 'flag_no', 'cover_no', 'Oslo', '385.178 km2', '5,403,544', 'Norwegian', 'Christian', 'Euro', 56.589766, -0.248267, 71.708555, 36.226342, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(15, 'Portugal', 'flag_pt', 'cover_pt', 'Lisbon', '91.568 km2', '10,208,226', 'Portuguese', 'Christian', 'Euro', 36.553811, -11.871803, 42.415379, -5.653541, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(16, 'Russia', 'flag_ru', 'cover_ru', 'Moscow', '17.100.000 km2', '145,908,012', 'Russian', 'Christian', 'Euro', 42.384358, 24.330949, 72.485794, 149.311415, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(17, 'Spain', 'flag_es', 'cover_es', 'Madrid', '498.511 km2', '46,763,147', 'Spanish', 'Christian', 'Euro', 34.806410, -10.781356, 44.364550, 4.951065, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(18, 'Switzerland', 'flag_ch', 'cover_ch', 'Bern', '41.285 km2', '8,627,337', 'German, French, Italian, Romansh', 'Christian', 'Euro', 45.623108, 5.478409, 48.046042, 10.958137, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(19, 'Turkey', 'flag_tr', 'cover_tr', 'Ankara', '783.562 km2', '84,090,239', 'Turkish', 'Christian', 'Euro', 35.278243, 25.240364, 42.937417, 45.257453, 'Belgie')");
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
                    cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getDouble(10),
                    cursor.getDouble(11), cursor.getDouble(12), cursor.getDouble(13), cursor.getString(14));
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
                cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getDouble(10),
                cursor.getDouble(11), cursor.getDouble(12), cursor.getDouble(13), cursor.getString(14));
        cursor.close();
        db.close();

        return newsArticle;
    }
}
