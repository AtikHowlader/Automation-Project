package Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment_3 {

    public static void main(String[] args) throws InterruptedException {
        //set the chrome drive location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //defining the web driver that will be used
        WebDriver driver = new ChromeDriver();
        //run in headless mode
        options.addArguments("headless");
        //run in incognito mode
        options.addArguments("incognito");

        String[] hobbies = new String[5];
        hobbies[0] = "gaming";
        hobbies[1] = "coding";
        hobbies[2] = "boxing";
        hobbies[3] = "swimming";
        hobbies[4] = "gambling";

        for (int i = 0;i < hobbies.length;i++) {
            //navigate to bing homepage
            driver.navigate().to("https://www.bing.com");
            driver.manage().window().maximize();
            // 2 second delay
            Thread.sleep(2000);
            driver.findElement(By.className("sb_form_q")).sendKeys(hobbies[i]);
            //1 second delay
            Thread.sleep(1000);
            //Press enter
            driver.findElement(By.name("search")).submit();
            //2 second delay
            Thread.sleep(2000);
            String results = driver.findElement(By.className("sb_count")).getText();
            //split by single space
            String[] arrayResults = results.split(" ");
            //print statement
            System.out.println("My search number for " + hobbies[i] + " is " + arrayResults[0]);
        }//end of loop

        driver.quit();

    }//end of method

}//end of class
