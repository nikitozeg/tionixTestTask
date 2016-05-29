package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author Nikita Ivanov tazg@ya.ru
 *         Date: 6.02.16
 */

public class LandingPage {

    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    By newUserRadioBtnLocator = By.id("ap_signin_create_radio");
    By emailInputLocator = By.id("ap_email");
    By signInButtonLocator = By.id("signInSubmit-input");


    @Step
    public void userTypeEmailInForm(String email) {
        driver.findElement(newUserRadioBtnLocator).click();
        driver.findElement(emailInputLocator).sendKeys(email);
    }

    @Step
    public void userClickSignInBtn() {
        driver.findElement(signInButtonLocator).click();
    }


    @Step
    public CredentialsPage goToCredentialPage(String email) {
        userTypeEmailInForm(email);
        userClickSignInBtn();
        return new CredentialsPage(driver);
    }

}
