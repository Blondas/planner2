package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class Avatar implements IsSerializable, Serializable {

	private int id;
	private int name;
	private Set<Aggregate> aggregates;
	private Set<Teacher> teachers;

	public Avatar() {

	}

}
