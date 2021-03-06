package com.francesco.malagrino.actions;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.francesco.malagrino.dao.*;
import com.francesco.malagrino.entity.User;
import com.francesco.malagrino.utility.MD5;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7164958494835190250L;
//	Variables
	private User user = new User();
	private UserDao userDao = new UserDao();
	private String email, password = setEmail("");
	SessionMap<String, Object> sessionmap;

// Methods
	public String execute() {
//		HttpSession session = ServletActionContext.getRequest().getSession(true);
		try {
			user = (User) userDao.getByEmail(this.email);
			if (user.getPassword().equals(MD5.getMd5(this.password))) {
				sessionmap.put("email", email);
				sessionmap.put("name", user.getName());
				sessionmap.put("role", user.getAccountType());
				addActionMessage("Welcome back, " + user.getName());
				return "success";
			} else {
				addActionError("We could not find any registered user matching the login details.");
				return "error";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addActionError("We could not find any registered user matching the login details.");
		}
		return "error";
	}

	@Override
	public void setSession(Map<String, Object> map) {
		sessionmap = (SessionMap<String, Object>) map;
		sessionmap.put("login", "true");

	}

	@org.apache.struts2.interceptor.validation.SkipValidation
	public String logout() {

		sessionmap.remove("email");
		sessionmap.remove("name");
		sessionmap.invalidate();
		addActionMessage("You have been logged out successfully.");

		return "success";
	}

//	getter and setter
	public String getEmail() {
		return email;
	}

	public String setEmail(String email) {
		this.email = email;
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//  Validation
	public void validate() {
		if (this.getEmail().length() == 0) {
			addFieldError("email", "Email is required.");
		}
		if (this.getEmail().length() == 0) {
			addFieldError("password", "Password is required.");
		}
	}

}
