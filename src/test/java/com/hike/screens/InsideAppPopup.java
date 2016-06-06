package com.hike.screens;

import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;

public interface InsideAppPopup {

	By popupTitle = MobileBy.id("title");
	By popupSubtitleMessage = MobileBy.id("messageBodyContainer");
	By popupLeftBTN = MobileBy.id("btn_negative");
	By popUpRightBTN = MobileBy.id("btn_positive");

}
