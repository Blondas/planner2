package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;
import pl.edu.agh.planner.shared.hibernate.entity.AvatarEntity;
import pl.edu.agh.planner.shared.hibernate.entity.TeacherEntity;

import java.io.Serializable;

public class Teacher implements IsSerializable, Serializable {

	private int id;
	private String name;
	private String lastName;
	private String emailAddress;
	private Avatar avatar;

	public Teacher() {

	}

	public Teacher(TeacherEntity teacherEntity) {
		this.id = teacherEntity.getId();
		this.name = teacherEntity.getName();
		this.lastName = teacherEntity.getLastName();
		//TODO: brakuje avatara

//        if(teacherEntity.getAvatar() != null){
//            AvatarEntity avatarEntity = teacherEntity.getAvatar();
//            this.avatar.setId(avatarEntity.getId());
//            this.avatar.setName(avatarEntity.getName());
//        }
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

}
