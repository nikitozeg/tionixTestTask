package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author Nikita Ivanov tazg@ya.ru
 *
 */

public class CredentialsPage {

    private WebDriver driver;

    public CredentialsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailInputLocator = By.id("ap_email");
    private By nameFieldLocator = By.id("ap_customer_name");
    private By secondEmailLocator = By.id("ap_email_check");
    private By pwdLocator = By.id("ap_password");
    private By secondpwdLocator = By.id("ap_password_check");
    private By createAccountBtnLocator = By.id("continue-input");
    private By errorMsgLocator = By.xpath(".//*[@id='message_error']/p");


    @Step
    public String getEmailInputContent() {
        return driver.findElement(emailInputLocator).getAttribute("value");
    }


    @Step
    public void userTypeName(String name) {
        driver.findElement(nameFieldLocator).sendKeys(name);

    }

    @Step
    public void userRepeatEmail(String repeatEmail) {
        driver.findElement(secondEmailLocator).sendKeys(repeatEmail);

    }

    @Step
    public void userTypePwd(String pwd) {
        driver.findElement(pwdLocator).sendKeys(pwd);

    }

    @Step
    public void userRepeatPwd(String repeatPwd) {
        driver.findElement(secondpwdLocator).sendKeys(repeatPwd);

    }


    @Step
    public String getErrorMsg() {
       return driver.findElement(errorMsgLocator).getText();
    }

    @Step
    public RegistrationPage userPressCreateAccount() {
      driver.findElement(createAccountBtnLocator).click();
      return new RegistrationPage(driver);
    }


}
