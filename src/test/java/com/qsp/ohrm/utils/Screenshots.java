package com.qsp.ohrm.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
	public static String takeScreenshot(WebDriver driver, String fileName){
		File f =null;
		fileName = fileName + ".png";
		String directory = "reports\\ss\\";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			f= new File(directory + fileName);
			Log.info("Screen shot path : " + f.getAbsolutePath());
			FileUtils.copyFile(sourceFile, f);
		} catch (IOException e) {
			Log.info("Error while taking screenshot...");
			e.printStackTrace();
		}
		return f.getAbsolutePath();
	}
	
	public static String getCurrentDateAndTime() {
		Date date = new Date();
		String date1 = date.toString().replaceAll(" ", "_").replaceAll(":", "_");
		// display time and date using toString()
		System.out.println(date1);

		return date1;
	}

}