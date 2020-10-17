package Day12_10102020;

import Reusable_Library.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.lang.Thread.sleep;

public class TestNG_Assertions {


    @Test
    public void assertions() throws InterruptedException {

        WebDriver driver = Reusable_Methods.getDriver();

        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);

        //verify the google title using hard assert
        //Assert.assertEquals("Google",driver.getTitle());

        //verify the google title using soft assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"GOOGLE");

        Reusable_Methods.sendKeys(driver,"//*[@name='q']","cars","Search Field");

        softAssert.assertAll();//to store all errors coming from soft assert

    }//end of test



}//end of class
