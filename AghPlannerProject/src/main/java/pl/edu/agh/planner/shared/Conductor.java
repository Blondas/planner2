package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.Data;

import java.io.Serializable;

@Data
public class Conductor implements Serializable, IsSerializable {

	private String firstName;
	private String lastName;
	private String mailAddress;
	private String mobileNumber;

	public Conductor() {

	}

}
