package com.video.persistence;

import java.util.*;

import com.video.domain.User;

public class Repository {
	private List<User> userList = new ArrayList<>();
	public Repository() {
		
	}
	
		
	public void addUser(User u) {
		userList.add(u);
	}

	
	public List<User> getUserList() {
		return userList;
	}
}
