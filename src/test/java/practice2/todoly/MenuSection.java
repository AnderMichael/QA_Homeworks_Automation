package practice2.todoly;

import org.openqa.selenium.By;
import practice2.control.Button;

public class MenuSection {

    public Button logoutButton = new Button(By.xpath("//a[text()='Logout']"));

    public Button settingsButton = new Button(By.xpath("//a[text()='Settings']"));

}
