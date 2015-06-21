package pl.edu.agh.planner.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.planner.CreateDatabaseWithRelations;
import pl.edu.agh.planner.CreateDatabaseWithoutRelations;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
public class DatabaseController {

    @RequestMapping(method = GET, value = "/createDatabaseWithoutRelations")
    public void createDatabaseWithoutRelations() {
        CreateDatabaseWithoutRelations createDatabaseWithoutRelations = new CreateDatabaseWithoutRelations();
        createDatabaseWithoutRelations.contextLoads();

    }

    @RequestMapping(method = GET, value = "/createDatabaseWithRelations")
    public void createDatabaseWithRelations() {
        CreateDatabaseWithRelations createDatabaseWithRelations = new CreateDatabaseWithRelations();
        createDatabaseWithRelations.create();
    }
}


