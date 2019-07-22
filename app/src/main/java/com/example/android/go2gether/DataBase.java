package com.example.android.go2gether;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="Data.db";
    private static final String TABLE_NAME="Client";

    public DataBase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (" +
                " email TEXT PRIMARY KEY " +
                ", name TEXT " +
                ", country TEXT " +
                ", phonenumber TEXT " +
                ", gender TEXT " +
                ", password TEXT)");
        //db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addOne(Client client) {
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "INSERT INTO "+TABLE_NAME+" (email,name,country,phonenumber,gender,password) VALUES ('"+client.email+"','"+client.name+"','"+client.country+"','"+client.phonenumber+"','"+client.gender+"','"+client.password+"')";
        database.execSQL(sql);
        database.close();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",client.name);
        contentValues.put("email",client.email);
        contentValues.put("country",client.country);
        contentValues.put("phonenumber",client.phonenumber);
        contentValues.put("gender",client.gender);
        contentValues.put("password",client.password);
        //long ins=database.insert(TABLE_NAME,null,contentValues);
       // database.close();
       // if (ins==-1)return false;
        //else return true;
    }

    public boolean chkEmail(String email){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor =database.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE email=?",new String[]{email});
        if(cursor.getCount()>0)return false;
        else return true;
    }
    /*void updateOne(Client client) {
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "UPDATE product SET name='" + client.name + "', price =" + client.price + " WHERE id=" + client.id;
        database.execSQL(sql);
        database.close();
    }

    void deleteOne(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "DELETE FROM product WHERE id=" + id;
        database.execSQL(sql);
        database.close();
    }

    ArrayList<Client> getall() {
        SQLiteDatabase database = this.getReadableDatabase();
        String sql = "SELECT * FROM product";
        Cursor cursor = database.rawQuery(sql, null);
        ArrayList<Client> products= new ArrayList<>();

        do {
            if(cursor.moveToNext()){
                Client product = new Client(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
                products.add(product);
            }


        } while (cursor.moveToNext());

        return products;
    }*/

}