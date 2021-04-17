package io.vinam.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCampaignPage {
	  WebDriver driver;
	    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Create Campaign']")
	    private WebElement CreateCampaign;
	    @FindBy(how = How.XPATH, using = "//*[@id='name']")
	    private WebElement EnterCampaignName;
	    @FindBy(how = How.XPATH, using = "//*[@id='subject']")
	    private WebElement EnterSubject;
	    @FindBy(how = How.XPATH, using = "//input[@id='sname']")
	    private WebElement SenderName;
	    @FindBy(how = How.XPATH, using = "//*[@class='v-select add-sender-v-select vs--single vs--searchable']")
	    private WebElement FormId;
	    @FindBy(how = How.XPATH, using = "//button[text()='Choose email template']")
	    private WebElement ChoseEmailTemplate;
	    @FindBy(how = How.XPATH, using = "//h2[text()='Choose template']")
	    private WebElement ChoseTemplate;
	    @FindBy(how = How.XPATH, using = "//*[@class='template-list-ul list-inline']/li[3]")
	    private WebElement ToyTemplate;
	    @FindBy(how = How.XPATH, using = "//*[@class='btn btnw-170 mr-3 btn-primary']")
	    private WebElement ClickContinue;
	    @FindBy(how = How.XPATH, using = "//*[@class='ml-auto col-auto']/*[contains(text(),'Continue')]")
	    private WebElement ClickCampaignContinue;
	    @FindBy(how = How.XPATH, using = "//*[@class='btn btnw-170 btn-primary']")
	    private WebElement ClickPublish;
	    @FindBy(how = How.XPATH, using = "//h2[text()='Rock on']")
	    private WebElement RockOn;
	    public CreateCampaignPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    public void verifyCreateCampaignt() {

	        WebDriverWait wait = new WebDriverWait(driver, 20);
	        wait.until(ExpectedConditions.visibilityOfAllElements((CreateCampaign)));
	    }
	    public void enterCampaignName(String name) {
	    	EnterCampaignName.sendKeys(name);
	    }
	    public void enterSubjectLine(String line) {
	    	EnterSubject.sendKeys(line);
	    }
	    public void enterSenderName(String name) throws Exception {
	    	Thread.sleep(3000);
	    	SenderName.sendKeys(name);
	    }
	    public void clickFormId() throws InterruptedException {
	    	FormId.click();
	    	Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='senderId']")).sendKeys("vaibhav.nathe@rediffmail.com"+Keys.ENTER);
	    }
	    public void clickChoseEmailTemplate() {
	    	ChoseEmailTemplate.click();
	    } 
	    public void verifyChoseTemplate() {

	        WebDriverWait wait = new WebDriverWait(driver, 20);
	        wait.until(ExpectedConditions.visibilityOfAllElements((ChoseTemplate)));
	    }
	    public void selectTemplate() {
	    	 WebDriverWait wait = new WebDriverWait(driver, 20);
	         wait.until(ExpectedConditions.elementToBeClickable(ToyTemplate));
	    	ToyTemplate.click();
	    } 
	    public void clickContinueButton() throws InterruptedException {
	    	 WebDriverWait wait = new WebDriverWait(driver, 20);
	         wait.until(ExpectedConditions.elementToBeClickable(ClickContinue));
	    	ClickContinue.click();
	    }
	    public void clickCreateCampaignContinueButton() {
	    	WebDriverWait wait = new WebDriverWait(driver, 20);
	         wait.until(ExpectedConditions.elementToBeClickable(ClickCampaignContinue));
	    	ClickCampaignContinue.click();
	    }
	    public void clickAgainContinue() {
	    	WebDriverWait wait = new WebDriverWait(driver, 20);
	         wait.until(ExpectedConditions.elementToBeClickable(ClickCampaignContinue));
	    	ClickCampaignContinue.click();
	    }
	    public void clickPublish() {
	    	 WebDriverWait wait = new WebDriverWait(driver, 20);
	         wait.until(ExpectedConditions.elementToBeClickable(ClickPublish));
	    	ClickPublish.click();
	    }
	    public boolean VerifyRockOn() throws InterruptedException {
	    	Thread.sleep(6000);
	    	String str = driver.findElement(By.xpath("//h2[text()='Rock on']")).getText();
	    	return RockOn.isDisplayed();
	    }
}
