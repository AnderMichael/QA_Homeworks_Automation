package practice2.exercise3.testSuites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice2.session.Session;
import practice2.todoly.LoginSection;
import practice2.todoly.MainPage;
import practice2.todoly.MenuSection;
import practice2.todoly.SettingsSection;

public class FullNameTest {
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    MenuSection menuSection = new MenuSection();
    SettingsSection settingsSection = new SettingsSection();

    @BeforeEach
    public void open() {
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @AfterEach
    public void close() {
        Session.getInstance().closeSession();
    }

    @Test
    public void changeFullName() throws InterruptedException {
        String newFullName = "Andersaurio Cayman";

        // Entering web page and Settings Section
        login();
        menuSection.settingsButton.click();
        Thread.sleep(2000);
        Assertions.assertTrue(settingsSection.confirmationButton.isControlDisplayed(), "ERROR la sección SETTINGS no se abrió");

        // Setting a different value in fullName input and confirming changes
        settingsSection.fullNameBox.clearSetText(newFullName);
        Thread.sleep(2000);
        settingsSection.confirmationButton.click();
        Thread.sleep(2000);

        //Closing session and quit of the menu section
        menuSection.logoutButton.click();
        Thread.sleep(2000);

        // Opening a session again and SETTINGS section to visualize changes
        login();
        Thread.sleep(2000);
        menuSection.settingsButton.click();
        Thread.sleep(2000);

        Assertions.assertEquals(newFullName, settingsSection.fullNameBox.showText(), "ERROR el nombre no aparenta haber sido cambiado");
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
