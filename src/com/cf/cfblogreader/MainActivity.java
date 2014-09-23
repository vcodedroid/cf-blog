package com.cf.cfblogreader;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	BlogListAdapter blogListAdapter;
	
    public void onCreate(Bundle saveInstanceState)
    {
            super.onCreate(saveInstanceState);
            setContentView(R.layout.activity_main);
            //GenList gen = new GenList(this);
            //gen.generate();
            ListView list = (ListView) findViewById(R.id.blogs_list);
            blogListAdapter = new BlogListAdapter(this);
            list.setAdapter(blogListAdapter);
    }       
}