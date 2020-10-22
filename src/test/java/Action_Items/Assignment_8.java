package Action_Items;

import Reusable_Library.Abstract_Class_Cross_Browser;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.awt.*;

public class Assignment_8 extends Abstract_Class_Cross_Browser {

    @Test
    public void fedexInfo () throws InterruptedException, AWTException {
        driver.manage().deleteAllCookies();
        //navigate to express homepage
        driver.navigate().to("https://www.fedex.com/en-us/home.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        Reusable_Methods_Loggers.click(driver,"//*[@aria-label='Open Design & Print menu']",logger,"Design and Print");
        Reusable_Methods_Loggers.click(driver,"//*[@alt='Upload a Print-Ready File']",logger,"Upload a Print Ready File");
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Fedex Office Print")){
            System.out.println(actualTitle);
            logger.log(LogStatus.PASS,"The page title is " + actualTitle);
        } else {
            System.out.println("The actual title is " + actualTitle);
            logger.log(LogStatus.FAIL,"The actual page title is " + actualTitle);
        }//end of if else condition
        Reusable_Methods_Loggers.clickByIndex(driver,"//*[@class='js-selectProjectType']",2,logger,"Document Printing");
        Reusable_Methods_Loggers.click(driver,"//*[@title='Copies & Custom Projects']",logger,"Copies & Custom Projects");
        Reusable_Methods_Loggers.click(driver,"//*[@name='upload-files-button']",logger,"Use your File");
        Thread.sleep(4000);
        Reusable_Methods_Loggers.uploadFile("/Users/atikhowlader/Documents/Indianapolis-Colts1.jpg");
        Thread.sleep(5000);
        Reusable_Methods_Loggers.click(driver,"//*[@id='js-modal__continue-btn_lowResolutionPreview']",logger,"Continue");
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@class='quantity-field']","5",logger,"Quantity");
        Reusable_Methods_Loggers.click(driver,"//*[@name='update_quanity-addToCart-lbl']",logger,"Add to Cart");
        Reusable_Methods_Loggers.click(driver,"//*[@id='cartToCheckoutBtn']",logger,"Checkout");
        Reusable_Methods_Loggers.click(driver,"//*[@id='continueAsGuest']",logger,"Continue as Guest");
        Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@id='radiusSelect']","5",logger,"Radius");
        Reusable_Methods_Loggers.typeAndSubmit(driver,"//*[@id='loc_seacrh_text']",logger,"11435","Zipcode");
        String address = Reusable_Methods_Loggers.captureResult(driver,"//*[@class='active']",logger,"Address");
        System.out.println(address);
        logger.log(LogStatus.PASS,"The address is " + address);
        driver.quit();
    }//end of test

}//end of class
