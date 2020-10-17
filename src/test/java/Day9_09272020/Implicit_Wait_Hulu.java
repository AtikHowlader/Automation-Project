package Day9_09272020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Implicit_Wait_Hulu {

    public static void main(String[] args) {

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

        //set your implicit wait before test steps
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.hulu.com");
        driver.findElement(By.xpath("//*[@class='button--cta button--white Masthead__input-cta']")).click();

    }//end of method
}//end of class
