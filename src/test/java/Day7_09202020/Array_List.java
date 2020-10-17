package Day7_09202020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Array_List {

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

        //click on different month from dropdown using array list
        ArrayList<String> smList = new ArrayList<>();
        smList.add("Jan");
        smList.add("Feb");
        smList.add("Mar");
        smList.add("Apr");
        smList.add("May");
        smList.add("Jun");

        //navigate to mlcalc website
        driver.navigate().to("https://www.mlcalc.com");
        driver.manage().window().maximize();
        //2 second delay
        Thread.sleep(2000);
        //using loop i want to iterate trhough all month list and and click on each one
        for (int i = 0; i < smList.size();i++) {
            //use WebElement variable to store your start month dropdown
            WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
            Select smDropDown = new Select(startMonth);
            smDropDown.selectByVisibleText(smList.get(i));

            //selecting start month when html tag is not under Select tag
            driver.findElement(By.xpath("//*[@name='sm']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[text()='" + smList.get(i) + "']")).click();

        }//end of for loop

    }//end of method

}//end of class
