 package mainproject;
// <artifactId>ibmProject</artifactId>
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Test_Runner {
	WebDriver driver;
	  //1st test to perform verifcation of Admin group that is System administrators	
	  @Test(priority=1)
	  public void f1() throws InterruptedException {
	     Actions builder=new Actions(driver);
	     //click in "Personal"                                                                                                                                                                                
		 Action mouseoverhome= builder.moveToElement(  driver.findElement(By.xpath("//*[@id='menu1']/span[2]"))).build();
		 mouseoverhome.perform();
		 Thread.sleep(3000);
		 //click in "profile"
		 driver.findElement(By.xpath("//*[@id='menu1']/span[2]")).click();
		 //click in "Admin group"
		 driver.findElement(By.xpath(".//*[@id='submenu1.0']/span[2]")).click();
		 //taking value from "Admin group"
	     String s=driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/input")).getAttribute("value");
		 System.out.println(s);
		 Thread.sleep(3000);
		 System.out.println("1st test to perform verifcation of Admin group that is System administrators");
		  }
	  //2nd test to perform verifcation of Login name that is admin
	  @Test(priority=2)
	  public void f2() throws InterruptedException
	  {  
		  ///taking value from "Login name"
		  String s=driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input")).getAttribute("value");
	      System.out.println(s);
	      Thread.sleep(3000);  
	      System.out.println("2nd test to perform verifcation of Login name that is admin");
	   }
	  //3rd test to edit the Full name
	  @Test(priority=4)
	  public void f3() throws InterruptedException
	  {
		  //click in "Change Button"
		  driver.findElement(By.id("modifyButton")).click();
		 //clear the content of"Full name"  
		  driver.findElement(By.xpath("//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")).clear();
			Thread.sleep(3000);
			//Give string value to "Full name'
			driver.findElement(By.xpath("//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")).sendKeys("srikumar");
			//click in"submit button"
			driver.findElement(By.id("saveButton")).click();
			Thread.sleep(3000);
			Alert alert=driver.switchTo().alert();
			 alert.accept();
			  System.out.println("3rd test to edit the Full name");
	  }
	  //4th test to edit the E-Mail
	  @Test(priority=5)
	  public void f4() throws InterruptedException
	  {      //click in "Change Button"
		   driver.findElement(By.id("modifyButton")).click();
		 //clear the content of"Email"
		   driver.findElement(By.xpath("//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/input")).clear();
		  	Thread.sleep(3000);
		  //Give string value to "Email"
		  	driver.findElement(By.xpath("//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/input")).sendKeys("srikumar@gmail.com ");
		  //click in"submit button"
		  	driver.findElement(By.id("saveButton")).click();
		  	Thread.sleep(3000);
		  	Alert alert=driver.switchTo().alert();
			alert.accept();
			System.out.println("4th test to edit the E-Mail");
	  }
	  //5th test click "Change password" and change the password
	  @Test(priority=6)
	  public void f5() throws InterruptedException
	  {   
		  ////click in "password change"
		  driver.findElement(By.xpath("//*[@id='submenu1.1']/span[2]")).click();
		  Thread.sleep(3000);
		  //submit value to"Current password"
		  driver.findElement(By.xpath("//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input")).sendKeys("1234");
		  //submit value to"New password"
		  driver.findElement(By.xpath("//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")).sendKeys("1234"); 
		//submit value to"Confirm new password"
		  driver.findElement(By.xpath("//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/input")).sendKeys("1234"); 
		//click in"submit button"
		  driver.findElement(By.xpath("//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[5]/td/input")).click();
		  Thread.sleep(3000); 
		  Alert alert=driver.switchTo().alert();
		  alert.accept();
		  System.out.println("5th test click Change password and change the password");
	  }
	  //6th test to check whether the "Admin group that is System administrators" and "Login name that is admin" is editable or not
	  @Test(priority=3)
	  public void f6() throws InterruptedException
	  {
		 //click in "Personal"  
		 driver.findElement(By.xpath(".//*[@id='submenu1.0']/span[2]")).click();
	     //check whether the Admin group is editable or not.
		 driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/input")).isEnabled();
		 Thread.sleep(3000); 
		 //check whether the Login name is editable or not.
		 driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input")).isEnabled();
	     Thread.sleep(3000); 
	     System.out.println("6th test to check whether the Admin group that is System administrators and Login name that is admin is editable or not");
	  }
	  @BeforeTest
	  public void beforeTest() {
		  	 driver=new FirefoxDriver();
		     driver.get("http://localhost:8585/do/login"); 
		     driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
			  driver.findElement(By.xpath("//input[@value='1']")).click();
		      driver.findElement(By.xpath("//input[@value='2']")).click();
		      driver.findElement(By.xpath("//input[@value='3']")).click();
		      driver.findElement(By.xpath("//input[@value='4']")).click();
		      driver.findElement(By.xpath("//input[@value='Submit']")).click();
	  }
	 @AfterTest
	 public void afterTest() {
		  System.out.println("Run Successful");	
		  driver.close();
}}