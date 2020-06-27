package com.dxc.services;

import java.util.List;

import com.dxc.dao.IUserdao;
import com.dxc.dao.UserdaoImpl;
import com.dxc.pojos.book;

public class UserServiceImpl implements IUserService{
	private IUserdao dao=new UserdaoImpl();

	
	public List<book> getAllbooks() {
		
	return dao.getAllbooks();
	}

	
	public boolean authenticate(int userid, String password1) {
		
		return dao.authenticate(userid, password1);
	}

	public void issuebook(int userid, int bookid) {
	dao.issuebook(userid, bookid);
	
		
	}



	public void returnbook(int userid, int bookid,int days) {
		
		dao.returnbook(userid, bookid,days);
	}


	
	public void closeconnection() {
		
		dao.closeconnection();
	}

}
