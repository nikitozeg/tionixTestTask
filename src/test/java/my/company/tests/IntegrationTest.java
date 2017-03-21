package my.company.tests;

import my.company.steps.*;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import static org.junit.Assert.assertEquals;

/**
 * @author Nikita Ivanov tazg@ya.ru
 *
 */

@Title("Suite contain positive and negative cases")
@Description("In this suite we'll make integration test")

public class IntegrationTest extends TestSettings {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Valid email and password")
    @Test
    public void lookAndFeelTest() throws Exception {
        LandingPage lp = new LandingPage(driver);
        PaymentsPage paymentsPage = lp.goToPaymentsPage();
        CommunnalPage crpage = paymentsPage.goToCommunalPage();
        crpage.checkLocation("г. Москва");
        assertEquals(crpage.getElement(0).getText(), "ЖКУ-Москва");
        ZhkuMskPage zk= crpage.clickOnGridElement(0);
        zk.checkCodeValidation();
        zk.checkDateValidation();
        lp.goToPaymentsPage();
        paymentsPage.userLookupItem("ЖКУ-Москва").lookupHasResult().checkFirstItem("ЖКУ-Москва").userClicksOnFoundItem(0);


    }


}

