package Day9_09272020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class USPS_Mouse_Movement {

    public static void main(String[] args) throws InterruptedException {

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

        //navigate to usps homepage
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(2000);

        //declare mouse action
        Actions mouseActions = new Actions(driver);

        //move your mouse to quick tools to open the drop down
        WebElement quickTools = driver.findElement(By.xpath("//*[text()='Quick Tools']"));
        mouseActions.moveToElement(quickTools).perform();
        //click on track a package using action
        WebElement trackPackage = driver.findElement(By.xpath("//*[text()='Track a Package']"));
        mouseActions.moveToElement(trackPackage).click().perform();
        //enter in tracking number using action
        Thread.sleep(2500);
        WebElement trackNumber = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        mouseActions.moveToElement(trackNumber).click().perform();
        mouseActions.moveToElement(trackNumber).sendKeys("1123234234").perform();
        trackNumber.sendKeys("12312312");


    }//end of main method
}//end of class
