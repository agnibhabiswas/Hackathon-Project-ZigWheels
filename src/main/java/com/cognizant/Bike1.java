package com.cognizant;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Bike1 extends Zigwheels {
	
	public void takeScreenshots(String filename) throws IOException {		 
		File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source_file, new File((System.getProperty("user.dir")+"\\screenshot\\screenshot_")+filename+".png"));
		System.out.println("The screenshot is taken");		
	}
	
	@Test(priority=6)
	public void newBikes() throws InterruptedException
	{
	  Actions actions = new Actions(driver);
	 
	  WebElement target = driver.findElement(By.xpath("//a[@data-track-component='navigation' and @href='/newbikes' ]"));
	  actions.moveToElement(target).build().perform();
	  driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	  driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/div[2]/ul/li[3]/ul/li/div[1]/ul/li[3]/a")).click();
	  driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	  try {
			takeScreenshots("new_bikes");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@Test(priority=7)
	public void hondaBikes()
	{
		WebElement choose = driver.findElement(By.xpath("//*[@id=\"makeId\"]"));
		Select select=new Select(choose);
		select.selectByIndex(7);

		driver.findElement(By.xpath("//span[@class=\"zw-cmn-loadMore\"]")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			takeScreenshots("honda_bikes");
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
	}
		
	@Test(priority=8)
	public void selectDetails()
	{		
		List<WebElement> bikes = driver.findElements(By.xpath("//div[@class=\"clr-bl p-5\"]"));
		count= bikes.size();
		
		
		for(int i=1;i<=count;i++) {
			
			WebElement bikeName = driver.findElement(By.xpath("//li[starts-with(@class, \"col\")]["+i+"]/descendant::strong"));
			WebElement bikePrice = driver.findElement(By.xpath("//li[starts-with(@class, \"col\")]["+i+"]/descendant::div[starts-with(@class, \"clr-bl\")]"));
		    WebElement bikeDate = driver.findElement(By.xpath("//li[starts-with(@class, 'col')]["+i+"]/descendant::div[starts-with(@class, 'clr-try')]"));
		    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		    
		    int count1=0;
			String price1 = bikePrice.getText();
			String price2 =price1.replace("Rs.", "");
			boolean isLakhs = price1.contains("Lakh");
			if(isLakhs) {
				String price3= price2.replaceAll("[^0-9.0-9]", "");
				float price4 = Float.parseFloat(price3) * 100000;
				int price5 = (int)price4;
				//System.out.println(price5);
				if(price5<400000) {
					
					System.out.println(bikeName.getText());
					System.out.println(bikePrice.getText());
					System.out.println(bikeDate.getText());
					
				}
				
			
			}else {
				System.out.println(bikeName.getText());
				System.out.println(bikePrice.getText());
				System.out.println(bikeDate.getText());
			}
		}		
	}
}
