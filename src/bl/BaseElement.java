package bl;

import core.automation.Element;
import core.automation.SeleniumDriverCore;

public class BaseElement {

	protected SeleniumDriverCore driver;

	public BaseElement(SeleniumDriverCore driver) {
		this.driver = driver;
	}

	public Element homePage() {
		return driver.elementFinder.findElement("//a[@id='appnav_maincontainers']/div");
	}

	public Element tradesPage() {
		return driver.elementFinder.findElement("//a[@id='appnav_mainpositions']");
	}

	public Element journeyPage() {
		return driver.elementFinder.findElement("//a[@id='appnav_mainjourney']/div");
	}

	public Element userProfilePage() {
		return driver.elementFinder.findElement("//a[@id='appnav_mainuser_profile']/div");
	}

	public Element depositBtn() {
		return driver.elementFinder.findElement("//*[@id='appnav_deposit']");
	}

	public Element logingMainPageBtn() {
		return driver.elementFinder.findElement("//a[text()='Log in']");// TODO
	}

	public Element signupMainPageBtn() {
		return driver.elementFinder.findElement("//*[@id='auth_header_signup']");
	}

	public Element tradeNowStopNowInstrument(String instrument) {
		return driver.elementFinder.findElement("(//div[text()='" + instrument + "']/../..//button)[1]");
	}

	public Element closedPosition(String instrument) {
		return driver.elementFinder.findElement("//div[@id='container_header_0']//div[text()='" + instrument + "']");
	}

	public Element helloHeaderTxtExists() {
		return driver.elementFinder.findElement("//*[contains(text(),'Hello')]");
	}

	public Element customerHeaderTxtExists() {
		return driver.elementFinder.findElement("//a[text()='Customer']");
	}

	public Element termsAndConditionsGeneralLink() {
		return driver.elementFinder
				.findElement("//*[contains(text(),'By clicking the ')]//a[text()='Terms and Conditions']");
	}

	public Element navigateBackBtn() {
		return driver.elementFinder.findElement("//*[@id='navigation_button_back']");
	}

	public Element modalMessageOkBtn() {
		return driver.elementFinder.findElement("//button[@id='notification_message_ok_button']");
	}

	public Element invalidPhoneFormatSignupMsg() {
		return driver.elementFinder
				.findElement("//span[text()='Invalid phone format']");
	}

	public Element academyPage() {
		return driver.elementFinder.findElement("//a[@id='appnav_academy']");
	}

	public Element divEquals(String text) {
		return driver.elementFinder.findElement("//div[text()='" + text + "']");
	}

	public Element divContains(String string) {
		return driver.elementFinder.findElement("//div[contains(text(),'" + string + "')]");
	}
	
	public Element tradesMenuButtonTxt() {
		return driver.elementFinder.findElement("//*[text()='Trades']");
	}

	public Element homeMenuButtonTxt() {
		return driver.elementFinder.findElement("//*[text()='Home']");
	}
	
	public Element termsAndConditionsIframe() {
		return driver.elementFinder.findElement("//iframe[@class='tt-terms-and-conditions__iframe-content']");
	}

	public Element awsomeWindow() {
		return driver.elementFinder.findElement("//div[starts-with(@class,'tt-pipstars-level-info-content')]");
	}
	
}
