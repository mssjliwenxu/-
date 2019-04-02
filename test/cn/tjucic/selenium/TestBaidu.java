package cn.tjucic.selenium;

import java.util.regex.Pattern;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
@RunWith(Parameterized.class)
public class TestBaidu {
  private static WebDriver driver;
  private static String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private String expected;
  private String id;
  private String password;
  private static int testCount;
  public TestBaidu(String expected,String id,String password)
  {
	  this.password=password;
	  this.expected=expected;
	  this.id=id;
  }
	@Parameters
	public static Collection<String[]> getData()
	{
		LinkedList<String[]> idPassword=new LinkedList<String[]>();
		File excelFile = new File("/Users/liwenxu/Public/学习/OneDrive - tju.edu.cn/学习/软件测试/idPassword.xlsx");
		XSSFWorkbook wb;
		try {
			wb = new XSSFWorkbook(new FileInputStream(excelFile));
			XSSFSheet sheet = wb.getSheetAt(0);
			String[] temp;
	        for (Row row : sheet) {
	        	temp=new String[3];
	        	int count=0;
	            for (Cell cell : row) {
	            	if (count==1)
	            	{
	                	temp[1]=String.valueOf(new DecimalFormat("#").format(cell.getNumericCellValue()));
	                	
	                	temp[2]=temp[1].substring(4);
	            	}
	            	else if(count==3)
	            	{
	            		temp[0]=cell.getRichStringCellValue().getString();
	            	}
	            	count++;
	            }
	            idPassword.add(temp);
	          }
	          idPassword.remove(idPassword.size()-1);
	         System.out.println(idPassword.size());
	          return idPassword;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
  @BeforeClass
  public static void setUp() throws Exception {
	  testCount=0;
	  String driverPath = System.getProperty("user.dir") + "/test/resource/driver/geckodriver";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver = new FirefoxDriver();
	  baseUrl = "http://121.193.130.195:8800";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get(baseUrl + "/");
  }

  @Test
  public void testBaidu() throws Exception {
	  testCount+=1;
    WebElement id = driver.findElement(By.name("id"));
    id.click();
//    driver.findElement(By.id("kw")).click();
    driver.findElement(By.name("id")).clear();
    driver.findElement(By.name("id")).sendKeys(this.id);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(this.password);
    driver.findElement(By.id("login_form")).submit();
    assertEquals(this.expected, driver.findElement(By.id("student-git")).getText());
    System.out.println(driver.findElement(By.id("student-git")).getText());
  }
  @AfterClass
  public static void quit()throws Exception{
	  driver.quit();
  }
  @After
  public void tearDown() throws Exception {
	    driver.get(baseUrl + "/logout");
	    driver.get(baseUrl + "/login");
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

