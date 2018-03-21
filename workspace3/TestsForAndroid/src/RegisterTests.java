import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import static org.testng.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Keys;

public class RegisterTests {
// Object of Connection from the Database
	private Connection conn = null;

// Object of Statement. It is used to create a Statement to execute the query
	private Statement stmt = null;

//Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
	private ResultSet resultSet = null;
	private WebDriver webdriver;
	private AppiumDriver<MobileElement> androiddriver=null;
	//private AppiumDriver<MobileElement> driver=null;
	private AppiumDriverLocalService service=null;
	private AppiumServiceBuilder builder=null;
	
	private MobileElement editTextName;
	private MobileElement editTextNickname;
	private MobileElement editTextPassword;
	private MobileElement editTextEmail;
	private MobileElement editTextConfirmPassword;		
	
	@BeforeTest
	public void SetUpConnection() throws SQLException, ClassNotFoundException {
			
		//Set the Desired Capabilities
				DesiredCapabilities caps = new DesiredCapabilities();
				/*caps.setCapability("deviceName", "My Phone");
				caps.setCapability("udid", "ENUL6303030010"); //Give Device ID of your mobile phone
				caps.setCapability("platformName", "Android");
				caps.setCapability("platformVersion", "6.0");*/
				caps.setCapability("BROWSER_NAME", "Android"); 
				caps.setCapability("VERSION", "6");  
				caps.setCapability("deviceName","Android Emulator"); 
				caps.setCapability("platformName","Android");
				caps.setCapability("avd","Nexus6P");     
				caps.setCapability("appPackage", "https://github.com/Samir689/SmartReminder/tree/master/app/src/main/java/com/example/android/smartreminder");
				caps.setCapability("appActivity", "https://github.com/Samir689/SmartReminder/tree/master/app/src/main/java/com/example/android/smartreminder/RegisterActivity.java");
				caps.setCapability("noReset", "true");
				
				//Build the Appium service
				builder = new AppiumServiceBuilder();
				builder.withIPAddress("127.0.0.1");
				builder.usingPort(4723);
				builder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
				builder.withAppiumJS(new File("C:\\Users\\User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"));
				//builder.withLogFile(new File("C:\\Users\\User\\workspace\\AppiumTest\\ConsoleLogs\\AppiumConsoleLogs.txt")));
				
				builder.withCapabilities(caps);
				builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
				builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
						
				service = AppiumDriverLocalService.buildService(builder);
					
				service.start();		
				
				//Instantiate Appium Driver			
				/*try {
						driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
					
				} catch (MalformedURLException e) {
					System.out.println(e.getMessage());
				}*/		
				// Register JDBC driver (JDBC driver name and Database URL)
				//Class.forName("org.sqlite.JDBC");

				//create a jdbc connection to book.db located in below file path
				//String path="jdbc:sqlite:E:\\test\\usersManager.db";
				//String path="\\data\\data\\smartreminder\\databases\\usersManager.db";
				//String path="data/data/smartreminder/databases/usersManager.db";
				//conn = DriverManager.getConnection(path);
				  		
				/*System.setProperty("webdriver.chrome.driver", "<Path of Driver>\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();

				// Code to disable the popup of saved password
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("password_manager_enabled", false);
				options.setExperimentalOption("prefs", prefs);
				webdriver = new ChromeDriver(options);
				webdriver.get("<URL>");*/
				
				
	}


@Test
public void OperationalMethod() {
	try {
		Path path = null;
	    try {
	      path = Files.createTempFile("cms", ".db");
	      path.toFile().setWritable(true);
	      path.toFile().getParentFile().setWritable(true);		     
	      Class.forName("org.sqlite.JDBC");
	     // This following statement throws an exception.
	      try(
	        Connection connection =
	            DriverManager.getConnection(
	                 "jdbc:sqlite:" +  path.toFile().getCanonicalPath());) {

	        // Prepared Statements and result set query to return the appropriate output.
	        }
	      
	    } catch (Exception e) {
	      System.out.println("Unable to create a temporary file: cms.db");
	      try {
			throw e;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    } finally {
	      if (path != null) {
	        path.toFile().deleteOnExit();
	      }
	    }				
	
		String query = " Insert into contacts (WHERE user_name, nick_name , user_email, user_password, user_salt) values(?,?,?,?,?)";
		
		editTextName=androiddriver.findElement(By.tagName("textInputEditTextName"));
		editTextNickname=androiddriver.findElement(By.tagName("textInputEditTextNickName"));
		editTextPassword=androiddriver.findElement(By.tagName("textInputEditTextPassword"));	
		editTextEmail=androiddriver.findElement(By.tagName("textInputEditTextEmail"));
		editTextConfirmPassword=androiddriver.findElement(By.tagName("textInputEditTextConfirmPassword"));
		
		editTextName.findElement(By.tagName("textInputEditTextName")).sendKeys("newUserName");
		editTextNickname.findElement(By.tagName("textInputEditTextName")).sendKeys("newUserNickname");
		editTextPassword.findElement(By.tagName("textInputEditTextName")).sendKeys("new12345678");
		editTextEmail.findElement(By.tagName("textInputEditTextName")).sendKeys("newUserEmail@gmail.com");
		editTextConfirmPassword.findElement(By.tagName("textInputEditTextName")).sendKeys("new12345678");
		
		editTextName.sendKeys(Keys.RETURN);
		editTextNickname.sendKeys(Keys.RETURN);
		editTextPassword.sendKeys(Keys.RETURN);
		editTextEmail.sendKeys(Keys.RETURN);
		editTextConfirmPassword.sendKeys(Keys.RETURN);
		
		MobileElement register=androiddriver.findElement(By.name("Register"));
		register.click();  
		
		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString(1, editTextName.getText());
		preparedStmt.setString(2, editTextNickname.getText());
		preparedStmt.setString(3, editTextEmail.getText());
		preparedStmt.setString(4, editTextPassword.getText());
		
		// execute the preparedstatement
		preparedStmt.execute();
		//conn.close();
	} catch (Exception e) {
		System.out.println("Got an exception!");
		System.out.println(e.getMessage());
	}
}

public void CloseTheConnection() throws SQLException {
//To clean all entered data
	editTextName.findElement(By.tagName("textInputEditTextName")).sendKeys("");
	editTextNickname.findElement(By.tagName("textInputEditTextName")).sendKeys("");
	editTextPassword.findElement(By.tagName("textInputEditTextName")).sendKeys("");
	editTextEmail.findElement(By.tagName("textInputEditTextName")).sendKeys("");
	editTextConfirmPassword.findElement(By.tagName("textInputEditTextName")).sendKeys("");
	

//To delete entered registration credentials
	String query = " Delete from contacts WHERE user_name, nick_name , user_email, user_password, user_salt";
	stmt = conn.createStatement();
	resultSet = stmt.executeQuery(query);

	
// Code to close each and all Object related to Database connection
if (resultSet != null) {
	try {
		resultSet.close();
	} catch (Exception e) {
	}
}

if (stmt != null) {
	try {
		stmt.close();
	} catch (Exception e) {
	}
}

if (conn != null) {
	try {
		conn.close();
	} catch (Exception e) {
	}
}

webdriver.quit();
androiddriver.quit();
}

}
