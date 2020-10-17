package Day4_09122020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Search {

    public static void main(String[] args) throws InterruptedException {

        //set the chrome drive location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver();

        //let's get to google home page
        //driver.get("https://www.google.com");

        //let's navigate to google home page
        driver.navigate().to("https://www.google.com");
        //maximize my window
        driver.manage().window().maximize();
        //put 2 second delay
        //Thread.sleep(2000);
        //locate search field by name and enter a keyword on the field
        driver.findElement(By.name("q")).sendKeys("cars");
        //click on google search
        //driver.findElement(By.name("btnK")).click();
        driver.findElement(By.name("btnK")).submit();
        //put 2 second delay
        Thread.sleep(2000);
        //close driver
        //driver.close();
        //quit the entire session
        driver.quit();

    }//end of method

}//end of class
