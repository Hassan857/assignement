package tests;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    public WebDriver driver;
    public ExcelFileManager excelfile ;


    @BeforeMethod
    public void setup () {

        excelfile = new ExcelFileManager(System.getProperty("user.dir")+"/src/test/resources/TestDataFiles/Data.xlsx");
        WebDriver driver = BrowserFactory.getBrowser();
        BrowserActions.navigateToURL(driver , "https://www.phptravels.net/register" , "https://www.phptravels.net/register" );
    }
    @AfterMethod
    public void after_method () {

        BrowserActions.closeCurrentWindow(driver);
    }
}
