package tests;

import GUIPages.PhpTravels_Registration_Page;
import GUIPages.PhpTravels_UserAccount_Page;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("PHPTRAVELS")
@Feature("GUI")
public class SignUp_Test_Cases extends BaseClass {

    private WebDriver driver;
    private PhpTravels_Registration_Page RegistrationPage ;
    private PhpTravels_UserAccount_Page useraccountpage;
    String firstName, lastName, mobileNumber, email, password;




    @Test(description = "Valid User Sign Up")
    @Description("When I enter valid data in the sign up form And click the signup button, Then I should be registered successfully And be navigated to the user account page And I can see my user data and Hi message")
    @Story("Sign Up")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("focus-case-1637098")
    @Issue("bug-tracker#1")
    public void testingValidUserSignUp() {
        firstName = excelfile.getCellData("firstname");
        lastName = excelfile.getCellData("lastname");
        mobileNumber = excelfile.getCellData("mobilenumber");
        email = excelfile.getCellData("email");
        password = excelfile.getCellData("password");
        RegistrationPage = new PhpTravels_Registration_Page(driver);
        useraccountpage = RegistrationPage
                .userSignUp(firstName, lastName, mobileNumber, email, password);

        Assert.assertEquals(useraccountpage.getHiMessage(), "Hi, " + firstName + " " + lastName, "Wrong Hi Message Names!");
    }


    }
