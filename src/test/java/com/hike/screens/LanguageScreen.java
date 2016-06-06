/**
 *
 */
package com.hike.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.hike.library.AppiumLibrary;

import io.appium.java_client.MobileBy;

/**
 * @author vivekupreti
 *
 */
public class LanguageScreen extends AppiumLibrary implements ActionBar {

	private By phoneLanguageDropDown = MobileBy.id("txt_lang");
	private By chooseLanguageTxt = MobileBy.AccessibilityId("text_choose_language");
	private By chooseLanguageDescTxt = MobileBy.AccessibilityId("text_choose_language_description");


	
	public By getPhoneLanguageDropDown() {
		return phoneLanguageDropDown;
	}

	public By getChooseLanguageTxt() {
		return chooseLanguageTxt;
	}

	public By getChooseLanguageDescTxt() {
		return chooseLanguageDescTxt;
	}

	public WebElement getDoneBTN() {
		return driver.findElement(nextBtn);
	}

	public void clickOnDoneBTN() {
		getDoneBTN().click();
	}
	public String getTitleLblTxt() {
		return getText(titleLbl);
	}

	public String getNextBTNTXT() {
		return getText(nextBtn);
	}
	public void waitForPageToLoad(boolean verify) {
		if (verify) {
			boolean found = false;
			int counter = 0;

			while (!found && counter < 10) {
				try {
					driver.findElement(getChooseLanguageDescTxt());
					driver.findElement(getChooseLanguageTxt());
					driver.findElement(getPhoneLanguageDropDown());
					found = true;
					break;
				} catch (Exception e) {
					counter++;
				}
			}

			if (!found) {
				Assert.fail("Failed to load Screen : " + this.getClass().getSimpleName());
			}
		} else {
			System.out.println("User do not want to verify Language Screen");
		}
	}



	public void clickOnHikeLogoIcon() {
		// TODO Auto-generated method stub

	}


}
