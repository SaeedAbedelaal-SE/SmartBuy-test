package edge_test;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sec_class {
	
	public WebDriver driver ;

	
	
	
	@BeforeTest
	
	public void Login() {
		
		WebDriverManager.chromedriver().setup();

		
		driver = new ChromeDriver();
		
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		

	}
	
	
	@Test()
	
	
	public void test_select () throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).click();
		List <WebElement> thePrices = driver.findElements(By.className("inventory_item_price"));
		List <Double> thePricesEdited = new ArrayList<>();
		
		for(int i=0 ; i<thePrices.size() ; i++) {
			
			String price = thePrices.get(i).getText();
			String editPrice = price.replace("$", "");
			double val =Double.parseDouble(editPrice.trim());
			thePricesEdited.add(val);
			
		}
		
		for(int k=0 ; k<thePricesEdited.size() ; k++) {
			
			boolean checkProcces = thePricesEdited.get(0) < thePricesEdited.get(thePricesEdited.size()-1) ;
			Assert.assertEquals(checkProcces, true);
		}
		
		
	}
	
	

}
