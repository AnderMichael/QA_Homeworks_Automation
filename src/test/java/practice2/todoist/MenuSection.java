package practice2.todoist;

import org.openqa.selenium.By;
import practice2.control.Button;

public class MenuSection {
    public Button addTask = new Button(By.xpath("//button[@data-track=\"navigation|quick_add\"]"));
}
