package task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CreateEditProjectTest {
    ChromeDriver chrome;
    String proyectName = "Cookie Protocol";

    @BeforeEach
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        // implicit
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        chrome.get("http://todo.ly/");
    }

    @Test
    public void verifyCreateTest() throws InterruptedException {
        // click Login Button
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        // set Email
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("andersaurio@ander.com");
        // set Password
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("Standbyme1");
        // click Login
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        // Count similar elements before creation
        List<WebElement> similarElementsBefore = chrome.findElements(By.xpath(String.format("//td[text()='%s']", proyectName)));

        // click Add New Project
        chrome.findElement(By.xpath("//div[@class=\"AddProjectLiDiv\"]")).click();
        // set New Name Project in the correct input
        chrome.findElement(By.id("NewProjNameInput")).sendKeys(proyectName);
        // NewProjNameButton
        chrome.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(1000);

        // Count similar elements after creation
        List<WebElement> similarElementsAfter = chrome.findElements(By.xpath(String.format("//td[text()='%s']", proyectName)));
        //Final Verification
        Assertions.assertTrue(similarElementsBefore.size() < similarElementsAfter.size(),
                "ERROR no se pudo crear un proyecto");
    }

    @Test
    public void verifyEditTest() throws InterruptedException {
        String newProjectName = "Cookie Project";
        // click Login Button
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        // set Email
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("andersaurio@ander.com");
        // set Password
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("Standbyme1");
        // click Login
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        // The number of similar projects before edition
        List<WebElement> similarProjectsBefore = chrome.findElements(By.xpath(String.format("//td[text()='%s']", newProjectName)));

        List<WebElement> similarElements = chrome.findElements(By.xpath(String.format("//tr[td[@class='ProjItemContent' and text()='%s']]", proyectName)));
        WebElement lastProjectCreated = similarElements.get(similarElements.size() - 1);
        lastProjectCreated.click();
        lastProjectCreated.findElement(By.xpath(".//div[@class='ProjItemMenu']/img")).click();

        chrome.findElement(By.xpath("//ul[@id=\"projectContextMenu\"]/li[@class='edit']")).click();
        chrome.findElement(By.id("ItemEditTextbox")).clear();
        chrome.findElement(By.id("ItemEditTextbox")).sendKeys(newProjectName);
        chrome.findElement(By.id("ItemEditSubmit")).click();
        //
        Thread.sleep(1000);

        List<WebElement> similarProjectsAfter = chrome.findElements(By.xpath(String.format("//td[text()='%s']", newProjectName)));

        //Final Verification
        Assertions.assertTrue(similarProjectsBefore.size() < similarProjectsAfter.size(), "ERROR no se pudo editar un proyecto");
    }

    @AfterEach
    public void closeBrowser() {
        chrome.quit();
    }
}
