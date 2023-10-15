package practice2.todoist;

import org.openqa.selenium.By;
import practice2.control.Button;
import practice2.control.TextBox;

public class LoginSection {
    public TextBox emailInput = new TextBox(By.id("element-0"));
    public TextBox passwordInput =  new TextBox(By.id("element-3"));
    public Button confirmationButton =  new Button(By.xpath("//button[@data-gtm-id=\"start-email-login\"]"));
}
