/**
 *
 */
package com.hike.screens;

import org.openqa.selenium.By;

import com.bsb.hike.qa.apisupport.ConsoleDataSupport;
import com.hike.library.AppiumLibrary;

import io.appium.java_client.MobileBy;

/**
 * @author vivekupreti
 *
 */
public class PinEnteringScreen extends AppiumLibrary implements ActionBar {

    private By pleaseEnterPinSentViaSMSLBL = MobileBy.id("txt_img1");
    private By pinEDT = MobileBy.id("et_enter_pin");
    private By callMeBTN = MobileBy.id("btn_call_me");
    ConsoleDataSupport consoleDataSupport = new ConsoleDataSupport();
    public AboutYouLoginScreen clickOnNextLBL() {
        clickOnElement(nextBtn);
        return new AboutYouLoginScreen();
    }

    public void enterPin(String msisdn) {
//        HikeLibrary hikeLibrary = new HikeLibrary();
        enterText(getPinEDT(), (consoleDataSupport.getPinFromConsole(msisdn)));

    }

    public void clickOnCallMeBTN() {
        clickOnElement(callMeBTN);
    }

    public By getPleaseEnterPinSentViaSMSLBL() {
        return pleaseEnterPinSentViaSMSLBL;
    }

    public By getPinEDT() {
        return pinEDT;
    }

    public By getCallMeBTN() {
        return callMeBTN;
    }

    public By getHikeLogoIcon() {
        return hikeLogoIcon;
    }

    public By getTitleLbl() {
        return titleLbl;
    }

    public By getNextButton() {
        return nextBtn;
    }

   

}
