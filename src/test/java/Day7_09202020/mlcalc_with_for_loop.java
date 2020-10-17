package Day7_09202020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class mlcalc_with_for_loop {

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

        //set the values for purchase price list
        ArrayList<String> pPriceList = new ArrayList<>();
        pPriceList.add("450000");
        pPriceList.add("500000");

        //set the values for down payment list
        ArrayList<String> dPaymentList = new ArrayList<>();
        dPaymentList.add("30");
        dPaymentList.add("40");

        //call the for loop to iterate through the array list
        for (int i = 0;i < pPriceList.size();i++){
            //navigate to mlcalc website
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(2000);
            //clear and enter purchase price payment
            try{
                WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
                pPrice.clear();
                pPrice.sendKeys(pPriceList.get(i));
            } catch (Exception err) {
                System.out.println("Unable to enter value of down payment " + err);
            }//end of purchase price exception
            //clear and enter down payment
            try {
                WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
                dPayment.clear();
                dPayment.sendKeys(dPaymentList.get(i));
            } catch (Exception err) {
                System.out.println("Unable to enter value of down payment " + err);
            }//end of down payment exception
            //click on calculate
            try {
                System.out.println("Clicking on calculate button");
                driver.findElement(By.xpath("//*[@alt='Calculate']")).click();
            } catch (Exception err) {
                System.out.println("Unable to click on Calculate button " + err);
            }//end of calculate exception

            Thread.sleep(2000);

            //capture and print monthly payment
            try {
                String mntPayment = driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
                System.out.println("My monthly payment is " + mntPayment );
            } catch (Exception err) {
                System.out.println("Unable to capture the monthly payment " + err);
            }//end of start moth exception

        }//end of for loop




    }//end of main method
}//end of class
