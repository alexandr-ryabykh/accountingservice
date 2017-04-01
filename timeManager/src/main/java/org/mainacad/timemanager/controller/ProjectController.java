package org.mainacad.timemanager.controller;

import lombok.Setter;
import org.mainacad.db.register.domain.Project;
import org.mainacad.db.register.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectController {

    @Autowired
    @Setter
    private ProjectService projectService;

    @RequestMapping(value = "/tmprojects", method = RequestMethod.GET)
    public String listProjects(Model model) {
        model.addAttribute("projectAttribute", this.projectService.listProjects());
        return "projectList";
    }

    @RequestMapping("tmprojects/new")
    public String addProject(Model model) {
        model.addAttribute("addNewProject", new Project());
        return "projectForm";
    }

    @RequestMapping(value = "projectAddProject", method = RequestMethod.POST)
    public String newProject(Project project) {
        this.projectService.addProject(project);
        return "redirect:/tmprojects";
    }

    @RequestMapping("tmprojects/delete/{projectId}")
    public String deleteProject(@PathVariable long projectId) {
        this.projectService.deleteProject(projectId);
        return "redirect:/tmprojects";
    }

}
