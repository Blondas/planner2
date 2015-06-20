package pl.edu.agh.planner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.planner.domain.ScheduleEntity;
import pl.edu.agh.planner.dto.Schedule;
import pl.edu.agh.planner.service.ScheduleService;
import pl.edu.agh.planner.utils.DtoEntityMapper;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(method=GET,value="/schedule")
    public Schedule getStudentGroup(@RequestParam("id") Long id){
        ScheduleEntity scheduleEntity = scheduleService.getById(id);
        return DtoEntityMapper.entityToSchedule(scheduleEntity);
    }

    @RequestMapping(method=GET,value="/schedules")
    public List<Schedule> findStudentGroups(){
        List<ScheduleEntity> scheduleEntities = scheduleService.getList();
        List<Schedule> schedules = scheduleEntities.stream().map(DtoEntityMapper::entityToSchedule).collect(Collectors.toList());

        return schedules;
    }

    @RequestMapping(method=DELETE,value="/schedule")
    public void deleteAvatar(@RequestBody Schedule schedule){
        ScheduleEntity scheduleEntity = DtoEntityMapper.scheduleToEntity(schedule);
        scheduleService.delete(scheduleEntity);
    }

    @RequestMapping(method=POST,value="/schedule")
    public Schedule saveOrUpdate(@RequestBody Schedule schedule){
        ScheduleEntity studentGroupEntity = DtoEntityMapper.scheduleToEntity(schedule);

        return DtoEntityMapper.entityToSchedule(scheduleService.saveOrUpdate(studentGroupEntity));
    }
}
