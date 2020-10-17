package Day5_09132020;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_Options {

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
        System.out.println("navigating to google home page");
        driver.navigate().to("https://www.google.com");
        //delay 2 seconds
        Thread.sleep(2000);
        //capture the home page title and verify it matches the expected title
        String actualTitle = driver.getTitle();
        //verify it matches the expected title
        if (actualTitle == "GOOGLE"){
            System.out.println("Title matches");
        } else {
            System.out.println("Title does not match. Actual title is " + actualTitle);
        }//end of conditional statement



    }//end of method

}//end of class
