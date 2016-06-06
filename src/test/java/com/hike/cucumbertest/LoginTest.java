package com.hike.cucumbertest;

import java.net.MalformedURLException;

import com.hike.screens.AboutYouLoginScreen;
import com.hike.screens.ConfirmYourNumberPopUp;
import com.hike.screens.LanguageScreen;
import com.hike.screens.PhoneNumberLoginScreen;
import com.hike.screens.PinEnteringScreen;
import com.hike.screens.RestoreAccountScreen;
import com.hike.screens.TellUsMoreLoginScreen;
import com.hike.screens.WelcomeScreen;


import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class LoginTest{
	
	
	WelcomeScreen welcomeScreen = new WelcomeScreen();
	PhoneNumberLoginScreen phoneNumberLoginScreen=new PhoneNumberLoginScreen();
	@Given("^hike app launched ond environment as \"(.*)\"$")
	public void launchAndSetEnvironment(String env) throws MalformedURLException{
		welcomeScreen.changeEnvironment(env);
	}
	
	@When("^logins using phonenumber as \"(.*)\"$")
	public void createUser(String number){
		
		createHikeUser(number);
		
	}

	@Then("^ login should be successfull$")
	public void verifylogin(){
//		ConversationScreen conversationScreen= new ConversationScreen();
//		Assert.assertTrue(driver.findElement(conversationScreen.getStartANewChatIcon()).isDisplayed());
	}
	
	@Then("^ verify Internet connectivity popup$")
	public void verifyPopup(){
//		ConversationScreen conversationScreen= new ConversationScreen();
//		Assert.assertTrue(driver.findElement(conversationScreen.getStartANewChatIcon()).isDisplayed());
	}
	
	public void createHikeUser(String name) {

		
		
		
        phoneNumberLoginScreen.enterPhoneNumber(name);

        ConfirmYourNumberPopUp confirmYourNumberPopUp = phoneNumberLoginScreen.clickOnNextBtn();
        PinEnteringScreen pinEnteringScreen = confirmYourNumberPopUp.clickOnConfirmBtn();
        pinEnteringScreen.enterPin(name);
        AboutYouLoginScreen aboutYouLoginScreen = pinEnteringScreen.clickOnNextLBL();

        aboutYouLoginScreen.enterName("test");
        TellUsMoreLoginScreen tellUsMoreScreen = aboutYouLoginScreen.clickonNextBtn();
        tellUsMoreScreen.clickOnIAmABoyLbl();
        tellUsMoreScreen.clickOnNextBtn();

        RestoreAccountScreen restoreAccountScreen = new RestoreAccountScreen();

        try {
           
            restoreAccountScreen.clickOnSkipBTN();

        } catch (Exception e) {
            System.out.println("Backup restore screen does not appear continuing");
        }

        try {
            LanguageScreen languageScreen = new LanguageScreen();
       
            languageScreen.clickOnDoneBTN();
        } catch (Exception e) {
            System.out.println("Language Selection screen does not appear continuing");
        }

        

    }
}
