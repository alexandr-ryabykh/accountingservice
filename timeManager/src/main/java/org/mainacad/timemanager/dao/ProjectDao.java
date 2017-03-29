package org.mainacad.timemanager.dao;

import org.mainacad.timemanager.model.Project;
import org.mainacad.timemanager.model.User;

import java.util.List;


public interface ProjectDao {


        public List<Project> listProjects();

        public Project addProject(Project project);

        public void deleteProject(long projectId);

        public Project getProject(long projectId);



}
