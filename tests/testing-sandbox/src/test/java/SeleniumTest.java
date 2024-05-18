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
import test.java.Page.NewsPage;
import test.java.Executor.JavaScriptExecutor;

import java.net.URL;
import java.util.Set;
import java.net.MalformedURLException;


public class SeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavaScriptExecutor jsExecutorHelper;

    @Before
    public void Setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, 10);
        jsExecutorHelper = new JavaScriptExecutor(driver);
    }

    @Test
    public void testSelenium() {
        this.driver.get("https://www.bbc.com/");

        //Static page test
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomeDisplayed());

        //Reading the page title
        System.out.println(homePage.getPageTitle()); //BBC Home - Breaking News, World News, etc.
        Assert.assertEquals(homePage.getPageTitle().contains("BBC Home"), true);

        //Hover to news
        homePage.hoverOverNewsElement();

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

        //Random data login
        homePage.clickLogin();
        String randomUsername = homePage.generateRandomString(10) + "@random.com";
        String randomPassword = homePage.generateRandomString(10);
        loginPage.enterUsername(randomUsername);
        Assert.assertTrue(loginPage.isWrongUsername());
        this.driver.get("https://www.bbc.com/");
    }

    @Test
    public void testMultiplePages() {
        String[] pages = {
            "https://www.bbc.com/news",
            "https://www.bbc.com/sport",
            "https://www.bbc.com/culture"
        };

        for (String page : pages) {
            this.driver.get(page);
            HomePage homePage = new HomePage(driver);
            System.out.println(homePage.getPageTitle());
            Assert.assertTrue(homePage.getPageTitle().contains("BBC"));
        }
    }

    @Test
    public void testBrowserHistory() {
        this.driver.get("https://www.bbc.com/");
        HomePage homePage = new HomePage(driver);
        NewsPage newsPage = new NewsPage(driver);

        // Navigate to News page
        newsPage.goToNewsPage();

        // Navigate back to Home page
        newsPage.navigateBack();
        Assert.assertTrue(homePage.isHomeDisplayed());
    }

    @Test
    public void testJavaScriptExecutor() {
        this.driver.get("https://www.bbc.com/");
        String pageTitle = jsExecutorHelper.getPageTitle();
        Assert.assertTrue(pageTitle.contains("BBC Home"));

        jsExecutorHelper.scrollToBottom();
    }

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
