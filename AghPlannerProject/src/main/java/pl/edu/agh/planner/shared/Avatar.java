package pl.edu.agh.planner.shared;

import com.google.gwt.user.client.rpc.IsSerializable;
import pl.edu.agh.planner.shared.hibernate.entity.AvatarEntity;

import java.io.Serializable;
import java.util.Set;

public class Avatar implements IsSerializable, Serializable {

	private int id;
	private String name;
	private Set<Aggregate> aggregates;
	private Set<Teacher> teachers;

	public Avatar() {

	}

    public Avatar(AvatarEntity avatarEntity){
        this.id = avatarEntity.getId();
        this.name = avatarEntity.getName();
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
