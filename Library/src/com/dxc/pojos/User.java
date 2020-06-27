package com.dxc.pojos;

public class User {
	private int userid;
	private String username;
	private String password;
	private int balance;
public User()
{
	}
public User(int userid, String username, String password, int balance) {
	super();
	this.userid = userid;
	this.username = username;
	this.password = password;
	this.balance = balance;
}


public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getBalance() {
	return balance;
}

public void setBalance(int balance) {
	this.balance = balance;
	
}



public void display1()
{
	System.out.println(userid+" "+username+" "+password+" "+" "+balance);
	}
}

