import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OverweightCategoryTest {
    @Test
    public void calculateOverweight() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("80");
        driver.findElement(By.name("ht")).sendKeys("174");
        driver.findElement(By.name("cc")).click();
        String actualCategoryText = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedCategoryText = "Your category is Overweight";
        Assert.assertEquals(actualCategoryText, expectedCategoryText, "Incorrect category is displayed: " + actualCategoryText);
        driver.close();
    }
}
