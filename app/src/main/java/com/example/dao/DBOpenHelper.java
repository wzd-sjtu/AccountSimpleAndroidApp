package com.example.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 直接使用db对象执行了一系列SQL语句
        // 这里的处理是非常明确的
        //user table
        // 典型的数据库建表操作
        db.execSQL("create table if not exists user_tb(_id integer primary key autoincrement," +
                "userID text not null," +
                "pwd text not null)");

        //Configuration table
        db.execSQL("create table if not exists refCode_tb(_id integer primary key autoincrement," +
                "CodeType text not null," +
                "CodeID text not null," +
                "CodeName text null)");

        //costDetail_tb
        db.execSQL("create table if not exists basicCode_tb(_id integer primary key autoincrement," +
                "userID text not null," +
                "Type integer not null," +
                "incomeWay text not null," +
                "incomeBy text not null," +
                "category text not null," +
                "item text not null," +
                "cost money not null," +
                "note text not null," +
                "makeDate text not null)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 这里作者并没有给出代码的具体写法
        // 具体想要怎么写暂时还是不清楚的
    }
}
