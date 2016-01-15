package com.example.dynam.menutemple;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tsunderella on 14-12-2015.
 */
public class MenuReaderDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MenuDB";
    public static final int DATABASE_VERSION = 1;
    private static final String TABLE_MENU = "menu";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_DESCRIPTION="description";
    private static final String KEY_DESCRIPTION2="description2";
    private static final String KEY_PRICE="price";
    private static final String KEY_CATEGORY="category";
    private static final String KEY_FOTO="foto2";
    private static final String[] COLUMNS={KEY_ID,KEY_NAME,KEY_DESCRIPTION,KEY_DESCRIPTION2,KEY_PRICE,KEY_CATEGORY,KEY_FOTO};
    public String DBpath;
    Context currentContext;

    public MenuReaderDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        currentContext = context;
        DBpath = "/data/data/" + context.getPackageName() + "/databases/";
        //createDatabase();

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String query;
        query = "CREATE TABLE menu ( id INTEGER, name TEXT, description TEXT, description2 TEXT, price DOUBLE, category TEXT, foto2 TEXT)";
        db.execSQL(query);


    }
    public void createDatabase(){
       // boolean dbExists = checkDbExist();
        //if(dbExists){

       // }else{
            SQLiteDatabase db;
            //db = currentContext.openOrCreateDatabase(DATABASE_NAME, 0 , null);
            String myPath = DBpath + DATABASE_NAME;
            db=SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
            String CREATE_MENU_TABLE = "CREATE TABLE IF NOT EXISTS menu ( " +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name VARCHAR, "+
                    "description VARCHAR, "+
                    "description2 VARCHAR, "+
                    "price DOUBLE, "+
                    "category VARCHAR, "+
                    "foto2 VARCHAR);";
            // create books table
            db.execSQL(CREATE_MENU_TABLE);
            db.execSQL("INSERT INTO " + TABLE_MENU + "(name,description,description2,price,category,foto2)"+
                    " Values ('Maguro Tataki','Pétalos de atún sellados en costra de sal, cebollín, jengibre y ponzu','Pétalos de atún sellados en costra de sal, cebollín, jengibre y ponzu'" +
                    ",'8200','appetizer_frio','magurot');");
            db.execSQL("INSERT INTO " + TABLE_MENU + "(name,description,description2,price,category,foto2)"+
                    " Values ('Usuzukuri','Finas láminas de pescado blanco acompañada de cebollín y salsa ponzu','Finas láminas de pescado blanco acompañada de cebollín y salsa ponzu'" +
                    ",'7600','appetizer_frio','usuzukuri');");
            db.execSQL("INSERT INTO " + TABLE_MENU + "(name,description,description2,price,category,foto2)"+
                    " Values ('Sake Carpaccio','Carpaccio de salmón y palta aliñado con jengibre, cebollín, alcaparra y dressing fusión','Carpaccio de salmón y palta aliñado con jengibre, cebollín, alcaparra y dressing fusión'" +
                    ",'8000','appetizer_frio','sakeCarp');");
            db.execSQL("INSERT INTO " + TABLE_MENU + "(name,description,description2,price,category,foto2)"+
                    " Values ('Shiromi Style','Pétalos de pescado blanco bañados en salsa ponzu estilo temple','Pétalos de pescado blanco bañados en salsa ponzu estilo temple'" +
                    ",'6800','appetizer_frio','shiromiS');");
            db.execSQL("INSERT INTO " + TABLE_MENU + "(name,description,description2,price,category,foto2)"+
                    " Values ('Sakana Tataki','Frescos trozos de pescado del día macerados en salsa sésamo','Frescos trozos de pescado del día macerados en salsa sésamo'" +
                    ",'7200','appetizer_frio','SakanaTataki');");
            db.execSQL("INSERT INTO " + TABLE_MENU + "(name,description,description2,price,category,foto2)"+
                    " Values ('Gyu Tataki','Láminas de filete selladas en costras de sal, cebollín. jengobre, nabo y salsa ponzu','Láminas de filete selladas en costras de sal, cebollín. jengobre, nabo y salsa ponzu'" +
                    ",'9200','appetizer_frio','gyutataki');");
            db.execSQL("INSERT INTO " + TABLE_MENU + "(name,description,description2,price,category,foto2)"+
                    " Values ('Tataki Maguro','Cubos de atún sellados, sobre cama de vegetales al wok, reducción de aceto, soja, texturas de cítricos','Cubos de atún sellados, sobre cama de vegetales al wok, reducción de aceto, soja, texturas de cítricos'" +
                    ",'9200','appetizer_frio','tatakimaguro');");
        //}

    }
    private boolean checkDbExist(){
        SQLiteDatabase checkDB = null;
        try{
            String myPath = DBpath + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }catch(SQLiteException e){

        }
        if(checkDB != null){
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        String query;
        query = "DROP TABLE IF EXISTS menu";
        db.execSQL(query);
        onCreate(db);

        // create fresh books table
        this.onCreate(db);
    }
    public void addProducto(MenuTemple menu){
        //for logging
        Log.d("addProducto", menu.toString());

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, menu.getName()); // get title
        values.put(KEY_DESCRIPTION, menu.getDescription());// get author
        values.put(KEY_DESCRIPTION2, menu.getDescription2());
        values.put(KEY_PRICE, menu.getPrice());
        values.put(KEY_CATEGORY, menu.getCategory());
        values.put(KEY_FOTO, menu.getFoto2());

        // 3. insert
        db.insert(TABLE_MENU, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }
    public void insertUser(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", queryValues.get("id"));
        values.put("name", queryValues.get("name"));
        values.put("description", queryValues.get("description"));
        values.put("description2", queryValues.get("description2"));
        values.put("price", queryValues.get("price"));
        values.put("foto2", queryValues.get("foto2"));
        database.insert("menu", null, values);
        database.close();
    }

    /**
     * Saca lista de productos por categorya a un arraylist
     * @return
     */
    public ArrayList<HashMap<String, String>> getAllUsers(String categoria) {
        ArrayList<HashMap<String, String>> usersList;
        usersList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM users";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("userId", cursor.getString(0));
                map.put("userName", cursor.getString(1));
                usersList.add(map);
            } while (cursor.moveToNext());
        }
        database.close();
        return usersList;
    }
    public MenuTemple getMenu(int id){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_MENU, // a. table
                        COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build book object
        MenuTemple menu = new MenuTemple();
        menu.setId(Integer.parseInt(cursor.getString(0)));
        menu.setName(cursor.getString(1));
        menu.setDescription(cursor.getString(2));
        menu.setDescription2(cursor.getString(3));
        menu.setPrice(cursor.getDouble(4));
        menu.setCategory(cursor.getString(5));
        menu.setFoto2(cursor.getString(6));

        //log
        Log.d("getMenu(" + id + ")", menu.toString());

        // 5. return book
        return menu;
    }
    // Get All Books
    public ArrayList<MenuTemple> getAllBooks(String categoria) {
        ArrayList<MenuTemple> menus = new ArrayList<MenuTemple>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_MENU + " where category = ?";

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        String[] args = new String[]{categoria};
        Cursor cursor = db.rawQuery(query, args);

        // 3. go over each row, build book and add it to list
        MenuTemple menu = null;
        if (cursor.moveToFirst()) {
            do {
                menu = new MenuTemple();
                menu.setId(Integer.parseInt(cursor.getString(0)));
                menu.setName(cursor.getString(1));
                menu.setDescription(cursor.getString(2));
                menu.setDescription2(cursor.getString(3));
                menu.setPrice(cursor.getDouble(4));

                menu.setCategory(cursor.getString(5));
                menu.setFoto2(cursor.getString(6));
                System.out.println(cursor.getString(0));
                // Add book to books
                menus.add(menu);
            } while (cursor.moveToNext());
        }else{
            System.out.println("nada");
        }


        Log.d("getAllMenus()", menus.toString());

        // return books
        return menus;
    }
    //Get menu by id

    public ArrayList<MenuTemple> getMenubyID(Integer id) {
        ArrayList<MenuTemple> menus = new ArrayList<MenuTemple>();
        System.out.println(id);
        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_MENU + " where id = ?";

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        String [] args = new String[]{Integer.toString(id)};
        Cursor cursor = db.rawQuery(query, args);


        // 3. go over each row, build book and add it to list
        MenuTemple menu = null;
        if (cursor.moveToFirst()) {
            do {
                menu = new MenuTemple();
                menu.setId(Integer.parseInt(cursor.getString(0)));
                menu.setName(cursor.getString(1));
                menu.setDescription(cursor.getString(2));
                menu.setDescription2(cursor.getString(3));
                menu.setPrice(cursor.getDouble(4));

                menu.setCategory(cursor.getString(5));
                menu.setFoto2(cursor.getString(6));
                System.out.println(cursor.getString(0));
                // Add book to books
                menus.add(menu);
            } while (cursor.moveToNext());
        }else{
            System.out.println(id);
        }

        Log.d("getAllMenus()", menus.toString());

        // return books
        return menus;
    }
    // Updating single book
    public int updateMenu(MenuTemple menu) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, menu.getName()); // get title
        values.put(KEY_DESCRIPTION, menu.getDescription());// get author
        values.put(KEY_DESCRIPTION2, menu.getDescription2());
        values.put(KEY_PRICE, menu.getPrice());
        values.put(KEY_CATEGORY, menu.getCategory());
        values.put(KEY_FOTO, menu.getFoto2());

        // 3. updating row
        int i = db.update(TABLE_MENU, //table
                values, // column/value
                KEY_ID+" = ?", // selections
                new String[] { String.valueOf(menu.getId()) }); //selection args

        // 4. close
        db.close();

        return i;

    }
    // Deleting single book
    public void deleteBook() {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_MENU,
                null,
                null);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU);
        // 3. close
        db.close();

        //Log.d("deleteMenu", menu.toString());

    }
}