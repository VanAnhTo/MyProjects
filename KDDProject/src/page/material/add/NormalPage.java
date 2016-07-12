package page.material.add;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import util.PropertiesStore;

public class NormalPage extends PageEvent {

	WebDriver driver;

	public NormalPage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		positionOfFileNumberField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfFileNumberField_NormalPage"));
		positionOfAmountMaterialField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfAmountMaterialField_NormalPage"));
		positionOfQualityMaterialField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfQualityMaterialField_NormalPage"));
	
	}


}
