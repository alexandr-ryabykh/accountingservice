package org.mainacad.db.register.service;



import org.mainacad.db.register.domain.Project;

import java.util.List;


public interface ProjectService {


        public Iterable<Project> listProjects();

        public Project addProject(Project project);

        public void deleteProject(long projectId);

        public Project getProject(long projectId);

}
