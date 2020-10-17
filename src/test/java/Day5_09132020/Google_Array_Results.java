package Day5_09132020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Google_Array_Results {

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

        //let's create dynamic array to handle multiple borough google search
        String[] boroughs = new String[5];
        boroughs[0] = "Queens";
        boroughs[1] = "Brooklyn";
        boroughs[2] = "Manhattan";
        boroughs[3] = "Bronx";
        boroughs[4] = "Staten Island";

        for (int i = 0;i < boroughs.length;i++) {
            //let's navigate to google home page
            driver.navigate().to("https://www.google.com");
            //maximize my window
            driver.manage().window().maximize();
            //put 2 second delay
            Thread.sleep(2000);
            //locate search field by name and enter a keyword on the field
            driver.findElement(By.name("q")).sendKeys(boroughs[i]);
            Thread.sleep(1000);
            //click on google search
            //driver.findElement(By.name("btnK")).click();
            driver.findElement(By.name("btnK")).submit();
            //2 second delay to load page
            Thread.sleep(2000);
            String results = driver.findElement(By.id("result-stats")).getText();
            String[] arrayResults = results.split(" ");
            //print out the search results
            System.out.println("My search number for " + boroughs[i] + " is " + arrayResults[1]);
        }//end of loop

        driver.quit();

    }//end of method

}//end of class
