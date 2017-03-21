package my.company.steps;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Common {

    public static void checkValues(final String gridLocator, final WebDriver driver) {
        Predicate<WebDriver> waitCondition = new Predicate<WebDriver>() {

            public boolean apply(WebDriver webDriver) {
                System.out.println("wait for size>0 actual=" + driver.findElements(By.xpath(gridLocator)).size());
                return driver.findElements(By.xpath(gridLocator)).size() > 0;

            }

        };
        new WebDriverWait(driver, 20).until(waitCondition);
    }


    public static void waitXpathElementVisible(final String gridLocator, final WebDriver driver) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(gridLocator)));

    }


    public static void clickOnElement(By by, WebDriver driver) {
        boolean clicked = false;
        while (!clicked) {
            try {
                WebElement element = driver.findElement(by);

                new WebDriverWait(driver, 5).pollingEvery(2, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOf(element));
                Actions action = new Actions(driver);
                action.moveToElement(element).click(element).build().perform();
                clicked = true;
                System.out.println("Sucessfully Clicked on the element\n");
            } catch (StaleElementReferenceException e) {
                System.out.println("Element is not attached to the page document " + e.getStackTrace());
                e.toString();
                System.out.println("Trying to recover from currentURL stale element :" + e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println("Element  was not found in DOM " + e.getStackTrace());
            } catch (Exception e) {
                System.out.println("Element was not clickable " + e.getStackTrace());
            }
        }

    }

}


