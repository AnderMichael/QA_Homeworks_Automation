package practice2.exercise1.testSuites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice2.todoly.*;
import practice2.session.Session;

public class ProjectItemTest {
    String nameProject = "Salchipapas con Jamon";
    String nameItem = "Papitas con sabor a yuca";
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    ProjectsSection projectsSection = new ProjectsSection();
    ItemsSection itemsSection = new ItemsSection();

    @AfterEach
    public void close() {
        Session.getInstance().closeSession();
    }

    @BeforeEach
    public void open() {
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @Test
    public void createProject() throws InterruptedException {
        login();
        projectsSection.addProjectButton.click();
        projectsSection.textBoxProjectName.setText(nameProject);
        projectsSection.addButton.click();

        Thread.sleep(1000);

        int lastProjectIndex = projectsSection.getProjects(nameProject).size();
        Assertions.assertEquals(nameProject, projectsSection.getProjects(nameProject).get(lastProjectIndex - 1).getName(), "ERROR proyecto creado no encontrado!");
    }

    @Test
    public void createItem() throws InterruptedException {
        login();

        int lastProjectIndex = projectsSection.getProjects(nameProject).size();
        projectsSection.getProjects(nameProject).get(lastProjectIndex - 1).click();

        itemsSection.newItemInput.setText(nameItem);
        itemsSection.newItemButton.click();

        Thread.sleep(3000);

        int lastItemIndex = itemsSection.getItems(nameItem).size();
        Assertions.assertEquals(nameItem, itemsSection.getItems(nameItem).get(lastItemIndex - 1).getName(), "ERROR item creado no encontrado!");
    }

    @Test
    public void updateItem() throws InterruptedException {
        login();
        String newItemName = "Arroz con sabor a fideo!";
        int lastProjectIndex = projectsSection.getProjects(nameProject).size();
        projectsSection.getProjects(nameProject).get(lastProjectIndex - 1).click();

        int lastItemIndex = itemsSection.getItems(nameItem).size();
        itemsSection.getItems(nameItem).get(lastItemIndex - 1).click();

        itemsSection.newItemNameInput.clearSetText(newItemName);
        Thread.sleep(3000);

        Assertions.assertEquals(newItemName, itemsSection.getItems(newItemName).get(lastItemIndex - 1).getName(), "ERROR item modificado no encontrado!");

    }

    public void login() {
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText("andersaurio@ander.com");
        loginSection.pwdTextBox.setText("Standbyme1");
        loginSection.loginButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR al iniciar sesion");
    }
}
