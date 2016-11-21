package com.jkxy.note;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2016/11/21.
 */
public class Method  {
    /*数据写入*/

    public void dateWrite(Db db){
        SQLiteDatabase dbWrite =db.getWritableDatabase();

        ContentValues cv =new ContentValues();
        cv.put("name","张三");
        cv.put("sex","男");
        dbWrite.insert("user",null,cv);

        cv=new ContentValues();
        cv.put("name","李四");
        cv.put("sex","女");
        dbWrite.insert("user",null,cv);
        dbWrite.close();
    }

    /*数据读取*/
    public void dateRead(Db db){
        SQLiteDatabase dbRead =db.getReadableDatabase();
        Cursor c=dbRead.query("user",null,null,null,null,null,null);

        while(c.moveToNext()){

            String name=c.getString(c.getColumnIndex("name"));
            String sex=c.getColumnName(c.getColumnIndex("sex"));

            System.out.println(name+"  "+sex);
        }
    }
}
