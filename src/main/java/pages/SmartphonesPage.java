package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SmartphonesPage extends BasePage{

    @FindBy(xpath = "//a[@data-id='Apple']")
    private WebElement appleFilter;

    @FindBy(xpath = "//span[@class='goods-tile__title']")
    private List<WebElement> listAppleSmartphones;

    public SmartphonesPage(WebDriver driver) {
        super(driver);
    }

    private void moveToElement(WebElement element){
        Actions moveTo = new Actions(driver);
        moveTo.moveToElement(element);
    }

    public void moveAndClickAppleFilter(){
        moveToElement(appleFilter);
        appleFilter.click();
    }

    public List<WebElement> getListAppleSmartphones(){
        return listAppleSmartphones;
    }
}

