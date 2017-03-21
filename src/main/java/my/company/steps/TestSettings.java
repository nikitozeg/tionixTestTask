package my.company.steps;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


/**
 * @author Nikita Ivanov tazg@ya.ru
 */

public class TestSettings {

    protected WebDriver driver;

    @Before //will be executed before every test
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(); //chrome will started for visual-control, should be change for headless
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //set implicit wait
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.tinkoff.ru/"); //open page

    }

    @After //will be executed after every test
    public void tearDown() {
        driver.quit(); //close browser and clear session
    }
}

