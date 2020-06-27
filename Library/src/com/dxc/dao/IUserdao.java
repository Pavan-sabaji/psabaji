package com.dxc.dao;

import java.util.List;

import com.dxc.pojos.book;

public interface IUserdao {
	public List<book> getAllbooks();
	public boolean authenticate(int userid, String password1);
	public void issuebook(int userid,int bookid);
	public void returnbook(int userid,int bookid,int days);
	public void closeconnection();
}
