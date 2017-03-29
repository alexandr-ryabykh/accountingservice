package org.mainacad.timemanager.controller;


import org.mainacad.timemanager.dao.impl.ProjectDaoImpl;
import org.mainacad.timemanager.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectController {


    @Autowired
    private ProjectDaoImpl projectDaoImpl;

    @Autowired
    public ProjectController(ProjectDaoImpl projectDaoImpl) {
        this.projectDaoImpl = projectDaoImpl;
    }

    @RequestMapping(value = "/tmprojects", method = RequestMethod.GET)
    public String listProjects(Model model) {
        model.addAttribute("projectAttribute", this.projectDaoImpl.listProjects());
        return "projectList";
    }

    @RequestMapping("tmprojects/new")
    public String addProject(Model model) {
        model.addAttribute("addNewProject", new Project());
        return "projectForm";
    }

    @RequestMapping(value = "projectAddProject", method = RequestMethod.POST)
    public String newProject(Project project) {
        this.projectDaoImpl.addProject(project);
        return "redirect:/tmprojects";
    }

    @RequestMapping("tmprojects/delete/{projectId}")
    public String deleteProject(@PathVariable long projectId) {
        this.projectDaoImpl.deleteProject(projectId);
        return "redirect:/tmprojects";
    }
    
}
