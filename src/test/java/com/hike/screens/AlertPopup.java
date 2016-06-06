package com.hike.screens;

import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;

public interface AlertPopup {

	By titleLbl = MobileBy.id("alertTitle");
	By subtitleLbl = MobileBy.id("message");
	By leftButton = MobileBy.id("button2");
	By rightButton = MobileBy.id("button1");

	public String getTitleTxt();

	public String getSubtitleTxt();

	public String getLeftButton();

	public String getRightButton();

}
