package pl.edu.agh.planner.dto;


public class Foo {

  private Long id;
  private String name;
  private Long teacherId;
  private String teacherName;
  private String teacherLastName;

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

  public Long getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(Long teacherId) {
    this.teacherId = teacherId;
  }

  public String getTeacherName() {
    return teacherName;
  }

  public void setTeacherName(String teacherName) {
    this.teacherName = teacherName;
  }

  public String getTeacherLastName() {
    return teacherLastName;
  }

  public void setTeacherLastName(String teacherLastName) {
    this.teacherLastName = teacherLastName;
  }

  @Override
  public String toString() {
    return "Foo{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", teacherId=" + teacherId +
            ", teacherName='" + teacherName + '\'' +
            ", teacherLastName='" + teacherLastName + '\'' +
            '}';
  }
}
