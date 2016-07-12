package page.material.add;

import org.openqa.selenium.WebDriver;

public class SpecialOfNormalPage extends PageEvent {
	
	WebDriver driver;

	private int positionOfFileNumberField = 0;
	private int positionOfAmountMaterialField = 3;
	private int positionOfQualityMaterialField = 4;
	
	public SpecialOfNormalPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	protected int getPositionOfFileNumberField() {
		return positionOfFileNumberField;
	}
	
	@Override
	protected int getPositionOfAmountMaterialField() {
		return positionOfAmountMaterialField;
	}
	
	@Override
	protected int getPositionOfQualityMaterialField() {
		return positionOfQualityMaterialField;
	}


}
