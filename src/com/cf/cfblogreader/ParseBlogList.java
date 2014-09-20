package com.cf.cfblogreader;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseBlogList {
	
	private ArrayList<BlogRecord> records;
	
	//private final String URL = new String("http://localhost/cf/Recent%20actions%20-%20Codeforces.htm"); //for debugging :)
	private final String URL = new String("https://codeforces.com/recent-actions"); //This is to be used in production. :)
	private final String domClass = new String("recent-actions");
	private final String outerDomTag = new String("li");
	private final String innerDomTag = new String("a");
	private final String domAttribute = new String("href");
	Document doc;
	
	public ArrayList<BlogRecord> getBlogs()
	{
		return records;
	}
	
	public void loadDoc()
	{
		Elements recentList;
		Elements list;
		Elements curr;
		
		try
		{
			doc = Jsoup.connect(URL).get();
			recentList = doc.getElementsByClass(domClass);
			//System.out.println(recentList);
			for(Element con : recentList)
			{
				list = con.getElementsByTag(outerDomTag);
				//System.out.println(current);
				//System.out.println("...........................................");
				for(Element one: list)
				{
					curr = one.getElementsByTag(innerDomTag);
					records.add(new BlogRecord(curr.get(0).ownText(), curr.get(0).ownText(), "vb", "vb"));
					for(Element d: curr )
					{
						
						System.out.println(d.ownText());
						System.out.println(d.attr(domAttribute));
					}
					System.out.println("............................");
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in loading the doc "+e);
		}
	}
	
	public static void main(String ds[])
	{
		ParseBlogList b = new ParseBlogList();
		b.loadDoc();
		System.out.println("successfull parsing");
	}
}
