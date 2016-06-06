package com.hike.screens;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.hike.library.AppiumLibrary;

import io.appium.java_client.MobileBy;



/**
 * @author pooja
 *
 */
public class PhoneNumberLoginScreen extends AppiumLibrary{


	private By hikeLogoIcon= MobileBy.id("hike_logo");
	private By phoneNumberTitleLbl= MobileBy.id("title");
	private By tickIMG = MobileBy.id("arrow");
	private By nextBtn = MobileBy.id("next_btn");
	private By hiWhatsYourNumberLbl = MobileBy.id("txt_img1");
	private By globeIcon; //get resourceId
	private By selectedCountryName=MobileBy.id("selected_country_name");
	private By countryCodeLbl= MobileBy.id("country_picker");
	private By phoneNumberTxt=MobileBy.id("et_enter_num");

	public By getHikeLogoIcon() {
		return hikeLogoIcon;
	}

	public By getPhoneNumberTitleLbl() {
		return phoneNumberTitleLbl;
	}

	public By getTickIMG() {
		return tickIMG;
	}

	public By getNextBtn() {
		return nextBtn;
	}

	public By getHiWhatsYourNumberLbl() {
		return hiWhatsYourNumberLbl;
	}

	public By getGlobeIcon() {
		return globeIcon;
	}

	public By getSelectedCountryName() {
		return selectedCountryName;
	}

	public By getCountryCodeLbl() {
		return countryCodeLbl;
	}

	public By getPhoneNumberTxt() {
		return phoneNumberTxt;
	}
//	public String getTitleLblTxt() {
//		return getText(titleLbl);
//	}

	public String getNextBTNTXT() {
		return getText(nextBtn);
	}


//	public PhoneNumberLoginScreen() {
//		waitForScreenToLoad(true);
//	}
//
//	public PhoneNumberLoginScreen(boolean check) {
//		waitForScreenToLoad(check);
//	}
//
//	public void waitForScreenToLoad(boolean check) {
//		boolean found=false;
//		int counter=0;
//
//		while(!found && counter<10 ){
//			try {
//				driver.findElement(getHikeLogoIcon());
//				driver.findElement(getNextBtn());
//				driver.findElement(getCountryCodeLbl());
//				driver.findElement(getSelectedCountryName());
//				found = true;
//				break;
//			} catch (Exception e) {
//				try {
//					Thread.sleep(1000);
//					counter++;
//				}catch (Exception exception) {}
//			}
//		}
//
//		if(!found){
//			Assert.fail("Failed to load Screen : "+this.getClass().getName());
//		}
//	}



	public ConfirmYourNumberPopUp clickOnNextBtn() {
		clickOnElement(getNextBtn());
		ConfirmYourNumberPopUp popup = new ConfirmYourNumberPopUp();
		return popup;
	}

	public void clickOnIndiaLbl() {
		clickOnElement(getSelectedCountryName());
	}

	public void clickOnCountryCodeLbl() {
		clickOnElement(getCountryCodeLbl());
	}

	public void clickOnPhoneNumberTxt() {
		clickOnElement(getPhoneNumberTxt());
	}

	public void enterPhoneNumber(String msisdn) {
		enterText(getPhoneNumberTxt(), msisdn);
	}


}