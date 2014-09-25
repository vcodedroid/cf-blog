package com.cf.cfblogreader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class ListDbHelper extends SQLiteOpenHelper {

  public static final String TABLE_RECENT = "recentblogs";
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_BLOGID = "_bid";
  public static final String COLUMN_HANDLE = "handle";
  public static final String COLUM_TITLE = "title";
  public static final String COL_DESC = "desc";
  private static final String DATABASE_NAME = "cfblogs1.db";
  private static final int DATABASE_VERSION = 3;

  // Database creation sql statement
  private static final String DATABASE_CREATE = "create table "
      + TABLE_RECENT 
      + "(" 
      + COLUMN_ID
      + " integer primary key autoincrement, "
      + COLUMN_BLOGID
      + " text not null, " 
      + COLUMN_HANDLE
      + " text not null, "
      + COLUM_TITLE
      + " text not null, "
      + COL_DESC
      + " text );";

  
  public ListDbHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase database) {
	  database.execSQL(DATABASE_CREATE);
	  //System.out.println("The sql query executed :)");
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	System.out.println("Database updated.");
	Log.w(ListDbHelper.class.getName(),
        "Upgrading database from version " + oldVersion + " to "
            + newVersion + ", which will destroy all old data");
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECENT);
    onCreate(db);
  }

} 