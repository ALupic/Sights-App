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
        db.execSQL("CREATE TABLE sight (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, cover TEXT, listImage TEXT, latt REAL, longt REAL, bottomBoundary REAL, leftBoundary REAL, topBoundary REAL, rightBoundary REAL, content TEXT, country_id INTEGER, FOREIGN KEY(country_id) REFERENCES country(id))");

        // Insert countries
        db.execSQL("INSERT INTO country VALUES(1, 'Albania', 'flag_al', 'cover_al', 'Tirana', '28.748 km2', '2,876,591', 'Albanian', 'Muslim', 'Albanian lek', 39.400209, 17.763303, 42.970574, 21.872190, 'Shqiperia')");
        db.execSQL("INSERT INTO country VALUES(2, 'Andorra', 'flag_ad', 'cover_ad', 'Andorra la Vella', '467 km2', '76.177', 'Catalan', 'Christian', 'Euro', 42.417101, 1.336736, 42.686201, 1.828375, 'Andorra')");
        db.execSQL("INSERT INTO country VALUES(3, 'Armenia', 'flag_am', 'cover_am', 'Yerevan', '79.743 km2', '2,951,745', 'Armenian', 'Christian', 'Armenian dram', 38.715853, 42.862813, 41.471865, 46.850850, 'Hayastan')");
        db.execSQL("INSERT INTO country VALUES(4, 'Austria', 'flag_at', 'cover_at', 'Vienna', '83.858 km2', '8,984,550', 'German', 'Christian', 'Euro', 45.669698, 8.707491, 49.205013, 17.815156, 'Osterreich')");
        db.execSQL("INSERT INTO country VALUES(5, 'Azerbaijan', 'flag_az', 'cover_az', 'Baku', '86.600 km2', '10,027,874', 'Azeri', 'Muslim', 'Azerbaijani manat', 38.225571, 44.082296, 42.265431, 51.047628, 'Azarbaycan')");
        db.execSQL("INSERT INTO country VALUES(6, 'Belarus', 'flag_by', 'cover_by', 'Minsk', '207.595 km2', '9,491,800', 'Belarusian, Russian', 'Christian', 'Belarusian ruble', 51.056699, 22.436228, 56.463801, 33.202830, 'Belarus')");
        db.execSQL("INSERT INTO country VALUES(7, 'Belgium', 'flag_be', 'cover_be', 'Brussels', '30.510 km2', '11,573,754', 'Dutch, French, German', 'Christian', 'Euro', 49.424999, 2.004660, 51.587054, 6.673849, 'Belgie')");
        db.execSQL("INSERT INTO country VALUES(8, 'Bosnia & Herzegovina', 'flag_ba', 'cover_ba', 'Sarajevo', '51.129 km2', '3,511,372', 'Bosnian, Croatian, Serbian', 'Muslim, Christian', 'BH convertible mark', 42.322685, 15.495384, 45.289065, 19.747093, 'Bosna i Hercegovina')");
        db.execSQL("INSERT INTO country VALUES(9, 'Bulgaria', 'flag_bg', 'cover_bg', 'Sofia', '110.994 km2', '6,969,406', 'Bulgarian', 'Christian', 'Bulgarian lev', 41.072587, 21.642918, 44.529278, 29.333347, 'Balgaria')");
        db.execSQL("INSERT INTO country VALUES(10, 'Croatia', 'flag_hr', 'cover_hr', 'Zagreb', '56.594 km2', '4,105,493', 'Croatian', 'Christian', 'Croatian kuna', 42.320839, 12.547671, 46.870384, 19.875552, 'Hrvatska')");
        db.execSQL("INSERT INTO country VALUES(11, 'Cyprus', 'flag_cy', 'cover_cy', 'Nicosia', '9.251 km2', '864,200', 'Greek, Turkish', 'Christian, Muslim', 'Euro', 34.426697, 32.008518, 35.810537, 34.771580, 'Kypros-Kibris')");
        db.execSQL("INSERT INTO country VALUES(12, 'Czech Republic', 'flag_cz', 'cover_cz', 'Prague', '78.866 km2', '10,703,353', 'Czech', 'Christian', 'Czech koruna', 47.909861, 11.089481, 51.721038, 19.812625, 'Cesko')");
        db.execSQL("INSERT INTO country VALUES(13, 'Denmark', 'flag_dk', 'cover_dk', 'Copenhagen', '42.933 km2', '5,783,550', 'Danish', 'Christian', 'Danish krone', 54.338983, 6.663153, 58.045945, 15.375311, 'Danmark')");
        db.execSQL("INSERT INTO country VALUES(14, 'Estonia', 'flag_ee', 'cover_ee', 'Tallinn', '45.222 km2', '1,328,360', 'German', 'Christian', 'Euro', 57.366236, 21.415288, 59.776862, 28.556401, 'Eesti')");
        db.execSQL("INSERT INTO country VALUES(15, 'Finland', 'flag_fi', 'cover_fi', 'Helsinki', '338.145 km2', '5,522,015', 'Finnish', 'Christian', 'Euro', 59.339819, 15.962986, 70.820084, 33.760837, 'Suomi')");
        db.execSQL("INSERT INTO country VALUES(16, 'France', 'flag_fr', 'cover_fr', 'Paris', '551.695 km2', '65,213,401', 'French', 'Christian', 'Euro', 40.353693, -6.229124, 51.841574, 10.557984, 'France')");
        db.execSQL("INSERT INTO country VALUES(17, 'Germany', 'flag_de', 'cover_de', 'Berlin', '357.386 km2', '83,753,511', 'German', 'Christian', 'Euro', 47.092716, 4.889749, 55.059622, 16.337502, 'Deutschland')");
        db.execSQL("INSERT INTO country VALUES(18, 'Georgia', 'flag_ge', 'cover_ge', 'Tbilisi', '69.700 km2', '3,723,464', 'Georgian', 'Christian', 'Georgian lari', 40.877453, 39.641807, 43.784245, 46.958701, 'Sakartvelo')");
        db.execSQL("INSERT INTO country VALUES(19, 'Great Britain', 'flag_uk', 'cover_uk', 'London', '242.495 km2', '66,595,844', 'English', 'Christian', 'Pound sterling', 47.965369, -15.128226, 61.693319, 5.306344, 'United Kingdom')");
        db.execSQL("INSERT INTO country VALUES(20, 'Greece', 'flag_gr', 'cover_gr', 'Athens', '131.940 km2', '10,444,289', 'Greek', 'Christian', 'Euro', 34.174543, 18.208311, 42.207362, 29.743956, 'Hellas')");
        db.execSQL("INSERT INTO country VALUES(21, 'Hungary', 'flag_hu', 'cover_hu', 'Budapest', '93.030 km2', '9,671,013', 'Hungarian', 'Christian', 'Hungarian forint', 45.408057, 15.635626, 49.046837, 23.402959, 'Magyarorszag')");
        db.execSQL("INSERT INTO country VALUES(22, 'Iceland', 'flag_is', 'cover_is', 'Reykjavik', '103.000 km2', '362,860', 'Icelandic', 'Christian', 'Icelandic krona', 62.768930, -26.234839, 67.181993, -11.403296, 'Island')");
        db.execSQL("INSERT INTO country VALUES(23, 'Italy', 'flag_it', 'cover_it', 'Rome', '301.338 km2', '60,503,793', 'Italian', 'Christian', 'Euro', 35.738650, 5.164633, 47.451259, 18.787680, 'Italia')");
        db.execSQL("INSERT INTO country VALUES(24, 'Ireland', 'flag_ie', 'cover_ie', 'Dublin', '70.273 km2', '4,921,183', 'Irish, English', 'Christian', 'Euro', 51.290573, -11.806033, 55.442538, -4.620975, 'Eire')");
        db.execSQL("INSERT INTO country VALUES(25, 'Latvia', 'flag_lv', 'cover_lv', 'Riga', '64.589 km2', '1,919,968', 'Latvian', 'Christian', 'Euro', 55.515255, 20.444754, 58.204578, 28.475760, 'Latvija')");
        db.execSQL("INSERT INTO country VALUES(26, 'Lithuania', 'flag_lt', 'cover_lt', 'Vilnius', '65.300 km2', '2,794,329', 'Lithuanian', 'Christian', 'Euro', 53.695885, 20.541934, 56.637342, 27.188663, 'Lietuva')");
        db.execSQL("INSERT INTO country VALUES(27, 'Luxembourg', 'flag_lu', 'cover_lu', 'Luxembourg', '2.586 km2', '613,894', 'Luxembourgish, French, German', 'Christian', 'Euro', 49.429618, 5.561892, 50.232160, 6.569887, 'Letzebuerg')");
        db.execSQL("INSERT INTO country VALUES(28, 'Malta', 'flag_mt', 'cover_mt', 'Valletta', '316 km2', '493,559', 'Maltese, English', 'Christian', 'Euro', 35.793243, 14.135266, 36.097316, 14.626904, 'Malta')");
        db.execSQL("INSERT INTO country VALUES(29, 'Moldova', 'flag_md', 'cover_md', 'Chisinau', '33.846 km2', '2,687,735', 'Romanian', 'Christian', 'Moldovan leu', 45.259484, 26.245547, 48.640226, 30.343447, 'Moldova')");
        db.execSQL("INSERT INTO country VALUES(30, 'Montenegro', 'flag_me', 'cover_me', 'Podgorica', '13.812 km2', '631,219', 'Montenegrin', 'Christian', 'Euro', 41.732645, 18.206198, 43.654220, 20.370504, 'Crna Gora')");
        db.execSQL("INSERT INTO country VALUES(31, 'Netherlands', 'flag_nl', 'cover_nl', 'Amsterdam', '41.543 km2', '17,118,616', 'Dutch', 'Christian', 'Euro', 50.489958, 2.465151, 53.908490, 8.342836, 'Nederland')");
        db.execSQL("INSERT INTO country VALUES(32, 'North Macedonia', 'flag_mk', 'cover_mk', 'Skopje', '25.713 km2', '2,077,132', 'Macedonian', 'Christian, Muslim', 'Macedonian denar', 40.757909, 20.299846, 42.462209, 23.106853, 'Severna Makedonija')");
        db.execSQL("INSERT INTO country VALUES(33, 'Norway', 'flag_no', 'cover_no', 'Oslo', '385.178 km2', '5,403,544', 'Norwegian', 'Christian', 'Norwegian krone', 56.589766, -0.248267, 71.708555, 36.226342, 'Norge')");
        db.execSQL("INSERT INTO country VALUES(34, 'Poland', 'flag_pl', 'cover_pl', 'Warsaw', '312.685 km2', '10,208,226', 'Polish', 'Christian', 'Polish zloty', 48.887716, 13.743748, 55.161193, 24.993748, 'Polska')");
        db.execSQL("INSERT INTO country VALUES(35, 'Portugal', 'flag_pt', 'cover_pt', 'Lisbon', '91.568 km2', '38,433,600', 'Portuguese', 'Christian', 'Euro', 36.553811, -11.871803, 42.415379, -5.653541, 'Portugal')");
        db.execSQL("INSERT INTO country VALUES(36, 'Romania', 'flag_ro', 'cover_ro', 'Bucharest', '238.397 km2', '19,523,621', 'Romanian', 'Christian', 'Romanian leu', 43.589807, 19.742283, 48.626978, 30.399021, 'Romania')");
        db.execSQL("INSERT INTO country VALUES(37, 'Russia', 'flag_ru', 'cover_ru', 'Moscow', '17.100.000 km2', '145,908,012', 'Russian', 'Christian', 'Russian ruble', 42.384358, 24.330949, 72.485794, 149.311415, 'Rossiya')");
        db.execSQL("INSERT INTO country VALUES(38, 'Serbia', 'flag_rs', 'cover_rs', 'Belgrade', '88.361 km2', '8,753,974', 'Serbian', 'Christian', 'Serbian dinar', 41.749651, 17.919986, 46.334465, 23.281314, 'Srbija')");
        db.execSQL("INSERT INTO country VALUES(39, 'San Marino', 'flag_sm', 'cover_sm', 'San Marino', '61 km2', '33,344', 'Italian', 'Christian', 'Euro', 43.888447, 12.386276, 43.998204, 12.532875, 'San Marino')");
        db.execSQL("INSERT INTO country VALUES(40, 'Slovakia', 'flag_sk', 'cover_sk', 'Bratislava', '49.035 km2', '5,450,421', 'Slovak', 'Christian', 'Euro', 47.483435, 16.676284, 49.876589, 22.751724, 'Slovensko')");
        db.execSQL("INSERT INTO country VALUES(41, 'Slovenia', 'flag_si', 'cover_si', 'Ljubljana', '20.273 km2', '2,070,050', 'Slovene', 'Christian', 'Euro', 45.316287, 13.212344, 47.052783, 16.836399, 'Slovenija')");
        db.execSQL("INSERT INTO country VALUES(42, 'Spain', 'flag_es', 'cover_es', 'Madrid', '498.511 km2', '46,763,147', 'Spanish', 'Christian', 'Euro', 34.806410, -10.781356, 44.364550, 4.951065, 'Espana')");
        db.execSQL("INSERT INTO country VALUES(43, 'Sweden', 'flag_se', 'cover_se', 'Stockholm', '450.295 km2', '10,319,601', 'Swedish', 'Christian', 'Swedish krona', 54.732127, 6.426853, 69.692131, 27.125095, 'Sverige')");
        db.execSQL("INSERT INTO country VALUES(44, 'Switzerland', 'flag_ch', 'cover_ch', 'Bern', '41.285 km2', '8,627,337', 'German, French, Italian, Romansh', 'Christian', 'Swiss franc', 45.623108, 5.478409, 48.046042, 10.958137, 'Schweiz-Suisse-Svizzera')");
        db.execSQL("INSERT INTO country VALUES(45, 'Turkey', 'flag_tr', 'cover_tr', 'Ankara', '783.562 km2', '84,090,239', 'Turkish', 'Muslim', 'Turkish lira', 35.278243, 25.240364, 42.937417, 45.257453, 'Turkiye')");
        db.execSQL("INSERT INTO country VALUES(46, 'Ukraine', 'flag_ua', 'cover_ua', 'Kiev', '603.628 km2', '42,030,832', 'Ukrainian', 'Christian', 'Ukrainian hryvna', 44.333668, 21.262585, 52.943669, 40.862194, 'Ukraina')");
        db.execSQL("INSERT INTO country VALUES(47, 'Vatican City', 'flag_va', 'cover_va', 'Vatican City', '0.44 km2', '1,000', 'Italian, Latin', 'Christian', 'Euro', 41.899616, 12.445045, 41.907984, 12.459378, 'Citta del Vaticano')");

        // Insert sights
        //Albania
        db.execSQL("INSERT INTO sight VALUES(1, 'Berat', 'sight_al_berat', 'sight_al_berat', 40.709817, 19.943761, 40.684503, 19.915265, 40.745916, 19.980840, 'Historic city of Ottoman architecture and a 13th century castle.', 1)");
        db.execSQL("INSERT INTO sight VALUES(2, 'Butrint', 'sight_al_butrint', 'sight_al_butrint', 39.744635, 20.025542, 39.734801, 20.009492, 39.753742, 20.032838, 'Ancient Greek city and a seat of a late Roman bishopric.', 1)");
        db.execSQL("INSERT INTO sight VALUES(3, 'Gjirokaster', 'cover_al', 'cover_al', 40.075610, 20.137917, 40.062309, 20.124270, 40.098691, 20.153281, 'Historic city with 17th century two-storey houses, bazaar, mosques and churches.', 1)");
        db.execSQL("INSERT INTO sight VALUES(4, 'Lake Ohrid', 'sight_al_ohrid', 'sight_al_ohrid', 40.913642, 20.659081, 40.865887, 20.578057, 41.106907, 20.775811, 'Natural and cultural heritage of Ohrid region.', 1)");
        db.execSQL("INSERT INTO sight VALUES(5, 'Primeval beech forests', 'sight_al_primeval', 'sight_al_primeval', 42.379005, 20.097236, 42.374297, 20.092601, 42.382476, 20.100669, 'Gashi river and Rrajce beech forests.', 1)");

        // Andorra
        db.execSQL("INSERT INTO sight VALUES(6, 'Madriu-Perafita-Claror Valley', 'cover_ad', 'cover_ad', 42.496550, 1.593910, 42.488006, 1.584555, 42.501202, 1.596228, 'Glacial valley in southeastern Andorra.', 2)");

        // Armenia
        db.execSQL("INSERT INTO sight VALUES(7, 'Azat valley', 'sight_am_azat', 'sight_am_azat', 40.330219, 44.963426, 40.161983, 44.765672, 40.439009, 45.012178, 'The complex of medieval buildings is set into a landscape of great natural beauty.', 3)");
        db.execSQL("INSERT INTO sight VALUES(8, 'Echmiatsin', 'sight_am_echmiadzin', 'sight_am_echmiadzin', 40.166258, 44.295664, 40.126631, 44.273692, 40.197996, 44.345274, 'The cathedral and churches of Echmiatsin and the archaeological remains at Zvartnots.', 3)");
        db.execSQL("INSERT INTO sight VALUES(9, 'Geghard Monastery', 'cover_am', 'cover_am', 40.140646, 44.818712, 40.138760, 44.817103, 40.142229, 44.819925, 'The monastery of Geghard contains a number of churches and tombs, most of them cut into the rock.', 3)");
        db.execSQL("INSERT INTO sight VALUES(10, 'Haghpat Monastery', 'sight_am_haghpat', 'sight_am_haghpat', 41.093856, 44.711944, 41.092611, 44.710694, 41.094665, 44.712615, 'Medieval monastery complex in Haghpat.', 3)");
        db.execSQL("INSERT INTO sight VALUES(11, 'Sanahin Monastery', 'sight_am_sanahin', 'sight_am_sanahin', 41.087477, 44.666283, 41.085277, 44.663590, 41.090970, 44.667517, 'Medieval monastery complex in Sanahin.', 3)");
        db.execSQL("INSERT INTO sight VALUES(12, 'Zvartnots', 'sight_am_zvartnots', 'sight_am_zvartnots', 40.166258, 44.295664, 40.126631, 44.273692, 40.197996, 44.345274, 'The cathedral and churches of Echmiatsin and the archaeological remains at Zvartnots.', 3)");

        // Austria
        db.execSQL("INSERT INTO sight VALUES(13, 'Graz', 'sight_at_graz', 'sight_at_graz', 47.071464, 15.439899, 46.609059, 14.619873, 47.458909, 16.232116, 'Historic city in the south of Austria.', 4)");
        db.execSQL("INSERT INTO sight VALUES(14, 'Salzburg', 'cover_at', 'cover_at', 47.805325, 13.045270, 47.553531, 12.595642, 48.015820, 13.418243, 'One of the best preserved city-centres north of the Alps, famous for its history, culture and attractions.', 4)");
        db.execSQL("INSERT INTO sight VALUES(15, 'Salzkammergut', 'sight_at_salzk', 'sight_at_salzk', 47.561619, 13.646698, 47.519575, 13.531025, 47.640697, 13.752468, 'Austrian resort area famous for the picturesque town of Hallstatt.', 4)");
        db.execSQL("INSERT INTO sight VALUES(16, 'Schoenbrunn', 'sight_at_schoenbrunn', 'sight_at_schoenbrunn', 48.185784, 16.312657, 48.174545, 16.291614, 48.190054, 16.324487, 'Rococo palace that served as the main summer residence of the Habsburg rulers located in Hietzing, Vienna.', 4)");
        db.execSQL("INSERT INTO sight VALUES(17, 'Semmering railway', 'sight_at_semmering', 'sight_at_semmering', 47.639006, 15.830390, 47.635102, 15.820272, 47.645858, 15.840443, 'The first mountain railway in Europe built with a standard gauge track.', 4)");
        db.execSQL("INSERT INTO sight VALUES(18, 'Vienna', 'sight_at_vienna', 'sight_at_vienna', 48.209104, 16.373871, 48.110685, 16.130798, 48.346254, 16.635483, 'Austria`s largest and most populous city.', 4)");
        db.execSQL("INSERT INTO sight VALUES(19, 'Wachau', 'sight_at_wachau', 'sight_at_wachau', 48.389437, 15.474718, 48.385162, 15.453818, 48.401946, 15.491541, 'Austrian valley with a picturesque landscape formed by the Danube river.', 4)");

        // Azerbaijan
        db.execSQL("INSERT INTO sight VALUES(20, 'Baku Old Town', 'cover_az', 'cover_az', 40.365633, 49.835555, 40.360858, 49.831478, 40.370635, 49.839160, 'Walled City of Baku with Shirvanshah`s Palace and Maiden Tower.', 5)");
        db.execSQL("INSERT INTO sight VALUES(21, 'Gobustan', 'sight_az_gobustan', 'sight_az_gobustan', 40.112349, 49.378236, 40.109501, 49.376337, 40.113465, 49.379341, 'Gobustan Rock Art Cultural Landscape.', 5)");
        db.execSQL("INSERT INTO sight VALUES(22, 'Sheki', 'sight_az_sheki', 'sight_az_sheki', 41.203641, 47.169111, 41.150408, 47.124822, 41.262766, 47.208936, 'Historic Centre of Sheki with the Khan’s Palace.', 5)");

        // Belarus
        db.execSQL("INSERT INTO sight VALUES(23, 'Belavezhskaya Pushcha', 'sight_by_bp', 'sight_by_bp', 52.799044, 23.952238, 52.534203, 23.637754, 52.994555, 24.068968, 'Bialowieza Forest conserves a diverse complex of protected forest ecosystems.', 6)");
        db.execSQL("INSERT INTO sight VALUES(24, 'Mir Castle', 'sight_by_mir', 'sight_by_mir', 53.451746, 26.472858, 53.449503, 26.470293, 53.452685, 26.474585, 'Mir Castle is an exceptional example of a central European castle, reflecting in its design and layout successive cultural influences.', 6)");
        db.execSQL("INSERT INTO sight VALUES(25, 'Nesvizh', 'cover_by', 'cover_by', 53.225315, 26.676988, 53.200849, 26.658105, 53.251102, 26.706599, 'The Architectural, Residential and Cultural Complex of the Radziwill Family at Nesvizh.', 6)");
        db.execSQL("INSERT INTO sight VALUES(26, 'Struve Geodetic Art', 'sight_by_sga', 'sight_by_sga', 52.799044, 23.952238, 51.056699, 22.436228, 56.463801, 33.202830, 'The Struve Geodetic Arc is a series of triangulation points, stretching over a distance of 2,820 kilometres from Hammerfest in Norway to the Black Sea.', 6)");

        // Belgium
        db.execSQL("INSERT INTO sight VALUES(27, 'Brugge', 'cover_be', 'cover_be', 51.208031, 3.222308, 51.190283, 3.179908, 51.234909, 3.264022, 'Canal-based city in Belgium, often known as the Venice of the North.', 7)");
        db.execSQL("INSERT INTO sight VALUES(28, 'La Grand Place', 'sight_be_brussels', 'sight_be_brussels', 50.846691, 4.352349, 50.846002, 4.350837, 50.847451, 4.353637, 'Brussels central square surrounded by opulent guildhalls, the Town Hall and the King`s House.', 7)");

        // Bosnia & Herzegovina
        db.execSQL("INSERT INTO sight VALUES(29, 'Medieval Tombstones', 'sight_ba_stecci', 'sight_ba_stecci', 43.093135, 17.923089, 43.091247, 17.921780, 43.094318, 17.924559, 'Monolith medieval tombstones found in the Balkans.', 8)");
        db.execSQL("INSERT INTO sight VALUES(30, 'Mostar', 'sight_ba_mostar', 'sight_ba_mostar', 43.345479, 17.807764, 43.331433, 17.794976, 43.358710, 17.816605, 'The Ottoman bridge, which crosses the Neretva river, was commissioned by Suleiman the Magnificent and completed in 1566/67.', 8)");
        db.execSQL("INSERT INTO sight VALUES(31, 'Visegrad Bridge', 'cover_ba', 'cover_ba', 43.782240, 19.288387, 43.778429, 19.284568, 43.788561, 19.294610, 'The Mehmed Pasha Sokolovic Bridge, which crosses the Drina river, was completed in 1577.', 8)");
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


        Country ctr = new Country(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getDouble(10),
                cursor.getDouble(11), cursor.getDouble(12), cursor.getDouble(13), cursor.getString(14));
        cursor.close();
        db.close();

        return ctr;
    }

    public ArrayList<Sight> getSights(){
        ArrayList<Sight> sights = new ArrayList<Sight>();
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT * FROM sight ORDER BY id ASC;";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        for(int i=0; i<cursor.getCount(); i++){
            Sight sight = new Sight(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                                    cursor.getString(3), cursor.getDouble(4), cursor.getDouble(5),
                                    cursor.getDouble(6), cursor.getDouble(7), cursor.getDouble(8), cursor.getDouble(9),
                                    cursor.getString(10), cursor.getInt(11));
            sights.add(sight);
            cursor.moveToNext();
        }

        cursor.close();
        db.close();
        return sights;
    }

    public Sight findSightById(int id){

        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT * FROM sight WHERE id = " + id + " ;";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();


        Sight sg = new Sight(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getDouble(4), cursor.getDouble(5),
                cursor.getDouble(6), cursor.getDouble(7), cursor.getDouble(8), cursor.getDouble(9),
                cursor.getString(10), cursor.getInt(11));
        cursor.close();
        db.close();

        return sg;
    }

}
