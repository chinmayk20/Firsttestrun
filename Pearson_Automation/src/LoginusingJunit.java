import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginusingJunit {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void OpenBrowser() throws Exception {
	System.out.println("Opening MyCloude URL Before every Test");  
    driver = new FirefoxDriver();
    baseUrl = "https://mycloud.mandc-test.com/";
  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(baseUrl);
  }
 
  @Test
  public void LoginTest() throws Exception {
	System.out.println("Running login Test");
	
	String vURL, vUsername, vPassword;
	String eXPath, eXPath1, eXPath2;
	
	vUsername = "bob.bob";
	vPassword = "PearsonInterview";
	eXPath = "//*[@id=\"ctl00_ContentPlaceHolder1_PremiumDevice1_UsernameTextBox\"]";
	eXPath1 = "//*[@id=\"ctl00_ContentPlaceHolder1_PremiumDevice1_PasswordTextBox\"]";
	eXPath2 = "//*[@id=\"ctl00_ContentPlaceHolder1_PremiumDevice1_SubmitButton\"]";
	
	driver.findElement(By.xpath(eXPath)).sendKeys(vUsername);	
	driver.findElement(By.xpath(eXPath1)).sendKeys(vPassword);
	driver.findElement(By.xpath(eXPath2)).click ();

	// Warning: verifyTextPresent may require manual changes
    try {
    	assertTrue(driver.findElement(By.xpath("//*[@id=\"application1Name\"]")).getText().matches("Google Mail"));
    
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    System.out.println("Test1 completed"); 
  }
  
  @After
  public void CloseBrowser() throws Exception {
    driver.quit();
    System.out.println("Closing the Browser");   

    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}