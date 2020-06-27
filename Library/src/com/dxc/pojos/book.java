package com.dxc.pojos;

public class book {
	private int bookid;
	private String bookname;
	public book()
	{
		
	}
	public book(int bookid,String bookname)
	{
		super();
		this.bookid=bookid;
		this.bookname=bookname;
	
	}
	
	
	
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	public int getBookid() {
		return bookid;
	}
	
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
public void display()
{
	System.out.println(bookid+" "+bookname);
	}

}
