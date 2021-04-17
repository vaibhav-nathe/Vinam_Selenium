package io.vinam.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashBoardPage {

    WebDriver driver;
    @FindBy(how = How.XPATH, using = "//*[@class='font-28 font-head breadcrumbs-title']")
    private WebElement DashBoard;
    @FindBy(how = How.XPATH, using = "//*[@class='ico-sidebar']")
    private WebElement MailerCloud;
    @FindBy(how = How.XPATH, using = "//*[text()='Automation']")
    private WebElement Automation;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void verifyPageName() {

        // WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.titleContains("Dashboard-Mailercloud"));
        String str = driver.getTitle();
        Assert.assertTrue(str.contains("Dashboard"));

    }


    public void clickAutomationLink() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(MailerCloud));
        Actions action = new Actions(driver);
        action.moveToElement(MailerCloud);
        action.moveToElement(Automation);
        Thread.sleep(3000);
        action.click().build().perform();

    }

}


