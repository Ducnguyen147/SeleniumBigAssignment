package test.java.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsernamePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By usernameLoginLocator = By.xpath("//input[@id='user-identifier-input']");
    private By continueButtonLocator = By.xpath("//button[@id='submit-button']");

    public UsernamePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void enterUsername(String username) {
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLoginLocator));
        usernameInput.sendKeys(username);
    }

    public void clickContinue() {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
        continueButton.click();
    }
}

