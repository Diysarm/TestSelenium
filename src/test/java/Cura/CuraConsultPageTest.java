package Cura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CuraConsultPageTest extends BookAppointmentPageTest{
    //Data
    String DataFirstName = "Muhammad";
    String DataLastName = "Rasyid";
    String DataH3TitleExpected = "Cura Consultation Page";
    //locators
    final By FirstNameObject = By.id("input_1_4_3");
    final By LastNameObject = By.id("input_1_4_6");
    final By H3TitleObject = By.xpath("//h3[contains(text(),'Cura Consultation Page')]");
    final By DOBFieldObject = By.id("input_1_5");
    final By DatePickerUIObject = By.id("ui-datepicker-div");
    final By SelectDateDOB =  By.xpath("//a[@data-date='6']");
    WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test(priority = 3)
    public void VerifyH3Title() {
        String DataH3TitleActual = driver.findElement(H3TitleObject).getText();
        Assert.assertEquals(DataH3TitleActual, DataH3TitleExpected);

    }
    @Test(priority = 3)
    public void InputFirstName() {
        driver.findElement(FirstNameObject).clear();
        driver.findElement(FirstNameObject).sendKeys(DataFirstName);
        String EnteredFirstname = driver.findElement(FirstNameObject).getAttribute("value");
        Assert.assertEquals(EnteredFirstname, DataFirstName);
    }
    @Test(priority = 3)
    public void InputLastName() {
        driver.findElement(LastNameObject).clear();
        driver.findElement(LastNameObject).sendKeys(DataLastName);
        String EnteredLastname = driver.findElement(LastNameObject).getAttribute("value");
        Assert.assertEquals(EnteredLastname, DataLastName);
    }
    @Test(priority = 3)
    public void InputDOBField() {

        driver.findElement(DOBFieldObject).click();
        driver.findElement(DatePickerUIObject).isDisplayed();
    }
    @Test(priority = 3)
    public void SelectMonthDropDown(){
            WebElement SelectMonthDOB = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
            WebElement SelectedOption = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']/option[@value='3']"));
            String SelectedMonth = SelectedOption.getText();

            Select SelectMonth = new Select(SelectMonthDOB);
            SelectMonth.selectByValue("3");

            if(SelectedMonth.equals("April")){
                System.out.println("Bulan sudah sesuai = " + SelectedMonth);
            }else{
                System.out.println("Bulan belum sesuai = " + SelectedMonth);
            }
        }

    @Test(priority = 3)
    public void SelectYearDropDown() {
        WebElement SelectYearDOB = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        WebElement SelectedOption = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']/option[@value='1994']"));
        String SelectedYear = SelectedOption.getText();

        Select SelectYear = new Select(SelectYearDOB);
        SelectYear.selectByValue("1994");

        if (SelectedYear.equals("1994")) {
            System.out.println("Tahun sudah sesuai = " + SelectedYear);
        } else {
            System.out.println("Tahun belum sesuai = " + SelectedYear);
        }
        }
    }
