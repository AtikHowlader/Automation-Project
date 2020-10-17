package Action_Items;

import Reusable_Library.Abstract_Class;
import Reusable_Library.Reusable_Methods;
import Reusable_Library.Reusable_Methods_Loggers;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Assignment_7 extends Abstract_Class {

    //declare all variables
    WebDriver driver;
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;

    @Test
    public void expressOrderError () throws InterruptedException, IOException, BiffException, WriteException {


        //setting the chrome driver
        driver = Reusable_Methods.getDriver();
        readableFile = Workbook.getWorkbook(new File("src/main/resources/Express_AI.xls"));
        readableSheet = readableFile.getSheet(0);
        writableFile = Workbook.createWorkbook(new File("src/main/resources/Express_AI_Results.xls"),readableFile);
        //Step 4: define the writable sheet for the writable file
        writableSheet = writableFile.getSheet(0);
        //Step 5: get the count of the rows that are not empty in excel workbook
        rowCount = writableSheet.getRows();

        //navigate to express homepage
        driver.navigate().to("https://www.express.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        if (actualTitle == "Men's and Woman's Clothing"){
            System.out.println(actualTitle);
        } else {
            System.out.println("The actual title is " + actualTitle);
        }//end of if else condition

        for (int i = 1;i < rowCount;i++){

            String size = writableSheet.getCell(0, i).getContents();
            String quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            String address = writableSheet.getCell(6, i).getContents();
            String zipCode = writableSheet.getCell(7, i).getContents();
            String city = writableSheet.getCell(8, i).getContents();
            String state = writableSheet.getCell(9, i).getContents();
            String cardNumber = writableSheet.getCell(10, i).getContents();
            String expMonth = writableSheet.getCell(11, i).getContents();
            String expYear = writableSheet.getCell(12, i).getContents();
            String cvv = writableSheet.getCell(13, i).getContents();


            driver.manage().deleteAllCookies();
            //navigate to express homepage
            driver.navigate().to("https://www.express.com");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver,"//*[@class='close-text drawer-close']",logger,"Exit drawer");
            Reusable_Methods_Loggers.mouseHover(driver,"//*[@href='/mens-clothing']",logger,"Mens");
            Reusable_Methods_Loggers.click(driver,"//*[@href='/mens-clothing/shirts/cat410008']",logger,"Shirts link");
            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            //scroll down to schedule
            jse.executeScript("scroll(0,400)");
            Thread.sleep(2500);
            Reusable_Methods_Loggers.clickByIndex(driver,"//*[@class='L_d7U']",2,logger,"Shirt");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver,"//*[@value='"+size+"']",logger,"Shirt Size");
            Reusable_Methods_Loggers.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _3yOD6 _1Qp1L _2veMA']",logger,"Add to Bag");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.mouseHover(driver,"//div[3]/div[1]/button[1]",logger,"Shopping Bag Icon");
            Reusable_Methods_Loggers.mouseClick(driver,"//*[contains(text(),'View Bag & Check Out')]",logger,"View Bag and Checkout");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@id='qdd-0-quantity']",quantity,logger,"Quantity");
            Reusable_Methods_Loggers.mouseClick(driver,"//*[@class='granify-td-cta granify-cta-dismiss']",logger,"Pop Up");
            jse.executeScript("scroll(0,50)");
            Reusable_Methods_Loggers.click(driver,"//*[@id='continue-to-checkout']",logger,"Checkout");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.click(driver,"//*[@class='_1UFak _2YpK4 _1f9t- _2yrqS']",logger,"Checkout as Guest");
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@id='contact-information-firstname']",firstName,logger,"First Name");
            Reusable_Methods_Loggers.sendKeys(driver,"//*[contains(@name,'lastname')]",lastName,logger,"Last Name");
            Reusable_Methods_Loggers.sendKeys(driver,"//*[contains(@name,'email')]",email,logger,"Email Address");
            Reusable_Methods_Loggers.sendKeys(driver,"//*[contains(@name,'confirmEmail')]",email,logger,"Confirm Email Address");
            Reusable_Methods_Loggers.sendKeys(driver,"//*[contains(@name,'phone')]",phoneNumber,logger,"Phone Number");
            Reusable_Methods_Loggers.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']",logger,"Continue button");
            Reusable_Methods_Loggers.sendKeys(driver,"//*[contains(@name,'shipping.line1')]",address,logger,"Street Address");
            Reusable_Methods_Loggers.sendKeys(driver,"//*[contains(@name,'shipping.postalCode')]",zipCode,logger,"Zip Code");
            Reusable_Methods_Loggers.sendKeys(driver,"//*[contains(@name,'shipping.city')]",city,logger,"City");
            Reusable_Methods_Loggers.dropDownMenu(driver,"//*[contains(@name,'shipping.state')]",state,logger,"State");
            Reusable_Methods_Loggers.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']",logger,"Continue button");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']",logger,"Continue button");
            Thread.sleep(3000);
            if (i == 1){
                jse.executeScript("scroll(0,100)");
                Reusable_Methods_Loggers.mouseClick(driver,"//*[@class='btn _9yfmt _194FD _2WoPG _1aV6J asfNW btnDarkSurroundingsPrimary']",logger,"Exit Pop Up");
            }//end of if condition
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@id='creditCardNumberInput']",cardNumber,logger,"Card Number");
            Reusable_Methods_Loggers.dropDownMenu(driver,"//*[contains(@name,'expMonth')]",expMonth,logger,"Exp Month");
            Reusable_Methods_Loggers.dropDownMenu(driver,"//*[contains(@name,'expYear')]",expYear,logger,"Exp Year");
            Reusable_Methods_Loggers.sendKeys(driver,"//*[contains(@name,'cvv')]",cvv,logger,"CVV");
            Reusable_Methods_Loggers.click(driver,"//*[contains(text(),'Place Order')]",logger,"Place Order");
            String errorMessage = Reusable_Methods_Loggers.captureResult(driver,"//*[@class='xnY7x notification']",logger,"Error Message");
            Label label = new Label(14, i, errorMessage);
            //adding this label to writable sheet
            writableSheet.addCell(label);
        }//end of for loop
        writableFile.write();
        writableFile.close();

    }//end of test class

}//end of class
