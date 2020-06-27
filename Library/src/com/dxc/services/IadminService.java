package com.dxc.services;

import java.util.List;


import com.dxc.pojos.User;
import com.dxc.pojos.book;

public interface IadminService {
	public void Addbooks(book b);
	public void AddUsers(User u);
	public List<book> getAllbooks();
	public List<User> getAllUsers();
	public boolean authenticate(int adminid,String password);
	public void Removebook(int bookid);
	public void Removeuser(int userid);
	public int getBalance(int userid);
	public void closeconnection();
	
	

	

}
