package Day15_101820;

import Reusable_Library.Abstract_Class;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class In_Class_AI extends Abstract_Class {

    @Test
    public void yahooErrorMsg() throws IOException, InterruptedException {

        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.yahoo.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        if (actualTitle == "Yahoo"){
            System.out.println(actualTitle);
        } else {
            System.out.println("The actual title is " + actualTitle);
        }//end of if else condition
        //get the count of all links in yahoo home page
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[@class='_yb_e0gik']"));
        //print out link count
        System.out.println("Link count is " + linkCount.size());
        logger.log(LogStatus.INFO,"Link count is " + linkCount.size());
        Reusable_Methods_Loggers.typeAndSubmit(driver,"//*[@name='p']",logger,"nutrition","Search Bar");
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
        logger.log(LogStatus.INFO,"My search number is " + searchResult[0]);
        Thread.sleep(1000);
        //go back to top of page
        jse.executeScript("scroll(0,-5000)");
        Reusable_Methods_Loggers.clickByIndex(driver,"//*[@class='fl-l mr-5']",4,logger,"Images");
        List<WebElement> imageCount = driver.findElements(By.xpath("//*[@class='ld  r0']"));
        //click on sign in button
        Reusable_Methods_Loggers.click(driver,"//*[text()='Sign In']",logger,"Sign In button");
        Thread.sleep(2500);
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //expecting the checkbox to be selected
        if(checkboxState == true){
            System.out.println("Checkbox is selected as expected");
        } else {
            System.out.println("Checkbox is not selected by default");
        }//end of if else
        Reusable_Methods_Loggers.typeAndSubmit(driver,"//*[@name='username']",logger,"sgdajgsdas","Username");
        String errorMsg = Reusable_Methods_Loggers.captureResult(driver,"//*[@class='error-msg']",logger,"Error Message");
        if(errorMsg.contains("Sorry, we don't recognize this email.") ){
            System.out.println("The error message is " + errorMsg);
            logger.log(LogStatus.PASS,"The error message is " + errorMsg);
        } else {
            System.out.println("The actual error message is " + errorMsg);
            logger.log(LogStatus.FAIL,"The actual error message is " + errorMsg);
        }//end of if else condition
        driver.quit();
    }//end of test class

}//end of class
