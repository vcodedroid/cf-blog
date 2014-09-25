package com.cf.cfblogreader;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class BlogListDataSource {
	public Context context;
		// Database fields
	private SQLiteDatabase database;
	private ListDbHelper dbHelper;
	private String[] allColumns = {
	ListDbHelper.COLUMN_ID,
	ListDbHelper.COLUMN_BLOGID,
	ListDbHelper.COLUMN_HANDLE,
	ListDbHelper.COLUM_TITLE,
	ListDbHelper.COL_DESC
	};
  
  
  public BlogListDataSource(Context context) {
	  this.context = context;
	  dbHelper = new ListDbHelper(context);
  }

  public Cursor getAllBlogRecords()
  {
	  return database.rawQuery("select * from "+ListDbHelper.TABLE_RECENT, null);	//dude, better use sqlitequerybuilder :)
  }
  
  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase();
  }

  public void close() {
    dbHelper.close();
  }

  public BlogRecord addListItem(BlogRecord record) {
    ContentValues values = new ContentValues();
    values.put(ListDbHelper.COLUMN_BLOGID, record.getBlogId());
    values.put(ListDbHelper.COLUMN_HANDLE, record.getHandle());
    values.put(ListDbHelper.COLUM_TITLE, record.getTitle());
    values.put(ListDbHelper.COL_DESC, record.getDesc());
    
    long insertId = database.insert(ListDbHelper.TABLE_RECENT, null,
        values);
    
    System.out.println("The value of the context id is "+insertId);
    
    if(insertId < 0)
    {
    	System.out.println("Error somewhere in database connection.");
    }
    
    Cursor cursor = database.rawQuery("select * from "+ListDbHelper.TABLE_RECENT, null);	//dude, better use sqlitequerybuilder :)
    cursor.moveToFirst();
    BlogRecord newComment = cursorToComment(cursor);
    cursor.close();
    return newComment;
  }

  public void deleteComment(BlogRecord record) {
    String id = record.getBlogId();
    System.out.println("Comment deleted with id: " + id);
    database.delete(ListDbHelper.TABLE_RECENT, ListDbHelper.COLUMN_BLOGID
        + " = " + id, null);
  }

  public ArrayList<BlogRecord> getAllBlogs() {
    ArrayList<BlogRecord> blogs = new ArrayList<BlogRecord>();

    Cursor cursor = database.query(ListDbHelper.TABLE_RECENT,
        allColumns, null, null, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      BlogRecord rec = cursorToComment(cursor);
      blogs.add(rec);
      cursor.moveToNext();
    }
    // make sure to close the cursor
    cursor.close();
    return blogs;
  }

  private BlogRecord cursorToComment(Cursor cursor) {
	  System.out.println("Printing the cursoor "+cursor);
	  BlogRecord rec = new BlogRecord(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
	  return rec;
  }
} 