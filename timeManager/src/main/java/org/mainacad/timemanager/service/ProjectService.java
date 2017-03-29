package org.mainacad.timemanager.service;

import org.mainacad.timemanager.model.Project;

import java.util.List;


public interface ProjectService {


        public List<Project> listProjects();

        public Project addProject(Project project);

        public void deleteProject(long projectId);

        public Project getProject(long projectId);

}
