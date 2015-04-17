package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.Data;
import pl.edu.agh.planner.shared.enums.UserLoginStatusEnum;

import java.io.Serializable;

@Data
public class User implements Serializable, IsSerializable {

	private int id;
	private String login;
	private String password;
	private String passwordMd5;
	private UserLoginStatusEnum userStatus;

	public User() {

	}

}
