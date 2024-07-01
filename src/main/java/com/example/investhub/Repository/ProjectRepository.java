package com.example.investhub.Repository;

import com.example.investhub.Model.Project;
import com.example.investhub.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Optional<Project> findByUser(Optional<User> user);
}
