package page.material.add;

import org.openqa.selenium.WebDriver;

public class NormalPage extends PageEvent {

	WebDriver driver;

	private int positionOfFileNumberField = 0;
	private int positionOfAmountMaterialField = 4;
	private int positionOfQualityMaterialField = 5;

	public NormalPage(WebDriver driver) {
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
