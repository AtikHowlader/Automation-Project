package Day6_09192020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class yahoo_with_xpath {

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
        //maximize window
        driver.manage().window().maximize();
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");
        //2 second delay
        Thread.sleep(2000);
        // type in search bar
        driver.findElement(By.xpath("//*[@name='p']")).sendKeys("cars");
        //click on search button
        driver.findElement(By.xpath("//*[@value='Search']")).click();
        //delay 2 to 3 seconds
        Thread.sleep(2500);
        //need to scroll to bottom of page to capture search result
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //scroll down using executeScript
        jse.executeScript("scroll(0,5000)");
        //capture the entire footer including search result on yahoo search page
        String result = driver.findElement(By.xpath("//*[@class='compPagination']")).getText();
        //need to split by next
        String[] arrayResult = result.split("Next");
        //split again to only get search results
        String[] searchResult = arrayResult[1].split(" ");
        //print out the search results
        System.out.println("My search number is " + searchResult[0]);
        Thread.sleep(1000);
        //go back to top of page
        jse.executeScript("scroll(0,-5000)");

        //driver.quit();



    }//end of main method
}//end of class
