package practice2.todoly;

import org.openqa.selenium.By;
import practice2.control.Button;
import practice2.control.TextBox;

public class SettingsSection {
    public TextBox fullNameBox = new TextBox(By.id("FullNameInput"));
    public Button confirmationButton = new Button(By.xpath("//span[@class='ui-button-text' and text()='Ok']"));
}
