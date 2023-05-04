package com.example.stacksourcewebservices.controller;

import com.example.stacksourcewebservices.entities.DigitalProfile;
import com.example.stacksourcewebservices.entities.Project;
import com.example.stacksourcewebservices.service.IDigitalProfileService;
import com.example.stacksourcewebservices.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/projects")
@CrossOrigin(origins = "*")
@Api(tags = "Projects", value = "Web Service RESTFul of Projects")
public class ProjectController {

    private final IProjectService projectService;
    private final IDigitalProfileService digitalProfileService;

    public ProjectController(IProjectService projectService, IDigitalProfileService digitalProfileService) {
        this.projectService = projectService;
        this.digitalProfileService = digitalProfileService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List all Projects", notes = "Method to list all Projects")
    @ApiResponses({
            @ApiResponse(code = 200, message = "All Projects founds"),
            @ApiResponse(code = 404, message = "Projects Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<List<Project>> findAllProjects(){
        try {
            List<Project> projects = projectService.getAll();
            if (projects.size() > 0){
                return new ResponseEntity<>(projects, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Project by Id", notes = "Method for finding an Project by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Project found by Id"),
            @ApiResponse(code = 404, message = "Project Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<Project> findProjectById(@PathVariable("id") Long id){
        try {
            Optional<Project> project = projectService.getById(id);
            if (!project.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else {
                return new ResponseEntity<>(project.get(), HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/digitalProfile/{id}" , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Insert Project", notes = "Method for inserting an Project")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Project created"),
            @ApiResponse(code = 404, message = "Project Not Created"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<Project> insertProject(@PathVariable("id") Long digitalProfileId , @RequestBody Project project){
        try {
             Optional<DigitalProfile> digitalProfile = digitalProfileService.getById(digitalProfileId);
                if (!digitalProfile.isPresent()){
                    return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
                }
                else {
                    project.setDigitalProfile(digitalProfile.get());
                    Project newProject = projectService.save(project);
                    return ResponseEntity.status(HttpStatus.CREATED).body(newProject);
                }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/digitalProfile/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Projects by Digital Profile Id", notes = "Method for finding Projects by Digital Profile id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Projects found by Digital Profile Id"),
            @ApiResponse(code = 404, message = "Projects Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<List<Project>> findProjectsByDigitalProfileId(@PathVariable("id") Long digitalProfileId){
        try {
            Optional<DigitalProfile> digitalProfile = digitalProfileService.getById(digitalProfileId);
            if (!digitalProfile.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else {
                List<Project> projects = projectService.findByDigitalProfileId(digitalProfileId);
                return new ResponseEntity<>(projects, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //delete project by id
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete Project by Id", notes = "Method for deleting an Project by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Project deleted by Id"),
            @ApiResponse(code = 404, message = "Project Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<Project> deleteProjectById(@PathVariable("id") Long id){
        try {
            Optional<Project> project = projectService.getById(id);
            if (!project.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else {
                projectService.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}