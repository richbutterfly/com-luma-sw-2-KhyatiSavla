package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/** 4. Write down the following test into ‘LoginTest’
 class
 1. userShouldLoginSuccessfullyWithValid
 Credentials()
 * Click on ‘Sign In’ link
 * Enter valid Email
 * Enter valid Password
 * Click on ‘Sign In’ button
 * Verify the ‘Welcome’ text is display
 2. verifyTheErrorMessageWithInvalidCredentials
 * Click on ‘Sign In’ link
 * Enter valid Email
 * Enter valid Password
 * Click on ‘Sign In’ button
 * Verify the error message ‘The account sign-in was
 incorrect or your account is disabled temporarily. Please wait and try again
 later.’
 3. userShouldLogOutSuccessfully
 * Click on ‘Sign In’ link
 * Enter valid Email
 * Enter valid Password
 * Click on ‘Sign In’ button
 * Verify the ‘Welcome’ text is display
 * Click on down aero neare Welcome
 * Click on Sign Out link
 * Verify the text ‘You are signed out
 */
public class LoginTest extends BaseTest {

    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        // Find the Sign In link and click on it
        WebElement signIn = driver.findElement(By.xpath("//a[contains(@href, '/customer/account/login/referer/a')]"));
        signIn.click();
        // Find the Email field and enter valid email address
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("blackspider@ymail.com");
        // Find the password field and enter valid password
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("Spider_man");
        // Find 'SignIn' button and click on it to sign in
        WebElement signInBtn = driver.findElement(By.xpath("//button[@class = 'action login primary' and @name ='send' ]"));
        signInBtn.click();
        Thread.sleep(3000);
        //Verify the displayed Text
        String expectedText = "Welcome, Spider Black!";
        String actualText = driver.findElement(By.xpath("//li[@class  = 'greet welcome']")).getText();
        // Verify expectedText and actualText
       Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        //Click on 'Sign In' link
        driver.findElement(By.xpath("//a[contains(@href, '/customer/account/login/referer/a')]")).click();
        // Find the Email field and enter Invalid email address
        driver.findElement(By.id("email")).sendKeys("spider123@ymail.com");
        // Find the password field and enter Invalid password
        driver.findElement(By.id("pass")).sendKeys("spider_man");
        // Find the 'SignIn' button and click on it
        driver.findElement(By.xpath("//button[@class = 'action login primary' and @name ='send' ]")).click();
        // Verify the error message
        String expectedMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualMessage = driver.findElement(By.xpath("//div[contains(text(),'The account sign-in was incorrect or your account ')]")).getText();
        //Verify expected message and actual message displayed
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void userShouldLogOutSuccessfully() throws InterruptedException {
        //Click on 'Sign In' link
        driver.findElement(By.xpath("//a[contains(@href, '/customer/account/login/referer/a')]")).click();
        // Find the Email field and enter valid email address
        driver.findElement(By.id("email")).sendKeys("blackspider@ymail.com");
        // Find the password field and enter valid password
        driver.findElement(By.id("pass")).sendKeys("Spider_man");
        // Find 'SignIn' button and click on it to sign in
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
        //Verify the displayed Text
        String expectedText = "Welcome, Spider Black!";
        String actualText = driver.findElement(By.xpath("//span[text()='Welcome, Spider Black!']")).getText();
        // Verify expectedText and actualText
        Assert.assertEquals(expectedText,actualText);
        // Find the down aero near Welcome and click on it
        driver.findElement(By.xpath("//button[@class = 'action switch']")).click();
        Thread.sleep(3000);
        // Find the sign out link and click on it
        WebElement signOut = driver.findElement(By.xpath("//a[contains(text(), 'Sign Out')]"));
        signOut.click();
        // Verify the text after logged out
        String expectedDisplay= "You are signed out";
        String actualDisplay = driver.findElement(By.xpath("//span[text() = 'You are signed out']")).getText();
        Assert.assertEquals(expectedDisplay,actualDisplay);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
