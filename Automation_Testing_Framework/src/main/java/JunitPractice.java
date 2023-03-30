import Managers.WebDriverManager;
import org.junit.jupiter.api.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

public class JunitPractice {
    WebDriverManager chromeDriverManager = new WebDriverManager("CHROME");
    @BeforeEach
    public void beforeTestProcedure(){
        chromeDriverManager.getDriver().get("https://demo.opencart.com/");
    }
    @AfterEach
    public void afterTestInstructions(){
        chromeDriverManager.getDriver().close();
    }

    @Test
    @DisplayName("Adresa URL a paginii Register este disponibila din pagina Home")
    public void verufyIfTheRegisterPageIsAcesible(){
        HomePage homePage = new HomePage(chromeDriverManager.getDriver());
        homePage.navigateToREegisterPage();
        boolean urlIsValid = chromeDriverManager.getDriver().getCurrentUrl().contains("register");
        Assertions.assertTrue(urlIsValid, "Adresa URL nu este valida");
    }
    @Test
    @DisplayName("Register page elements are displayed")
    public void registerPageElementsAreDispalyed(){
        HomePage homePage = new HomePage(chromeDriverManager.getDriver());
        homePage.navigateToREegisterPage();
        RegisterPage registerPage = new RegisterPage(chromeDriverManager.getDriver());
        Assertions.assertTrue(registerPage.allElementsAreDispayed(), "Cel putin unul din elemente nu a fost afisat");
    }
}
