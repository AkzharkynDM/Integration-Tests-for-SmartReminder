
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
public class InstallationTests {
	//private AppiumDriver<MobileElement> driver=null;
	private AppiumDriverLocalService service=null;
	private AppiumServiceBuilder builder=null;
	
	@Test
	public void setUp() {
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
		caps.setCapability("appPackage", "https://github.com/AkzharkynDM/SmartReminder/tree/master/app/src/main/java/com/example/android/smartreminder");
		caps.setCapability("appActivity", "https://github.com/AkzharkynDM/SmartReminder/tree/master/app/src/main/java/com/example/android/smartreminder/MainActivity.java");
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
	}
			
	 @AfterTest
	 public void closeAll(){
		 service.stop();
		 //driver.quit();
	 }
	
}