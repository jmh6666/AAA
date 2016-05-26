package com.example.administrator.hello;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/23.
 */
public class SqliteHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="user.db";
    private static final int DB_VERSION=1;
    private static final String USER_TBL="userInfo";
    private static final String USER_TBL_ID="uId";
    private static final String USER_TBL_NAME="uName";
    private static final String USER_TBL_AGE="uAge";
    private static final String USER_TBL_HEADER="uHeader";
    private static final String USER_TBL_SEX="uSex";
    public SqliteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sCategory=new StringBuilder();
        sCategory.append("create table if not exists ");
        sCategory.append(USER_TBL);
        sCategory.append("(");
        sCategory.append(USER_TBL_ID).append(" Integer primary key autoincrement,");
        sCategory.append(USER_TBL_NAME).append(" varchar(20),");
        sCategory.append(USER_TBL_AGE ).append(" Integer,");
        sCategory.append(USER_TBL_SEX).append(" varchar(10),");
        sCategory.append(USER_TBL_HEADER).append(" varchar(100)");
        sCategory.append(")");
//        String sql="CREAT TABLE"+USER_TBL+"("+USER_TBL_ID+" Integer primary key autoincrement,"
//                +USER_TBL_NAME+" VACHAR(20),"+USER_TBL_AGE+" INTEGER,"+USER_TBL_SEX+ " VARCHAR(10),"
//                +USER_TBL_HEADER+" VARCHAR(100));";
        log(sCategory.toString());
        db.execSQL(sCategory.toString());
        List<User> userList=UserDao.mList;
        for (User uList:userList){
            ContentValues values=new ContentValues();
            values.put(USER_TBL_ID,uList.getType());
            values.put(USER_TBL_NAME,uList.getUserName());
            values.put(USER_TBL_AGE,uList.getUserAge());
            values.put(USER_TBL_SEX,uList.getUserSex());
            values.put(USER_TBL_HEADER,uList.getUserHeader());
            db.insert(USER_TBL,null,values);
        }
    }
    public long insert(String name,int age,String sex,int header){
        log("insert");
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(USER_TBL_NAME,name);
        cv.put(USER_TBL_AGE,age);
        cv.put(USER_TBL_SEX,sex);
      //  cv.put(USER_TBL_HEADER,header);
        //cv.put(USER_TBL_ID,type);
        long row=db.insert(USER_TBL,null,cv);
        log(row);
        return row;
    }

    private static final boolean DEBUG = true;

    private void log(long content) {
        log(String.valueOf(content));
    }

    private void log(String content) {
        if (DEBUG) {
            Log.e("db", content);
        }
    }

    public void delete(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        String where=USER_TBL_ID+"=?";
        String[] whereValue={Integer.toString(id)};
        db.delete(USER_TBL,where,whereValue);
    }
    public void update(int id,String name){
        SQLiteDatabase db=this.getWritableDatabase();
        String where=USER_TBL_ID+"=?";
        String[] whereValue={Integer.toString(id)};

        ContentValues cv=new ContentValues();
        cv.put(USER_TBL_NAME,name);
        db.update(USER_TBL,cv,where,whereValue);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+USER_TBL);
        onCreate(db);
    }
    public void updateDB(SQLiteDatabase db,int oldDB,int newDB,String typeDB){
        try {
            db.execSQL("ALTER TABLE"+USER_TBL+"CHANGE"+oldDB+""+newDB+""+typeDB);
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    static class UserDao{
        static ArrayList<User> mList=new ArrayList<User>();

        static {
            mList.add(new User("张三",11,"男",R.mipmap.ic_launcher,1));
            mList.add(new User("李四",12,"女",R.mipmap.ic_launcher,2));
        }
    }
    }

