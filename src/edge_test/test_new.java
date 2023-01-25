package edge_test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class test_new {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.edge.driver", "C:\\edgeDriver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://127.0.0.1:5500/index.html");
//		driver.manage().window().maximize();
//		
//		Date currentDate = new Date();
//		String actualDate = currentDate.toString().replace(":", " ");
//		
//		TakesScreenshot src = ((TakesScreenshot) driver);
//		File SrcFile = src.getScreenshotAs(OutputType.FILE);
//		File dest = new File(".\\\\images\\"+actualDate+".png");
//		FileUtils.copyFile(SrcFile, dest);

		List<WebElement> numOfStudent = driver.findElements(By.tagName("option"));

		System.out.println("numOfStudent:" + numOfStudent.size());
		int originalNum = numOfStudent.size();

		int numWeRemove = 16;
		System.out.println("numWeRemove:" + numWeRemove);

		for (int i = 0; i < numWeRemove; i++) {
			if (i%2 == 0) {
				numOfStudent.get(i).click();
				System.err.println("sorry i will remove " + numOfStudent.get(i).getText());
				driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
			}
		}

		List<WebElement> newNum = driver.findElements(By.tagName("option"));
		int numOfStudentAfterRemove = newNum.size();
		System.out.println("the num after remove =" + numOfStudentAfterRemove);

		int expectedNum = originalNum - numWeRemove / 2;
		System.out.println("expectedNum:" + expectedNum);

		Assert.assertEquals(numOfStudentAfterRemove, expectedNum);
		
		
		Date currentDate = new Date();
		String actualDate = currentDate.toString().replace(":", " ");
		TakesScreenshot src = ((TakesScreenshot) driver);
		File SrcFile = src.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\\\images\\"+actualDate+".png");
		FileUtils.copyFile(SrcFile, dest);


	}
	
	

}

