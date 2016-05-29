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
    protected String valid_email;
    String user;
    String hostname;
    String domain;
    protected String valid_password;

    @Before //will be executed before every test
    public void setUp() {
        valid_password = "abcDEF12345";
        user = String.valueOf(0 + (int) (Math.random() * ((999999999) + 1))); //dirty hack (can not delete test data)
        hostname = "hostname";
        domain = "com";
        valid_email = user + "@" + hostname + "." + domain;
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(); //chrome will started for visual-control, should be change for headless
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //set implicit wait
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get("https://portal.aws.amazon.com/gp/aws/developer/registration/index.html"); //open page

    }

    @After //will be executed after every test
    public void tearDown() {
        driver.quit(); //close browser and clear session
    }
}

