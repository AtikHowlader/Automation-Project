package Reusable_Library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable_Methods {

    static int timeout = 10;

    public static WebDriver getDriver(){
        //set the chrome drive location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set driver to be maximized (doesn't work on mac)
        //options.addArguments("start-maximized");

        //set the driver to incognito mode(private) (doesn't work on mac)
        options.addArguments("incognito");
        //run in headless mode
        //options.addArguments("headless");

        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }//end of get driver

    //reusable method to click on websites
    public static void click(WebDriver driver, String locator, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("Clicking on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
        } catch (Exception err) {
            System.out.println("Unable to click on element" + err);
        }//end of exception

    }//end of click method

    //reusable method to type on any element on websites
    public static void sendKeys(WebDriver driver, String locator, String userValue, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("Typing on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception err) {
            System.out.println("Unable to type on element" + err);
        }//end of exception
    }//end of sendkeys method

    public static void submit(WebDriver driver, String locator, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("Submitting on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).submit();
        } catch (Exception err) {
            System.out.println("Unable to submit on element" + err);
        }//end of exception
    }//end of submit method

    public static String capturingText(WebDriver driver, String locator, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String captureText = "";
        try {
            System.out.println("Capturing text " + elementName);
            captureText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
            System.out.println(captureText);
        } catch (Exception err){
            System.out.println("Unable to capture text " + err);
        }//end of capture text exception
        return captureText;
    }//end of capture text method

    public static void selectDropDown(WebDriver driver, String locator, String dropDownOptions, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("Selecting in a dropdown " + elementName);
            WebElement ddMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select dropDown = new Select(ddMenu);
            dropDown.selectByVisibleText(dropDownOptions);
        } catch (Exception err) {
            System.out.println("Unable to select from dropdown " + err);
        }//end of select from dropdown exception
    }//end of select dropdown method

    public static void clickByIndex(WebDriver driver,String locator,int index, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            System.out.println("Clicking by index " + index + " on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click by index " + index +  " on element " + elementName + " " + e);
        }
    }//end of click by index method

    public static void typeAndSubmit(WebDriver driver,String locator, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            Thread.sleep(1000);
            element.sendKeys(Keys.ENTER); //this is another way to submit to an element using key event
        } catch (Exception e) {
            System.out.println("Unable to enter on element " + elementName + " " + e);
        }
    }//end of type and submit method

    //method to click on an element
    public static void mouseClick(WebDriver driver,String locator,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions(driver);
        try{
            System.out.println("Mouse clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to mouse click element " + elementName + " " + e);
        }//end of exception
    }//end of click method
}//end of class

