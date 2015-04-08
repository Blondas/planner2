package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

public class User implements Serializable, IsSerializable {

	private int id;
	private String login;
	private String password;
	private String passwordMd5;
	private UserLoginStatusEnum userStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordMd5() {
		return passwordMd5;
	}

	public void setPasswordMd5(String passwordMd5) {
		this.passwordMd5 = passwordMd5;
	}

	public UserLoginStatusEnum getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserLoginStatusEnum userStatus) {
		this.userStatus = userStatus;
	}

}
