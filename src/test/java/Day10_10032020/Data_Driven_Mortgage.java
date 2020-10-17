package Day10_10032020;

import Reusable_Library.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Data_Driven_Mortgage {

    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {
        //setting the chrome driver
        WebDriver driver = Reusable_Methods.getDriver();

        //Step 1: locate the readable excel workbook
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/Mortgage_Info.xls"));
        //Step 2: locate the excel sheet for this workbook
        Sheet readableSheet = readableFile.getSheet(0);
        //Step 3: make a copy of readable file to write back to the excel so it doesn't corrupt the original file
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/Mortgage_Info_Result.xls"),readableFile);
        //Step 4: define the writable sheet for the writable file
        WritableSheet writableSheet = writableFile.getSheet(0);
        //Step 5: get the count of the rows that are not empty in excel workbook
        int rowCount = writableSheet.getRows();

        //all the test steps have to go inside for loop
        for (int i = 1;i < rowCount;i++){
            //I need to get content of the cell
            //column is hard coded and row is dynamic(i)
            String homeVal = writableSheet.getCell(0,i).getContents();
            String downPay = writableSheet.getCell(1,i).getContents();
            String loanAmount = writableSheet.getCell(2,i).getContents();
            String startMonth = writableSheet.getCell(3,i).getContents();
            String startYear = writableSheet.getCell(4,i).getContents();

            //navigate to mortgage calculator homepage
            driver.navigate().to("https://www.mortgagecalculator.org");
            Thread.sleep(2000);
            //enter home value
            Reusable_Methods.sendKeys(driver,"//*[@id='homeval']",homeVal,"Home Value");
            //enter down payment
            Reusable_Methods.sendKeys(driver,"//*[@id='downpayment']",downPay,"Down Payment");
            //enter loan amount
            Reusable_Methods.sendKeys(driver,"//*[@id='loanamt']",loanAmount,"Loan Amount");
            //enter start month
            Reusable_Methods.selectDropDown(driver,"//*[@name='param[start_month]']",startMonth,"Start Month");
            //enter start year
            Reusable_Methods.sendKeys(driver,"//*[@id='start_year']",startYear,"Start Year");
            //click on calculate
            Reusable_Methods.click(driver,"//*[@value='Calculate']","Calculate");
            Thread.sleep(2000);
            //capture the monthly payment
            String result = Reusable_Methods.capturingText(driver,"//*[@class='left-cell']/following::h3[contains(text(),'$')]","Monthly Payment");

            //store and send it to the empty column in excel writable file
            Label label = new Label(5,i,result);
            //adding this label to writable sheet
            writableSheet.addCell(label);

        }//end of for loop

        writableFile.write();
        writableFile.close();

    }//end of method
}//end of class
