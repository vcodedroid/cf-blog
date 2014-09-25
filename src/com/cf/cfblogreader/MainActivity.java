package com.cf.cfblogreader;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	public BlogListAdapter blogListAdapter;
	public BlogListDataSource dataSource;

	
    public void onCreate(Bundle saveInstanceState)
    {
            super.onCreate(saveInstanceState);
            setContentView(R.layout.activity_main);
            ListView list = (ListView) findViewById(R.id.blogs_list);
            dataSource = new BlogListDataSource(this);
            dataSource.open();
            for(int i=0;i<3;i++)
            {
            	dataSource.addListItem(new BlogRecord("vb", "vb", "vb", "vb"));
            }
            Cursor temp = dataSource.getAllBlogRecords();
            System.out.println("Cursor :"+temp);
            blogListAdapter = new BlogListAdapter(this, temp);
            list.setAdapter(blogListAdapter);
            System.out.println("Adapter is being called");
    }       
}