import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Login {

	public static void main(String[] args) throws Exception {

		String vURL, vUsername, vPassword;
		String eXPath, eXPath1, eXPath2;

//Initialise the variables 
		
		vURL = "https://mycloud.mandc-test.com/";
		vUsername = "bob.bob";
		vPassword = "PearsonInterview";
		eXPath = "//*[@id=\"ctl00_ContentPlaceHolder1_PremiumDevice1_UsernameTextBox\"]";
		eXPath1 = "//*[@id=\"ctl00_ContentPlaceHolder1_PremiumDevice1_PasswordTextBox\"]";
		eXPath2 = "//*[@id=\"ctl00_ContentPlaceHolder1_PremiumDevice1_SubmitButton\"]";
		
		WebDriver myD = new FirefoxDriver ();
		myD.navigate().to(vURL);
		System.out.println("Test case starts, I am ready to login to myCloud");
		Thread.sleep(3000);
		
//Step 1 - Sending login Keys here
		
		myD.findElement(By.xpath(eXPath)).sendKeys(vUsername);	
		myD.findElement(By.xpath(eXPath1)).sendKeys(vPassword);
		myD.findElement(By.xpath(eXPath2)).click ();
		Thread.sleep(3000);
		

//Step 2 - Accepting T&C
		
		myD.findElement(By.xpath("//*[@id=\"btnAccept\"]")).click();
		Thread.sleep(3000);		
		
	
//Step 3 - Verify the presence of Google mail  
		
		
		String myText = myD.findElement(By.xpath("//*[@id=\"application1Name\"]")).getText();
		Thread.sleep(3000);
		System.out.println("Application name is " + myText);
		
		if (myText.equals("Google Mail")) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		
		try {
	    	assertTrue(myD.findElement(By.xpath("//*[@id=\"application1Name\"]")).getText().matches("Google Mail"));
	    
	    } catch (Error e){
	    	System.out.println("Error is" + e );
	    }
	  
		File myImg = ((TakesScreenshot)myD).getScreenshotAs(OutputType.FILE);
		String myP = "C://Selenium/Logintest.jpg";
		FileUtils.copyFile(myImg, new File(myP));
		Thread.sleep(2000);
	
		System.out.println("Test is Completed Successfully");
		
		myD.close();
		
	}

}