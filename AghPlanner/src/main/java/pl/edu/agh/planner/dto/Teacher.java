package pl.edu.agh.planner.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;

public class Teacher{

	private Long id;
	private String name;
	private String lastName;
	@JsonBackReference(value = "avatar-teacher")
	private Avatar avatar;

	public Teacher() {

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
