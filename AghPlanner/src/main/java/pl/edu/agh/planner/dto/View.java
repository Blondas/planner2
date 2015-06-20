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

	public boolean getCalendar() {
		return calendar;
	}

	public void setCalendar(boolean calendar) {
		this.calendar = calendar;
	}

	public boolean getTeacherContainer() {
		return teacherContainer;
	}

	public void setTeacherContainer(boolean teacherContainer) {
		this.teacherContainer = teacherContainer;
	}

	public boolean getAvatarContainer() {
		return avatarContainer;
	}

	public void setAvatarContainer(boolean avatarContainer) {
		this.avatarContainer = avatarContainer;
	}

	public boolean getAggregateContainer() {
		return aggregateContainer;
	}

	public void setAggregateContainer(boolean aggregateContainer) {
		this.aggregateContainer = aggregateContainer;
	}

	public boolean getStudentGroupContainer() {
		return studentGroupContainer;
	}

	public void setStudentGroupContainer(boolean studentGroupContainer) {
		this.studentGroupContainer = studentGroupContainer;
	}

	public boolean getProgrammeUnitContainer() {
		return programmeUnitContainer;
	}

	public void setProgrammeUnitContainer(boolean programmeUnitContainer) {
		this.programmeUnitContainer = programmeUnitContainer;
	}
}
