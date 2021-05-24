package com.db.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class BaseUtil {

	public WebDriver Driver;
	public String executionMode;
	//public String selectedBrowser;
	public static String URLForExecution;
	public static long startTime = 0;
	public static List<String> str = null;
	public static String environmentBeingTested = "";

	public static String getTheEnvURL() throws IOException {
		try {
			File f = new File("Config.properties");
			FileInputStream fis = new FileInputStream(f);
			Properties p = new Properties();
			p.load(fis);
			String EnvForExecution = (String) p.get("URLForExecution");
			environmentBeingTested = EnvForExecution;
			switch (EnvForExecution.toLowerCase()) {
			case "betatest":
				URLForExecution = (String) p.get("BetaTestURL");
				break;
			default:
				Assert.fail("Incorrect 'URLForExecution' mentioned in the Config.properties file");
			}
			System.out.println("########################## URL For Execution ########################");
			System.out.println("##########################" + URLForExecution + "########################");
		} catch (FileNotFoundException ex) {
			Assert.fail("Config Properties file was not found");
		}
		startTime = System.currentTimeMillis();
		return URLForExecution;
	}

}
