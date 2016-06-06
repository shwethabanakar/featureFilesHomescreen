package com.hike.screens;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.hike.library.AppiumLibrary;

import io.appium.java_client.MobileBy;

/**
 * @author pooja
 *
 */
public class AboutYouLoginScreen extends AppiumLibrary implements ActionBar {

    private By yourNameTxt = MobileBy.id("et_enter_name");
    private By howYoungAreYouTxt = MobileBy.id("birthday");
    private By profileImageIcon = MobileBy.id("profile");
    private By cameraIcon = MobileBy.id("profile_cam");
    private By aboutYouTitleLabel = MobileBy.id("title");

//    public AboutYouLoginScreen() {
//        waitForScreenToLoad(true);
//    }
//
//    public AboutYouLoginScreen(boolean check) {
//        waitForScreenToLoad(check);
//    }

//    public void waitForScreenToLoad(boolean check) {
//        if (check) {
//            int counter = 0;
//            boolean found = false;
//            while (!found && counter < 2) {
//                try {
//                    waitForElement(getCameraIcon(), HikeConstants.DEFAULT_OBJECT_WAIT_TIME);
//                    waitForElement(getAboutYouTitleLabel(), HikeConstants.DEFAULT_OBJECT_WAIT_TIME);
//                    waitForElement(getHowYoungAreYouTxt(), HikeConstants.DEFAULT_OBJECT_WAIT_TIME);
//                    waitForElement(getProfileImageIcon(), HikeConstants.DEFAULT_OBJECT_WAIT_TIME);
//                    found = true;
//                } catch (Exception e) {
//                    try {
//                        counter++;
//                    } catch (Exception exception) {
//                    }
//                }
//            }
//
//            if (!found) {
//                Assert.fail("Failed to load Screen : " + this.getClass().getName());
//            }
//        }
//    }

    public By getNextBtn() {
        return nextBtn;
    }

    public By getTickIcon() {
        return tickIMG;
    }

    public By getYourNameTxt() {
        return yourNameTxt;
    }

    public void enterName(String name) {
        enterText(getYourNameTxt(), name);
    }

    public By getHowYoungAreYouTxt() {
        return howYoungAreYouTxt;
    }

    public void enterAge(String age) {
        enterText(getHowYoungAreYouTxt(), "" + age);
    }

    public By getProfileImageIcon() {
        return profileImageIcon;
    }

    public By getCameraIcon() {
        return cameraIcon;
    }

    public By getAboutYouTitleLabel() {
        return aboutYouTitleLabel;
    }

    public TellUsMoreLoginScreen clickonNextBtn() {
        clickOnElement(getNextBtn());
        TellUsMoreLoginScreen tellUsMoreLoginScreen = new TellUsMoreLoginScreen();
        return tellUsMoreLoginScreen;
    }

//    public PhotosFolderSelectionScreen clickonProfileImageIcon() {
//        clickOnElement(getProfileImageIcon());
//        return new PhotosFolderSelectionScreen();
//    }
//
//    public PhotosFolderSelectionScreen clickonCameraIcon() {
//        clickOnElement(getCameraIcon());
//        return new PhotosFolderSelectionScreen();
//    }

    public void clickonYourNameTxt() {
        clickOnElement(getYourNameTxt());
    }

    public void clickonHowYoungAreYouTxt() {
        clickOnElement(getHowYoungAreYouTxt());
    }

    public void clickOnHikeLogoIcon() {
        // TODO Auto-generated method stub

    }

    public String getTitleLblTxt() {
        return getText(titleLbl);
    }

    public String getNextBTNTXT() {
        return getText(nextBtn);
    }
}
