package GUIPages;

import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PhpTravels_UserAccount_Page {

    private WebDriver driver ;

    private By hi_text = By.xpath("//*[@style='margin-left: 17px']");

    public PhpTravels_UserAccount_Page ( WebDriver Driver ) {
        this.driver=driver;
    }

    @Step("Get the text of the Hi message")
    public String getHiMessage() {
        String hiMessage = ElementActions.getText(driver, hi_text);
        return hiMessage;
    }
}
