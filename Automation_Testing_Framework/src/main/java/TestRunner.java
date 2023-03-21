import Managers.WebDriverManager;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager webDriverManager = new WebDriverManager("FIREFOX");
        webDriverManager.getDriver().get("https://www.autodoc.de/");
        webDriverManager.getDriver().close();
    }
}
