package tests;

import application.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestBase {
//    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));
//    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.EDGE));

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }
}
