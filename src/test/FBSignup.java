package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		System.setProperty("webdriver.chrome.driver", "chromedriver"); //Setting ChromeDriver
		
		WebDriver driver = new ChromeDriver(); //oject Created for Chrome Driver
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		

		WebElement SignupLink = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		SignupLink.click();
		
		WebElement FirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		FirstName.sendKeys("Rishabh");
		
		WebElement LastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		LastName.sendKeys("Sehgal");
		
		WebElement Email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		Email.sendKeys("9897533429");
		
		WebElement Password = driver.findElement(By.xpath("//input[@data-type='password']"));
		Password.sendKeys("Test@1234");

		//Date of Birth DropDowns
		
		WebElement Day = driver.findElement(By.name("birthday_day"));
		Select DDay = new Select(Day);
		DDay.selectByVisibleText("8");
		

		WebElement Month = driver.findElement(By.name("birthday_month"));
		Select ddMonth = new Select(Month);
		ddMonth.selectByVisibleText("Jan");
		
	  /*List<WebElement> Months = ddMonth.getOptions();
		
		for(WebElement elm: Months) {
			System.out.println(elm.getText());	
		} */
		
		System.out.println("Selected Month is " + ddMonth.getFirstSelectedOption().getText());

		
		List<WebElement> AllMonths = driver.findElements(By.xpath("//select[@name='birthday_month']/option"));
		for(WebElement elm: AllMonths) {
			System.out.println(elm.getText());	
			
		
		WebElement Year = driver.findElement(By.name("birthday_year"));
		Select YYear = new Select(Year);
		YYear.selectByVisibleText("1997");
		
		
	  //Gender Radio Button
		String Gender = "Male";
		
		/*	WebElement Male = driver.findElement(By.xpath("//input[@type='radio'and @value='2']"));
			WebElement Female = driver.findElement(By.xpath("//input[@type='radio'and @value='1']"));
			WebElement Other = driver.findElement(By.xpath("//input[@type='radio'and @value='-1']")); 
			
			
			if(Gender.equals("Male")) {
				Male.click();
			}
			if(Gender.equals("Female")) {
				Female.click();
			}
			if(Gender.equals("Other")) {
				Other.click(); 
			} */
			
			WebElement GenderRadioBtn = driver.findElement(By.xpath("//label[text()='" + Gender + "']/following-sibling::input"));
			GenderRadioBtn.click();
			
			WebElement SignUpButton = driver.findElement(By.xpath("//button[@name='websubmit']"));
			SignUpButton.click();
				

	}

}
}
