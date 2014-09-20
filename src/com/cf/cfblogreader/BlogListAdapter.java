package com.cf.cfblogreader;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BlogListAdapter extends BaseAdapter 
{
	private ArrayList<BlogRecord> blogs = new ArrayList<BlogRecord>();
	
	public BlogListAdapter()
	{
		for(int i=0;i<10;i++)
			blogs.add(new BlogRecord("vb", "vb", "vb", "vb"));
		ParseBlogList parse = new ParseBlogList();
		parse.loadDoc();
		blogs = parse.getBlogs();

	}
	
	@Override
	public int getCount() {
		return blogs.size();
	}

	@Override
	public Object getItem(int index) {
		return blogs.get(index);
	}

	@Override
	public long getItemId(int index) {	
		return index;
	}

	@Override
	public View getView(int index, View view, ViewGroup parent) {
		if(view == null)
		{
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			view = inflater.inflate(R.layout.blog_list_item, parent, false);
		}
		BlogRecord blog = blogs.get(index);
		
		TextView handleTextView = (TextView) view.findViewById(R.id.handle);
		handleTextView.setText(blog.getHandle());
		
		TextView titleTextView = (TextView) view.findViewById(R.id.title);
		titleTextView.setText(blog.getTitle());
		
		return view;
	}

}
