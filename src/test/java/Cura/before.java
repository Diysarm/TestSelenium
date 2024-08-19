package Cura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class before {

    WebDriver driver;
    // Define XPath
    final By H1Homepage = By.xpath("//h1[contains(text(), 'VISITING A DOCTOR IS ONE TOUCH AWAY')]");
    final By ButtonSeeDoctor = By.xpath("//a[contains(text(),'See a Doctor')]");

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cura.com/demo-home-health/");
        driver.manage().window().maximize();
    }
}
