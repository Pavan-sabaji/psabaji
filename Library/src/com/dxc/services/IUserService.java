package com.dxc.services;

import java.util.List;


import com.dxc.pojos.book;

public interface IUserService {
	
	public List<book> getAllbooks();
	public boolean authenticate(int userid,String password1);
	public void issuebook(int userid,int bookid);
	public void returnbook(int userid,int bookid,int days);
	public void closeconnection();
	
	
	


}
