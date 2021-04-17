package io.vinam.webpages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPage {

	private static final DateTimeFormatter DATE_FORMAT_CALENDAR = DateTimeFormatter.ofPattern("MMM yyyy dd");
    WebDriver driver;
    @FindBy(how = How.XPATH, using = "//*[text()='Create automation']")
    private WebElement CreateButton;
    @FindBy(how = How.XPATH, using = "//*[@class='col-auto']/*[@class='font-28 font-head breadcrumbs-title']")
    private WebElement CreateAutomation;
    @FindBy(how = How.ID, using = "name")
    private WebElement Name;
    @FindBy(how = How.XPATH, using = "//*[text()='Choose your target']")
    private WebElement ChoseTarget;
    @FindBy(how = How.XPATH, using = "//*[text()=' Choose your target ']")
    private WebElement ChoseYourTarget;
    @FindBy(how = How.CSS, using = "label.custom-control-label:after")
    private WebElement SelectOption;
    @FindBy(how = How.XPATH, using = "//*[@class='btn btn-primary']")
    private WebElement SelectContinue;
    @FindBy(how = How.XPATH, using = "//*[text()='Add Campaign']")
    private WebElement ClickCampaignButton;
    @FindBy(how = How.XPATH, using = "//div[@name='end date']")
    private WebElement SelectEndDate;
    @FindBy(how = How.XPATH, using = "//*[@class='cell day'][6]")
    private WebElement ClickDate;
    @FindBy(how = How.XPATH, using = "//*[@class='btn btnw-170 btn-primary']")
    private WebElement ClickContinue;
    @FindBy(how = How.XPATH, using = "//*[@id='modalAutomationCampaign___BV_modal_header_']")
    private WebElement ChoseYoursTarget;
    @FindBy(how = How.XPATH, using = "//*[text()='Create new']")
    private WebElement ClickCreateNewButton;
    @FindBys(@FindBy(how = How.XPATH, using = "//span[@class='day__month_btn up']/following-sibling::span"))
    private List<WebElement> calendarNextArrows;
    @FindBys(@FindBy(how = How.XPATH, using = "//div[@class='vdp-datepicker cstm_inline']"))
    private List<WebElement> calendars;

    public AutomationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCreateButton() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(CreateButton));
        CreateButton.click();
    }

    public void verifyPageName() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(CreateAutomation));
    }

    public void enterName(String name) {

        Name.sendKeys(name);
    }

    public void clickChoseTarget() {
        ChoseTarget.click();
    }

    public void verifyChoseTarget() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements((ChoseYourTarget)));

    }

    public void clickOptionFromList() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) (driver)).executeScript("document.querySelector('label.custom-control-label', ':after').click();");

        //SelectOption.click();

    }

    public void clickContinueButton() {
        SelectContinue.click();

    }

	/*
	 * public void clickEndDate() { WebDriverWait wait = new WebDriverWait(driver,
	 * 20); wait.until(ExpectedConditions.elementToBeClickable(SelectEndDate));
	 * SelectEndDate.click(); String text =
	 * driver.findElement(By.xpath("//*[@class='day__month_btn up']")).getText();
	 * System.out.println(text); driver.findElement(By.xpath(
	 * "//*[@id=\"app\"]/div/section/div[2]/div[1]/div/div[3]/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/span[33]"
	 * )).click();
	 * 
	 * }
	 * 
	 * public void selectDate() { Actions action = new Actions(driver);
	 * action.moveToElement(ClickDate); action.click().build().perform();
	 * 
	 * }
	 */
    public void clickStartDate(String date) {
        final WebElement endDate = calendars.get(0);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", endDate);
        endDate.click();
        LocalDate dateToCheck = LocalDate.from(DATE_FORMAT_CALENDAR.parse(date));
        LocalDate tempCurrentDate = LocalDate.now().withDayOfMonth(1);
        long noOfMonths = ChronoUnit.MONTHS.between(tempCurrentDate, dateToCheck);
        for (int i = 0; i < noOfMonths; i++) {
            calendarNextArrows.get(0).click();
        }
        driver.findElements(By.xpath("//span[contains(@class,'cell day')  and text()='" + dateToCheck.getDayOfMonth() + "']")).get(0).click();
    }

    public void clickStartDate(int daysToAdd) {
        final String startDate = LocalDate.now().plusDays(daysToAdd).format(DATE_FORMAT_CALENDAR);
        clickStartDate(startDate);
    }

    public void clickEndDate(String date) {
        final WebElement endDate = calendars.get(1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", endDate);
        endDate.click();
        LocalDate dateToCheck = LocalDate.from(DATE_FORMAT_CALENDAR.parse(date));
        LocalDate tempCurrentDate = LocalDate.now().withDayOfMonth(1);
        long noOfMonths = ChronoUnit.MONTHS.between(tempCurrentDate, dateToCheck);
        for (int i = 0; i < noOfMonths; i++) {
            calendarNextArrows.get(1).click();
        }
        driver.findElements(By.xpath("//span[contains(@class,'cell day')  and text()='" + dateToCheck.getDayOfMonth() + "']")).get(1).click();
    }

    public void clickEndDate(int daysToAdd) {
        final String endDate = LocalDate.now().plusDays(daysToAdd).format(DATE_FORMAT_CALENDAR);
        clickEndDate(endDate);
    }
    public void clickContinue() {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(ClickContinue));
        ClickContinue.click();

    }
    public void clickAddCampaignButton() {
    	 WebDriverWait wait = new WebDriverWait(driver, 20);
         wait.until(ExpectedConditions.elementToBeClickable(ClickCampaignButton));

    	ClickCampaignButton.click();
    }
    public void verifyChoseYourTarget() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements((ChoseYoursTarget)));

    }
    public void clickOnCreateNewButton() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(ClickCreateNewButton));
        ClickCreateNewButton.click();
    }

}
