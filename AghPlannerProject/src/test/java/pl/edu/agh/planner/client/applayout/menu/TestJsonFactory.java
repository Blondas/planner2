package pl.edu.agh.planner.client.applayout.menu;

import org.json.JSONObject;
import pl.edu.agh.planner.hibernate.entity.Teacher;

public class TestJsonFactory {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setName("ma kota");
        teacher.setName("ala");

//        String teacherJson = JsonFactory.serializeTeacherToJson(teacher);
        JSONObject jsonObj = new JSONObject( teacher );
        System.out.println( jsonObj );

//        System.out.println(teacherJson);
    }
}
