package util;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

public class WaitFor {
	WebDriver driver;

	public WaitFor(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement presenceOfTheElement(final By elementIdentifier) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(elementIdentifier);
			}
		});

	}

	public void hiddenOfTheElement(final By elementIdentifier) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(elementIdentifier));

	}

	public void waitForLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				String state = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString();
				AppLogger.logMessage(state);
				return state.equals("complete") || state.equals("loaded");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	public void waitForReady() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				final long timeout = 60000;
				final long startTime = System.currentTimeMillis();
				final JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

				while ((startTime + timeout) >= System.currentTimeMillis()) {
					final Boolean scriptResult = (Boolean) javascriptExecutor
							.executeScript("return jQuery.active == 0");

					if (scriptResult)
						return true;

					delay(100);

				}
				return false;
			}
		};
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(pageLoadCondition);
	}

	private void delay(final long amount) {
		try {
			Thread.sleep(amount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean waitForJSandJQueryToLoad() {

	    WebDriverWait wait = new WebDriverWait(driver, 30, 2000L);
	    ExpectedCondition<Boolean> libraryLoad = new ExpectedCondition<Boolean>() {
	      public Boolean apply(WebDriver driver) {
	        boolean isAjaxFinished = false;
	        boolean isLoaderSpinning = false;
	        boolean isPageLoadComplete = false;
	        try {
	          isAjaxFinished = ((Boolean)((JavascriptExecutor)driver).executeScript("return jQuery.active == 0;"));
	        } catch (Exception e) {
	            // no Javascript library not found
	            isAjaxFinished = true;
	        }
	        try { // Check your page, not everyone uses class=spinner
	            // Reduce implicit wait time for spinner
	            driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

//	              isLoaderSpinning = driver.findElement(By.className("spinner")).isDisplayed(); // This is the default
	            // Next was modified for GoComics
	            isLoaderSpinning = driver.findElement(By.cssSelector(".z-loading-indicator")).isDisplayed();

	            if (isLoaderSpinning)
	            	AppLogger.logMessage("jquery loader is spinning");
	        } catch (Exception f) {
	            // no loading spinner found
	            isLoaderSpinning = false;
	        } finally { // Restore implicit wait time to default
	            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        }
	        isPageLoadComplete = ((JavascriptExecutor)driver).executeScript("return document.readyState;")
	                .toString().equals("complete");
	        if (!(isAjaxFinished & !(isLoaderSpinning) & isPageLoadComplete))
	        	AppLogger.logMessage(isAjaxFinished + ", " + !(isLoaderSpinning) +", " + isPageLoadComplete);

	        return isAjaxFinished & !(isLoaderSpinning) & isPageLoadComplete;
	      }
	    }; // Terminates statement started by ExpectedCondition<Boolean> libraryLoad = ...

	  return wait.until(libraryLoad); 
	}

	public boolean waitForAngularToLoad(WebDriver driver, int waitTimeInSeconds) {

	    WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds, 2000L);

	    ExpectedCondition<Boolean> libraryLoad = new ExpectedCondition<Boolean>() {

	      public Boolean apply(WebDriver driver) {
	        try {
	          return ((Boolean)((JavascriptExecutor)driver).executeScript(
	                  "return angular.element(document.body).injector().get(\'$http\').pendingRequests.length == 0;"
	                  ));
	        }
	        catch (Exception e) {
	            // Angular not found
	        	AppLogger.logMessage("Not found: " + "return angular.element(document.body).injector().get(\'$http\').pendingRequests.length == 0;");
	            return true;
	        }
	      }
	    };

	    // wait for browser readystate complete; it is arguable if selenium does this all the time
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

	      public Boolean apply(WebDriver driver) {
	        return ((JavascriptExecutor)driver).executeScript("return document.readyState;")
	        .toString().equals("complete");
	      }
	  };

	  return wait.until(libraryLoad) && wait.until(jsLoad);

	}

	public boolean waitForPrototypeToLoad(WebDriver driver, int waitTimeInSeconds) {

	    WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds, 2000L);

	    // wait for jQuery to load
	    ExpectedCondition<Boolean> libraryLoad = new ExpectedCondition<Boolean>() {

	      public Boolean apply(WebDriver driver) {
	        try {
	          return ((Boolean)((JavascriptExecutor)driver).executeScript("return Ajax.activeRequestCount == 0;"));
	        }
	        catch (Exception e) {
	            // Prototype  not found
	        	AppLogger.logMessage("Not found: " + "return Ajax.activeRequestCount == 0;");
	            return true;
	        }
	      }
	    };

	    // wait for browser readystate complete; it is arguable if selenium does this all the time
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

	      public Boolean apply(WebDriver driver) {
	        return ((JavascriptExecutor)driver).executeScript("return document.readyState;")
	        .toString().equals("complete");
	      }
	  };

	  return wait.until(libraryLoad) && wait.until(jsLoad);

	}

}
