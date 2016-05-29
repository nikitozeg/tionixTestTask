package my.company.tests;

import my.company.steps.CredentialsPage;
import my.company.steps.LandingPage;
import my.company.steps.RegistrationPage;
import my.company.steps.TestSettings;
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

@Title("Suite contain positive cases")
@Description("In this suite we'll test login form in positive case")
public class RegistrationFormTest extends TestSettings {

    @Severity(SeverityLevel.BLOCKER)
    @Description("Valid email and password")
    @Test
    public void lookAndFeelTest() throws Exception {
        LandingPage lp = new LandingPage(driver);
        CredentialsPage crpage = lp.goToCredentialPage(valid_email);
        assertEquals(valid_email,crpage.getEmailInputContent());
        crpage.userTypeName("name");
        crpage.userRepeatEmail(valid_email);
        crpage.userTypePwd(valid_password);
        crpage.userRepeatPwd(valid_password);
        RegistrationPage regpage = crpage.userPressCreateAccount();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Valid email and password")
    @Test
    public void differentPwdTest() throws Exception {
        LandingPage lp = new LandingPage(driver);
        CredentialsPage crpage = lp.goToCredentialPage(valid_email);
        assertEquals(valid_email,crpage.getEmailInputContent());
        crpage.userTypeName("name");
        crpage.userRepeatEmail(valid_email);
        crpage.userTypePwd(valid_password);
        crpage.userRepeatPwd("invalid_pwd");
        crpage.userPressCreateAccount();
        assertEquals("Проверьте, что пароли совпадают, и попробуйте снова.",crpage.getErrorMsg());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Valid email and password")
    @Test
    public void invalidEmailTest() throws Exception {
        LandingPage lp = new LandingPage(driver);
        CredentialsPage crpage = lp.goToCredentialPage("invalidemail");
        assertEquals("invalidemail",crpage.getEmailInputContent());
        crpage.userTypeName("name");
        crpage.userRepeatEmail("invalidemail");
        crpage.userTypePwd(valid_password);
        crpage.userRepeatPwd(valid_password);
        crpage.userPressCreateAccount();
        assertEquals("Ваш адрес электронной почты имеет недействительный формат. Внесите исправления и попробуйте снова.",crpage.getErrorMsg());
    }


}

