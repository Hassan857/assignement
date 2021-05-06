package GUIPages;

import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PhpTravels_Registration_Page {

    private WebDriver driver;

    // Constructor
    public PhpTravels_Registration_Page(WebDriver driver) {

        this.driver = driver;
    }

    // Elements
    private By firstname_field = By.name("firstname");
    private By lastname_field = By.name("lastname");
    private By phone_field = By.name("phone");
    private By email_field = By.name("email");
    private By password_field = By.name("password");
    private By confirmpassword_field = By.name("confirmpassword");
    //    private By signup_button = By.xpath("//button[contains(text() ,'Sign Up')]");
    private By alert_text = By.xpath("//div[contains(@class, 'alert')]");

    // Methods
    @Step("User Sign up with Data --> First Name: [{firstName}], Last Name: [{lastName}], Mobile Number: [{mobileNumber}], Email: [{email}] and Password: [{password}]")
    public PhpTravels_UserAccount_Page userSignUp(String firstName, String lastName, String mobileNumber, String email,
                                                  String password) {
        enterFirstNameField(firstName);
        enterLastNameField(lastName);
        enterMobileNumberField(mobileNumber);
        enterEmailField(email);
        enterPasswordFields(password);
        ElementActions.keyPress(driver , confirmpassword_field , Keys.ENTER);
        return new PhpTravels_UserAccount_Page(driver);
    }
    @Step("User Invalid Sign up")
    public PhpTravels_Registration_Page invalidUserSignUp(String firstName, String lastName, String phone, String email,
                                                    String password) {
        userSignUp(firstName, lastName, phone, email, password);
        return this;
    }

    @Step("Enter First Name --> [{firstName}]")
    public PhpTravels_Registration_Page enterFirstNameField(String firstName) {
        ElementActions.type(driver, firstname_field, firstName);
        return this;
    }
    @Step("Enter Last Name --> [{lastName}]")
    public PhpTravels_Registration_Page enterLastNameField(String lastName) {
        ElementActions.type(driver, lastname_field, lastName);
        return this;
    }
    @Step("Enter Mobile Number --> [{mobileNumber}]")
    public PhpTravels_Registration_Page enterMobileNumberField(String mobileNumber) {
        ElementActions.type(driver, phone_field, mobileNumber);
        return this;
    }
    @Step("Enter Email --> [{email}]")
    public PhpTravels_Registration_Page enterEmailField(String email) {
        ElementActions.type(driver, email_field, email);
        return this;
    }
    @Step("Enter Password and Confirm Password --> [{password}]")
    public PhpTravels_Registration_Page enterPasswordFields(String password) {
        ElementActions.type(driver, password_field, password);
        ElementActions.type(driver, confirmpassword_field, password);
        return this;
    }

    @Step("Get the text of the Alert message")
    public String getAlertMessage() {
        String alertMessage = ElementActions.getText(driver, alert_text);
        return alertMessage;
    }

}
