package com.ptp.phamtanphat.sqliteimage0208;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static Database database;
    ListView listViewthucung;
    Button btnthemthucung;
    ThucungAdapter thucungAdapter;
    ArrayList<Thucung> thucungArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewthucung = (ListView) findViewById(R.id.listviewthucung);
        btnthemthucung = (Button) findViewById(R.id.buttonthem);
        database = new Database(MainActivity.this,"Quanlythucung.sqlite",null,1);
//        String CreateTable = "CREATE TABLE IF NOT EXISTS ThuCung (Id INTEGER PRIMARY KEY AUTOINCREMENT , Ten VARCHAR(200) ,Hinhanh BLOB)";
//        database.QueryData(CreateTable);
        thucungArrayList = new ArrayList<>();
        thucungAdapter = new ThucungAdapter(MainActivity.this,thucungArrayList);
        listViewthucung.setAdapter(thucungAdapter);


        btnthemthucung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ThemAcitivity.class);
                startActivity(intent);
            }
        });
        String getdata = "SELECT * FROM ThuCung";
        Cursor cursor = database.GetData(getdata);
        while (cursor != null && cursor.moveToNext()){
            int id = cursor.getInt(0);
            String ten = cursor.getString(1);
            byte[] hinhanh = cursor.getBlob(2);

            thucungArrayList.add(new Thucung(id,ten,hinhanh));
        }
        thucungAdapter.notifyDataSetChanged();
    }
}
