package pl.edu.agh.planner.dto;


import java.util.Set;

public class Avatar {

	private Long id;
	private String name;
	private Set<Aggregate> aggregates;
	private Set<Teacher> teachers;

	public Avatar() {

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

	public Set<Aggregate> getAggregates() {
		return aggregates;
	}

	public void setAggregates(Set<Aggregate> aggregates) {
		this.aggregates = aggregates;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
}
