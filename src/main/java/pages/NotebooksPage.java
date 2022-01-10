package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NotebooksPage extends BasePage{

    @FindBy(xpath = "//button[@class='buy-button goods-tile__buy-button ng-star-inserted'][1]")
    private WebElement addToCartFirstItemButton;

    @FindBy(xpath = "//p[@class='ng-star-inserted']//span[@class='goods-tile__price-value'][1]")
    private WebElement priceFirstItem;

    public NotebooksPage(WebDriver driver) {
        super(driver);
    }

    private void moveToElement(WebElement element){
        Actions moveTo = new Actions(driver);
        moveTo.moveToElement(element);
        moveTo.perform();
    }

    public void moveAndClickOnAddToCartFirstItemButton(){
        moveToElement(addToCartFirstItemButton);
        addToCartFirstItemButton.click();
    }

    public int getPriceFirstItem(){
        return Integer.parseInt(priceFirstItem.getText().replaceAll("(\\d)\\s(\\d)", "$1$2"));
    }
}
