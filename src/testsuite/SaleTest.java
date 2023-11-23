package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * 5.Write down the following test into ‘SaleTest’ class
 * 1. verifyTheTotalItemsDisplayedOnTheWomensJacketsPage()
 * Click on ‘Sale’ Menu tab
 * Click on ‘Jackets’ link on left side
 * under WOMEN’S DEAL Category
 * Verify the text ‘Jackets’ is displayed
 * Count the Total Item Displayed on Page
 * and print the name of all items into
 * console.
 * Verify total 12 Items displayed on page
 */
public class SaleTest extends BaseTest {
    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        // Find the sales menu and click on it
        driver.findElement(By.linkText("Sale")).click();
        //Find 'Jackets' option on the left side under women's deal and click on it
        driver.findElement(By.xpath("//a[@href = 'https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html' and text() = 'Jackets']")).click();
        String expectedText = "Jackets";
        String actualText = driver.findElement(By.xpath("//span[@class = 'base']")).getText();
        // Validate expected and actual text
        Assert.assertEquals(expectedText, actualText);

        // Count total items displayed on the page and print item names in console
        int expectedNoItems = 12;
        List<WebElement> itemsList = driver.findElements(By.xpath("//a [@class='product-item-link']"));
        int actualNoItems = itemsList.size();
        for (WebElement items : itemsList) {
            System.out.print(items.getText());
        }
        // Verify expected No. of items and actual No. of items must be same
        Assert.assertEquals(expectedNoItems, actualNoItems);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
