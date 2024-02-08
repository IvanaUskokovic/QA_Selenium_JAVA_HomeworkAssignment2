import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class TestCaseForTextBox {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");

        WebElement fullNameField = driver.findElement(By.id("userName"));
        fullNameField.sendKeys("John Smith");

        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys("john@yahoo.com");

        WebElement currentAddressField = driver.findElement(By.id("currentAddress"));
        currentAddressField.sendKeys("Address");

        WebElement permanentAddressField = driver.findElement(By.id("permanentAddress"));
        permanentAddressField.sendKeys("Address");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("submit")));

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(5000);


        String expectedURL = "https://demoqa.com/text-box";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement contactField = driver.findElement(By.id("output"));
        Assert.assertTrue(contactField.isDisplayed());

    }
}
