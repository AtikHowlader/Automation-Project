package Day6_09192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class yahoo_with_findElements {

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
        options.addArguments("headless");

        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //navigate to google home page
        driver.navigate().to("https://www.yahoo.com");
        //2 second delay
        Thread.sleep(2000);
        WebElement searchField = driver.findElement(By.xpath("//*[@name='p']"));
        //clear any pre defined value on the field
        searchField.clear();
        //enter new keyword
        searchField.sendKeys("cars");
        //submit on the same field after the value
        searchField.submit();

        //using .findElements to click on 3rd link(news)
        //driver.findElements(By.xpath("//*[@class=_yb_e4mte ']")).get(2).click();

    }//end of main method
}//end of class
