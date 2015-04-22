package utils;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edu.agh.planner.server.controllers.AvatarController;
import pl.edu.agh.planner.server.controllers.TeacherController;

@ContextConfiguration(locations = {
        "classpath:controllerContext.xml",
        "classpath:daoContext.xml",
        "classpath:serviceContext.xml",
        "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class DefaultTest {

    @Autowired
    protected TeacherController teacherController;

    @Autowired
    protected AvatarController avatarController;
}
