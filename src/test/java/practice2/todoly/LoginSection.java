package practice2.todoly;

import org.openqa.selenium.By;
import practice2.control.Button;
import practice2.control.TextBox;

public class LoginSection {
    // Define the elements we use in different sections
    public TextBox emailTextBox = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail"));
    public TextBox pwdTextBox = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword"));
    public Button loginButton = new Button(By.id("ctl00_MainContent_LoginControl1_ButtonLogin"));

}
