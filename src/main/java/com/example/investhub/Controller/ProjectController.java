package com.example.investhub.Controller;

import com.example.investhub.Model.Project;
import com.example.investhub.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.createProject(project));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Project> getProjectBySymbol(@PathVariable Long userId) {
        return ResponseEntity.ok(projectService.getProjectByUser(userId));
    }

    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    // Other project-related endpoints
}
