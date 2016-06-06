package com.hike.screens;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.hike.library.AppiumLibrary;

import io.appium.java_client.MobileBy;

public class RestoreAccountScreen extends AppiumLibrary implements ActionBar {

	
	private By backupFoundTitle = MobileBy.id("txt_backup_title");
	private By backupFoundHint = MobileBy.id("backupFoundTitle");
	private By sdcardIMG = MobileBy.id("sd_card");
	private By skipBTN = MobileBy.id("next_btn");
	private By restoreBTN = MobileBy.AccessibilityId("Restore (Backup found)");

	public void clickOnSkipBTN() {
		driver.findElement(skipBTN).click();
		// no verification for any screen
	}

	public void clickOnRestoreButton() {
		clickOnElement(restoreBTN);
	}

	public By getBackupFoundTitle() {
		return backupFoundTitle;
	}

	public By getBackupFoundHint() {
		return backupFoundHint;
	}

	public By getSdcardIMG() {
		return sdcardIMG;
	}

	public By getSkipBTN() {
		return skipBTN;
	}

	public By getRestoreBTN() {
		return restoreBTN;
	}

	
}
