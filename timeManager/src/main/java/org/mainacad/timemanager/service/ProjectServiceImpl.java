package org.mainacad.timemanager.service;

import org.mainacad.timemanager.dao.ProjectDao;
import org.mainacad.timemanager.model.Project;

import java.util.List;


public class ProjectServiceImpl implements ProjectService{


        private ProjectDao projectDao;

        public void setStudentDAO(ProjectDao projectDao) {
            this.projectDao = projectDao;
        }

        @Override
        public List<Project> listProjects() {
            return projectDao.listProjects();
        }

        @Override
        public Project addProject(Project project) {
            return projectDao.addProject(project);
        }

        @Override
        public void deleteProject(long projectId) {
            projectDao.deleteProject(projectId);
        }

        @Override
        public Project getProject(long projectId) {
            return null;
        }

}
