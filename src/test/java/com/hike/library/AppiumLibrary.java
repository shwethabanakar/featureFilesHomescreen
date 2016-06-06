package com.hike.library;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

import com.hike.utils.AppiumCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

public class AppiumLibrary extends AppiumCapabilities {

    protected By pasteButton = MobileBy.name("Paste");
    public int DEFAULT_TIMEOUT = 10;
    public int SWIPE_DURATION = 10;
    static String outputlocation = "/Users/" + System.getProperty("user.name") + "/Documents/code/";

    public By getPasteButton() {
        return pasteButton;
    }

    public boolean isElementPresentOnScreen(By element) {
        try {
            driver.findElement(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementPresentOnScreen(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // finds if an element is present under the given parent element
    public boolean isElementPresentUnderParentElement(By element, WebElement parentElement) {

        try {
            parentElement.findElement(element);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean isElementEnabled(By element) {
        boolean elementEnabled = false;
        try {
            elementEnabled = driver.findElement(element).isEnabled();

        } catch (Exception e) {
            elementEnabled = false;
        }
        return elementEnabled;
    }

    // To click on any element
    public void clickOnElement(By locator) {
        try {
            driver.findElement(locator).click();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to click on element : " + locator.toString());
        }
    }

    // To click on any element
    public void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Reporter.log("Unable to click on element : " + element.toString());
            // e.printStackTrace();
        }
    }

    //
    public static void clickOnElement(String id) {
        driver.findElement(By.name(id)).click();
    }

    // To get the text for any element
    public static String getTextByName(By locator) {
        String text = "";
        try {
            text = driver.findElement(locator).getAttribute("name");
            Reporter.log("Get text value for locator : " + locator.toString() + " Value : " + text);
        } catch (Exception e) {
            Reporter.log("Unable to get text for locator : " + locator);
        }

        return text;
    }

    // To get the text for any element by it's value attribute
    public static String getTextByValue(By locator) {
        String text = "";
        try {
            text = driver.findElement(locator).getAttribute("value");
            Reporter.log("Get text value for locator : " + locator.toString() + " Value : " + text);
        } catch (Exception e) {
            Reporter.log("Unable to get text for locator : " + locator);
        }

        return text;
    }

    // To check if particular element is enabled
    public static boolean isEnabled(By locator) {

        boolean isEnabled = false;
        try {
            if (driver.findElement(locator).isEnabled()) {
                isEnabled = true;
            }
        } catch (Exception e) {
            isEnabled = false;
        }
        return isEnabled;
    }

    // To enter some text in any element
    public static void enterText(By locator, String value) {
        try {
            WebElement element = driver.findElement(locator);
            element.sendKeys(value);
        } catch (Exception e) {
            Reporter.log("Unable to enter text : " + value + " in locator : " + locator.toString());
            e.printStackTrace();
        }

    }

    public static void enterTextWithClear(By locator, String value) {
        try {
            MobileElement element = (MobileElement) driver.findElement(locator);
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            Reporter.log("Unable to enter text : " + value + " in locator : " + locator.toString());
            e.printStackTrace();
        }

    }

    public static void doubleTapWithTwoFingers(By by) {

        try {
            MobileElement hikeLogoElement = (MobileElement) driver.findElement(by);
            TouchAction action0 = new TouchAction(driver).tap(hikeLogoElement);
            TouchAction action1 = new TouchAction(driver).tap(hikeLogoElement);
            MultiTouchAction doubleTap = new MultiTouchAction(driver);
            doubleTap.add(action0).add(action1).perform();
            // TODO try with 500 ms run
            doubleTap.add(action0).add(action1).perform();
        } catch (Exception e) {
            Reporter.log("Unable to pick hike logo/double tap on hike logo");
            e.printStackTrace();
        }

    }

    public static void singleTapWithTwoFingers(By locator) {

        try {
            MobileElement hikeLogoElement = (MobileElement) driver.findElement(locator);
            TouchAction action0 = new TouchAction(driver).tap(hikeLogoElement);
            TouchAction action1 = new TouchAction(driver).tap(hikeLogoElement);
            MultiTouchAction doubleTap = new MultiTouchAction(driver);
            doubleTap.add(action0).add(action1).perform();
        } catch (Exception e) {
            Reporter.log("Unable to perform double tap");
        }
    }

    // Method checks whether keyboard is visible or not
    public static boolean isKeyboardVisible() {

        boolean keyboardVisible = false;
        try {
            By deleteBy = MobileBy.name("Delete");
            driver.findElement(deleteBy);
            keyboardVisible = true;
        } catch (Exception e) {
            keyboardVisible = false;
        }

        return keyboardVisible;
    }

    public void toggleWifi() {
        NetworkConnectionSetting networkSettings = new NetworkConnectionSetting(true, true, true);
        networkSettings.setWifi(false);
    }

    public void performPartialDelete() {

        By deleteBy = MobileBy.name("Delete");
        clickOnElement(deleteBy);
    }

    // waits for 5 seconds (maximum) for keyboard to load
    public void waitForKeyboardToLoad() {

        By deleteBy = MobileBy.name("Delete");
        int counter = 0;
        while (counter < 5) {
            try {
                driver.findElement(deleteBy);
                break;
            } catch (Exception e) {
                try {
                    Thread.sleep(1000);
                    counter++;
                } catch (Exception eSleep) {
                    e.printStackTrace();
                }
            }
        }
    }

    // this does a long press on element found by the locator @param
    public void tapAndHoldElement(By locator) {

        try {
            WebElement element = driver.findElement(locator);
            new TouchAction(driver).longPress(element).perform();
        } catch (Exception e) {
            Reporter.log("Not able to find element");
        }
    }

    // this does a long press on the element passed as @param
    public void longPressByElement(WebElement element) {
        try {
            new TouchAction(driver).longPress(element).perform();
        } catch (Exception e) {
            Reporter.log("Unable to perform long press on pass element");
        }
    }

    public void changeToWebView() {

        try {
            Set<String> currentContexts = driver.getContextHandles();
            for (String context : currentContexts) {
                System.out.println("Context : " + context);
                if (context.contains("WEBVIEW")) {
                    driver.context(context);
                    // driver.switchTo().window("WEBVIEW_com.bsb.hike");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeToNativeView() {

        try {
            Set<String> currentContexts = driver.getContextHandles();
            for (String context : currentContexts) {
                if (!context.contains("WEBVIEW")) {
                    driver.context(context);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void failToVerifyScreen(String className) {
        Assert.fail(className + " not loaded completely");
    }

    @AfterMethod
    public void createScreenshot(ITestResult result) {

        try {
            if (!result.isSuccess()) {
                Reporter.setCurrentTestResult(result);
                String className = result.getTestClass().getName();
                String testName = result.getMethod().getMethodName();
                String failureScreenshotName = className + "_" + testName + ".jpg";
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(file, new File("Screenshot/" + failureScreenshotName));
                Reporter.log("<a class=\"test-popup-link\" href=\"Screenshot/" + failureScreenshotName + "\">" + "Screenshot here" + "</a>");
                Reporter.setCurrentTestResult(null);
            }
        } catch (Exception e) {
            Reporter.log("Not able to store screenshot");
        }
    }

    public By getElementContainingText(String value) {
        return MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + value + "\")");

    }

    public By getIdentifierByText(String value) {
        return MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + value + "\")");
    }

    public void swipeScreen(By from, By to) {
        WebElement source = driver.findElement(from);
        WebElement destination = driver.findElement(to);
        driver.swipe(source.getLocation().getX(), source.getLocation().getY(), destination.getLocation().getX(), destination.getLocation().getY(), SWIPE_DURATION);
    }

    public boolean waitForElement(By element, int timeout) {
        System.out.println("waiting for element");
        boolean found = false;

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
            found = true;

        } catch (TimeoutException timeoutException) {
            System.out.println("Not found");
        }
        return found;
    }

    public String returnScreenshot() {
        System.out.println("Capturing the snapshot of the page ");
        File srcFiler = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFiler, new File(outputlocation + srcFiler.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return srcFiler.getAbsolutePath();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public WebElement getElement(By locator, int listIndex) {
        return (WebElement) driver.findElements(locator).get(listIndex);
    }

    public WebElement getChild(WebElement parent, By child, int index) {
        return parent.findElements(child).get(index);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

//    public WebElement getElementFromParent(WebElement sibling, Locators locator, String value, int index) {
//        System.out.println("Getting sibling by  value: " + value + " index :" + index);
//        By by = null;
//        WebElement object = null;
//        try {
//            switch (locator) {
//            case NAME:
//                by = MobileBy.AndroidUIAutomator("new UiSelector().fromParent(new UiSelector().text(\"" + value + "\"));");
//                break;
//
//            case ACCESSIBILITY_ID:
//                by = MobileBy.AndroidUIAutomator("new UiSelector().fromParent(new UiSelector().description(\"" + value + "\"));");
//                break;
//
//            case CLASSNAME:
//                by = MobileBy.AndroidUIAutomator("new UiSelector().fromParent(new UiSelector().className(\"" + value + "\").index(" + index + "));");
//                break;
//
//            case RESOURCE_ID:
//                by = MobileBy.AndroidUIAutomator("new UiSelector().fromParent(new UiSelector().resourceId(\"" + value + "\"));");
//                break;
//
//            default:
//                break;
//            }
//            object = sibling.findElement(by);
//        } catch (Exception e) {
//            System.out.println("Object not found");
//        }
//        return object;
//    }
//
//    public WebElement searchElementInList(Locators locator, String value, int index) {
//        System.out.println("Searching element in list: " + value + " index :" + index);
//        By by = null;
//        WebElement object = null;
//        try {
//            switch (locator) {
//            case NAME:
//                by = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + value + "\"));");
//                break;
//
//            case ACCESSIBILITY_ID:
//                by = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"" + value + "\"));");
//                break;
//
//            case CLASSNAME:
//                by = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"" + value + "\").index(" + index + "));");
//                break;
//
//            case RESOURCE_ID:
//                by = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"" + value + "\"));");
//                break;
//
//            default:
//                break;
//            }
//            object = driver.findElement(by);
//        } catch (Exception e) {
//           Assert.fail("Object not found in list");
//        }
//        return object;
//    }
//
//    public WebElement searchElementInList(Locators locator, String value) {
//        return searchElementInList(locator, value, 0);
//    }
//
//    public boolean searchElementInListWithoutAsserting(Locators locator, String value , int index) {
//        System.out.println("Searching element in list: " + value + " index :" + index);
//        By by = null;
//        Boolean isPresent = false;
//        try {
//            switch (locator) {
//            case NAME:
//                by = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + value + "\"));");
//                break;
//
//            case ACCESSIBILITY_ID:
//                by = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"" + value + "\"));");
//                break;
//
//            case CLASSNAME:
//                by = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"" + value + "\").index(" + index + "));");
//                break;
//
//            case RESOURCE_ID:
//                by = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"" + value + "\"));");
//                break;
//
//            default:
//                break;
//            }
//            if(isElementPresentOnScreen(by)){
//                isPresent = true;
//            }
//
//        } catch (Exception e) {
//           System.out.println("Object not found in list");
//           e.printStackTrace();
//        }
//        return isPresent;
//    }
//
//    public boolean searchElementInListWithoutAsserting(Locators locator, String value) {
//        return searchElementInListWithoutAsserting(locator, value, 0);
//    }
//
//    public void clickElementInList(Locators locator, String value, int index) {
//        WebElement element = searchElementInList(locator, value, index);
//        clickOnElement(element);
//    }
//
//    public void clickElementInList(Locators locator, String value) {
//        clickElementInList(locator, value, 0);
//    }
//
//    // TODO change logic - pooja
//    public void scrollToEnd() {
//        AndroidElement element = (AndroidElement) getElement(MobileBy.AndroidUIAutomator("new UiSelector().scrollable(true)"), 0);
//        String prevText = "";
//        String currentText = null;
//        List<WebElement> list1 = findElements(MobileBy.className(AndroidClassNames.TEXT_VIEW));
//        currentText = list1.get(list1.size() - 1).getText();
//
//        while (!prevText.equals(currentText)) {
//            element.swipe(SwipeElementDirection.DOWN, 50, 50, 1000);
//            List<WebElement> list = findElements(MobileBy.className(AndroidClassNames.TEXT_VIEW));
//            prevText = currentText;
//            currentText = list.get(list.size() - 1).getText();
//            System.out.println(currentText);
//
//        }
//    }
//
// // To click on any element
//    public void clickOnElementContinueOnFail(By locator) {
//        try {
//            driver.findElement(locator).click();
//        } catch (Exception e) {
//            Reporter.log("Unable to click on element : " + locator.toString());
//             e.printStackTrace();
//        }
//    }
//
//    public void click(int x, int y){
//        new TouchAction(driver).tap(x, y);
//    }
//
//    public void setLandscape(){
//        driver.rotate(ScreenOrientation.LANDSCAPE);
//    }
//
//    public void setPotrait() {
//        driver.rotate(ScreenOrientation.PORTRAIT);
//    }
//
//    public By searchElementContainingTest(String value){
//        By by = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + value + "\"));");
//        return by;
//    }
//    public void enterText(String text) {
//		try {
//			System.out.println("Entering text " + text);
//			WebElement textField = getElement(MobileBy.className(AndroidClassNames.EDIT_TEXT),0);
//			if (isElementPresentOnScreen(textField)) {
//				textField.click();
//				textField.sendKeys(text);
//				//TODO need to add
////				if (checkDeviceKeyboard())
////					device.pressBack();
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//    
//    public int getDisplayWidth()
//    {
//        //  new Actions(driver).moveByOffset(x,y).click().perform();
//        int x= driver.manage().window().getSize().getWidth();
//        return x;
//    }
//
//    public int getDisplayHeight()
//    {
//        int x = driver.manage().window().getSize().getHeight();
//        return x;
//    }

}
