package Day8_09262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class metlife_switchtabs {

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

        //navigate to metlife website
        driver.navigate().to("https://www.metlife.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='SOLUTIONS']")).click();
        //click on take along link
        driver.findElement(By.xpath("//*[text()='MetLife TakeAlong Dental']")).click();
        Thread.sleep(1500);
        //click on enroll now button
        driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();

        //need to store window handles command in as ArrayList to switch to different tab(s)
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to second tab
        driver.switchTo().window(tabs.get(1));

        //enter the zipcode
        driver.findElement(By.xpath("//*[@name='txtZipCode']")).sendKeys("11218");
        driver.close();//to close the window if you don't need it again
        //switch back to original tab
        driver.switchTo().window(tabs.get(0));

        //renavigate to metlife homepage
        driver.navigate().to("https://www.metlife.com");


    }//end of method
}//end of class
