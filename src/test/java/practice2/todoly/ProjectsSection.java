package practice2.todoly;

import org.openqa.selenium.By;
import practice2.control.Button;
import practice2.control.Project;
import practice2.control.Projects;
import practice2.control.TextBox;

import java.util.ArrayList;
import java.util.List;

public class ProjectsSection {

    public Button addProjectButton = new Button(By.xpath("//div[@class=\"AddProjectLiDiv\"]"));
    public TextBox textBoxProjectName = new TextBox(By.id("NewProjNameInput"));
    public Button addButton = new Button(By.id("NewProjNameButton"));

    private Projects projects;

    public List<Project> getProjects(String projectName){
        projects =  new Projects(By.xpath(String.format("//td[text()='%s']", projectName)));
        return projects.getList();
    }
}
