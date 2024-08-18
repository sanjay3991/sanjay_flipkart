package demo;

import java.security.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize the elements
    }

    @FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']")
    WebElement Searchbox;

    @FindBy(xpath = "//div[normalize-space()='Popularity']")
    WebElement Popularity_link;

    public void SearchProduct(String ProductName) throws InterruptedException {
        Searchbox.clear();
        Searchbox.sendKeys(ProductName);
        Searchbox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    public void clickOnPopularity() throws InterruptedException{
        Popularity_link.click();
        Thread.sleep(2000);
    }
}
