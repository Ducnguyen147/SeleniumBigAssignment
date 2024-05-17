package test.java;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;

import test.java.Page.AccountPage;
import test.java.Page.HomePage;
import test.java.Page.LoginPage;

import java.net.URL;
import java.util.Set;
import java.net.MalformedURLException;


public class SeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void Setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testSelenium() {
        this.driver.get("https://www.bbc.com/");

        //Static page test
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomeDisplayed());

        //Login
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("jioserinjs@gmail.com");
        loginPage.enterPassword("jio12345?");

        //Account page validation
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.isAccountDisplayed());

        //Sign out
        accountPage.signOut();

    }

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
