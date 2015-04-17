package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.Data;

import java.io.Serializable;

@Data
public class SaleHour implements Serializable, IsSerializable {

	private int id;
	private int lessonId;
	private int lessonBeginId;
	private int lessonEndId;
	private int saleId;

	public SaleHour() {

	}

}
