package com.hike.screens;

import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;

public interface ActionBar {
	By hikeLogoIcon= MobileBy.id("hike_logo");
	By titleLbl= MobileBy.id("title");
	By tickIMG = MobileBy.id("arrow");
	By nextBtn = MobileBy.id("next_btn");
}
