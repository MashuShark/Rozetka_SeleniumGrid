package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SmokeTests extends BaseTest {

    private final String UA_LANGUAGE_URL = "ua";
    private final String FILTER_BY_VENDOR = "Apple";

    @Test
    public void checkUrlContainsUaLanguage(){
        getHomePage().clickUaLanguageButton();
        assertTrue(getDriver().getCurrentUrl().contains(UA_LANGUAGE_URL));
    }

    @Test
    public void checkFilterResultContainsQuery(){
        getHomePage().clickCatalogButton();
        getHomePage().moveToSmartphones();
        getHomePage().clickOnSmartphonesButton();
        getSmartphonesPage().implicitWait(120);
        getSmartphonesPage().moveAndClickAppleFilter();
        getSmartphonesPage().waitLoadPage(120);
        for (WebElement element : getSmartphonesPage().getListAppleSmartphones()) {
            assertTrue(element.getText().contains(FILTER_BY_VENDOR));
        }
    }

    @Test
    public void checkThatItemAddedToCart(){
        getHomePage().clickCatalogButton();
        getHomePage().clickOnNotebooksButton();
        getHomePage().implicitWait(120);
        getNotebooksPage().moveAndClickOnAddToCartFirstItemButton();
        getNotebooksPage().implicitWait(120);
        int priceItem = getNotebooksPage().getPriceFirstItem();
        getHomePage().clickOnCartButton();
        getNotebooksPage().waitVisibilityOfElement(120, getCartPage().getCartWindow());
        int priceCart = getCartPage().getPrice();
        assertEquals(priceItem, priceCart);
    }
}
