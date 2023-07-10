package smsGenericUtilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * this class consistes of methods related to selenium or webdriver
 */
public class WebDriverutility {
	/**
	 * this methode is used to maximize the browser window
	 * @param driver
	 */
	public void maximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method is used to minimize the browser window
	 * @param driver
	 */
	public void minimizeTheWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * this method is used to wait until page get loads
	 * @param driver
	 */
	public void waitTillPageGetLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathconstants.implicitWaitDuration));
	}
	/**
	 * this method is used to wait until the element is visible
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPathconstants.ExplicitWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method is used to wait untill the element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPathconstants.ExplicitWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitTillElementToBeClear(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPathconstants.ExplicitWaitDuration));
		wait.until(ExpectedConditions.textToBePresentInElementValue(element,""));
	}
	/**
	 * mmm
	 * 
	 */
	public void waitTillElementToInvisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPathconstants.ExplicitWaitDuration));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	/**
	 * this method will wait untill the element get particular text
	 * @param driver
	 * @param url
	 */
	public void waitTilltextToBePresentInElement(WebDriver driver,WebElement element,String Text)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(element, Text));
		
	}
	/**
	 * this method is used to wait untill the alert is present in UI
	 * @param driver
	 */
	public void waitForTheAlertPopUp(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPathconstants.ExplicitWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * this method is used ti wait title to be visible in a webpage
	 * @param driver
	 * @param title
	 */
	public void waitForATitle(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPathconstants.ExplicitWaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * this method will wait utill the url is presents
	 * @param driver
	 * @param url
	 */
	public void waitForAUrl(WebDriver driver,String url)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPathconstants.ExplicitWaitDuration));
		wait.until(ExpectedConditions.urlContains(url));
	}
	/**
	 * this method will ignore if it get noSuchElementException
	 * @param driver
	 */
	public void ignoreNoSuchElementException(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPathconstants.ExplicitWaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}

	/**
	 * this metod is used to select element in drop down based on index
	 * @param element
	 * @param index
	 */
	public void selectElementInDropDown(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * this metod is used to select element in drop down based on value
	 * @param element
	 * @param value
	 */
	public void selectElementInDropDown(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * this metod is used to select element in drop down based on visible text
	 * @param text
	 * @param element
	 */
	public void selectElementInDropDown(String text,WebElement element)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * this method will fetch all the options present in the dropdown
	 * @param element
	 * @return
	 */
	public List<String> getAllOptionsFromDropdown(WebElement element)
	{
		Select select=new Select(element);
		List<WebElement> options=select.getOptions();
		List<String> text=new ArrayList<String>();
		for(int i=0;i<options.size();i++)
		{
			 text.add(options.get(i).getText());
		}
		return text;
	}
	/**
	 * this method is used to mouse over on an element
	 * @param driver
	 * @param element
	 */
	
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	/**
	 * this method is used to perform right click action on element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * this method is used to perform double click action on element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	/**
	 * this method is used to switch frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);

	}
	/**
	 * this method is used to switch frame based on NameOrId
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver,String id)
	{
		driver.switchTo().frame(id);
	}
	/**
	 * this method is used to switch frame based on element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * this method is used to switch to the main frame of a webpage
	 * @param driver
	 */
	public void switchToFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * this method is used to accept the alert popup
	 * @param driver
	 * @param text
	 */
	public void switchToAleterPopuoAccept(WebDriver driver,String text)
	{
		Alert alt=driver.switchTo().alert();
		if(alt.getText().trim().equalsIgnoreCase(text.trim()))
		{System.out.println("alert is present");
		}
		else
		{
			System.out.println("alert is not present");
		}
		alt.accept();
		}

/**
 * this method is used to dismiss the alert popup
 * @param driver
 * @param text
 */
public void switchToAleterPopuoDismiss(WebDriver driver,String text)
{
	Alert alt=driver.switchTo().alert();
	if(alt.getText().trim().equalsIgnoreCase(text.trim()))
	{System.out.println("alert is present");
	}
	else
	{
		System.out.println("alert is not present");
	}
	alt.dismiss();
	}

/**
 * this metod is used to handle fileUploadPopup
 * @param element
 * @param path
 */
public void fileUpload(WebElement element,String path)
{
	element.sendKeys(path);
}
/**
 * this method is used to provide user own polling time
 * @param duration
 * @param element
 * @param pollingTime
 */
public void customwait(int duration,WebElement element,long pollingTime)
{
	int count=0;
	while(count<duration)
	{
		try {
			element.click();
			break;
		}
		catch (Exception e) {
			try
			{
				Thread.sleep(pollingTime);
			}
			catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			count++;
		}
		}
	
}
/**
 * this method is used to get screenshots
 * @param driver
 * @param screenShotName
 * @return
 * @throws Exception 
 */
public String takeSereenShot(WebDriver driver,String screenShotName) throws Exception
{
	TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
	File src=takesScreenshot.getScreenshotAs(OutputType.FILE);
	LocalDateTime localDateTime=LocalDateTime.now();
	String dateTime=localDateTime.toString().replace(" ","_").replace(":", "-");
	File dst=new File("./sreenShots/"+screenShotName+""+dateTime+".png");
	FileUtils.copyFile(src,dst);
	return screenShotName;
}
/**
 * this method is used to switch to child window
 * @param driver
 * @param title
 */

public void switchWindow(WebDriver driver,String title)
{
	Set<String> set=driver.getWindowHandles();
	for(String wdw:set)
	{
		driver.switchTo().window(wdw);
		String text=driver.getTitle();
		if(text.contains(title))
		{
			break;
		}
}
}
public void switchingWindow(WebDriver driver,String url)
{
	Set<String> set=driver.getWindowHandles();
	Iterator<String> it=set.iterator();
	while(it.hasNext())
	{
		String wid=it.next();
		driver.switchTo().window(wid);
		String text=driver.getCurrentUrl();
		if(text.contains(url))
		{
			break;
		}
		
		}
}
/**
 * this method is used to disable the browser notifications
 */
public void disableNotifications()
{
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--disable-notification=*");
}
/**
 * this method is used to scroll to the particular element
 * @param driver
 * @param element
 */
public void scrollDownToElement(WebDriver driver,WebElement element)
{
	JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
	int y=element.getLocation().getY();
	javascriptExecutor.executeScript("window.scrollBy(0,"+y+")", element);
}
public void pressContorlAndA() throws Exception
{	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_A);
}
public void releaseControlAndA() throws Exception
{
	Robot r=new Robot();
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_A);
	
}
public void pressAndReleaseBackSpace() throws Exception
{Robot r=new Robot();
	r.keyPress(KeyEvent.VK_BACK_SPACE);
	r.keyRelease(KeyEvent.VK_BACK_SPACE);
}


}

	
	
	
	


	
	
	
	
	
	
	
	
	
	


