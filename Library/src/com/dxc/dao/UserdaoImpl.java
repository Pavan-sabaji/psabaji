package com.dxc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.pojos.User;
import com.dxc.pojos.book;

public class UserdaoImpl implements IUserdao{
	private static Connection conn;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","pass");
	
		}
		catch(Exception e)
		{
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
	
	public boolean authenticate( int userid, String password1) {
		boolean b=false;
		try {
			PreparedStatement pstmt=conn.prepareStatement("select * from user");
			ResultSet rset=pstmt.executeQuery();
			while(rset.next()) 
			{
				if( userid==rset.getInt(1)&& rset.getString(3).equals(password1))
				{b=true;
				break;
				}
					
				
						
			}
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return b;
	}


	public void issuebook(int userid, int bookid) {
		try {
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("select bookid from books");
			while(rset.next())
			{
				if (bookid==rset.getInt(1))
			{
				PreparedStatement pstmt=conn.prepareStatement("insert into bookdetails values(?,?)");
				pstmt.setInt(1, userid);
				pstmt.setInt(2, bookid);
				pstmt.execute();
				System.out.println("successfuly recived book from library");
			}
				
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public void returnbook(int userid, int bookid,int days) {
		try
		{PreparedStatement pstmt=conn.prepareStatement("select balance from user where userid=?");
		pstmt.setInt(1, userid);
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		int amount=rs.getInt(1);
		int k =amount-(5*days);
		PreparedStatement pstmt3=conn.prepareStatement("update user set balance=? where userid=?");
				pstmt3.setInt(1,k);
				pstmt3.setInt(2,userid);
				pstmt3.execute();
		PreparedStatement pstmt1=conn.prepareStatement("delete from bookdetails where userid=?&&bookid=?");
			pstmt1.setInt(1, userid);
			pstmt1.setInt(2, bookid);
			pstmt1.execute();
			System.out.println("successfully returned the book");
			int redbalance=5*days;
			System.out.println(redbalance+"  "+"rupees is deducted");
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
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
