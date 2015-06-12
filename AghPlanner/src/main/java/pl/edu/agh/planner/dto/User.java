package pl.edu.agh.planner.dto;


import java.util.Set;

public class User {

	private Long id;
	private String login;
	private String password;
	private String passwordMd5;
//	private UserLoginStatusEnum userStatus;
    private Set<Authorization> authorizations;

    private boolean isLoggedIn = false;
    private String sessionId ;

	public User() {

	}



//	public UserLoginStatusEnum getUserStatus() {
//		return userStatus;
//	}
//
//	public void setUserStatus(UserLoginStatusEnum userStatus) {
//		this.userStatus = userStatus;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

    public Set<Authorization> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(Set<Authorization> authorizations) {
        this.authorizations = authorizations;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
