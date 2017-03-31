package org.mainacad.db.register.service;


import lombok.Setter;
import org.mainacad.db.register.domain.Project;
import org.mainacad.db.register.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

        @Autowired
        @Setter
        private ProjectRepository projectRepository;

        @Override
        public Iterable<Project> listProjects() {
            return projectRepository.findAll();
        }

        @Override
        public Project addProject(Project project) {
            return projectRepository.save(project);
        }

        @Override
        public void deleteProject(long projectId) {
            projectRepository.delete(projectId);
        }

        @Override
        public Project getProject(long projectId) {
            return projectRepository.findOne(projectId);
        }

}
