package io.vinam.base;

import io.vinam.webpages.AutomationPage;
import io.vinam.webpages.CreateCampaignPage;
import io.vinam.webpages.DashBoardPage;
import io.vinam.webpages.LoginPage;
import io.vinam.webpages.PropertiesUtiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    protected LoginPage login;
    protected DashBoardPage board;
    protected AutomationPage automation;
    protected CreateCampaignPage createcampaign;
    protected Properties properties;
    public static Logger log;
 

    @Parameters({"env"})
    @BeforeMethod
    public void setUp(@Optional("SIT") String env) throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\eclipse_workspace\\Selenium\\io.vinam\\src\\test\\resources\\executable\\chromedriver.exe");
        driver = new ChromeDriver();
        login = new LoginPage(driver);
        board = new DashBoardPage(driver);
        automation = new AutomationPage(driver);
        createcampaign = new CreateCampaignPage(driver);
        properties = PropertiesUtiles.loadPropertiesFile(env);
        log = LogManager.getLogger("devp");
        
        
        driver.get(properties.getProperty("Url"));
        driver.manage().window().maximize();
        log.info("Browser Opened !!");
        login = PageFactory.initElements(driver, LoginPage.class);
    }

	
	  @AfterMethod public void tearDown() { if (driver != null) { driver.quit(); }
	  log.debug("Test Execution Completed"); }
	 
}
