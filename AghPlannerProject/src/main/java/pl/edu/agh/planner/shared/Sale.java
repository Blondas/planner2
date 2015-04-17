package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.Data;

import java.io.Serializable;

@Data
public class Sale implements Serializable, IsSerializable {

	private int id;
	private int number;
	private int buildingId;
	private int numberOfSeats;

	public Sale() {

	}

}
