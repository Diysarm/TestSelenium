package Cura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class before {

    WebDriver driver;
    //define xpath
    private final By H1Homepage = By.xpath("//h1[contains(text(), 'VISITING A DOCTOR IS ONE TOUCH AWAY')]");
    private final By ButtonSeeDoctor = By.xpath("//a[contains(text(),'See a Doctor')]");
    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cura.com/demo-home-health/");
        driver.manage().window().maximize();
    }
    @Test
    public void homePage(){
        driver.findElement(By.id("logo")).click();
        String ExpectedH1 = "VISITING A DOCTOR IS ONE TOUCH AWAY";
        String ActualH1 = driver.findElement(H1Homepage).getText();
        Assert.assertEquals(ExpectedH1, ActualH1);

        if(ExpectedH1.equals(ActualH1)){
            System.out.println("H1 Match");
        }else
            System.out.println("H1 NOT Match");

        WebElement seeDoctorButton = driver.findElement(ButtonSeeDoctor);

        boolean isClickable = seeDoctorButton.isDisplayed() && seeDoctorButton.isEnabled();
        Assert.assertTrue(isClickable, "The 'See a Doctor' button is not clickable");

        if (isClickable) {
            System.out.println("The 'See a Doctor' button is clickable.");
        } else {
            System.out.println("The 'See a Doctor' button is NOT clickable.");

        }

    }
}