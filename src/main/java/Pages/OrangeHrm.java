package Pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Base.Base;

public class OrangeHrm extends Base {
	By user = By.xpath("//input[@placeholder='Username']");
	By pass = By.xpath("//input[@placeholder='Password']");
	By submit = By.xpath("//button[@type='submit']");
	By admin = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");
	By print = By.xpath("//div[@class='oxd-table']");
 
	public void login() throws InterruptedException {
 
		driver.findElement(user).sendKeys("Admin");
		driver.findElement(pass).sendKeys("admin123");
		driver.findElement(submit).click();
		driver.findElement(admin).click();
        Thread.sleep(1000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
        driver.findElement(submit).click();
		Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(print));
		WebElement s = driver.findElement(print);
		String st = s.getText();
		System.out.println(st);
 
		try {
			PrintStream ps = new PrintStream(new File("Output File\\DemoFile.txt"));
			System.setOut(ps);
			ps.print(st);
		} catch
 
		(FileNotFoundException ft) {
			System.out.println(ft);
		}
		driver.close();
	}

}



