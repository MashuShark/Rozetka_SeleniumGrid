package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.CartPage;
import pages.HomePage;
import pages.NotebooksPage;
import pages.SmartphonesPage;
import utils.CapabilityFactory;


import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();// ThreadLocal позволяет нам хранить данные, которые будут доступны только конкретным потоком. Каждый поток будет иметь свой собственный экземпляр ThreadLocal
    private CapabilityFactory capabilityFactory = new CapabilityFactory();

    private static final String ROZETKA_URL = "https://rozetka.com.ua";

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://192.168.1.102:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        getDriver().manage().window().maximize();
        getDriver().get(ROZETKA_URL);
    }


    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }

    @AfterClass
    void terminate() {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public HomePage getHomePage(){
        return new HomePage(getDriver());
    }

    public SmartphonesPage getSmartphonesPage(){
        return new SmartphonesPage(getDriver());
    }

    public NotebooksPage getNotebooksPage(){
        return new NotebooksPage(getDriver());
    }
    public CartPage getCartPage(){
        return new CartPage(getDriver());
    }
}
