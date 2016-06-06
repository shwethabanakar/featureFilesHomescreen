package com.hike.screens;

import org.testng.Assert;

import com.hike.library.AppiumLibrary;


public class ConfirmYourNumberPopUp extends AppiumLibrary implements AlertPopup {

//	public ConfirmYourNumberPopUp() {
////		boolean found = false;
////		int counter = 0;
////
////		while (!found && counter < 10) {
////			try {
////				driver.findElement(titleLbl);
////				verifyScreenElement();
////				found = true;
////				break;
////			} catch (Exception e) {
////				counter++;
////
////			}
////		}
////
////		if (!found) {
////			Assert.fail("Failed to load Screen : " + this.getClass().getSimpleName());
////		}
//	}

	public PhoneNumberLoginScreen clickOnEditBtn() {
		clickOnElement(leftButton);
		PhoneNumberLoginScreen scrn = new PhoneNumberLoginScreen();
		return scrn;
	}

	public PinEnteringScreen clickOnConfirmBtn() {
		clickOnElement(rightButton);
		PinEnteringScreen pinScrn = new PinEnteringScreen();
		return pinScrn;
	}

//	public void verifyScreenElement() {
//		Assert.assertTrue(getTitleTxt().equals("Confirm your number"), "Confirm your number Text is not present");
//		Assert.assertTrue(getSubtitleTxt().equals("Is +91" + HikeConstants.getDEFAULT_MSISDN() + " your number?"), "subtitle containing 'your number' is not present");
//		Assert.assertTrue(getLeftButton().equals("EDIT"), "EDIT text is not present");
//		Assert.assertTrue(getRightButton().equals("CONFIRM"), "CONFIRM text is not present");
//	}

	public String getTitleTxt() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSubtitleTxt() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLeftButton() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRightButton() {
		// TODO Auto-generated method stub
		return null;
	}

	
}