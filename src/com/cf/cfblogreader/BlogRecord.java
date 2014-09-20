package com.cf.cfblogreader;

public class BlogRecord {
	private String handle;
	private String title;
	private String blogId;
	private String desc;
	public BlogRecord(String handle, String title, String blogId, String desc)
	{
		this.handle = handle;
		this.title = title;
		this.blogId = blogId;
		this.desc = desc;
	}
	public void setDescription(String desc)
	{
		this.desc = desc;
	}
	public String getHandle()
	{
		return handle;
	}
	public String getTitle()
	{
		return title;
	}
	public String getBlogId()
	{
		return blogId;
	}
	public String getDesc()
	{
		return desc;
	}
}
