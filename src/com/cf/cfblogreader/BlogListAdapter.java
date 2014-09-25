package com.cf.cfblogreader;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BlogListAdapter extends CursorAdapter
{
	
	@SuppressWarnings("deprecation")
	public BlogListAdapter(Context context, Cursor cursor)
	{
		super(context, cursor);
		System.out.println("Constructor success ");
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) 
	{
		TextView handle = (TextView) view.findViewById(R.id.handle);
		TextView title = (TextView) view.findViewById(R.id.title);
		handle.setText(cursor.getString(2));
		title.setText(cursor.getString(3));
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup viewGroup) 
	{
		LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
		View view = inflater.inflate(R.layout.blog_list_item, viewGroup, false);
		return view;
	}

}
