package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static my.company.steps.Locators.COMMUN_GRID_LOCATOR;
import static my.company.steps.Locators.LOCATION_LOCATOR;

/**
 * @author Nikita Ivanov tazg@ya.ru
 */

public class CommunnalPage {

    private WebDriver driver;

    public CommunnalPage(WebDriver driver) {
        this.driver = driver;
        Common.checkValues(COMMUN_GRID_LOCATOR, driver);

    }

    By locationLocator = By.xpath(LOCATION_LOCATOR);


    @Step
    public void checkLocation(String location) {
        if (!driver.findElement(locationLocator).getText().equalsIgnoreCase("Москве"))
            setLocation(location);
    }

    @Step
    public ZhkuMskPage clickOnGridElement(int num) {
        getListElement().get(num).click();
        return new ZhkuMskPage(driver);
    }

    @Step
    public List<WebElement> getListElement() {
        return driver.findElements(By.xpath(COMMUN_GRID_LOCATOR));
    }

    @Step
    public WebElement getElement(int i) {
        return getListElement().get(i).findElement(By.xpath(".//span[text()]"));
    }

    @Step
    public CommunnalPage setLocation(String name) {
        Common.clickOnElement(locationLocator, driver);
        Common.clickOnElement(By.xpath("//span[text()=\"" + name + "\"]"), driver);
        Common.checkValues(COMMUN_GRID_LOCATOR, driver);

        return this;
    }


}
