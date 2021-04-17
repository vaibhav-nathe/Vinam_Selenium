package io.vinam.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "input-3")
    private WebElement Email;
    @FindBy(how = How.ID, using = "input-5")
    private WebElement Password;
    @FindBy(how = How.XPATH, using = "//*[@type='submit']")
    private WebElement Login;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        Email.sendKeys(email);

    }

    public void enterPassword(String password) {
        Password.sendKeys(password);

    }

    public void clickLoginButton() {
        Login.click();

    }

}
