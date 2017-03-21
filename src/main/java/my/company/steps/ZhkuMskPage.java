package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

import static my.company.steps.Common.waitXpathElementVisible;
import static my.company.steps.Locators.*;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.Keys.ENTER;

/**
 * @author Nikita Ivanov tazg@ya.ru
 */

public class ZhkuMskPage {
    static String currentURL;
    private WebDriver driver;

    public ZhkuMskPage(WebDriver driver) {
        this.driver = driver;
        waitXpathElementVisible(PAYERCODE_LOCATOR,driver);
    }


    @Step
    public void checkCodeValidation() {

        driver.findElement(By.xpath(PAYERCODE_LOCATOR)).sendKeys(ENTER);
        assertEquals("Поле обязательное",driver.findElement(By.xpath(ERROR_MSG_LOCATOR)).getText());

        List<String> messages = Arrays.asList("123456789", "12345678901", "Are", "You");
        for (String value:messages) {
            driver.findElement(By.xpath(PAYERCODE_LOCATOR)).clear();
            driver.findElement(By.xpath(PAYERCODE_LOCATOR)).sendKeys(value);
            driver.findElement(By.xpath(PAYERCODE_LOCATOR)).sendKeys(ENTER);
            assertEquals("Поле неправильно заполнено",driver.findElement(By.xpath(ERROR_MSG_LOCATOR)).getText());

        }
        currentURL = driver.getCurrentUrl();
    }

    @Step
    public void checkDateValidation() {
        driver.findElement(By.xpath(PAYERCODE_LOCATOR)).clear();

        driver.findElement(By.xpath(PAYERCODE_LOCATOR)).sendKeys("1234567890");

        List<String> messages = Arrays.asList("13.2015", "99.2017");
        for (String value:messages) {
            driver.findElement(By.xpath(PERIOD_LOCATOR)).clear();
            driver.findElement(By.xpath(PERIOD_LOCATOR)).sendKeys(value);
            driver.findElement(By.xpath(PERIOD_LOCATOR)).sendKeys(ENTER);
            assertEquals("Поле заполнено некорректно",driver.findElement(By.xpath(ERROR_MSG_LOCATOR)).getText());

        }

    }


}
