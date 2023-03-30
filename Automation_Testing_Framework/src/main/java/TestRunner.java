import Managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager chromeDriverManager = new WebDriverManager("CHROME");
        chromeDriverManager.getDriver().get("https://demo.opencart.com/");
        HomePage homePage = new HomePage(chromeDriverManager.getDriver());
        homePage.navigateToREegisterPage();
        RegisterPage registerPage = new RegisterPage(chromeDriverManager.getDriver());
        registerPage.fillInTheRegisterForm("Iurie", "Reabenchi", "iuriereabenchi@rambler.ru","1111");

        Thread.sleep(3000);

        LoginPage loginPage = new LoginPage(chromeDriverManager.getDriver());
        loginPage.navigateToLoginPage();
        loginPage.fillLoginPage("Iura", "2222222");

        Thread.sleep(3000);
        loginPage.continueButton();
    }
}