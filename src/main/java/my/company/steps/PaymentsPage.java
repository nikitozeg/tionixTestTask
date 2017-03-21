package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static my.company.steps.Common.waitXpathElementVisible;
import static my.company.steps.LandingPage.currentURL1;
import static my.company.steps.Locators.*;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.Keys.ENTER;

/**
 * @author Nikita Ivanov tazg@ya.ru
 */

public class PaymentsPage {

    private WebDriver driver;
    static List<WebElement> list;

    public PaymentsPage(WebDriver driver) {
        this.driver = driver;
        waitXpathElementVisible(COMMUN_PAYMENTS_LOCATOR, driver);
    }

    private By communalPaymentsLocator = By.xpath(COMMUN_PAYMENTS_LOCATOR);
    By lookupLocator = By.xpath(LOOKUP_INPUT_LOCATOR);

    @Step
    public PaymentsPage userLookupItem(String item) {
        driver.findElement(lookupLocator).clear();
        driver.findElement(lookupLocator).sendKeys(item);
        driver.findElement(lookupLocator).sendKeys(ENTER);

        list = driver.findElements(By.xpath(LOOKUP_RESULTS_LOCATOR));
        return this;
    }

    @Step
    public PaymentsPage checkFirstItem(String item) {
        assertEquals(item, list.get(0).getText());
        return this;
    }

    @Step
    public ZhkuMskPage userClicksOnFoundItem(int item) {
        list.get(item).click();

        waitXpathElementVisible(FIELD_PAYER_CODE_LOCATOR,driver);
        currentURL1 = driver.getCurrentUrl();
        assertEquals(ZhkuMskPage.currentURL, currentURL1);
        return new ZhkuMskPage(driver);
    }


    @Step
    public PaymentsPage lookupHasResult() {
        Common.checkValues(LOOKUP_RESULTS_LOCATOR, driver);
        return this;
    }

    @Step
    public CommunnalPage goToCommunalPage() {
        Common.clickOnElement(communalPaymentsLocator, driver);
        return new CommunnalPage(driver);
    }


}
