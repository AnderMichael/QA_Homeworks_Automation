package practice2.exercise2.testSuites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice2.session.Session;
import practice2.todoist.LoginSection;
import practice2.todoist.MenuSection;


public class LoginTest {
    LoginSection loginSection = new LoginSection();
    MenuSection menuSection = new MenuSection();

    @BeforeEach
    public void open() {
        Session.getInstance().getBrowser().get("https://todoist.com/app/");
    }

    @AfterEach
    public void close() {
        Session.getInstance().closeSession();
    }

    @Test
    public void openingSession() throws InterruptedException {
        loginSection.emailInput.setText("andersaurio@ander.com");
        loginSection.passwordInput.setText("Standbyme1");
        loginSection.confirmationButton.click();

        Thread.sleep(5000);
        Assertions.assertTrue(menuSection.addTask.isControlDisplayed(), "ERROR no se abrió una sessión en Todoist");
    }
}
