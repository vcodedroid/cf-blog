package com.cf.cfblog;

import java.util.ArrayList;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class GenList {
	Activity cur;
	ArrayList<String> animalsNameList;
	public GenList(Activity con)
	{
		cur = con;
	}
	public void generate()
	{
    // Get the reference of ListViewAnimals
     ListView animalList=(ListView)cur.findViewById(R.id.listViewAnimals);
     
     
      animalsNameList = new ArrayList<String>();
      getAnimalNames();
      // Create The Adapter with passing ArrayList as 3rd parameter
      ArrayAdapter<String> arrayAdapter =      
      new ArrayAdapter<String>(cur ,android.R.layout.simple_list_item_1, animalsNameList);
      // Set The Adapter
      animalList.setAdapter(arrayAdapter); 
      
      // register onClickListener to handle click events on each item
      animalList.setOnItemClickListener(new OnItemClickListener()
         {
                  // argument position gives the index of item which is clicked
                 public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
                 {
                     
                         String selectedAnimal=animalsNameList.get(position);
                         Toast.makeText(cur.getApplicationContext(), "Animal Selected : "+selectedAnimal,   Toast.LENGTH_LONG).show();
                      }
         });
	}
	void getAnimalNames()
	{
		for(Integer i=0;i<1000;i++)
			animalsNameList.add(i.toString());
	}
}
