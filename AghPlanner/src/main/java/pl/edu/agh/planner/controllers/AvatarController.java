package pl.edu.agh.planner.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.planner.domain.AvatarEntity;
import pl.edu.agh.planner.domain.TeacherEntity;
import pl.edu.agh.planner.dto.Avatar;
import pl.edu.agh.planner.dto.Teacher;
import pl.edu.agh.planner.service.AvatarService;
import pl.edu.agh.planner.service.TeacherService;
import pl.edu.agh.planner.utils.DtoEntityMapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class AvatarController {

    @Autowired
    private AvatarService avatarService;

    @Autowired
    private TeacherService teacherService;


    @RequestMapping(method=GET,value="/avatar")
    public Avatar getTeacher(@RequestParam("id") Long id){
        AvatarEntity avatarEntity = avatarService.getById(id);
        return DtoEntityMapper.entityToAvatar(avatarEntity);
    }

    @RequestMapping(method=GET,value="/avatars")
    public List<Avatar> findAvatars(){
        List<AvatarEntity> avatarEntity = avatarService.getList();
        List<Avatar> avatars = avatarEntity.stream().map(DtoEntityMapper::entityToAvatar).collect(Collectors.toList());

        return avatars;
    }

    @RequestMapping(method=DELETE,value="/avatar")
    public void deleteAvatar(@RequestBody Avatar avatar){
        AvatarEntity avatarEntity = DtoEntityMapper.avatarToEntity(avatar);
        avatarService.delete(avatarEntity);
    }

    @RequestMapping(method=POST,value="/avatar")
    public Avatar saveOrUpdate(@RequestBody Avatar avatar){
        AvatarEntity avatarEntity = DtoEntityMapper.avatarToEntity(avatar);

        Set<TeacherEntity> teacherSet = avatarEntity.getTeachers();
        for(TeacherEntity teacherEntity: teacherSet){
            teacherEntity.setAvatar(avatarEntity);
            teacherService.saveOrUpdate(teacherEntity);
        }
//        avatarEntity.setTeachers(teacherSet);
        return DtoEntityMapper.entityToAvatar(avatarService.saveOrUpdate(avatarEntity));
//        return new ResponseEntity(HttpStatus.OK);
    }
}
