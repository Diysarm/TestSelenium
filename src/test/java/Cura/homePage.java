package Cura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homePage extends before {

    @Test
    public void testHomePage() {
        driver.findElement(By.id("logo")).click();

        String ExpectedH1 = "VISITING A DOCTOR IS ONE TOUCH AWAY";
        String ActualH1 = driver.findElement(H1Homepage).getText();
        Assert.assertEquals(ExpectedH1, ActualH1);

        if (ExpectedH1.equals(ActualH1)) {
            System.out.println("H1 Match");
        } else {
            System.out.println("H1 NOT Match");
        }

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
