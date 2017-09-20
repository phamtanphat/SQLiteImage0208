package com.ptp.phamtanphat.sqliteimage0208;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by KhoaPhamPC on 20/9/2017.
 */

public class Database extends SQLiteOpenHelper {
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //Thuc hien cau truy van khong tra ket qua
    public void QueryData(String sql){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
    }

    //Thuc hien cau truy van tra ve ket qua
    public Cursor GetData(String sql){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql,null);
    }
    //Ham insert du lieu
    public void InsertData(String ten,byte[] hinhanh){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String insert = "INSERT INTO ThuCung VALUES (null,?,?)";
        SQLiteStatement sqLiteStatement=sqLiteDatabase.compileStatement(insert);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1,ten);
        sqLiteStatement.bindBlob(2,hinhanh);
        sqLiteStatement.executeInsert();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
