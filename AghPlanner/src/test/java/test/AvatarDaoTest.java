package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.edu.agh.planner.Application;
import pl.edu.agh.planner.dao.AvatarDao;
import pl.edu.agh.planner.domain.AvatarEntity;
import pl.edu.agh.planner.dto.Foo;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class AvatarDaoTest {

  private AvatarDao avatarDao = new AvatarDao();

  @Test
  public void shouldSelectAllAvatars(){
    List<Foo> list = avatarDao.getList2();

    for(Foo avatar: list){
      System.out.println(avatar.toString());
    }

  }

  @Test
  public void shouldSelectAvatarsWithoutAggreagates(){
      List<AvatarEntity> list = avatarDao.getAvatarsWithoutAggregate();
      for(AvatarEntity avatarEntity : list){
        System.out.println("!!!!!!!!");
        System.out.println(avatarEntity.toString());
      }

  }
}
