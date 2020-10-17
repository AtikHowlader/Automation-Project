package Day6_09192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class xpath_concepts {

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
        driver.manage().window().maximize();
        //navigate to yahoo home page
        driver.navigate().to("https://www.yahoo.com");
        //2 second delay
        Thread.sleep(2000);

        //locate search field by name or id
        driver.findElement(By.xpath("//*[@id='ybar-sbq' or @name='p']")).sendKeys("cars");
        //navigate to yahoo home page
        driver.navigate().to("https://www.yahoo.com");
        //2 second delay
        Thread.sleep(2000);
        //using contains to only specify matching word within a property to locate an element
        driver.findElements(By.xpath("//*[contains(@class,'yb_e4mte')]")).get(2).click();

    }//end of main method
}//end of class
