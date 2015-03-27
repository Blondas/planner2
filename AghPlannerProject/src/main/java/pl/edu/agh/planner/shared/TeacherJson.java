package pl.edu.agh.planner.shared;

import lombok.Data;
import pl.edu.agh.planner.hibernate.entity.Avatar;

import javax.persistence.*;

@Data
public class TeacherJson {

    private int id;

    private String name;

    private String lastname;

}
