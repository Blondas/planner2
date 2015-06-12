package pl.edu.agh.planner.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.planner.domain.AvatarEntity;
import pl.edu.agh.planner.dto.Avatar;
import pl.edu.agh.planner.service.AvatarService;
<<<<<<< HEAD
=======
import pl.edu.agh.planner.service.AvatarServiceImpl;
>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6
import pl.edu.agh.planner.utils.DtoEntityMapper;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class AvatarController {

    @Autowired
    private AvatarService avatarService;


    @RequestMapping(method=GET,value="/avatar")
    public Avatar getTeacher(@RequestParam("id") Long id){
<<<<<<< HEAD
        AvatarEntity avatarEntity = avatarService.getById(id);
=======
        AvatarEntity avatarEntity = avatarService.getOne(id);
>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6
        return DtoEntityMapper.entityToAvatar(avatarEntity);
    }

    @RequestMapping(method=GET,value="/avatars")
    public List<Avatar> findAvatars(){
<<<<<<< HEAD
        List<AvatarEntity> avatarEntity = avatarService.getList();
        List<Avatar> avatars = avatarEntity.stream().map(DtoEntityMapper::entityToAvatar).collect(Collectors.toList());
=======
        List<AvatarEntity> teacherEntity = avatarService.findAll();
        List<Avatar> avatars = teacherEntity.stream().map(DtoEntityMapper::entityToAvatar).collect(Collectors.toList());
>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6

        return avatars;
    }

    @RequestMapping(method=DELETE,value="/avatar")
<<<<<<< HEAD
    public void deleteAvatar(@RequestBody Avatar avatar){
        AvatarEntity avatarEntity = DtoEntityMapper.avatarToEntity(avatar);
        avatarService.delete(avatarEntity);
=======
    public void deleteAvatar(@RequestParam("id") Long teacherId){
        avatarService.delete(teacherId);
>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6
    }

    @RequestMapping(method=POST,value="/avatar")
    public Avatar saveOrUpdate(@RequestBody Avatar avatar){
        AvatarEntity avatarEntity = DtoEntityMapper.avatarToEntity(avatar);

        return DtoEntityMapper.entityToAvatar(avatarService.saveOrUpdate(avatarEntity));
    }
<<<<<<< HEAD
=======


>>>>>>> bcb0c636d15f156ae24142734a9613f33aca3fa6
}
