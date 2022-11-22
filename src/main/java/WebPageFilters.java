import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WebPageFilters {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // insert text into Search window to filter results
        driver.findElement(By.cssSelector("#search-field")).sendKeys("Rice");

        //collect all veggies names (after text "Rice" is insert into search window)
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));

        //filter all veggies which contains "Rice" text
        List<WebElement> filteredList = veggies.stream().filter(s -> s.getText().contains("Rice")).collect(Collectors.toList());

        //check if results (veggies) from "search" window are equals to filtered list - check by comparing size of lists
        Assert.assertEquals(veggies.size(), filteredList.size());

    }
}
