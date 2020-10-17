package Day7_09202020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class try_catch_in_mlcalc {

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

        //navigate to mlcalc website
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2000);

        //clear and enter purchase price payment
        try{
            WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
            pPrice.clear();
            pPrice.sendKeys("400000");
        } catch (Exception err) {
            System.out.println("Unable to enter value of down payment " + err);
        }//end of purchase price exception

        //clear and enter down payment
        try {
            WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
            dPayment.clear();
            dPayment.sendKeys("40");
        } catch (Exception err) {
            System.out.println("Unable to enter value of down payment " + err);
        }//end of down payment exception

        //select a start month
        try {
            WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
            Select smList = new Select(startMonth);
            smList.selectByVisibleText("Feb");
        } catch (Exception err) {
            System.out.println("Unable to select start month " + err);
        }//end of start moth exception

        //click on calculate
        try {
            driver.findElement(By.xpath("//*[@alt='Calculate']")).click();
        } catch (Exception err) {
            System.out.println("Unable to click on Calculate button " + err);
        }//end of calculate exception

    }//end of main method

}//end of class
