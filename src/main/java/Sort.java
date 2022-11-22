import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Sort {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //1. click on column to sort
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //2. capture all webelements into the list
        List<WebElement> webElementList = driver.findElements(By.xpath("//tr/td[1]"));

        //3. capture text values of all webelements into new list (original)
        List<String> originalList = webElementList.stream().map(s -> s.getText()).collect(Collectors.toList());

        //4. sort the original list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        //5. compare original list vs sorted list
        Assert.assertTrue(originalList.equals(sortedList));

        //6. scan the "Veg/fruit name" table and when find "Rice" then print out the Price
        List<String> price;

        do {
            List<WebElement> veggieNameList = driver.findElements(By.xpath("//tr/td[1]"));
            price = veggieNameList.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());

            price.forEach(a -> System.out.println(a));

            //pagination
            if (price.size() < 1) {
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
            }
        } while (price.size() < 1);
    }

    private static String getPriceVeggie(WebElement s) {
        // //tr/td[1]/following-sibling::td[1]
        // we have already "//tr/td[1]" webelements stored in "s" in point 2
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

        return priceValue;
    }
}
