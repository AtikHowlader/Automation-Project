package Day9_09272020;

import Reusable_Library.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable_Method_Applesite {

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

        driver.navigate().to("https:www.apple.com");

        //call on resusable click method for mac link
        Reusable_Methods.click(driver, "//*[@data-analytics-title='mac']", "Mac Link");
        //click on mac air
        Reusable_Methods.click(driver, "//*[text()='MacBook Air']", "Mac Book Air");
        //click on search icon
        Reusable_Methods.click(driver,"//*[@id='ac-gn-link-search']", "Search Icon");
        //entering keyword into search field
        Reusable_Methods.sendKeys(driver,"//*[@placeholder='Search apple.com']", "iphone","Search Field");
        //hit submit
        Reusable_Methods.submit(driver,"//*[@placeholder='Search apple.com']","Search Field");


    }//end of method
}//end of class
