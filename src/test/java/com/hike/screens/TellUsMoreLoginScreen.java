package com.hike.screens;

import org.openqa.selenium.By;

import com.hike.library.AppiumLibrary;

import io.appium.java_client.MobileBy;

/**
 * @author pooja
 *
 */
public class TellUsMoreLoginScreen extends AppiumLibrary implements ActionBar{
	private By tickIcon = MobileBy.id("arrow");
	private By pickOneLbl = MobileBy.id("txt_img1");
	private By iAmABoyLbl = MobileBy.id("male");
	private By iAmAGirlLbl = MobileBy.id("female");

	
	public By getTickIcon(){
		return tickIcon;
	}

	public By getTellUsMoreTitleLbl(){
		return titleLbl;
	}

	public By getNextBtn(){
		return nextBtn;
	}

	public By getPickOneLbl(){
		return pickOneLbl;
	}

	public By getIAmABoyLbl(){
		return iAmABoyLbl;
	}

	public By getIAmAGirlLbl(){
		return iAmAGirlLbl;
	}

	public void clickOnNextBtn() {
		clickOnElement(getNextBtn());
	}

	public void clickOnIAmABoyLbl() {
		clickOnElement(getIAmABoyLbl());
	}

	public void clickOnIAmAGirlLbl() {
		clickOnElement(getIAmAGirlLbl());
	}

	public void clickOnTickIcon() {
		clickOnElement(getTickIcon());
	}
}