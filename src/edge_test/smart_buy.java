package edge_test;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class smart_buy {
	
	public WebDriver driver ;
//	public int num_of_try = 10 ;
	SoftAssert softassertProcces = new SoftAssert() ;
	
	
	
	
	@BeforeTest()
	
	public void this_is_before_test() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://smartbuy-me.com/smartbuystore/");
		driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[2]/a")).click();
		driver.manage().window().maximize();

	}
	
	
//	@Test()
//	
//	
//	public void adding_items_test() throws InterruptedException {
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		for(int i=0 ; i<num_of_try ; i++) {
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[3]/div/div[3]/div[1]/div/div/form[1]/div[1]/button")).click();
//			Thread.sleep(1000);
//			String msg = driver.findElement(By.xpath("//*[@id=\"addToCartLayer\"]/div[1]")).getText();
//			if(msg.contains("Sorry") || msg.contains("عذرا")) {
//				driver.findElement(By.xpath("//*[@id=\"addToCartLayer\"]/a[1]")).click();
//				num_of_try = i ;
//
//			}else {
//				driver.findElement(By.xpath("//*[@id=\"addToCartLayer\"]/a[2]")).click();
//
//			}
//		}
//		
//		
//		
//	}
//	
//	
//	
//	@Test()
//	
//	public void total_price() throws InterruptedException {
//		driver.navigate().back();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	String total_priceqq = 	driver.findElement(By.xpath("//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[3]/div/div[2]/div[2]/div/div/span[3]")).getText();
//	String updated_total_priceqq[] = total_priceqq.split(" ");
//	String final_total_price = updated_total_priceqq[0].trim().replace(",", ".") ;
//	double final_total_price_num = Double.parseDouble(final_total_price);
//	System.out.println(final_total_price_num);
//	System.out.println(final_total_price_num*num_of_try);
//	
//	
//	System.out.println("===================================");
//	Thread.sleep(1000);
//	driver.findElement(By.xpath("/html/body/main/header/div[4]/div/nav/div/div[3]/div/ul/li[1]/div/div/div[1]/a")).click();
//	Thread.sleep(1000);
//	String expected_total_price = driver.findElement(By.className("value")).getText();
//	String updated_expected_total_price[] = expected_total_price.split(" ");
//	String final_expected_total_price = updated_expected_total_price[0].trim().replace(",", ".").replaceAll(".000", "") ;
//	double expected_total_price_double = Double.parseDouble(final_expected_total_price);
//	System.out.println(expected_total_price_double);	
//	softassertProcces.assertEquals(final_total_price_num*num_of_try, expected_total_price_double);
//	softassertProcces.assertAll();
//	
//		
//	}
	
	@Test(invocationCount = 5)
	
	public void test_persentage() throws InterruptedException {
		Thread.sleep(1000);
		String disaccount = driver.findElement(By.xpath("//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[3]/div/div[2]/div[2]/div/div/span[1]")).getText();
		System.out.println(disaccount);
		String updated_disaccount = disaccount.replace("%", "").trim();
		System.out.println(updated_disaccount);
		double updated_disaccount_new = Double.parseDouble(updated_disaccount);
		
		
		String original_price = 	driver.findElement(By.xpath("//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[3]/div/div[2]/div[2]/div/div/span[2]")).getText();
	String updated_original_price[] = original_price.split(" ");
	String final_original_price = updated_original_price[0].trim().replace(",", "") ;
		double original_price_num = Double.parseDouble(final_original_price);
		System.out.println(original_price_num);
		double new_price = original_price_num - ((original_price_num*updated_disaccount_new)/100) ;
		double new_price11 = Math.round(new_price);
		System.out.println(new_price11);

		String total_priceqq = 	driver.findElement(By.xpath("//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[3]/div/div[2]/div[2]/div/div/span[3]")).getText();
		String updated_total_priceqq[] = total_priceqq.split(" ");
		String final_total_price = updated_total_priceqq[0].trim().replace(",", "") ;
		double final_total_price_num = Double.parseDouble(final_total_price);
		softassertProcces.assertEquals(final_total_price_num, new_price11);
	}



	
	
}



















