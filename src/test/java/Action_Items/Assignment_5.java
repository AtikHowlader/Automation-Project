package Action_Items;

import Reusable_Library.Reusable_Methods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Assignment_5 {
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

        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Atik");
        firstName.add("Bob");
        firstName.add("Jimmy");

        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Howlader");
        lastName.add("Jones");
        lastName.add("Smith");

        ArrayList<String> last6ssn = new ArrayList<>();
        last6ssn.add("456789");
        last6ssn.add("156378");
        last6ssn.add("090076");

        ArrayList<String> month = new ArrayList<>();
        month.add("September");
        month.add("December");
        month.add("June");

        ArrayList<String> day = new ArrayList<>();
        day.add("19");
        day.add("21");
        day.add("13");

        ArrayList<String> year = new ArrayList<>();
        year.add("1997");
        year.add("1986");
        year.add("1990");

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("13795");
        zipCode.add("11435");
        zipCode.add("13904");

        //navigate to uhc homepage
        driver.navigate().to("https://www.uhc.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        if (actualTitle == "Health insurance plans"){
            System.out.println(actualTitle);
        } else {
            System.out.println("The actual title is " + actualTitle);
        }//end of if else condition

        for (int i = 0;i < firstName.size();i++){
            driver.navigate().to("https://www.uhc.com");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            //clicking on find a doctor link
            Reusable_Methods.click(driver,"//*[@aria-label='Find a Doctor']","Find a Doctor" );
            //clicking on sign in to find a provider link
            Reusable_Methods.click(driver,"//*[@id='btn-sign-in']","Sign in to Find a Provider");
            Thread.sleep(2000);
            //need to store window handles command in as ArrayList to switch to different tab(s)
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to second tab
            driver.switchTo().window(tabs.get(1));
            //click on registration
            Reusable_Methods.click(driver,"//*[@id='registerbutton']","Register");
            Thread.sleep(2000);
            //entering first name
            Reusable_Methods.sendKeys(driver,"//*[@id='firstName']", firstName.get(i),"First Name");
            //entering last name
            Reusable_Methods.sendKeys(driver,"//*[@id='lastName']", lastName.get(i),"Last Name");
            //selecting month
            Reusable_Methods.selectDropDown(driver,"//*[@id='dob_month_input']",month.get(i),"Month");
            //entering day
            Reusable_Methods.sendKeys(driver,"//*[@id='dob_day']",day.get(i),"Day");
            //entering year
            Reusable_Methods.sendKeys(driver,"//*[@id='dob_year']",year.get(i),"Year");
            //scrolling down
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("scroll(0,1000)");
            Thread.sleep(2000);
            //clicking on ssn option
            Reusable_Methods.click(driver,"//*[@id='ssn_container']","Social Security Number");
            //entering last 6 digits of ssn
            Reusable_Methods.sendKeys(driver,"//*[@id='ssnLastSixDigits']",last6ssn.get(i),"Last 6 digit for SSN");
            //entering zip code
            Reusable_Methods.sendKeys(driver,"//*[@id='zipCode']",zipCode.get(i),"Zip Code");
            //clicking on submit button
            Reusable_Methods.click(driver,"//*[@id='submitBtn']","Submit Button");
            //capturing error message
            Reusable_Methods.capturingText(driver,"//*[@id='plainText_error']","Error Message");
            //to close the window
            driver.close();
            //switch back to original tab
            driver.switchTo().window(tabs.get(0));
        }//end of for loop
        driver.quit();
    }//end of main method

}//end of class


