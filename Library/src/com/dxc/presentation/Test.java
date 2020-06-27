package com.dxc.presentation;

import java.util.List;
import java.util.Scanner;
import com.dxc.services.*;

import com.dxc.pojos.User;
import com.dxc.pojos.book;

public class Test {
	

	public static void main(String[] args) {
	int choice;
	Scanner sc=new Scanner(System.in);
	IadminService AdminService=new AdminServiceImpl();
	IUserService UserService=new UserServiceImpl();
	while(true)
	{
		System.out.println("1.login as admin");
		System.out.println("2.login as user");
		System.out.println("enter your choice");
		choice=sc.nextInt();
		switch (choice)
		{case 1:
			
			System.out.println("enter admin id");
            System.out.println("enter password");
             int adminid=sc.nextInt();
              String password =sc.next();
			boolean b1=AdminService.authenticate(adminid, password);
			if(b1==true)
			{
			while (true) 
			{
				System.out.println("1.add user");
				System.out.println("2.add book");
				System.out.println("3.see users");
				System.out.println("4.see books");
				System.out.println("5.remove book");
				System.out.println("6.remove user");
				System.out.println("7.show balance");
				System.out.println("8.logout as admin");
				System.out.println("enter your choice");
				choice=sc.nextInt();
				switch (choice)
				{
				case 1:System.out.println("Enter userid,username,password,balance");
				AdminService.AddUsers(new User(sc.nextInt(), sc.next(), sc.next(), sc.nextInt()));
				break;
					
				
				case 2:
					System.out.println("Enter bookid,bookname");
					AdminService.Addbooks(new book(sc.nextInt(), sc.next()));
					break;
					
				case 3:List<User> list=AdminService.getAllUsers();
				for(User u:list)
					u.display1();
				System.out.println();
				break;
				case 4:
					List<book> list1=AdminService.getAllbooks();
					for(book b:list1)
						b.display();
					System.out.println();
					break;
				case 5:System.out.println("enter bookid of book to be removed");
				int bid=sc.nextInt();
				AdminService.Removebook(bid);
					
					break;
				case 6:System.out.println("enter userid of user to be removed");
				int uid=sc.nextInt();
				AdminService.Removeuser(uid);
				
					break;
				case 7:System.out.println("enter userid to view balance");
				int userid=sc.nextInt();
				int balance=AdminService.getBalance(userid);
				System.out.println("balance is"+balance);
				break;
				case 8:System.out.println("logout successful");
				AdminService.closeconnection();
				System.exit(0);
				break;
				}
			}
			
			
			}
			break;
		case 2:
			System.out.println("enter userid");
			System.out.println("enter password");
			int userid=sc.nextInt();
            String password1 =sc.next();
			boolean b2=UserService.authenticate(userid, password1);
			if (b2==true)
			{
				System.out.println("user logged in successfuly");
			while(true)
			{
				System.out.println("1.show book list");
				System.out.println("2.issue book");
				System.out.println("3.return book");
				System.out.println("4.logout as user");
				choice=sc.nextInt();
				switch (choice)
				{
				case 1:List<book> list1=UserService.getAllbooks();
				for(book b:list1)
					b.display();
				System.out.println();
				break;
					
				case 2:System.out.println("enter bookid");
				UserService.issuebook(userid,sc.nextInt());
					break;
				case 3:System.out.println("enter bookid to return");
				System.out.println("Enter number of days");
				UserService.returnbook(userid,sc.nextInt(),sc.nextInt());
					break;
				case 4:System.out.println("logout successful");
				AdminService.closeconnection();
				System.exit(0);
				break;
				}
			
				
				}
			
			}
			else 
			{
				System.out.println("Icorrect login credentials");
			}
			break;
		
		}
	}

	}

}
