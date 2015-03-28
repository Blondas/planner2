package pl.edu.agh.planner.client.tools;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;
import pl.edu.agh.planner.hibernate.entity.Teacher;

public class JsonFactory {

    public static String serializeTeacherToJson(Teacher teacher) {
        AutoBean<Teacher> bean = AutoBeanUtils.getAutoBean(teacher);
        return AutoBeanCodex.encode(bean).getPayload();
    }
}
