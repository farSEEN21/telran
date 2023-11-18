package lesson_11;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumXpathIcarro {

    WebDriver driver;

    @BeforeClass
    public void preconditions() {
        driver = new ChromeDriver();
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void testH1Xpath() {
        String checking_text = driver.findElement(By.xpath("//div/h1")).getText();
        Assert.assertEquals(checking_text, "Find your car now!", "Correct text");
    }
    @Test
        public void testXpathByText() {
            String checking_text = driver.findElement(By.xpath("//*[text() = 'Find your car now!']")).getText();
            Assert.assertEquals(checking_text, "Find your car now!", "Correct text");
        }
    @Test
    public void testXpathByContains() {
        String checking_text =  driver.findElement(By.xpath("//*[contains(text(), 'now!')]")).getText();
        Assert.assertEquals(checking_text, "Find your car now!", "Correct text");
    }
    @Test
    public void testXpathByTypeID() {
        String checking_text =    driver.findElement(By.xpath("//input[@id='city']")).getAttribute("ng-reflect-name");
        Assert.assertEquals(checking_text, "city", "Correct text");
    }
 @Test
    public void testXpathByClass() {
        String checking_text =    driver.findElement(By.xpath("//div[@class='input-container']")).getAttribute("ng-reflect-name");
        Assert.assertEquals(checking_text, "city", "Correct text");
    }
 @Test
    public void testXpathByContain() {
        String checking_text =    driver.findElement(By.xpath("//input[contains(@id,'ci')]")).getAttribute("ng-reflect-name");
        Assert.assertEquals(checking_text, "city", "Correct text");
    }
 @Test
    public void testXpathByContainCI() {
        String checking_text =   driver.findElement(By.xpath("//input[contains(@id,'ci')]")).getAttribute("ng-reflect-name");
        Assert.assertEquals(checking_text, "city", "Correct text");
    }
 @Test
    public void testXpathByPartOfID() {
        String checking_text =    driver.findElement(By.xpath("//input[contains(@id,'ci') or contains(@id,'da')]")).getAttribute("ng-reflect-name");
        Assert.assertEquals(checking_text, "city", "Correct text");
    }
 @Test
    public void testXpathByPartIDorType() {
        String checking_text =   driver.findElement(By.xpath("//input[contains(@id,'ci') and @type='text']")).getAttribute("ng-reflect-name");
        Assert.assertEquals(checking_text, "city", "Correct text");
    }
 @Test
    public void testListElements() {

     List<WebElement> listInputs = driver.findElements(By.xpath("//input[@id]"));

         Assert.assertEquals(listInputs.size(), 2, "Correct length");
    }
 @Test
    public void testXpathByID() {
     WebElement parentOfInput = driver.findElement(By.xpath("//input[@id='city']/.."));
        Assert.assertEquals(parentOfInput.getAttribute("class"), "input-container", "Correct text");
    }


//
//        System.out.println(driver.findElement(By.xpath("//h1/following-sibling::h2")).getText());
//        System.out.println(driver.findElement(By.xpath("//h2/preceding-sibling::h1")).getText());
 //   }

//    @AfterClass
//    public void postConditions() {
//        driver.quit();
//    }
}