package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import static my.company.steps.Locators.PAYMENTS_LOCATOR;

/**
 * @author Nikita Ivanov tazg@ya.ru
 *         Date: 6.02.16
 */

public class LandingPage {

    private WebDriver driver;
    static String currentURL1;

    By paymentsBtn = By.xpath(PAYMENTS_LOCATOR);


    public LandingPage(WebDriver driver) {
        this.driver = driver;

    }


    @Step
    public void userClicksOnPaymentLink() {
        Common.clickOnElement(paymentsBtn, driver);

    }


    @Step
    public PaymentsPage goToPaymentsPage() {
        userClicksOnPaymentLink();
        return new PaymentsPage(driver);
    }

}
