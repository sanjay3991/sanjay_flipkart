package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Verification {
    WebDriver driver;

    public Verification(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }

    @FindBy(xpath = "//div[@class='XQDdHH']")
    List<WebElement> Ratings;

    @FindBy(xpath = "//div[@class='UkUFwK']/span")
    List<WebElement> Discount_percentage;

    @FindBy(xpath = "(//section[@class=\"-5qqlC _2OLUF3\"])[2]/descendant::div[@class='ewzVkT _3DvUAf']")
    List<WebElement> RatingElements;

    @FindBy(xpath = "//span[@class='Wphh3N']")
    List<WebElement> Reviews;

    public int Count_Rating_Less_than_4(){
        int count =0;
        for (WebElement webElement : Ratings) {
            if(Float.valueOf(webElement.getText()) <=4){
                count++;
            }
        }
        return count;
    }

    public void PrintTitleWithDiscount(){
        for (WebElement webElement : Discount_percentage) {
            String number = webElement.getText().replaceAll("\\D+", "");
            if(Integer.valueOf(number) > 17){
                WebElement Title = webElement.findElement(By.xpath("ancestor::div[@class='yKfJKb row']/div/div[@class='KzDlHZ']"));
                System.out.println(Title.getText()+" Having Discount "+webElement.getText());
            }
        }
    }

    public void clickRatingByValue(int val){
        for (WebElement webElement : RatingElements) {
            String Title = webElement.getAttribute("title");

            if(Title.contains(String.valueOf(val))){
                webElement.click();
                break;
            }
        }
    }

    public void PrintTitleAndImageUrlWtihTop(int val) throws InterruptedException{
        int i=0;
        int[] arr = new int[Reviews.size()];
        for (WebElement webElement : Reviews) {
            String cleanedValue = webElement.getText().replaceAll("[(),]", "").trim();
            arr[i] = Integer.valueOf(cleanedValue);
            i++;
        }
        Arrays.sort(arr);
        for (int j = arr.length-1; j>= arr.length-val; j--) {
            for (WebElement webElement : Reviews) {

                try {

                    if(arr[j] == Integer.valueOf(webElement.getText().replaceAll("[(),]", "").trim())){
                    
                        WebElement Href = webElement.findElement(By.xpath("ancestor::div[@class='slAVV4']/a[@class='VJA3rP']"));
                        WebElement Title = webElement.findElement(By.xpath("ancestor::div[@class='slAVV4']/a[@class='wjcEIp']"));
                        System.out.println("Title of Product : "+Title.getText());
                        System.out.println("Image Url : "+Href.getAttribute("href"));
                        System.out.println();
                        
                        
                    }
                } catch (StaleElementReferenceException e) {
                    
                    
                }
                
            }
        }


    }

}
