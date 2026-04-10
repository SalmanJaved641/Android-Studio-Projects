package com.example.databasesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DB_Helper extends SQLiteOpenHelper {

//    private static final String DATABASE_NAME = "contects db";
    private static final String DATABASE_NAME_2 = "contects db_2";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CONTECTS = "contects";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE_NO = "phone_no";

    public DB_Helper( Context context) {

        super(context, DATABASE_NAME_2, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //CREATE TABLE contects (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone_no TEXT);

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CONTECTS + // executeSQL Method
                "("+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +KEY_NAME +" TEXT, " +KEY_PHONE_NO +" TEXT" + ")" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_CONTECTS);
        onCreate(sqLiteDatabase);
    }
    public void add_contects(String name,String phone_no){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME,name);
        values.put(KEY_PHONE_NO,phone_no);

        db.insert(TABLE_CONTECTS,null,values);
        db.close();
    }

// Fetch all data base in a array list and return arraylist:
    public ArrayList<Contect_Model> fetch_contects() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM "+TABLE_CONTECTS,null);
        ArrayList<Contect_Model> arrayContects = new ArrayList<>();

        while (cursor.moveToNext()){
            Contect_Model contect_model = new Contect_Model();
            contect_model.id= cursor.getInt(0);
            contect_model.name= cursor.getString(1);
            contect_model.phone_no= cursor.getString(2);

            arrayContects.add(contect_model);
        }
        return arrayContects;
    }

    public static void updateContent(Context context,Contect_Model contectModel){
        DB_Helper dbHelper = new DB_Helper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(KEY_PHONE_NO,contectModel.phone_no);
        db.update(TABLE_CONTECTS,cv,KEY_ID + " = "+contectModel.id,null);
    }
    public static void DeleteContect(Context context,int id){
        DB_Helper dbHelper = new DB_Helper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TABLE_CONTECTS,KEY_ID + " = ?",new String[]{String.valueOf(id)});
    }
}