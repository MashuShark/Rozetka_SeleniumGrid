package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//single-modal-window[@class='ng-star-inserted']")
    private WebElement cartWindow;


    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']/span")
    private WebElement price;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCartWindow(){
        return cartWindow;
    }

    public int getPrice(){
        return Integer.parseInt(price.getText());
    }


}
