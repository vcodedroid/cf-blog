package com.cf.cfblog;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	
    public void onCreate(Bundle saveInstanceState)
    {
            super.onCreate(saveInstanceState);
            setContentView(R.layout.activity_main);
            GenList gen = new GenList(this);
            gen.generate();
    }       
}