package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.Data;
import pl.edu.agh.planner.shared.hibernate.entity.TeacherEntity;

import java.io.Serializable;

public class Teacher implements IsSerializable, Serializable {

	private int id;
	private String name;
	private String lastName;
	private Avatar avatar;

	public Teacher() {

	}

	public Teacher(TeacherEntity teacherEntity) {
		this.id = teacherEntity.getId();
		this.name = teacherEntity.getName();
		this.lastName = teacherEntity.getLastName();
		//TODO: brakuje avatara
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

}
