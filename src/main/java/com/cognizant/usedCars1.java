package com.cognizant;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class usedCars1 extends Zigwheels{

	String[] pr510 = new String[25];
	public void takeScreenshots(String filename) throws IOException {		 
		File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source_file, new File((System.getProperty("user.dir")+"\\screenshot\\screenshot_")+filename+".png"));
		System.out.println("The screenshot is taken");		
	}	
		public void usedC() {
			
			driver.navigate().to("https://www.zigwheels.com/");
			
			
			driver.findElement(By.xpath("//a[@data-track-label='used-cars']")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//a[@data-track-label='used-cars-chennai']")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
			driver.findElement(By.xpath("/html/body/div[11]/div/div[2]/div[1]/div[1]/div[2]/ul/li[1]/div[2]/ul/li[3]/label")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)", "");
			
			try {
				
				Thread.sleep(2000);					
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			js.executeScript("window.scrollBy(0,800)", "");
			try {
				
				Thread.sleep(2000);					
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//takess();
			
			js.executeScript("window.scrollBy(0,1200)", "");
			try {
				
				Thread.sleep(2000);					
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//takess();
			
			
			js.executeScript("window.scrollBy(0,1600)", "");
			try {
				
				Thread.sleep(2000);					
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//takess();
			
			
			js.executeScript("window.scrollBy(0,2000)", "");
			try {
				
				Thread.sleep(2000);					
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			for(int i=1;i<=24;i++)
			{
				pr510[i]=driver.findElement(By.xpath("//div[starts-with (@class,'zw-sr')]["+i+"]/descendant::a[starts-with (@class ,'fnt-22')]")).getText();
			}
			
			
			

			driver.navigate().to("https://www.zigwheels.com/used-car/Chennai");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			driver.findElement(By.xpath("/html/body/div[11]/div/div[2]/div[1]/div[1]/div[2]/ul/li[1]/div[2]/ul/li[4]/label")).click();

			js.executeScript("window.scrollBy(0,400)", "");
			try {
				
				Thread.sleep(2000);					
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//takess();
			
			
			js.executeScript("window.scrollBy(0,800)", "");
			try {
				
				Thread.sleep(2000);					
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//takess();
			
			js.executeScript("window.scrollBy(0,1200)", "");
			try {
				
				Thread.sleep(2000);					
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//takess();
			
			js.executeScript("window.scrollBy(0,1600)", "");
			try {
				
				Thread.sleep(2000);					
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//takess();
			
			js.executeScript("window.scrollBy(0,2000)", "");
			try {
				
				Thread.sleep(2000);					
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			String pr1015[] = new String[25];
			
			
			for(int i=1;i<=24;i++)
			{
				pr1015[i]=driver.findElement(By.xpath("//div[starts-with (@class,'zw-sr')]["+i+"]/descendant::a[starts-with (@class ,'fnt-22')]")).getText();
			}
				
			
			try {
				takeScreenshots("used_cars");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	
		public void sortCar1()
		{
			System.out.println("Maruti cars between 5-10 lakhs");
			for(int i=1;i<=24;i++)
			{
				if(pr510[i].contains("Maruti"))
				{
					System.out.println(pr510[i]);
				}
			}
		}
		
		public void sortCar2()
		{
			System.out.println("Hyundai cars between 5-10 lakhs");
			for(int i=1;i<=24;i++)
			{
				if(pr510[i].contains("Hyundai"))
				{
					System.out.println(pr510[i]);
				}
			}
		}
		
		public void sortCar3()
		{
			System.out.println("Honda cars between 5-10 lakhs");
			for(int i=1;i<=24;i++)
			{
				if(pr510[i].contains("Honda"))
				{
					System.out.println(pr510[i]);
				}
			}
		}
		
}
