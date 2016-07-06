package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class HomePageObject {
	WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
   
    public boolean resultsAppearForOutboundJourney() throws InterruptedException {
        waitForSearchResultsToAppear();
        return isElementPresent(By.className("welcome-panel-content"));
    }
    private void waitForSearchResultsToAppear() throws InterruptedException  {
        //Conditional wait for one of the elements on the search results page to be present
//        new WaitFor(driver).presenceOfTheElement(By.id("mod_link"));
    	Thread.sleep(3000);
    }
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
   
}
