import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginusingJunit {
	
	private WebDriver driver;

@Before

public void OpenBrowser () throws Exception {
	
	String vURL;
	vURL = "https://mycloud.mandc-test.com/";
	System.out.println( "Open MyCloud URL");
	driver = new FirefoxDriver ();
	driver.navigate().to(vURL);
	Thread.sleep(3000);

}

@Test

public void logintest () {

	String eXPath, eXPath1, eXPath2;
	String vUsername, vPassword;
	vUsername = "bob.bob";
	vPassword = "PearsonInterview";
	eXPath = "//*[@id=\"ctl00_ContentPlaceHolder1_PremiumDevice1_UsernameTextBox\"]";
	eXPath1 = "//*[@id=\"ctl00_ContentPlaceHolder1_PremiumDevice1_PasswordTextBox\"]";
	eXPath2 = "//*[@id=\"ctl00_ContentPlaceHolder1_PremiumDevice1_SubmitButton\"]";
	driver.findElement(By.xpath(eXPath)).sendKeys(vUsername);	
	driver.findElement(By.xpath(eXPath1)).sendKeys(vPassword);
	driver.findElement(By.xpath(eXPath2)).click ();
	
	System.out.println( "Login is Successful");
}

@After

public void CloseBrowser () {
	
	driver.findElement(By.xpath("//*[@id=\"userDetailsSignOut\"]")).click ();
	driver.quit();
	System.out.println( "Closing the Browser");
}


}
