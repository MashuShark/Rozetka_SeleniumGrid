package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//li[@class='lang__item lang-header__item ng-star-inserted']//a[@class='lang__link ng-star-inserted']")
    private WebElement uaLanguageButton;

    @FindBy(xpath = "//button[@id='fat-menu']")
    private WebElement catalogButton;

    @FindBy(xpath = "//div[@class='menu-wrapper menu-wrapper_state_animated']//a[contains(@href,'telefony')][contains(text(),'Смартфоны')]")
    private WebElement smartphonesCatalog;

    @FindBy(xpath = "//a[@class='menu__link'][contains(text(),'Смартфоны')]")
    private WebElement smartphonesButton;

    @FindBy(xpath = "//div[@class='menu__hidden-column ng-star-inserted']//a[text()='Ноутбуки']")
    private WebElement notebooksButton;

    @FindBy(xpath = "//button[@class='header__button ng-star-inserted header__button--active']")
    private WebElement cartButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickUaLanguageButton(){
        uaLanguageButton.click();
    }

    public void clickCatalogButton(){
        catalogButton.click();
    }

    private void moveToElement(WebElement element){
        Actions moveTo = new Actions(driver);
        moveTo.moveToElement(element);
        moveTo.perform();
    }

    public void moveToSmartphones(){
        moveToElement(smartphonesCatalog);
    }

    public void clickOnSmartphonesButton(){
        smartphonesButton.click();
    }

    public void clickOnNotebooksButton(){
        notebooksButton.click();
    }

    public void clickOnCartButton(){
        cartButton.click();
    }



}
