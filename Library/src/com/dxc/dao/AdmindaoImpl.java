package com.dxc.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import com.dxc.pojos.User;
import com.dxc.pojos.book;


public class AdmindaoImpl implements IAdmindao{

	private static Connection conn;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		System.out.println("welcome");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","pass");
	System.out.println("to library application");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void Addbooks(book b) {
		try {
			PreparedStatement pstmt=(PreparedStatement)conn.prepareStatement("insert into books values(?,?)");
		    pstmt.setInt(1, b.getBookid());
		    pstmt.setString(2, b.getBookname());
		    
		    pstmt.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	
	public void AddUsers(User u) {
		try {
			java.sql.PreparedStatement pstmt=conn.prepareStatement("insert into User values(?,?,?,?)");
		    pstmt.setInt(1, u.getUserid());
		    pstmt.setString(2, u.getUsername());
		    pstmt.setString(3, u.getPassword());
		    pstmt.setInt(4,u.getBalance());
		    
		    
		    pstmt.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}


	public List<book> getAllbooks() {
		List<book> list=new ArrayList<>();
		
		try {
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("select *from books");
			while(rset.next())
			{
				book b=new book(rset.getInt(1), rset.getString(2));
				list.add(b);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
		
	}

	
	public List<User> getAllUsers() {
List<User> list=new ArrayList<>();
		
		try {
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("select * from User");
			while(rset.next())
			{
				User u=new User(rset.getInt(1),rset.getString(2) ,rset.getString(3),rset.getInt(4));
				list.add(u);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
		
		
	}


	
	public boolean authenticate(int adminid, String password) {
		boolean b=false;
	try {
	Statement stmt=conn.createStatement();
		ResultSet rset=stmt.executeQuery("select * from admin");
		while(rset.next()) 
		{
			if(adminid==rset.getInt(1)&&password.equals(rset.getString(2)))
			{
			b=true;
			System.out.println("login successful");
			}
			else {
				System.out.println("incorrect login credentials");
			}
		}
	}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	return b;
	}

	public void Removebook(int bookid) {
		try {
			PreparedStatement pstmt=(PreparedStatement)conn.prepareStatement("delete from books where bookid=?");
		    pstmt.setInt(1, bookid);
		    pstmt.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	public void Removeuser(int userid) {
		try {
			PreparedStatement pstmt=(PreparedStatement)conn.prepareStatement("delete from user where userid=?");
		    pstmt.setInt(1, userid);
		    pstmt.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
}


	
	public int getBalance(int userid) {
		Statement stmt;
		int balance=0;
		try {
			 stmt=conn.createStatement();
				ResultSet rset=stmt.executeQuery("select * from user");
				
				while(rset.next()) 
				{
					if (userid==rset.getInt(1))
					{
						balance=rset.getInt(5);
					}
		
		
		
				}
		
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return balance;
		
	}


	
	public void closeconnection() {
		try {
			conn.close();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	
	
	
			
	}	
	
		
	


	
	


	
	

