package com.dxc.services;

import java.util.List;

import com.dxc.dao.AdmindaoImpl;
import com.dxc.dao.IAdmindao;
import com.dxc.pojos.User;
import com.dxc.pojos.book;

public class AdminServiceImpl implements IadminService {
	private IAdmindao dao=new AdmindaoImpl();
	public void Addbooks(book b) {
		dao.Addbooks(b);
		
		
	}

	
	public void AddUsers(User u) {
		dao.AddUsers(u);
		
		
	}

	
	public List<book> getAllbooks() {
	
		
		return dao.getAllbooks();
	}

	
	public List<User> getAllUsers() {
		
		return dao.getAllUsers();
	}


	
	public boolean authenticate(int  adminid,String password) {
	
		 return dao.authenticate(adminid,password);
	}


	@Override
	public void Removebook(int bookid) {
		dao.Removebook(bookid);
		
	}


	@Override
	public void Removeuser(int userid) {
	dao.Removeuser(userid);
		
	}


	@Override
	public int getBalance(int userid) {
	return dao.getBalance(userid);
		
	}


	public void closeconnection() {
		dao.closeconnection();
		
	}



	


	
	







}
