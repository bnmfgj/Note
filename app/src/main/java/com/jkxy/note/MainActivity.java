package com.jkxy.note;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    private SimpleCursorAdapter simpleCursorAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        Db db = new Db(this);
        new Method().dateWrite(db);
        new Method().dateRead(db);
        SQLiteDatabase date = db.getReadableDatabase();
        Cursor c = date.query("user", null, null, null, null, null, null);

        simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.user_list_cell, c, new String[]{"name", "sex"}, new int[]{R.id.textView1, R.id.textView2},1);
        listView.setAdapter(simpleCursorAdapter);





    }
}
