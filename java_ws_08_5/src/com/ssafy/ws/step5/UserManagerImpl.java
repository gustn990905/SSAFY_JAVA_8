package com.ssafy.ws.step5;

import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements IUserManager {

	private User loginUser;
	private List<User> users = new ArrayList<>();

	private static IUserManager instance = new UserManagerImpl();

	private UserManagerImpl() {
	}

	public static IUserManager getInstance() {
		return instance;
	}

	@Override
	public User getLoginUser() {
		return loginUser;
	}

	@Override
	public void signup(User user) {
		users.add(user);
	}

	@Override
	public User login(String id, String password) {

		for (User u : users) {

			if (u.getUserId().equals(id) && u.getPassword().equals(password)) {
				loginUser = u;
				return u;
			}
		}

		return null;
	}

	@Override
	public void logout() {
		loginUser = null;
	}

	@Override
	public User getUser(int userSeq) {

		for (User u : users)
			if (u.getUserSeq() == userSeq)
				return u;

		return null;
	}

	@Override
	public User getUser(String nickName) {

		for (User u : users)
			if (u.getNickName().equals(nickName))
				return u;

		return null;
	}
}