package demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import demo.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        System.out.println("Setup: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Count of items with different Star ratings, Prices and number of Reviews" ,enabled = true)
    public void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.flipkart.com/");

        HomePage HP = new HomePage(driver);
        HP.SearchProduct("Washing Machine");
        HP.clickOnPopularity();

        Verification VF = new Verification(driver);
        int Count = VF.Count_Rating_Less_than_4();
        System.out.println("No of Products have Rating <=4 : "+Count);

        System.out.println("End Test case: testCase01");
    }

    @Test(description = "“iPhone”, print the Titles and discount % of items with more than 17% discount",enabled = true)
    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.flipkart.com/");

        HomePage HP = new HomePage(driver);
        HP.SearchProduct("iPhone");

        Verification VF = new Verification(driver);
        VF.PrintTitleWithDiscount(); 

        System.out.println("End Test case: testCase02");
    }

    @Test(description = "select 4 stars and above, and print the Title and image URL of the 5 items with highest number of reviewst",enabled = true)
    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.flipkart.com/");

        HomePage HP = new HomePage(driver);
        HP.SearchProduct("Coffee Mug");

        Verification VF = new Verification(driver);
        VF.clickRatingByValue(4); 
        VF.PrintTitleAndImageUrlWtihTop(5);

        System.out.println("End Test case: testCase03");
    }

    @AfterMethod(enabled = true)
    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }
}
