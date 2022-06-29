package utility;

import com.aventstack.extentreports.service.ExtentService;

public class SystemInfo {
	
	public void setSystemInfo() {
		ExtentService.getInstance().setSystemInfo("Platform", "Desktop");
		ExtentService.getInstance().setSystemInfo("Java Version", "JDK 17");
		ExtentService.getInstance().setSystemInfo("Browser", "Chrome");
	}
}
