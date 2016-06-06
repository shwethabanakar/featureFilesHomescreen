package com.hike.screens;

import org.openqa.selenium.By;

import com.hike.library.AppiumLibrary;
import com.hike.utils.AppiumCapabilities;

import io.appium.java_client.MobileBy;


/**
 * @author pooja
 *
 */
public class WelcomeScreen extends AppiumLibrary{

	private By welcomeToLbl = MobileBy.id("welcome_text");
	private By hikeMessengerLogoIcon = MobileBy.id("hike_messenger_img");
	//	//	private By termsLbl = getIdentifierByText("Terms"); // TODO resourceId
	private By getStartedBtn = MobileBy.id("btn_continue");




	public By getWelcomeToLbl() {
		return welcomeToLbl;
	}

	public By getHikeMessengerLogoIcon() {
		return hikeMessengerLogoIcon;
	}

	public By getGetStartedBtn() {
		return getStartedBtn;
	}

	public By getMadeWithLoveInIndiaLbl() {
		return madeWithLoveInIndiaLbl;
	}

	private By madeWithLoveInIndiaLbl=MobileBy.id("loveIndia");// = MobileBy.id("");


	public void clickOnHikeMessengerLogoIcon(){
		waitForElement(getHikeMessengerLogoIcon(), 20);
		clickOnElement(getHikeMessengerLogoIcon());
	}

	public void changeEnvironment(String env){
		clickOnHikeMessengerLogoIcon();
	}
	
	public void verifyWelcomeScreen(){

	}
}
