package practice2.session;

import org.openqa.selenium.WebDriver;
import practice2.factoryBrowsers.FactoryBrowser;

import java.time.Duration;

public class Session {
    private static Session session;
    private WebDriver browser;
    private Session(){
        browser = FactoryBrowser.make("chrome").create();
        // Browser needs to ocupate all the screen once initialized
        browser.manage().window().maximize();
        // An implicit time to run tests
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

    }

    public static Session getInstance(){
        // Create a new instance if it is necessary
        if(session == null){
            session =  new Session();
        }
        return session;
    }

    // To interact with browser elements
    public WebDriver getBrowser(){
        return browser;
    }

    public void closeSession(){
        // Erase session from memory to start another
        browser.quit();
        session = null;
    }
}
