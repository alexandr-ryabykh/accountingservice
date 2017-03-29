package org.mainacad.timemanager.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mainacad.timemanager.dao.ProjectDao;
import org.mainacad.timemanager.dao.ProjectDao;
import org.mainacad.timemanager.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProjectDaoImpl implements ProjectDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Project> listProjects() {
        List<Project> projectList;
        try (Session session = this.sessionFactory.openSession()) {
            projectList = session.createCriteria(Project.class).list();
        }
        return projectList;
    }

    @Override
    public Project addProject(Project project) {

        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(project);
            session.getTransaction().commit();

        }

        return project;
    }

    @Override
    public void deleteProject(long projectId) {


        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();
            Project project = session.get(Project.class, projectId);
            session.delete(project);
            session.getTransaction().commit();
        }

    }

    @Override
    public Project getProject(long projectId) {
        return null;
    }
}

