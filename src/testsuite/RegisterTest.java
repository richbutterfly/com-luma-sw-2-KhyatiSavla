package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

/**
 * 2. Create the package ‘testsuite’ and create the
 * following classes inside the ‘testsuite’ package.
 * 1. RegisterTest
 * 2. LoginTest
 * 3. SaleTest
 * 3. Write down the following test into ‘RegisterTest’
 * class
 * 1. verifyThatSignInPageDisplay
 * click on the ‘Create an Account’ link
 * Verify the text ‘Create New Customer Account’
 * 2. userSholdRegisterAccountSuccessfully
 * click on the ‘Create an Account’ link
 * Enter First name
 * Enter Last name
 * Click on checkbox Sign Up for Newsletter
 * Enter Emai
 * Enter Password
 * Enter Confirm Password
 * Click on Create an Account button
 * Verify the text 'Thank you for
 * registering with Main Website Store.’
 * Click on down aero neare Welcome
 * Click on Sign Out link
 * Verify the text ‘You are signed out’
 */
public class RegisterTest extends BaseTest {

    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyThatSignInPageDisplay() {
        // Find option 'Create an account' and click on it
        WebElement createAnAccount = driver.findElement(By.linkText("Create an Account"));
        createAnAccount.click();
        //Verify the actual text with expected text
        String expectedText = "Create New Customer Account";
        String actualText = driver.findElement(By.className("base")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
        driver.findElement(By.linkText("Create an Account")).click(); // Click on Create an account
        // Find first name field and enter first name
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("Black");
        // Find last name field and enter last name
        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys("Spider");
        //Find email field and enter email address
        WebElement email = driver.findElement(By.name("email"));
        Random randomEmail = new Random();
        int randomInt = randomEmail.nextInt(1000);
        email.sendKeys("spider" + randomInt+ "@gmail.com");
        // Find password field and enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Spider_man");
        // Find Confirm password field and enter password again
        WebElement confirmPassword = driver.findElement(By.name("password_confirmation"));
        confirmPassword.sendKeys("Spider_man");
        // Find Create an account field and click on it
        WebElement createAccount = driver.findElement(By.xpath("//button[@class = 'action submit primary']"));
        createAccount.click();
        // Verify expected text and actual text
        String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[@class = 'message-success success message']")).getText();
        Assert.assertEquals(expectedText, actualText);
        // Find the down aero near Welcome and click on it
        driver.findElement(By.xpath("//button[@class = 'action switch']")).click();
        Thread.sleep(3000);
        // Find the sign out link and click on it
        WebElement signOut = driver.findElement(By.linkText("Sign Out"));
        signOut.click();


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
