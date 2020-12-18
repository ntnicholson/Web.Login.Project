package com.dao;

import java.util.ArrayList;

import com.bean.User;

public class UserAccount implements com.interfaces.IUserService
{
	@Override
	public boolean Login(User findUser) 
	{
		boolean matchFound = false;
		ArrayList<com.bean.User> userList = new ArrayList<com.bean.User>();
		System.out.println("Attempted login: User: " + findUser.getName() + " Pass: " + findUser.getPassword());
		
		//Populate list using test values
		PopulateUserList(userList);
		System.out.println("ArrayList contents: " + userList.size());
		for(com.bean.User x : userList) 
		{
			System.out.println(x.toString());
			if(x.getName().equals(findUser.getName()) && x.getPassword().equals(findUser.getPassword())) 
			{
				matchFound = true;
			}
		}
		
		return matchFound;
	
	}
	private void PopulateUserList(ArrayList<com.bean.User> arrList) 
	{
		arrList.add(new User("John", "pass"));
		arrList.add(new User("Diane", "pass"));
		arrList.add(new User("Nick", "pass"));
		arrList.add(new User("Lori", "pass"));
	}

}
