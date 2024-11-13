package TutorialsNinja.Register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {
	
	
	@Test
	public static void VerifyTheRegisteringWithValidFields() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Ashish");
		driver.findElement(By.id("input-lastname")).sendKeys("Bahurupi");
		driver.findElement(By.id("input-email")).sendKeys(GenerateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("9595959595");
		driver.findElement(By.id("input-password")).sendKeys("ashish@1234");
		driver.findElement(By.id("input-confirm")).sendKeys("ashish@1234");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		String successMessage=driver.findElement(By.xpath("//div[@id='content']")).getText();
		System.out.println(successMessage);
		
		System.out.println(successMessage.contains(successMessage));
		String properDetailsOne="Congratulations! Your new account has been successfully created!";
		String properDetailsTwo="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String properDetailsThree="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String properDetailsFour="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
		String actualProperDetailsText=driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
		Assert.assertTrue(actualProperDetailsText.contains(properDetailsOne));
		Assert.assertTrue(actualProperDetailsText.contains(properDetailsTwo));
		Assert.assertTrue(actualProperDetailsText.contains(properDetailsThree));
		Assert.assertTrue(actualProperDetailsText.contains(properDetailsFour));
		System.out.println(driver.findElement(By.linkText("Logout")).isDisplayed());
		driver.findElement(By.linkText("Continue")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Account")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();
		
	}
	
	public static String GenerateEmail()
	{
		Date date=new Date();
		String dateString=date.toString();
		String noSpaceDate=dateString.replaceAll(" ", "");
		String realDateWithoutSpaces=noSpaceDate.replace(":", "");
		String emailWithTimeStamp = realDateWithoutSpaces+"@gmail.com";
		System.out.println(emailWithTimeStamp);
		return emailWithTimeStamp;
		
	}

}
