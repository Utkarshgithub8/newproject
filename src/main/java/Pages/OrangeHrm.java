package Pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Base.Base;

public class OrangeHrm extends Base{
	
	public void login() throws InterruptedException  {
		
		//driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		//WebDriverWait wait1 = new WebDriverWait(driver, 20);
		//WebElement element1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='oxd-table']")));
		Thread.sleep(2000);
		WebElement s = driver.findElement(By.xpath("//div[@class='oxd-table']"));
        String st = s.getText();
		System.out.println(st);
		
	    try {
	    	PrintStream ps = new PrintStream(new File("Output File\\DemoFile.txt"));
	    	System.setOut(ps);
	    	ps.print(st);
	    }
		catch 
		
		(FileNotFoundException ft)
		{
			System.out.println(ft);
		}
		driver.close();
	}

}



