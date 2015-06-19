package pl.edu.agh.planner.dto;


public class View implements java.io.Serializable{
	private Long id;
	private String name;
	public boolean calendar;
	public boolean teacherContainer;
	public boolean avatarContainer;
	public boolean aggregateContainer;
	public boolean studentGroupContainer;
	public boolean programmeUnitContainer;

	public View() {

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
}
