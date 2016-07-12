package page.material.add;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import util.PropertiesStore;

public class SpecialOfNormalPage extends PageEvent {

	WebDriver driver;

	public SpecialOfNormalPage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		positionOfFileNumberField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfFileNumberField_SpecialOfNormalPage"));
		positionOfAmountMaterialField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfAmountMaterialField_SpecialOfNormalPage"));
		positionOfQualityMaterialField = Integer
				.parseInt(PropertiesStore.getProperty("PositionOfQualityMaterialField_SpecialOfNormalPage"));
	}


}
