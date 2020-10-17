package Day8_09262020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class In_Class_Action_Item {

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

        ArrayList<String> locations = new ArrayList<>();
        locations.add("New York");
        locations.add("Miami");
        locations.add("Los Angeles");

        ArrayList<String> checkIn = new ArrayList<>();
        checkIn.add("09/28/20");
        checkIn.add("09/29/20");
        checkIn.add("09/30/20");

        ArrayList<String> checkOut = new ArrayList<>();
        checkOut.add("10/15/20");
        checkOut.add("10/16/20");
        checkOut.add("10/17/20");

        ArrayList<String> rooms = new ArrayList<>();
        rooms.add("1");
        rooms.add("2");
        rooms.add("3");

        ArrayList<String> adults = new ArrayList<>();
        adults.add("1");
        adults.add("2");
        adults.add("3");

        //navigate to hotels.com website
        driver.navigate().to("https://www.hotels.com");
        Thread.sleep(2000);
        for (int i = 0;i < locations.size();i++){
            try{
                WebElement searchField = driver.findElement(By.xpath("//*[@name='q-destination']"));
                searchField.clear();
                searchField.sendKeys(locations.get(i));
            } catch (Exception err) {
                System.out.println("Unable to enter location name" + err);
            }//end of send location exception
                Thread.sleep(1000);
            try{
                driver.findElement(By.xpath("//*[@class='autosuggest-category-result']")).click();
            } catch (Exception err) {
                System.out.println("Unable to click on suggestion" + err);
            }//end of click suggestion exception
            Thread.sleep(2000);
            try {
                WebElement checkIn_Field = driver.findElement(By.xpath("//*[@name='q-localised-check-in']"));
                checkIn_Field.clear();
                checkIn_Field.sendKeys(checkIn.get(i));
            } catch (Exception err){
                System.out.println("Unable to enter check in date" + err);
            }//end of check in exception
            try {
                WebElement checkOut_Field = driver.findElement(By.xpath("//*[@name='q-localised-check-out']"));
                checkOut_Field.clear();
                checkOut_Field.sendKeys(checkOut.get(i));
            } catch (Exception err){
                System.out.println("Unable to enter check out date" + err);
            }//end of check out exception
            try {
                WebElement roomsAmount = driver.findElement(By.xpath("//*[@name='q-rooms']"));
                Select roomsDropdown = new Select(roomsAmount);
                roomsDropdown.selectByIndex(i);
            } catch (Exception err){
                System.out.println("Unable to select from room dropdown" + err);
            }//end of room exception
            try {
                WebElement adultAmount = driver.findElement(By.xpath("//*[@name='q-room-0-adults']"));
                Select adultDropdown = new Select(adultAmount);
                adultDropdown.selectByIndex(i);
            } catch (Exception err){
                System.out.println("Unable to select from adult dropdown" + err);
            }//end of adult exception
            try {
                driver.findElement(By.xpath("//*[@type='submit']")).click();
            } catch (Exception err){
                System.out.println("Unable to click on submit" + err);
            }//end of submit exception
            Thread.sleep(5000);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("0,2000");
            //need to store window handles command in as ArrayList to switch to different tab(s)
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            if (i == 0){
                try {
                    driver.findElements(By.xpath("//*[@class='property-name-link']")).get(0).click();
                } catch (Exception err){
                    System.out.println("Unable to click on 1st link" + err);
                }//end of 1st link exception

                //switch to second tab
                driver.switchTo().window(tabs.get(1));
                try {
                    String propertyDescription = driver.findElement(By.xpath("//*[@class='vcard']")).getText();
                    String roomCost = driver.findElement(By.xpath("//*[@class='current-price bold']")).getText();
                    System.out.println("The hotel is " + propertyDescription);
                    System.out.println("The room cost is " + roomCost);
                    driver.findElement(By.xpath("//*[@id='book-now-button']")).click();
                } catch (Exception err){
                    System.out.println("Unable to find property description & room cost" + err);
                    System.out.println("Unable to click on reserve button" + err);
                }//end of property description + reserve button exception
                Thread.sleep(2000);
                try {
                    String roomInfo_1 = driver.findElement(By.xpath("//*[@class='room-name']")).getText();
                    String roomInfo_2 = driver.findElement(By.xpath("//*[@class='room-and-hotel-info']")).getText();
                    System.out.println(roomInfo_1 + " " + roomInfo_2);
                } catch (Exception err){
                    System.out.println("Unable to get room information" + err);
                }//end of room info exception
                try {
                    String roomOptions_1 = driver.findElement(By.xpath("//*[@class='rateplan-features']")).getText();
                    String roomOptions_2 = driver.findElement(By.xpath("//*[@class='mvt8409']")).getText();
                    System.out.println(roomOptions_1 + " " + roomOptions_2);
                } catch (Exception err){
                    System.out.println("Unable to get room options" + err);
                }//end of room option exception
                driver.close();
                driver.switchTo().window(tabs.get(0));
            }//end of if condition
            if (i == 1){
                try {
                    driver.findElements(By.xpath("//*[@class='property-name-link']")).get(2).click();
                } catch (Exception err){
                    System.out.println("Unable to click on 3rd link" + err);
                }//end of 3rd link exception
            }//end of if condition
            if (i == 2){
                try {
                    driver.findElements(By.xpath("//*[@class='property-name-link']")).get(1).click();
                } catch (Exception err){
                    System.out.println("Unable to click on 2nd link" + err);
                }//end of 2nd link exception
            }//end of if condition

        }//end of for loop



    }//end of main method

}//end of class
