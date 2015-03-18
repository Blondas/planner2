package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

public class SaleHour implements Serializable, IsSerializable {

	private int id;
	private int lessonId;
	private int lessonBeginId;
	private int lessonEndId;
	private int saleId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public int getLessonBeginId() {
		return lessonBeginId;
	}

	public void setLessonBeginId(int lessonBeginId) {
		this.lessonBeginId = lessonBeginId;
	}

	public int getLessonEndId() {
		return lessonEndId;
	}

	public void setLessonEndId(int lessonEndId) {
		this.lessonEndId = lessonEndId;
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

}
