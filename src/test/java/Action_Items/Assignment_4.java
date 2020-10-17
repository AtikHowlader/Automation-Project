package Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Assignment_4 {

    public static void main(String[] args) throws InterruptedException {

        //set the chrome drive location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to incognito mode(private) (doesn't work on mac)
        options.addArguments("incognito");
        //run in headless mode
        options.addArguments("headless");

        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);

        //Array list for Zipcodes
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("15367");
        zipCode.add("13795");
        zipCode.add("20017");

        for (int i = 0;i < zipCode.size();i++) {
            //navigate to weight watchers homepage
            driver.navigate().to("https://www.weightwatchers.com");
            //maximize window
            driver.manage().window().maximize();
            //2 second delay
            Thread.sleep(2000);
            String actualTitle = driver.getTitle();
            if (actualTitle == "Weight Watchers: Weight Loss & Wellness Help") {
                System.out.println("Title Matches");
            } else {
                System.out.println("The Actual Title is " + actualTitle);
            }//end of if else condition
            try{
                driver.findElement(By.xpath("//*[@da-label='Find a Workshop']")).click();
            } catch (Exception err){
                System.out.println("Unable to click on Find a Workshop button");
            }//end of try catch
            //2 second delay
            Thread.sleep(2000);
            try{
                //setting search field as an element to enter zipcodes
                WebElement searchField = driver.findElement(By.xpath("//*[@id='location-search']"));
                searchField.sendKeys(zipCode.get(i));
                searchField.submit();
            } catch (Exception err){
                System.out.println("Unable to enter zipcode into search field");
            }//end of try catch
            //2 second delay
            Thread.sleep(2000);
            if (i == 0){
                try{
                    System.out.println("Clicking the 2nd link");
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(1).click();
                } catch (Exception err){
                    System.out.println("Unable to click on link" + err);
                }//end of try catch
            }//end of if condition
            if (i == 1){
                try{
                    System.out.println("Clicking the 3rd link");
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(2).click();
                } catch (Exception err){
                    System.out.println("Unable to click on link" + err);
                }//end of try catch
            }//end of if condition
            if (i == 2){
                try{
                    System.out.println("Clicking the 1st link");
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(0).click();
                } catch (Exception err){
                    System.out.println("Unable to click on link");
                }//end of try catch
            }//end of if condition
            //2 second delay
            //2 second delay
            Thread.sleep(2000);
            try{
                String studioName = driver.findElement(By.xpath("//*[@class='locationName-1jro_']")).getText();
                String studioAddress_1 = driver.findElements(By.xpath("//*[@class='address-2PZwW']")).get(0).getText();
                String stuioAddress_2 = driver.findElements(By.xpath("//*[@class='address-2PZwW']")).get(1).getText();
                System.out.println("The address is " + studioName + " " + studioAddress_1 + " " + stuioAddress_2);
            } catch (Exception err){
                System.out.println("Unable to get address");
            }
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            //scroll down to schedule
            jse.executeScript("scroll(0,800)");
            Thread.sleep(2500);
            try{
                String schedule = driver.findElements(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).get(0).getText();

                System.out.println(schedule);
            } catch (Exception err){
                System.out.println("Unable to find the schedule");
            }//end of try catch

        }//end of loop
        driver.quit();

    }//end of main method

}//end of class
