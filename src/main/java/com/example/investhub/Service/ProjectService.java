package com.example.investhub.Service;

import com.example.investhub.Model.Project;
import com.example.investhub.Model.User;
import com.example.investhub.Repository.ProjectRepository;
import com.example.investhub.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;

    public Project createProject(Project project) {
        // Add validation and business logic
        return projectRepository.save(project);
    }

    public Project getProjectByUser(Long userId) {
        Optional<User> u = userRepository.findById(userId);
        return projectRepository.findByProjectOwner(u.get())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Other project-related methods
}
