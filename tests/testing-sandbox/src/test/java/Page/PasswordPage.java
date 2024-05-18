package test.java.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By pwLoginLocator = By.xpath("//input[@id='password-input']");
    private By buttonSigninLocator = By.xpath("//button[@id='submit-button']");

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(pwLoginLocator));
        passwordInput.sendKeys(password);
    }

    public void clickSignin() {
        WebElement signinButton = wait.until(ExpectedConditions.elementToBeClickable(buttonSigninLocator));
        signinButton.click();
    }
}
